package com.fs.tetouan.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

import org.apache.commons.lang.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fs.tetouan.model.CourseSubscription;
import com.fs.tetouan.model.NotificationElement;
import com.fs.tetouan.model.Training;
import com.fs.tetouan.model.User;
import com.fs.tetouan.repository.CourseSubscriptionRepsitory;
import com.fs.tetouan.repository.NotificationRepository;
import com.fs.tetouan.repository.TrainingRepository;
import com.fs.tetouan.repository.UserRepository;


@RestController
@RequestMapping("/training/")
@CrossOrigin(origins = "*", maxAge = 3600)

public class CourseController {
	
    @Autowired
    private TrainingRepository trainingRepository;
    
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private CourseSubscriptionRepsitory subscriptionRepository ;
    
    @Autowired
    private NotificationRepository notficationRepository ;
    
   
    
    List<Training> trainings ;
    
    List<String> files = new ArrayList<String>();
    private final Path rootLocation = Paths.get("F:\\data\\");
    
    @PostMapping("placeTrail/{idUser}")
    public Training addTraining(@RequestPart("trainingObj") String trainingString, @RequestPart("courseImg") MultipartFile profileImage,
    		@PathVariable(name = "idUser") long instructorId) throws IOException{
       
       //Transform String data to Object
       Training  training = new ObjectMapper().readValue(trainingString, Training.class);
       
       //get Image from Request param
       training.setImage(compressBytes(profileImage.getBytes()));
       //add user to instructor
       Optional<User> instructor = userRepository.findById(instructorId);
       training.setUser(instructor.get());
       return trainingRepository.save(training);
       
       
    }

    @GetMapping("findAllTraining")
	public List<Training> findAllOrders() {
		trainings = trainingRepository.findAll();
		for (Training training : trainings) {
			training.setImage(decompressBytes(training.getImage()));
		}
		return trainings ;
    }
    
    @GetMapping("find/{id}")
    public Training getTrainingById(@PathVariable("id") long id){
    	Training training = trainingRepository.findTrainingById(id) ;
    	training.setImage(decompressBytes(training.getImage()));
        return training;
    }
    
    @GetMapping("startCourse/{id}")
    public Training startTraining(@PathVariable("id") long id){
    	
    	Training training = trainingRepository.findTrainingById(id) ;
    	training.setStarted(1);
    	
    	// notification generater 
    	List<CourseSubscription> cs = subscriptionRepository.findAllCourseSubscriptionByTrainId(id)  ; 
    	cs.forEach(item -> {
    		Optional<User> user = userRepository.findById(item.getUser().getId()) ;
    		notficationRepository.save(new NotificationElement("Your course " +item.getTraining().getTrainingName()+ " is confirmed , you are invited to assiste the course in "+ item.getTraining().getStartdate() + " at "+item.getTraining().getEtablissement() + " we hope you enjoy it ", "Course starting ",user.get()));
    	});
    	
    	trainingRepository.save(training);
        return  null  ;
    }
    
  
    
    @GetMapping("findTrainingByidInstructor/{idInstructor}")
    public List<Training> findTrainingByidInstructor(@PathVariable("idInstructor") long instructorId){
    	
    	trainings = trainingRepository.findTrainingByidInstructor(instructorId);
		for (Training training : trainings) {
			training.setImage(decompressBytes(training.getImage()));
		}
        return trainings ;
    }
    
    
    @GetMapping("listAlltrain")
    public List<Training> getTrainingBetweenTwoDate(){
    	Date today = DateUtils.truncate(new Date(), Calendar.DAY_OF_MONTH);
        return trainingRepository.getAllTrainingBetweenTwoDate(today, DateUtils.addMonths(new Date(), 1));
    }
    
    @GetMapping("delete/{id}")
    public void deleteTrainingbyID(@PathVariable("id") long id){
    	Training training = trainingRepository.findTrainingById(id) ;
        trainingRepository.delete(training);
    }
    
    @PostMapping("savefile/{id}")
    public ResponseEntity<String> handleFileUpload(@RequestPart("file") MultipartFile file,  @PathVariable ("id") long id) {
       String message;
       User user = userRepository.findUserById(id) ;
       try {
            Files.copy(file.getInputStream(), this.rootLocation.resolve(user.getUsername()+".pdf"));
            files.add(file.getOriginalFilename());
            message = "Successfully uploaded!";
            user.setPath("F:\\data\\"+user.getUsername()+".pdf");
            userRepository.save(user) ;
            return ResponseEntity.status(HttpStatus.OK).body(message);
       } catch (Exception e) {
          message = "Failed to upload!";
          return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(message);
       }
    }
    
    
 // compress the image bytes before storing it in the database
 	public static byte[] compressBytes(byte[] data) {
 		Deflater deflater = new Deflater();
 		deflater.setInput(data);
 		deflater.finish();
 		ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
 		byte[] buffer = new byte[1024];
 		while (!deflater.finished()) {
 			int count = deflater.deflate(buffer);
 			outputStream.write(buffer, 0, count);
 		}
 		try {
 			outputStream.close();
 		} catch (IOException e) {
 			System.err.println(e.getMessage());
 		}
 		System.out.println("Compressed Image Byte Size - " + outputStream.toByteArray().length);
 		return outputStream.toByteArray();
 	}
 	
 	// uncompress the image bytes before returning it to the angular application
 	public static byte[] decompressBytes(byte[] data) {
 		Inflater inflater = new Inflater();
 		inflater.setInput(data);
 		ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
 		byte[] buffer = new byte[1024];
 		try {
 			while (!inflater.finished()) {
 				int count = inflater.inflate(buffer);
 				outputStream.write(buffer, 0, count);
 			}
 			outputStream.close();
 		} catch (IOException ioe) {
 		} catch (DataFormatException e) {
 		}
 		return outputStream.toByteArray();
 	}
    
}

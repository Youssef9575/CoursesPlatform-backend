package com.fs.tetouan.repository ;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fs.tetouan.model.PlanElement;

public interface PlanElementRepository extends JpaRepository<PlanElement,Integer> {
}

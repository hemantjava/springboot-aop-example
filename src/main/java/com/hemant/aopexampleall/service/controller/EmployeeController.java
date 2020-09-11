package com.hemant.aopexampleall.service.controller;

import com.hemant.aopexampleall.aspect.LogExecutionTime;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;

@Log4j2
@Controller
public class EmployeeController {

  @LogExecutionTime
  public void empAround(){
    log.info("EmployeeController");
  }

}

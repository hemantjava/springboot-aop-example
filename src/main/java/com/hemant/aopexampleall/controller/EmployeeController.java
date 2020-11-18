package com.hemant.aopexampleall.controller;

import com.hemant.aopexampleall.aspect.LogExecutionTime;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Log4j2
@Controller
public class EmployeeController {

  @SneakyThrows
  @LogExecutionTime
  @GetMapping("/")
  public void empAround(){
    Thread.sleep(5000);
    log.info("EmployeeController");

  }

}

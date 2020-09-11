package com.hemant.aopexampleall;

import com.hemant.aopexampleall.service.EmployeeService;
import com.hemant.aopexampleall.service.controller.EmployeeController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
public class AopExampleAllApplication implements CommandLineRunner {

	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private EmployeeController employeeController;

	public static void main(String[] args) {
		SpringApplication.run(AopExampleAllApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		employeeService.empAround();
		employeeController.empAround();
		employeeService.beforeAdvice();
		employeeService.getEpmName();
		try {
			employeeService.getEpmThrowException();
		}catch (Exception e){}

	}
}

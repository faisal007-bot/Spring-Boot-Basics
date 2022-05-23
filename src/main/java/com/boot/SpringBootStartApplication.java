package com.boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringBootStartApplication implements CommandLineRunner{

//	we can use the field method to get the object of the application context
//	it is not recommended
//	@Autowired
//	public ApplicationContext context;
	@Autowired
	public Student student;
	
	public static void main(String[] args) {
		ConfigurableApplicationContext context = 
				SpringApplication.run(SpringBootStartApplication.class, args);
		Student student = context.getBean("student",Student.class);
		student.setId(2);
		student.setName("neko");
		System.out.println(student);
	}

//	if we want to perform any task at the time of starting the spring boot application
//	then we can use the commandlinerunner interface and we can override the run method
//	to perform the task which we want to perform before starting the application
//	we can also implement the commandlinerunner on any class annotated with component
//	to execute the code that we want to perform at the time of initializing the application
	@Override
	public void run(String... args) throws Exception {
		System.out.println("this is commandline runners run method");
//		using the field method to get the object of the application context
//		Student student = context.getBean("student",Student.class);
//		student.setId(11);
//		student.setName("faisal");
//		System.out.println(student);
		
//		using the applicationcontextaware interface to get the object of the application context
//		it contains method which we can use to set the application context
		Student s = student.getContext().getBean("student",Student.class);
		s.setId(11);
		s.setName("faisal");
		System.out.println(s);
	}

}

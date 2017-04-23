package com.ddup.dubbo.consumer;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ddup.dubbo.service.api.PersonService;
import com.ddup.dubbo.service.dto.req.PersonDescriptionDTO;
import com.ddup.dubbo.service.dto.resp.PersonDTO;

public class Main {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-dubbo.xml");
		context.start();

		System.out.println("开始调用");
		PersonService personservice = (PersonService)context.getBean("personService");
		PersonDescriptionDTO dtoReq = new PersonDescriptionDTO();
		PersonDTO dtoResp = personservice.queryPerson(dtoReq);
		System.out.println(dtoResp.toString());
		
		context.close();
	}	

}

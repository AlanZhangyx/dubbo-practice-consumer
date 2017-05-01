package com.ddup.dubbo.consumer;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ddup.dubbo.service.api.PersonService;
import com.ddup.dubbo.service.dto.req.PersonDescriptionDTO;
import com.ddup.dubbo.service.dto.resp.PersonDTO;

/**
 * 用Spring容器来启动的小测试；
 */
public class SpringStart {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("META-INF/spring/spring-dubbo.xml");
		context.start();
		System.out.println("1. Spring容器已启动");

		System.out.println("2. 开始调用服务");
		PersonService personservice = (PersonService)context.getBean("personService");
		PersonDescriptionDTO dtoReq = new PersonDescriptionDTO();
		PersonDTO dtoResp = personservice.queryPerson(dtoReq);
		System.out.println(dtoResp.toString());
		
		context.close();
	}	

}

package com;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@MapperScan("com.crawler.storage.dao")
@RestController
public class WSApp {

	public static void main(String[] args) {
		SpringApplication.run(WSApp.class, args);
	}
	
	@RequestMapping("/getDemo")  
	public String testEnum() {
		return "123";

	}
	
}

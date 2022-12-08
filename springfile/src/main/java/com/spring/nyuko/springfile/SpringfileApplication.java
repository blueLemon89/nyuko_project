package com.spring.nyuko.springfile;

import com.spring.nyuko.springfile.service.file.FileService;
import jakarta.annotation.Resource;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringfileApplication implements CommandLineRunner {

	@Resource
	FileService fileService;
	public static void main(String[] args) {
		SpringApplication.run(SpringfileApplication.class, args);
	}

	public void run(String... arg) throws Exception{
		fileService.init();
	}
}

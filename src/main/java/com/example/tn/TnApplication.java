package com.example.tn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class TnApplication {

	public static void main(String[] args) {
		SpringApplication.run(TnApplication.class, args);
	}

}

@RestController
class HelloController {

	@GetMapping("/say/{name}")
	public Hello sayHi(@PathVariable String name) {
		return new Hello(name);
	}

}

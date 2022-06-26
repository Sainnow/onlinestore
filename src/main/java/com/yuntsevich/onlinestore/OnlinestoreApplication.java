package com.yuntsevich.onlinestore;

import com.yuntsevich.onlinestore.service.OrderServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
@RequiredArgsConstructor
public class OnlinestoreApplication implements CommandLineRunner {
	final
	OrderServiceImpl service;

	public static void main(String[] args) {
		SpringApplication.run(OnlinestoreApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

	}
}

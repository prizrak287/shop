package com.iteco.shop;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class ShopApplication {

	public static void main(String[] args) {
		new SpringApplicationBuilder(ShopApplication.class).run(args);

	}
}

package com.lihuan;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan({ "com.lihuan.mapper" })
@SpringBootApplication
public class Go8AllApplication {
	public static void main(String[] args) {
		SpringApplication.run(Go8AllApplication.class, args);
	}
}

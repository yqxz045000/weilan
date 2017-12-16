package com.cfyj.weilan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan //使用webFileter等注解时需要添加这个注解
public class WeilanApplication {

	public static void main(String[] args) {
		SpringApplication.run(WeilanApplication.class, args);
	}
}

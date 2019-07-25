package com.hhawking.excel.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(value = "com.hhawking.excel.demo.dao")
public class ExcelDemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(ExcelDemoApplication.class, args);
    }

}

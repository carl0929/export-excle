package com.hhawking.excel.demo.controller;

import com.hhawking.excel.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
public class ExcelController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "dc")
    public void testExcel(HttpServletResponse response,String name) throws IOException {
        userService.testExcel(response,name);
    }
}

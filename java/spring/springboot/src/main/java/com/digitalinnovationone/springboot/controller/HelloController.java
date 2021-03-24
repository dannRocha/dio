package com.digitalinnovationone.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

  @GetMapping("/")
  public String helloMessage() {
    return "<h1>Title: Començando no Spring Boot</h1>";
  }  
}

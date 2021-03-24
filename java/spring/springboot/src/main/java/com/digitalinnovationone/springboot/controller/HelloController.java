package com.digitalinnovationone.springboot.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
  @Value("${app.ambiente}")
  private String ambiente;

  @GetMapping("/")
  public String helloMessage() {
    return "<h1> Ambiente: [" + ambiente + "]</h1>"+
      "<h2>Title: Començando no Spring Boot [<a href='/config'>Config</a>]</h2>";
  }  
}

package com.digitalinnovationone.springboot.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VariaveisAmbiente {

  @Value("${JAVA_HOME:NAO DEFINIDA}")
  private String javaHome;
  
  @Value("${ANY:NAO DEFINIDA}")
  private String naoDefinida;


  @GetMapping("/env")
  public String variavelJavaHome() {
    return "<h1>JAVA_HOME: " + javaHome + "</h1>" + 
    "<h1> VARIAVEL_NAO_DEFINIA: " + naoDefinida + "</h1>";
  }
}

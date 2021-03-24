package com.digitalinnovationone.springboot.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigController {

  @Value("${app.message}")
  private String configMsg;

  @GetMapping("/config")
  public String configMessage() {
    return configMsg;
  }
}

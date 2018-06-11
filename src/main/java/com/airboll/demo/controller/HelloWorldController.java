package com.airboll.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



import com.airboll.demo.domain.Properties;

@RestController
public class HelloWorldController {
  private final Logger logger = LoggerFactory
      .getLogger(HelloWorldController.class);
  @Autowired
  Properties properties;

  @RequestMapping("/hello")
  public String index() {
    System.out.println(properties.getRole());
    logger.error("22");
    return "Hello World";
  }
}

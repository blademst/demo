package com.airboll.demo.domain;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Properties {
  @Value("${com.airboll.demo.role}")
  private int role;

  public int getRole() {
    return role;
  }

  public void setRole(int role) {
    this.role = role;
  }

}

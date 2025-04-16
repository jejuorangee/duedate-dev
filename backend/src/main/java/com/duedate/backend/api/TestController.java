package com.duedate.backend.api;

import java.util.Date;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;


@RestController
@RequestMapping("/api")
public class TestController {
  
  @RequestMapping(value="/test", method=RequestMethod.GET)
  public String getNow() {
      return "현재 시간 : "+ new Date() + "!!";
  }
  
}

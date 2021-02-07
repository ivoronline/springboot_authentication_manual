package com.ivoronline.springboot_authentication_manual.controllers;

import com.ivoronline.springboot_authentication_manual.config.MyAuthenticationManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {

  @Autowired MyAuthenticationManager myAuthenticationManager;

  //==================================================================
  // AUTHENTICATE
  //==================================================================
  @ResponseBody
  @RequestMapping("/Authenticate")
  public String authenticate(@RequestParam String enteredUsername, @RequestParam String enteredPassword) {

    //AUTHENTICATE
    Authentication enteredAuth  = new UsernamePasswordAuthenticationToken(enteredUsername, enteredPassword);
    Authentication returnedAuth = myAuthenticationManager.authenticate(enteredAuth);

    //STORE AUTHENTICATION INTO CONTEXT (SESSION)
    SecurityContextHolder.getContext().setAuthentication(returnedAuth);

    //RETURN SOMETHING
    return "User is Authenticated";

  }

  //==================================================================
  // HELLO
  //==================================================================
  @ResponseBody
  @RequestMapping("/Hello")
  public String hello() {
    return "Hello from Controller";
  }

}

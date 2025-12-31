package com.example.controller;

import com.example.service.LoginProcessor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

  private final LoginProcessor loginProcessor;

  public LoginController(LoginProcessor loginProcessor) {
    this.loginProcessor = loginProcessor;
  }

  @GetMapping("/")
  public String loginGet() {
    return "login.html";
  }

  @PostMapping("/")
  public String loginPost(
      @RequestParam("username") String username,
      @RequestParam("password") String password,
      Model model) {
    this.loginProcessor.setUsername(username);
    this.loginProcessor.setPassword(password);

    boolean loggedIn = loginProcessor.login();

    if (loggedIn) {
      model.addAttribute("message", "You are now logged in.");
    } else {
      model.addAttribute("message", "Login failed!");
    }

    return "login.html";
  }
}

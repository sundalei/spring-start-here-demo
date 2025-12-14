package com.example.controller;

import com.example.service.LoggedUserManagementService;
import com.example.service.LoginCountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

  private final Logger LOG = LoggerFactory.getLogger(MainController.class);

  private final LoggedUserManagementService loggedUserManagementService;
  private final LoginCountService loginCountService;

  public MainController(
      LoggedUserManagementService loggedUserManagementService,
      LoginCountService loginCountService) {
    this.loggedUserManagementService = loggedUserManagementService;
    this.loginCountService = loginCountService;
  }

  @GetMapping("/main")
  public String home(@RequestParam(required = false) String logout, Model model) {
    if (logout != null) {
      LOG.info("logout :", logout);
      loggedUserManagementService.setUsername(null);
    }

    String username = loggedUserManagementService.getUsername();
    int count = loginCountService.getCount();

    if (username == null) {
      return "redirect:/";
    }

    model.addAttribute("username", username);
    model.addAttribute("loginCount", count);

    return "main.html";
  }
}

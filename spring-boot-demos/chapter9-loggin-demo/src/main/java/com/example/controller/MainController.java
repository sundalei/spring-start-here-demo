package com.example.controller;

import com.example.service.LoggedUserManagementService;
import com.example.service.LoginCountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Slf4j
public class MainController {

  private final LoggedUserManagementService loggedUserManagementService;
  private final LoginCountService loginCountService;

  public MainController(
      LoggedUserManagementService loggedUserManagementService,
      LoginCountService loginCountService) {
    this.loggedUserManagementService = loggedUserManagementService;
    this.loginCountService = loginCountService;
  }

  @GetMapping("/main")
  public String home(@RequestParam(name = "logout", required = false) String logout, Model model) {
    if (logout != null) {
      log.debug("logout :", logout);
      loggedUserManagementService.setUsername(null);
    }

    String username = loggedUserManagementService.getUsername();
    int count = loginCountService.getCount();

    if (username == null) {
      log.debug("login first to check this page");
      return "redirect:/";
    }

    model.addAttribute("username", username);
    model.addAttribute("loginCount", count);

    return "main.html";
  }
}

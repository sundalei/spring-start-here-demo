package com.example;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

  @RequestMapping("/home/{color}")
  public String home(@PathVariable String color, Model page) {
    page.addAttribute("username", "Katy");
    page.addAttribute("color", color);
    return "home.html";
  }

  @RequestMapping("/home")
  public String profile(
      @RequestParam(required = false, defaultValue = "Katy") String name,
      @RequestParam(required = false, defaultValue = "blue") String color,
      Model page) {
    page.addAttribute("username", name);
    page.addAttribute("color", color);
    return "home.html";
  }
}

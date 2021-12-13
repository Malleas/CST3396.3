package com.gcu.topic22.controller;

import com.gcu.topic22.business.OrdersBusinessServiceInterface;
import com.gcu.topic22.business.SecurityBusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class LoginController {


    @GetMapping("/login")
    public String display(Model model){
      model.addAttribute("title", "Login form");
      return "login";
    }

}

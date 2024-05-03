package com.example.Dev_module_16.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {
    @GetMapping("/test")
    public ModelAndView getTest() {
        ModelAndView result = new ModelAndView("notes/test");
        return result;
    }
}

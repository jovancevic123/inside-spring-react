package com.booking.ISAbackend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class IndexController {
    @GetMapping("")
    public ModelAndView home() {
        ModelAndView mav=new ModelAndView("index");
        return mav;
    }
}

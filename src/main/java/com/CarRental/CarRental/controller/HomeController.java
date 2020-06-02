package com.CarRental.CarRental.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @RequestMapping(value = "/carrental", method = RequestMethod.GET)
    public ModelAndView guesHhome(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("guestHome");
        return modelAndView;
    }

    @RequestMapping(value = "/user/carrental", method = RequestMethod.GET)
    public ModelAndView userHome (){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("userHome");
        return modelAndView;
    }

    @RequestMapping(value = "/admin/carrental", method = RequestMethod.GET)
    public ModelAndView adminHome (){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("adminHome");
        return modelAndView;
    }

}

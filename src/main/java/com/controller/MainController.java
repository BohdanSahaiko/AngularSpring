package com.controller;

import com.Entity.Publication;
import com.parserLogic.NoEntityObject;
import com.parserLogic.Parser;
import com.service.UserService;
import com.service.implementationService.PublicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.List;

/**
 * Created by bohdan on 02/05/17.
 */
@Controller
public class MainController {
    @Autowired
    private PublicationService soneSrvice;
    @ResponseBody
    @RequestMapping("/dev")
    public List<Publication> hello(){
        return soneSrvice.getAll();
    }

    @RequestMapping("/")
    public String helloPages(){
        return "hello_page";
    }


    @Autowired
    private UserService userService;

    @RequestMapping(value="/login", method = RequestMethod.GET)
    public ModelAndView login(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }


    @RequestMapping(value="/admin/home", method = RequestMethod.GET)
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("admin/home");
        return modelAndView;
    }
    @RequestMapping(value="admin/devs")
    ModelAndView parrrtList(@RequestParam("q") String param) throws IOException {
        ModelAndView mav = new ModelAndView("admin/home");
        List<NoEntityObject> noEntityObjectList = soneSrvice.allObject(param);
        mav.addObject("noEntityObjectList", noEntityObjectList);
        return mav;
    }
    @RequestMapping(value="/change")
        ModelAndView change() {
        soneSrvice.changer();
        return new ModelAndView("redirect:/");
    }

}

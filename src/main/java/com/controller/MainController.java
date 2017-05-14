package com.controller;

import com.Entity.Publication;
import com.service.implementationService.PublicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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
}

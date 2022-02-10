package com.example.oembed.home.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.persistence.NamedStoredProcedureQueries;

@Controller
@RequestMapping("")
public class HomeController {
    @RequestMapping(method= RequestMethod.GET)
    public String getHome() {
        return "index";
    }
}

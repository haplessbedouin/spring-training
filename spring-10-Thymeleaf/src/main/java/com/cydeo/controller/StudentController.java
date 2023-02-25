package com.cydeo.controller;

import com.cydeo.bootstrap.DataGenerator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/student")
public class StudentController {
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    //@GetMapping("/register")
    public String register(Model model) {

        model.addAttribute("students", DataGenerator.createStudent());

        return "student/register";
    }

    @RequestMapping("/welcome")
    //@PostMapping("/welcome")
    public String welcome(Model model) {

        model.addAttribute("students2", DataGenerator.createStudent());

        return "student/welcome";
    }

}

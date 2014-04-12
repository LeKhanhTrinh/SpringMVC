package com.qsoft.presentation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Contact {
    @RequestMapping("/addContact")
    public String addContact() {
        return "addContact";
    }
}

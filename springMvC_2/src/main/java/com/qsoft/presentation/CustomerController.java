package com.qsoft.presentation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CustomerController {
    @RequestMapping("/customerDetail")
    public String index() {
        return "customerDetail";
    }
}

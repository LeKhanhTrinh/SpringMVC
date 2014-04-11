package com.qsoft.presentation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OrderController {
    @RequestMapping("/order")
    public String index() {
        return "ListOrder";
    }
}

package com.qsoft.presentation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EquipmentController {
    @RequestMapping("/equipment")
    public String index() {
        return "ListEquipment";
    }
}

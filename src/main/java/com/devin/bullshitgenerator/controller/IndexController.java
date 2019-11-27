package com.devin.bullshitgenerator.controller;

import com.devin.bullshitgenerator.generator.BullshitGenerator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {


    @GetMapping("/index")
    public String index() {
        return "index.html";
    }

    @GetMapping("/generate")
    @ResponseBody
    public String generate(String title) {
        return BullshitGenerator.generate(title, 800);
    }
}

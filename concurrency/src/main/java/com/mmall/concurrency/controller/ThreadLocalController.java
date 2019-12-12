package com.mmall.concurrency.controller;

import com.mmall.concurrency.RequestHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/threadLocal")
public class ThreadLocalController {

    @GetMapping("/test")
    @ResponseBody
    public Long test() {
        return RequestHolder.getId();
    }
}

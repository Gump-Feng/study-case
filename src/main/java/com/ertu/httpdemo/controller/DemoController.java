package com.ertu.httpdemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hxf
 * @date 2019/4/14 23:45
 */
@RestController
public class DemoController {

    @GetMapping("hello")
    public String test() {
        return "hello world";
    }
}

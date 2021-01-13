package com.gsdyx.starter.controller;

import com.gsdyx.starter.common.Response;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: Jianfeng
 * @create: 2021-01-11 17:24
 **/
@RestController
public class TestController {

    @GetMapping("/test")
    public Response test() {
        return new Response("123");
    }
}


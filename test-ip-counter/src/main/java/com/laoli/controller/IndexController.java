package com.laoli.controller;

import com.laoli.service.IpCounterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author WeiHanQiang
 * @date 2024/09/28 22:56
 **/
@RestController
public class IndexController {
    @Autowired
    private IpCounterService ipCounterService;

    @GetMapping("/starter")
    public String index(){
        ipCounterService.record();
        return "Hello,Starter!";
    }
}
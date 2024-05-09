package org.example.demo.mvc.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/requestParamTest", produces = "application/json; charset=utf-8")
    public String requestParamTest(@RequestParam("name") String name) {
        return name + "测试成功";
    }
}

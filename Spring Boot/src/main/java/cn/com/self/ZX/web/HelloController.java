package cn.com.self.ZX.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * RESTful API
 */

@RestController
public class HelloController {
    @RequestMapping(value = "hello")
    public String index(){
        return "Hello world";
    }
}

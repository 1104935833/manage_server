package hxc.manage.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hxc
 * @version 1.0
 * @date 2019/12/27 14:26
 */
@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @RequestMapping("/basic")
    public String basic() {
        return "basic";
    }

    @RequestMapping("/")
    public String  hello() {
        return "Hello";
    }
}

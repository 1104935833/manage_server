package hxc.manage.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hxc
 * @version 1.0
 * @date 2019/12/27 14:26
 */
@RestController
@RequestMapping("/personnel")
public class PersonnelController {

    @RequestMapping("/")
    public String hello() {
        return "hello";
    }

    @RequestMapping("/emp/hello")
    public String helloEmp() {
        return "hello emp";
    }
}

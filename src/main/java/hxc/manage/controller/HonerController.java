package hxc.manage.controller;

import hxc.manage.service.HonerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HonerController {

    @Autowired
    HonerService honerService;



}

package hxc.manage.controller;

import hxc.manage.model.RespBean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hxc
 * @version 1.0
 * @date 2019/12/27 14:26
 */
@RestController
public class RegLoginController {

    @RequestMapping("/login_p")
    public RespBean login() {
        return RespBean.error("尚未登录或登录已过期，请登录!");
    }




}

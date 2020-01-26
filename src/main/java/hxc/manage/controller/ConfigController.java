package hxc.manage.controller;

import com.wf.captcha.ArithmeticCaptcha;
import hxc.manage.service.MenuService;
import hxc.manage.model.User;
import hxc.manage.model.Menu;
import hxc.manage.common.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author hxc
 * @version 1.0
 * @date 2019/12/27 14:26
 * 这是一个只要登录就能访问的Controller
 * 主要用来获取一些配置信息
 */
@RestController
@RequestMapping("/config")
public class ConfigController {

    @Autowired
    MenuService menuService;

    @RequestMapping("/sysmenu")
    public List<Menu> sysMenu() {
        return menuService.getMenusByUserId();
    }

//    @RequestMapping("/hr")
//    public User currentUser() {
//        return UserUtils.getCurrentUser();
//    }

    @GetMapping(value = "/code")
    public Map<String,Object> getCode(){
        // 算术类型 https://gitee.com/whvse/EasyCaptcha
        ArithmeticCaptcha captcha = new ArithmeticCaptcha(111, 36);
        // 几位数运算，默认是两位
        captcha.setLen(2);
        // 获取运算的结果
        String result = captcha.text();
        // 验证码信息
        Map<String,Object> imgResult = new HashMap<String,Object>(2){{
            put("img", captcha.toBase64());
            put("res",result);
        }};
        return imgResult;
    }
}

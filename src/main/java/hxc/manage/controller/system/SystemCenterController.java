package hxc.manage.controller.system;

import hxc.manage.model.User;
import hxc.manage.service.SystemCenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/center")
public class SystemCenterController {

    @Autowired
    SystemCenterService systemCenterService;

    @RequestMapping("/info")
    public Map<String, Object> info(HttpServletRequest request){
        Map<String,Object> map = new HashMap<>();
        User u = (User) request.getSession().getAttribute("userinfo");
        

        return map;

    }
}

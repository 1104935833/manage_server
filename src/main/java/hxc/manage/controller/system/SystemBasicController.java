package hxc.manage.controller.system;

import com.alibaba.druid.util.StringUtils;
import hxc.manage.model.Menu;
import hxc.manage.model.RespBean;
import hxc.manage.model.Role;
import hxc.manage.service.*;
import org.omg.PortableInterceptor.INACTIVE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * Created by sang on 2017/12/29.
 */
@RestController
@RequestMapping("/system/role")
public class SystemBasicController {
    


    @Autowired
    MenuService menuService;
    
    @PostMapping("/addMenu")
    public RespBean addMenu(Menu menu){
        try{
            if(StringUtils.equals(menu.getParentId()+"","") || menu.getParentId()==null)
                menu.setParentId((long)1);
            menuService.addMenu(menu);
            return RespBean.ok("添加成功！");
        }catch (Exception e){
            e.printStackTrace();
        }
        return RespBean.error("添加失败！");
    }
    @PostMapping("/upMenu")
    public RespBean upMenu(Menu menu){
        try{
            menuService.upMenu(menu);
            return RespBean.ok("修改成功！");
        }catch (Exception e){
            e.printStackTrace();
        }
        return RespBean.error("修改失败！");
    }

    @GetMapping("/getAllParent")
    public List<Map<String, Object>> getAllParent(){
        return  menuService.getAllParent();

    }
    //删除菜单
    @GetMapping("/menudel")
    public RespBean menuDelById(@RequestParam("id") String id){
        try {
            menuService.menuDelById(id);
            return RespBean.ok("删除成功");
        }catch (Exception e){
            e.printStackTrace();
        }
        return RespBean.ok("删除失败");
    }
    //禁用菜单
    @GetMapping("/menuhide")
    public RespBean menuHide(@RequestParam("id") String id,@RequestParam("type") String enabled){
        try {
            menuService.menuHideById(id,enabled);
            return RespBean.ok("操作成功");
        }catch (Exception e){
            e.printStackTrace();
        }
        return RespBean.ok("操作失败");

    }


//    菜单管理获取全部菜单
    @GetMapping("/getAllMenus")
    public Map<String,Object>  getAllMenu(@RequestParam(defaultValue = "1") Integer page,
                               @RequestParam(defaultValue = "10") Integer size){
        int start = (page - 1) * size;
        Map<String, Object> map = new HashMap<>();
        map.put("size",size);
        map.put("start",start);
        Map<String,Object> list=menuService.getAllMenus(map);

        return list;

    }

}

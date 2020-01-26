package hxc.manage.controller.system;

import com.alibaba.druid.util.StringUtils;
import hxc.manage.model.Menu;
import hxc.manage.model.RespBean;
import hxc.manage.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author hxc
 * @version 1.0
 * @date 2020/1/19 16:08
 */
@RestController
@RequestMapping("/system/menu")
public class SystemMenuController {

    @Autowired
    MenuService menuService;

    //    添加菜单
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
    //    更新菜单
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
    //    获取所有目录
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
        return RespBean.error("操作失败");

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
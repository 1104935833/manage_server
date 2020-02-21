package hxc.manage.controller.Table;

import hxc.manage.model.RespBean;
import hxc.manage.model.User;
import hxc.manage.model.table.ProductionUnion;
import hxc.manage.service.ProductionUnionService;
import hxc.manage.service.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
public class ProductionUnionController {
    @Autowired
    ProductionUnionService productionUnionService;

    @Autowired
    TableService tableService;

    @PostMapping("/insertProductionUnion")
    public RespBean insertProductionUnion(HttpServletRequest request, ProductionUnion productionUnion){
        User u = (User) request.getSession().getAttribute("userinfo");
        productionUnionService.insert(productionUnion);
        tableService.table(request,u.getUser_id(),String.valueOf(productionUnion.getId()),"jt_production_union",9);

        return RespBean.ok("success");
    }

    @GetMapping("/getProductionUnions")
    public Map<String,Object> getProductionUnions (@RequestParam(required = false) Map param){
        List<Map<String,Object>> res = productionUnionService.getProductionUnions(param);
        Map<String,Object> map = new HashMap<>();
        map.put("res",res);
        return map;
    }
}

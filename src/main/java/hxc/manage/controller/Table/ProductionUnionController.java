package hxc.manage.controller.Table;

import hxc.manage.common.DateConverter;
import hxc.manage.common.JwtTokenProvider;
import hxc.manage.model.RespBean;
import hxc.manage.model.User;
import hxc.manage.model.table.ProductionUnion;
import hxc.manage.service.AuditService;
import hxc.manage.service.PeddingService;
import hxc.manage.service.TableService;
import hxc.manage.service.table.ProductionUnionService;
import hxc.manage.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
public class ProductionUnionController {

    @Autowired
    JwtTokenProvider jwtTokenProvider;

    @Autowired
    ProductionUnionService productionUnionService;

    @Autowired
    TableService tableService;

    @Autowired
    PeddingService peddingService;

    @Autowired
    AuditService auditService;

    @PostMapping("/insertProductionUnion")
    public RespBean insertProductionUnion(HttpServletRequest request, ProductionUnion productionUnion) throws ParseException {
        DateConverter dateConverter = new DateConverter();
        String token = request.getHeader("Authorization");
        User u =jwtTokenProvider.getUserFromToken(token);
        productionUnion.setUnionEffectTime(dateConverter.date1ToTimeMillis(productionUnion.getUnionEffectTime()));
        productionUnion.setApprovalTime(dateConverter.date1ToTimeMillis(productionUnion.getApprovalTime()));
        productionUnion.setCreateTime(String.valueOf(new Date().getTime()));
        int id = tableService.table(request,u.getUser_id(),"jt_production_union",20);
        productionUnion.setTableId(id);
        productionUnionService.insert(productionUnion);

        return RespBean.ok("操作成功");
    }

    @PostMapping("/updataProductionUnion")
    public RespBean updataProductionUnion(HttpServletRequest request, @RequestBody Map info) throws ParseException {
        Map<String,Object> map = info;
        DateConverter dateConverter = new DateConverter();
        ProductionUnion productionUnion = Util.mapToEntity((Map<String, Object>) map.get("productionUnion"),ProductionUnion.class) ;
        String tableId = String.valueOf(info.get("tableId"));
        String id = String.valueOf(info.get("id"));
        productionUnion.setUnionEffectTime(dateConverter.date1ToTimeMillis(productionUnion.getUnionEffectTime()));
        productionUnion.setApprovalTime(dateConverter.date1ToTimeMillis(productionUnion.getApprovalTime()));
        productionUnionService.update(productionUnion);
        peddingService.sendPedding(request,productionUnion.getTableId()+"","1","0","4");
        auditService.updateAuit(tableId,"0","0",id,request);
        return RespBean.ok("操作成功");
    }

    @GetMapping("/getProductionUnion")
    public Map<String,Object> getProductionUnion(@RequestParam(required = false) Map param){
        DateConverter dateConverter = new DateConverter();
        ProductionUnion res = productionUnionService.getProductionUnion(param);
        res.setUnionEffectTime(dateConverter.stampToDate(res.getUnionEffectTime()));
        res.setApprovalTime(dateConverter.stampToDate(res.getApprovalTime()));

        Map<String,Object> map = new HashMap<>();
        map.put("res",res);
        return map;
    }



}

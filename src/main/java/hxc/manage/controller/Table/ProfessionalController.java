package hxc.manage.controller.Table;

import hxc.manage.common.DateConverter;
import hxc.manage.common.JwtTokenProvider;
import hxc.manage.model.RespBean;
import hxc.manage.model.User;
import hxc.manage.model.table.Professional;
import hxc.manage.model.table.Professional;
import hxc.manage.service.AuditService;
import hxc.manage.service.PeddingService;
import hxc.manage.service.TableService;
import hxc.manage.service.table.ProfessionalService;
import hxc.manage.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
public class ProfessionalController {

    @Autowired
    JwtTokenProvider jwtTokenProvider;

    @Autowired
    ProfessionalService professionalService;

    @Autowired
    TableService tableService;

    @Autowired
    PeddingService peddingService;

    @Autowired
    AuditService auditService;

    @PostMapping("/insertProfessional")
    public RespBean insertProfessional(HttpServletRequest request,@RequestBody Professional professional) throws ParseException {
        String token = request.getHeader("Authorization");
        User u =jwtTokenProvider.getUserFromToken(token);
        professional.setCreateTime(String.valueOf(new Date().getTime()));
        int id = tableService.table(request,u.getUser_id(),"jx_professional_building",32);
        professional.setTableId(id);
        professionalService.insert(professional);

        return RespBean.ok("操作成功");
    }

    @PostMapping("/updataProfessional")
    public RespBean updataProfessional(HttpServletRequest request, @RequestBody Map info) throws ParseException {
        Map<String,Object> map = info;
        Professional professional = Util.mapToEntity((Map<String, Object>) map.get("professional"),Professional.class) ;
        String tableId = String.valueOf(info.get("tableId"));
        String id = String.valueOf(info.get("id"));
        professionalService.update(professional);
        peddingService.sendPedding(request,professional.getTableId()+"","1","0","4");
        auditService.updateAuit(tableId,"0","0",id,request);
        return RespBean.ok("操作成功");
    }

    @GetMapping("/getProfessional")
    public RespBean getProfessional(@RequestParam(required = false) Map param){
        Professional res = professionalService.getProfessional(param);
        Map<String,Object> map = new HashMap<>();
        map.put("res",res);
        return RespBean.ok("操作成功",map);
    }


}

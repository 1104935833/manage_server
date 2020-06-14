package hxc.manage.controller.Table;

import hxc.manage.common.DateConverter;
import hxc.manage.common.JwtTokenProvider;
import hxc.manage.model.RespBean;
import hxc.manage.model.User;
import hxc.manage.model.table.TextBook;
import hxc.manage.model.table.TextBook;
import hxc.manage.service.AuditService;
import hxc.manage.service.PeddingService;
import hxc.manage.service.TableService;
import hxc.manage.service.table.TextBookService;
import hxc.manage.service.table.TextBookService;
import hxc.manage.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
public class TextBookController {

    @Autowired
    JwtTokenProvider jwtTokenProvider;

    @Autowired
    TextBookService textBookService;

    @Autowired
    TableService tableService;

    @Autowired
    PeddingService peddingService;

    @Autowired
    AuditService auditService;

    @PostMapping("/insertTextBook")
    public RespBean insertTextBook(HttpServletRequest request, TextBook textBook) throws ParseException {
        DateConverter dateConverter = new DateConverter();
        String token = request.getHeader("Authorization");
        User u =jwtTokenProvider.getUserFromToken(token);
        textBook.setWriteFinishTime(dateConverter.date1ToTimeMillis(textBook.getWriteFinishTime()));
        textBook.setDeclareTime(dateConverter.date1ToTimeMillis(textBook.getDeclareTime()));

        textBook.setCreateTime(String.valueOf(new Date().getTime()));
        int id = tableService.table(request,u.getUser_id(),"jx_textbook_compilation",31);
        textBook.setTableId(id);
        textBookService.insert(textBook);

        return RespBean.ok("操作成功");
    }

    @PostMapping("/updataTextBook")
    public RespBean updataTextBook(HttpServletRequest request, @RequestBody Map info) throws ParseException {
        Map<String,Object> map = info;
        DateConverter dateConverter = new DateConverter();
        TextBook textBook = Util.mapToEntity((Map<String, Object>) map.get("textBook"),TextBook.class) ;
        String tableId = String.valueOf(info.get("tableId"));
        String id = String.valueOf(info.get("id"));
        textBook.setWriteFinishTime(dateConverter.date1ToTimeMillis(textBook.getWriteFinishTime()));
        textBook.setDeclareTime(dateConverter.date1ToTimeMillis(textBook.getDeclareTime()));
        textBookService.update(textBook);
        peddingService.sendPedding(request,textBook.getTableId()+"","1","0","4");
        auditService.updateAuit(tableId,"0","0",id,request);
        return RespBean.ok("操作成功");
    }

    @GetMapping("/getTextBook")
    public Map<String,Object> getTextBook(@RequestParam(required = false) Map param){
        DateConverter dateConverter = new DateConverter();
        TextBook res = textBookService.getTextBook(param);
        res.setWriteFinishTime(dateConverter.stampToDate(res.getWriteFinishTime()));
        res.setDeclareTime(dateConverter.stampToDate(res.getDeclareTime()));
        Map<String,Object> map = new HashMap<>();
        map.put("res",res);
        return map;
    }

}

package hxc.manage.common.except;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 全局异常
 */

//@ControllerAdvice
public class controllerException {

    @ResponseBody
    @ExceptionHandler(Exception.class)
    public String doHandler(Exception e){
        return "ddd";
    }

}

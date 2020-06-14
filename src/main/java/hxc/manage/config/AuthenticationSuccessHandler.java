package hxc.manage.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import hxc.manage.common.JwtTokenProvider;
import hxc.manage.common.UserUtils;
import hxc.manage.model.RespBean;
import hxc.manage.model.User;
import hxc.manage.model.UserVo;
import hxc.manage.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Component
public class AuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    @Autowired
    private JwtTokenProvider tokenProvider;

    @Autowired
    RedisUtil redisUtil;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest req,
                                        HttpServletResponse resp,
                                        Authentication auth) throws IOException {
//        req.getSession().setAttribute("userinfo", UserUtils.getCurrentUser());//登陆成功存入session
//                        CustomTokenGranter tokenGranter = new CustomTokenGranter(
//                                tokenServiceFactory.customJwtTokenService(), clientDetailsService, authentication);

        String token = tokenProvider.createJwtToken(auth);
        User u =UserUtils.getCurrentUser();
        UserVo userVo = new UserVo();
        userVo.setUser(u);
        userVo.setToken(token);
        redisUtil.del("menu","menuAlll","part");
        resp.setContentType("application/json;charset=utf-8");
        RespBean respBean = RespBean.ok("登录成功!", userVo);
        ObjectMapper om = new ObjectMapper();
        PrintWriter out = resp.getWriter();
        out.write(om.writeValueAsString(respBean));
        out.flush();
        out.close();
    }
}

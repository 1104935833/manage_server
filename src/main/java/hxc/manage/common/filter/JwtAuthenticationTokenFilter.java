package hxc.manage.common.filter;

import com.alibaba.druid.util.StringUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import hxc.manage.common.AuthParameters;
import hxc.manage.common.HttpStatus;
import hxc.manage.common.JwtTokenProvider;
import hxc.manage.model.RespBean;
import hxc.manage.model.User;
import hxc.manage.model.UserDetail;
import hxc.manage.service.impl.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

@Component
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {

    private Logger logger = LoggerFactory.getLogger(JwtAuthenticationTokenFilter.class);

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    private AuthParameters authParameters;

    @Autowired
    private UserServiceImpl userService;


    //1.从每个请求header获取token
    //2.调用前面写的validateToken方法对token进行合法性验证
    //3.解析得到username，并从database取出用户相关信息权限
    //4.把用户信息(role等)以UserDetail形式放进SecurityContext以备整个请求过程使用。
    // （例如哪里需要判断用户权限是否足够时可以直接从SecurityContext取出去check）
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        String token = getJwtFromRequest(request);
        if (token != null && jwtTokenProvider.validateToken(token)) {
            User user = jwtTokenProvider.getUserFromToken(token);
            UserDetails userDetails = userService.loadUserByUsername(user.getWorkID());
            Authentication authentication = new UsernamePasswordAuthenticationToken(
                    userDetails, null, userDetails.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);

        } else if (!StringUtils.equals(request.getRequestURI(), "/login") && !StringUtils.equals(request.getRequestURI(), "/config/code")) {
            String msg = "认证失败，无法访问系统资源";
            response.setContentType("application/json");
            response.setCharacterEncoding("utf-8");
            response.setStatus(HttpStatus.SUCCESS);
            response.setContentType("application/json;charset=utf-8");
            ObjectMapper om = new ObjectMapper();
            PrintWriter out = response.getWriter();
            out.write(om.writeValueAsString(RespBean.error(msg)));
            out.flush();
            out.close();
        }
        super.doFilter(request, response, filterChain);
    }

    /**
     * Get Bear jwt from request header Authorization.
     *
     * @param request servlet request.
     * @return token or null.
     */
    private String getJwtFromRequest(HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        if (token != null) {
            return token;
        }
        return null;
    }

//    /**
//     * Get user name from Jwt, the user name have set to jwt when generate token.
//     *
//     * @param token jwt token.
//     * @param signKey jwt sign key, set in properties file.
//     * @return user name.
//     */
//    private String getUsernameFromJwt(String token, String signKey) {
//        return Jwts.parser().setSigningKey(signKey)
//                .parseClaimsJws(token)
//                .getBody()
//                .getSubject();
//    }
}

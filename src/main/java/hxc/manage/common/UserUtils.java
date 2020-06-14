package hxc.manage.common;

import hxc.manage.model.User;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * @author hxc
 * @version 1.0
 * @date 2019/12/11 11:05
 */
public class UserUtils {
    public static User getCurrentUser() {
        User u = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return u;
    }
}

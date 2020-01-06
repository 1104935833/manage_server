package hxc.manage.model;

import java.io.Serializable;

/**
 * @author hxc
 * @version 1.0
 * @date 2019/12/27 14:26
 */
public class MenuMeta implements Serializable {


    private boolean keepAlive;
    private boolean requireAuth;

    public boolean isKeepAlive() {
        return keepAlive;
    }

    public void setKeepAlive(boolean keepAlive) {
        this.keepAlive = keepAlive;
    }

    public boolean isRequireAuth() {
        return requireAuth;
    }

    public void setRequireAuth(boolean requireAuth) {
        this.requireAuth = requireAuth;
    }
}

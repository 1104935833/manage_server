package hxc.manage.model;

import java.io.Serializable;

/**
 * @author hxc
 * @version 1.0
 * @date 2019/12/27 14:26
 */
public class Role implements Serializable {
    private Long id;
    private String name;
    private String nameZh;

    public String getNameZh() {
        return nameZh;
    }

    public void setNameZh(String nameZh) {
        this.nameZh = nameZh;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

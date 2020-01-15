package hxc.manage.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @author hxc
 * @version 1.0
 * @date 2019/12/27 14:26
 */
@Data
public class Role implements Serializable {
    private Long id;
    private String name;
    private String nameZh;
    private Integer state;


}

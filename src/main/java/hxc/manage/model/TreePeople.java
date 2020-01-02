package hxc.manage.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @author hxc
 * @version 1.0
 * @date 2020/1/2 14:25
 */
@Data
public class TreePeople implements Serializable {
    private String name;
    private String treeCode;
    private Integer parentId;
    private Integer state;
}

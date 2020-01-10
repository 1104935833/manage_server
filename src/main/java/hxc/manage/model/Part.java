package hxc.manage.model;

import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * @author hxc
 * @version 1.0
 * @date 2020/1/10 14:04
 */
@Data
public class Part {

    private Integer id;

    private String label;

    private List children;
}

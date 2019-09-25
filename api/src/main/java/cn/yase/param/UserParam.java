package cn.yase.param;

import java.io.Serializable;

/**
 * @author yase
 * @since 2019/9/25 下午2:16
 */
public class UserParam implements Serializable {

    private static final long serialVersionUID = -4419718181207202800L;

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

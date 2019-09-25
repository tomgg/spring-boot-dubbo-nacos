package cn.yase.dto;

import java.io.Serializable;

/**
 * @author yase
 * @since 2019/9/25 下午2:31
 */
public class UserDTO implements Serializable {

    private static final long serialVersionUID = -798179129472194562L;

    private String result;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}

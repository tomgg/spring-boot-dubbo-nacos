package cn.yase.provider.rest;

import org.apache.dubbo.config.annotation.Service;

import cn.yase.api.SayHello;
import cn.yase.dto.UserDTO;
import cn.yase.param.UserParam;

/**
 * @author yase
 * @since 2019/9/24 下午4:23
 */
@Service(version = "1.0.0")
public class SayHelloImpl implements SayHello {

    @Override
    public UserDTO sayHello(UserParam param) {

        UserDTO dto = new UserDTO();

        String result = param.getName() + "你好呀!";

        dto.setResult(result);

        return dto;
    }
}

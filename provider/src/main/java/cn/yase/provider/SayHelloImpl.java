package cn.yase.provider;


import cn.yase.api.SayHello;
import org.apache.dubbo.config.annotation.Service;

/**
 * @author yase
 * @since 2019/9/24 下午4:23
 */
@Service(version = "1.0.0")
public class SayHelloImpl implements SayHello {
    @Override
    public String sayHello(String name) {
        return name + " 你好!";
    }
}

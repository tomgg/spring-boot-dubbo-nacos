package cn.yase.consumer;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.yase.api.SayHello;

/**
 * @author yase
 * @since 2019/9/24 下午4:30
 */
@RestController
public class ConsumerService {

    @Reference(version = "${service.version}")
    private SayHello sayHello;

    @GetMapping("/")
    public String sayHello(String name) {
        return sayHello.sayHello(name);
    }

}

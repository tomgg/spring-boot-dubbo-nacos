package cn.yase.consumer.controller;

import com.alibaba.fastjson.JSONObject;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;

import cn.yase.api.SayHello;
import cn.yase.dto.UserDTO;
import cn.yase.param.UserParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author yase
 * @since 2019/9/24 下午4:30
 */

@RestController
public class ConsumerController {

    @Reference(version = "1.0.0")
    private SayHello sayHello;

    @Resource
    private RestTemplate restTemplate;

    /**
     * dubbo调用
     * @param name
     * @return
     */
    @GetMapping("user/dubbo")
    public UserDTO sayHelloByDubbo(String name) {

        UserParam param = new UserParam();
        param.setName(name);

        return sayHello.sayHello(param);
    }

    /**
     * http调用
     * @param name
     * @return
     */
    @GetMapping("user/http")
    public UserDTO sayHelloByHttp(String name){

        // 需要看使用者的IP地址
        String host = "10.10.0.157";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        MultiValueMap<String, String> map= new LinkedMultiValueMap<>();
        map.add("name", name);

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, headers);

        ResponseEntity<String> response = restTemplate.postForEntity( "http://"+host+":8888/sayHello/user", request , String.class );

        System.out.println(response);

        String result = response.getBody();

        return JSONObject.parseObject(result, UserDTO.class);
    }

}

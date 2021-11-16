package cn.yase.consumer.controller;

import javax.annotation.Resource;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONPObject;
import okhttp3.*;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSONObject;

import cn.yase.api.SayHello;
import cn.yase.dto.UserDTO;
import cn.yase.param.UserParam;

import java.io.IOException;

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
     * 
     * @param name
     * @return
     */
    @GetMapping("user/dubbo")
    public UserDTO sayHelloByDubbo(String name) {

        UserParam param = new UserParam();
        param.setName(name+" dubbo");

        return sayHello.sayHello(param);
    }

    /**
     * http调用
     * 
     * @param name
     * @return
     */
    @GetMapping("user/http")
    public UserDTO sayHelloByHttp(String name) throws IOException {

         // 本地IP地址
         String addr = "127.0.0.1:8888";
         String url = "http://" + addr + "/sayHello/user";
        // 创建Content-Type头为JSON
        MediaType mediaType = MediaType.parse("application/json; charset=utf-8");

        OkHttpClient client = new OkHttpClient();
        JSONObject requestBody = new JSONObject();
        requestBody.put("name", "yase http");

        // 根据ContentType构建请求体
        RequestBody body = RequestBody.create(mediaType, requestBody.toJSONString());

        // 设置请求体
        Request request = new Request.Builder().url(url).post(body)
            .build();

        Response response = client.newCall(request).execute();

        String result = response.body().string();

        System.out.println(result);

        return JSONObject.parseObject(result, UserDTO.class);
    }

}

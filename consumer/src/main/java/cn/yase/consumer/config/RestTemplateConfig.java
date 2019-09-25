package cn.yase.consumer.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author yase
 * @since 2019/9/25 下午5:26
 */
@Configuration
public class RestTemplateConfig {

    @Bean
    public RestTemplate getRestTemplateBean() {
        return new RestTemplate();
    }
}

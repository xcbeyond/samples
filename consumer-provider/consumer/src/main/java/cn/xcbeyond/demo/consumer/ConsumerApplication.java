package cn.xcbeyond.demo.consumer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * 服务消费者启动类
 *
 * @author xcbeyond 2018年8月3日下午4:33:18
 */
@SpringBootApplication
public class ConsumerApplication {

  @Value("${provider.address}")
  private String providerAddr;

  public static void main(String[] args) {
    SpringApplication.run(ConsumerApplication.class, args);
  }

  @Bean
  public RestTemplate restTemplate(RestTemplateBuilder builder) {
    return builder.rootUri(providerAddr).build();
  }
}

package cn.xcbeyond.demo.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 服务提供者启动类
 *
 * @author xcbeyond 2018年8月3日下午4:31:38
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ProviderApplication {
  public static void main(String[] args) {
    SpringApplication.run(ProviderApplication.class, args);
  }
}

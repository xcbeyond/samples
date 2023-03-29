package cn.xcbeyond.demo.consumer.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 通过在本服务的service层直接调用其他服务的api层的API接口进行相关操作。 provider是一个服务提供者。
 *
 * @author xcbeyond 2018年8月10日上午10:44:48
 */
@FeignClient("provider")
public interface CommonService {

  @GetMapping("/provider/hello")
  public String hello();
}

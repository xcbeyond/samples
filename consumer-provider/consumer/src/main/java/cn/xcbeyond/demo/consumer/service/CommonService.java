package cn.xcbeyond.demo.consumer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * 通过在本服务的service层直接调用其他服务的api层的API接口进行相关操作。 provider是一个服务提供者。
 *
 * @author xcbeyond 2018年8月10日上午10:44:48
 */
@Service
public class CommonService {

  @Autowired
  private RestTemplate restTemplate;

  public String hello() {
    String result;
    try {
      ResponseEntity<String> responseEntity = restTemplate.getForEntity("/provider/hello",
          String.class);
      result = responseEntity.getBody();
    } catch (Exception e) {
      result = "Sorry, provider are unavailable, caused by " + e.getMessage();
      e.printStackTrace();
    }
    return result;
  }
}

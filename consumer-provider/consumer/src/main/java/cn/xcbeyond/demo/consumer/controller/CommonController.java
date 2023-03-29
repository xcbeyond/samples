package cn.xcbeyond.demo.consumer.controller;

import cn.xcbeyond.demo.consumer.service.CommonService;
import java.net.InetAddress;
import java.net.UnknownHostException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xcbeyond 2018年8月10日上午10:44:48
 */
@RestController
@RequestMapping("/consumer")
public class CommonController {

  @Autowired public CommonService commonService;

  @GetMapping("/ping")
  public String ping() throws UnknownHostException {
    InetAddress ia = InetAddress.getLocalHost();
    String hostname = ia.getHostName();
    String ip = ia.getHostAddress();
    return "consumer, hostname: " + hostname + ", ip: " + ip;
  }

  @GetMapping("/hello")
  public String hello() {
    String result;
    try {
      result = commonService.hello();
    } catch (Exception e) {
      result = "Sorry, provider are unavailable, caused by " + e.getMessage();
      e.printStackTrace();
    }
    return result;
  }
}

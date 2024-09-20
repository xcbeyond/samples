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

  @Autowired
  public CommonService commonService;

  @GetMapping("/info")
  public String ping() throws UnknownHostException {
    String version = System.getenv("VERSION");
    InetAddress ia = InetAddress.getLocalHost();
    String instanceId = ia.getHostName();
    String ip = ia.getHostAddress();
    return "from consumer, version: " + version + ", instance: " + instanceId + ", ip: " + ip;
  }

  @GetMapping("/hello")
  public String hello() {
    return commonService.hello();
  }

  /**
   * 模拟异常
   *
   * @return
   */
  @GetMapping("/error")
  public int error() {
    return 1 / 0;
  }
}

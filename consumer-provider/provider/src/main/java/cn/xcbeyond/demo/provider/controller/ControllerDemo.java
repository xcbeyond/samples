package cn.xcbeyond.demo.provider.controller;

import java.net.InetAddress;
import java.net.UnknownHostException;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 控制层,为其他服务提供对外API接口
 *
 * @author xcbeyond 2018年8月7日上午11:45:30
 */
@RestController
@RequestMapping("/provider")
public class ControllerDemo {

  @GetMapping("/ping")
  public String ping() throws UnknownHostException {
    return info();
  }

  @GetMapping("/hello")
  public String hello() throws UnknownHostException {
    return info();
  }

  private String info() throws UnknownHostException {
    String version = System.getenv("VERSION");
    if (StringUtils.isEmpty(version)) {
      version = "v1";
    }
    InetAddress ia = InetAddress.getLocalHost();
    String hostname = ia.getHostName();
    String ip = ia.getHostAddress();
    return "provider, version: " + version + ", hostname: " + hostname + ", ip: " + ip;
  }
}

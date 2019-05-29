package cn.com.self.feign;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "HELLO-SERVICE2")
public interface RefactorHelloService extends cn.com.self.api.service.HelloService {

}

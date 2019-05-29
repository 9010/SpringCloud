package cn.com.self.helloservice.web;

import cn.com.self.helloservice.entity.User;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.serviceregistry.Registration;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;


/**
 * RESTful API
 */

@RestController
public class HelloController {

    private final Logger logger = Logger.getLogger(getClass());

    @Autowired
    private DiscoveryClient client;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello(){
        return "Hello world";
    }

    @RequestMapping(value = "/hello1", method = RequestMethod.GET)
    public String hello(@RequestParam String name){
        return "Hello" + name;
    }

    @RequestMapping(value = "/hello2", method = RequestMethod.GET)
    public User hello(@RequestHeader String name, @RequestHeader Integer age){
        return new User(name, age);
    }

    @RequestMapping(value = "/hello3", method = RequestMethod.POST)
    public String hello(@RequestBody User user){
        return "Hello" + user.getName() + "," + user.getAge();
    }

//    @Autowired
//    Registration registration;

//    @RequestMapping(value = "/hello", method = RequestMethod.GET)
//    public String hello() throws  Exception{
//        //ServiceInstance instance = client.getLocalServiceInstance();
//        ServiceInstance instance = serviceInstance();
//
//        //模拟服务阻塞
//        int sleepTime = new Random().nextInt(3000);
//        logger.info("SleepTime: " + sleepTime);
//        Thread.sleep(sleepTime);
//
//        logger.info("/hello, host: " + instance.getHost() + ", service_id: " +
//                instance.getServiceId());
//        return "Hello world";
//    }

//    private ServiceInstance serviceInstance(){ //替换getLocalServiceInstance()函数...
//        List<ServiceInstance> list = client.getInstances(registration.getServiceId());
//
//        if (list != null && list.size() > 0){
//            for (ServiceInstance itm : list){
//                if (itm.getPort() == 58081 || itm.getPort() == 58082){
//                    return itm;
//                }
//            }
//        }
//
//        return null;
//    }
}

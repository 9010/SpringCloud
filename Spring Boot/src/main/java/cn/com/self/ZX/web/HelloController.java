package cn.com.self.ZX.web;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.serviceregistry.Registration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * RESTful API
 */

@RestController
public class HelloController {

    private final Logger logger = Logger.getLogger(getClass());

    @Autowired
    private DiscoveryClient client;

    @Autowired
    Registration registration;

    @RequestMapping(value = "hello", method = RequestMethod.GET)
    public String index(){
        //ServiceInstance instance = client.getLocalServiceInstance();
        ServiceInstance instance = serviceInstance();
        logger.info("/hello, host: " + instance.getHost() + ", service_id: " +
                instance.getServiceId());
        return "Hello world";
    }

    private ServiceInstance serviceInstance(){ //替换getLocalServiceInstance()函数...
        List<ServiceInstance> list = client.getInstances(registration.getServiceId());

        if (list != null && list.size() > 0){
            for (ServiceInstance itm : list){
                if (itm.getPort() == 8080){
                    return itm;
                }
            }
        }

        return null;
    }
}

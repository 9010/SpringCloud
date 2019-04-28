package cn.com.self.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumerController {
    @Autowired
    RestTemplate restTemplate;

    @RequestMapping(value = "/ribbon-consumer", method = RequestMethod.GET)
    public String helloConsumer(){
        //restTemplate.getForObject(url, Stirng.class);
        //restTemplate.postForEntity(url, class, String.class);
        //restTemplate.postForObject(url, class, String.class);
        //restTemplate.postForLocation(url, class, String.class);
        //restTemplate.put(url, class, String);
        //restTemplate.delete(url);
        return restTemplate.getForEntity("http://HELLO-SERVICE/hello",
                String.class).getBody();
    }
}

package cn.com.self.helloservice.indicator;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;

/**
 * 重写HealthIndicator接口，实现自定义的health监控
 */

//@Component
public class RocketMQHealthIndicator implements HealthIndicator {

    @Override
    public Health health() {
        int errorCode = 1;
        if (errorCode != 0){
            return Health.down().withDetail("Error Code", errorCode).build();
        }
        return Health.up().build();
    }

//    private int check(){}
}

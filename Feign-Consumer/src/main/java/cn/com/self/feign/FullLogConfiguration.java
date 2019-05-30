package cn.com.self.feign;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FullLogConfiguration {
    @Bean
    Logger.Level feginLoggerLevel(){
        return Logger.Level.FULL;
    }

}

package com.dc.starter.redisson;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "spring.redisson")
public class RedissonProperties {

    private String clientName;

    private String password;

    private String address;

    private Integer database;

}

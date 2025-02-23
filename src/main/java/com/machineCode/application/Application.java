package com.machineCode.application;

import com.influxdb.client.InfluxDBClient;
import com.influxdb.client.InfluxDBClientFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * @author anju
 * @created on 20/01/25 and 9:20 PM
 */

@SpringBootApplication
public class Application {


    public static void main(String[] args) {
        System.setProperty("io.netty.resolver.dns.disableJni", "true");
        SpringApplication.run(Application.class, args);
    }


}

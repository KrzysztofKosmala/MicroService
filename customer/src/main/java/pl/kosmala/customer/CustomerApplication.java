package pl.kosmala.customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages = "pl.kosmala.clients")
public class CustomerApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(CustomerApplication.class, args);
    }
}

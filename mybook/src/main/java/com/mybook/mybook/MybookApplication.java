package com.mybook.mybook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.convert.Jsr310Converters;

@EntityScan(
        basePackageClasses = {MybookApplication.class, Jsr310Converters.class}
)
@SpringBootApplication
public class MybookApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybookApplication.class, args);
    }
}

package com.manage.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
/**
 * The Test program implements a SpringBoot application that
 * manage a user.
 *
 * @author  SOUTIH Abdelkrim
 * @version 2.7.6
 * @since   2023-02
 */
@SpringBootApplication
@EnableSwagger2
public class Main {

    /**
     * The main SpringBoot application
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}
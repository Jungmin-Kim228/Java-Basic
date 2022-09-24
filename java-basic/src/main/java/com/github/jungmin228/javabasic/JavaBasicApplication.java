package com.github.jungmin228.javabasic;

import com.github.jungmin228.javabasic.array.CoordinateX;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JavaBasicApplication {

    public static void main(String[] args) {
//        SpringApplication.run(JavaBasicApplication.class, args);
        CoordinateX coordinateX = new CoordinateX();
        coordinateX.run();
    }

}

package org.zzb;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @author zzb
 * @version 1.0
 * @description:
 * @date 2023/12/23 15:20
 */
@EnableAsync
@SpringBootApplication(scanBasePackages =  {"org.zzb"})
@Slf4j
public class Application {


    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}

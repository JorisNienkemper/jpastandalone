package com.kayotic;

import com.kayotic.domain.AopStudent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class FullPostApp  implements CommandLineRunner {



        @Autowired
        private AopStudent student;

        @Override
        public void run(String... arg0) throws Exception {
            System.out.println(student.getName());
        }

        public static void main(String[] args) {
            // Used to make sure Tomcat is not started
            new SpringApplicationBuilder(FullPostApp.class)
                    .web(WebApplicationType.SERVLET).run(args);
        }

}

package com.j4mt.github.search;

import com.j4mt.github.search.service.HelloService;
import com.j4mt.github.search.service.SearchService;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;

@SpringBootApplication
public class ConsoleApplication implements CommandLineRunner {

    private HelloService helloService;

    private SearchService searchService;

    public ConsoleApplication(HelloService helloService) {
        this.helloService = helloService;
    }

    public static void main(String... args) {
        SpringApplication app = new SpringApplication(ConsoleApplication.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);
    }

    @Override
    public void run(String... args) throws Exception {
        if (args.length > 0) {
            if (args[0].equalsIgnoreCase("--searchUser")) {
                System.out.println("In search user");
                ResponseEntity<String> response = searchService.searchUser(args[1]);
                //TODO: display User information in Console
            } else if (args[0].equalsIgnoreCase("--searchRepo")) {
                System.out.println("In search Repo");

            } else {
                System.out.println(helloService.getMessage(args[0]));
            }
        } else {
            System.out.println(helloService.getMessage());
        }
    }
}

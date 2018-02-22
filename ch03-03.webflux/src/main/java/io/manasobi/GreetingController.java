package io.manasobi;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class GreetingController {

    @RequestMapping("/")
    public Mono<Greet> greet(){
        return Mono.just(new Greet("Hello World!"));
    }
}

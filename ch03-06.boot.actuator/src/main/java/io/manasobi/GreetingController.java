package io.manasobi;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class GreetingController {

    @Autowired
    private TPSHealth health;

    private Counter counter;

    private Double gauge;

    public GreetingController(MeterRegistry registry) {
        this.counter = registry.counter("greet.txnCount");
        this.gauge = registry.gauge("greet.gauge", 1.0);
    }

    @CrossOrigin
    @RequestMapping("/")
    public Greet greet(){

        log.info("Serving Request....!!!");

        health.updateTx();

        counter.increment();

        log.info("카운트:: {}", counter.count());

        return new Greet("Hello World!");
    }
}

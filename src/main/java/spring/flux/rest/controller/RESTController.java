package spring.flux.rest.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import spring.flux.dto.Customer;
import spring.flux.rest.service.RESTService;

import java.util.List;

@RestController
@RequestMapping("/rest")
@RequiredArgsConstructor
public class RESTController {
    private final RESTService service;

    @GetMapping("/t")
    protected List<Customer> findAllT() {
        return service.findAllT();
    }

    @GetMapping(value = "/s", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    protected Flux<Customer> findAllS() {
        return service.findAllS();
    }
}

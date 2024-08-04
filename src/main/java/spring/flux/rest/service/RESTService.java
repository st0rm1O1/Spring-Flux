package spring.flux.rest.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import spring.flux.dao.JPAProxy;
import spring.flux.dto.Customer;

import java.util.List;


@Service
@RequiredArgsConstructor
public class RESTService {
    private final JPAProxy proxy;

    public List<Customer> findAllT() {
        long start = System.currentTimeMillis();
        List<Customer> list = proxy.findAllTRESTCustomers();
        System.out.println("Execution Time : " + (System.currentTimeMillis() - start));
        return list;
    }

    public Flux<Customer> findAllS() {
        long start = System.currentTimeMillis();
        Flux<Customer> list = proxy.findAllSRESTCustomers();
        System.out.println("Execution Time : " + (System.currentTimeMillis() - start));
        return list;
    }

}

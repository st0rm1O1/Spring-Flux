package spring.flux.dao;

import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import spring.flux.dto.Customer;

import java.time.Duration;
import java.util.List;
import java.util.UUID;
import java.util.stream.IntStream;


@Service
public class JPAProxy {

    @SneakyThrows
    private static void sleep(int i) {
        Thread.sleep(1000);
    }

    public List<Customer> findAllTRESTCustomers() {
        return IntStream.rangeClosed(1, 10)
//                .peek(JPAProxy::sleep)
                .peek(i -> System.out.println("Iteration Index : " + i))
                .mapToObj(i -> new Customer(i, UUID.randomUUID().toString()))
                .toList();
    }

    public Flux<Customer> findAllSRESTCustomers() {
        return Flux.range(1, 10)
//                .delayElements(Duration.ofSeconds(1))
                .doOnNext(i -> System.out.println("Iteration Index : " + i))
                .map(i -> new Customer(i, UUID.randomUUID().toString()));
    }
}

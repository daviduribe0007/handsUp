package io.pivotal.literx;

import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Part01Flux {
    Flux<String> emptyFlux() {
        return Flux.empty();
    }

    Flux<String> fooBarFluxFromValues() {
        return Flux.just("foo", "bar");
    }

    Flux<String> fooBarFluxFromList() {
        List<String> fooBar = new ArrayList<>();
        fooBar.add("foo");
        fooBar.add("bar");
        Flux<String> flux = Flux.fromIterable(fooBar);
        return flux;
    }

    Flux<String> errorFlux() {
        return Flux.error(new IllegalStateException("se jodio"));
    }

    Flux<Long> counter() {
        return Flux.interval(Duration.ofMillis(100))
                .take(10);
    }

}

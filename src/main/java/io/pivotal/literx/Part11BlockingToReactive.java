package io.pivotal.literx;

import io.pivotal.literx.domain.User;
import io.pivotal.literx.repository.BlockingRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;


public class Part11BlockingToReactive {
    Flux<User> blockingRepositoryToFlux(BlockingRepository<User> repository) {
        return Flux.defer(() ->
                Flux.fromIterable(repository.findAll())
                        .subscribeOn(Schedulers.elastic())
        );
    }

    Mono<Void> fluxToBlockingRepository(Flux<User> flux, BlockingRepository<User> repository) {
        return flux.publishOn(Schedulers.elastic()).doOnNext(repository::save).then();
    }

}

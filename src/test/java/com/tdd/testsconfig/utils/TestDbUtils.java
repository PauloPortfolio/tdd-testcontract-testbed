package com.tdd.testsconfig.utils;

import com.tdd.parallel.entity.jsonview.PersonJsonview;
import com.tdd.parallel.entity.standard.PersonStandard;
import com.tdd.parallel.service.IService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static com.tdd.databuilder.PersonJsonviewBuilder.personWithIdAndNameJsonview;
import static com.tdd.databuilder.PersonStandardBuilder.personWithIdAndNameStandard;


public class TestDbUtils<E> {

  public void countPersonInDb(Flux<E> flux,Long totalItems) {
    StepVerifier
         .create(flux)
         .expectSubscription()
         .expectNextCount(totalItems)
         .verifyComplete();
  }


  public void findPersonInDb(Mono<E> flux,Long totalItems) {
    StepVerifier
         .create(flux)
         .expectSubscription()
         .expectNextCount(totalItems)
         .verifyComplete();
  }


  public PersonStandard personStandard_save_check(IService<PersonStandard> service) {
    PersonStandard localPerson = personWithIdAndNameStandard().create();

    StepVerifier
         .create(service.deleteAll()
                        .log())
         .expectSubscription()
         .expectNextCount(0L)
         .verifyComplete();

    StepVerifier
         .create(service.save(localPerson))
         .expectSubscription()
         .expectNext(localPerson)
         .verifyComplete();

    return localPerson;
  }


  public PersonJsonview personJsonview_save_check(IService<PersonJsonview> service) {
    PersonJsonview localPerson = personWithIdAndNameJsonview().create();

    StepVerifier
         .create(service.deleteAll()
                        .log())
         .expectSubscription()
         .expectNextCount(0L)
         .verifyComplete();

    StepVerifier
         .create(service.save(localPerson))
         .expectSubscription()
         .expectNext(localPerson)
         .verifyComplete();

    return localPerson;
  }

}
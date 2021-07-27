package com.tdd.parallel.core.config;

import com.tdd.parallel.repository.IMongoRepo;
import com.tdd.parallel.service.ServiceMongoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

@TestConfiguration
public class ServiceMongoTestConfig {

  @Autowired
  private IMongoRepo repo;


  @Bean
  public ServiceMongoRepo serviceMongoRepo() {
    return new ServiceMongoRepo(repo);
  }

}
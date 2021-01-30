package com.javafx.config

import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.scheduling.annotation.EnableScheduling
import org.springframework.transaction.annotation.EnableTransactionManagement

@Configuration
@EnableScheduling
@EnableTransactionManagement
@EntityScan(basePackages = ["com.javafx"])
@EnableJpaRepositories(basePackages = ["com.javafx.repository"])
@ComponentScan("com.javafx")
class AppConfig {

}

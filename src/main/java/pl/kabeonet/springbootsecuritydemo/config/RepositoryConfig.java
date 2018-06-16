package pl.kabeonet.springbootsecuritydemo.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableAutoConfiguration
@EntityScan(basePackages = {"pl.kabeonet.springbootsecuritydemo.entity"})
@EnableJpaRepositories(basePackages = {"pl.kabeonet.springbootsecuritydemo.repository"})
@EnableTransactionManagement
public class RepositoryConfig {
}

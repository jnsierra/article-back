package co.com.ud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import co.com.ud.audit.AuditorAwareImpl;

@Configuration
@EnableJpaAuditing(auditorAwareRef="auditorAware")
public class JpaConfig {
	@Bean
	public AuditorAware<String> auditorAware(){
		return new AuditorAwareImpl();	
	}

}

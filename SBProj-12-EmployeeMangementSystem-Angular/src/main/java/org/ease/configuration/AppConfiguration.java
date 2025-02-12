package org.ease.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration {

	@Bean
	ModelMapper getModelMapperInstance() {
		return new ModelMapper();
	}//getModelMapperInstance
}

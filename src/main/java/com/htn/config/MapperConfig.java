package com.htn.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {
    @Bean
    public ModelMapper modelMapper(){
        ModelMapper modelMapper = new ModelMapper();

        // Optional: Customize ModelMapper configuration
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.STRICT) // Or STANDARD, LOOSE
                .setFieldMatchingEnabled(true)
                .setFieldAccessLevel(org.modelmapper.config.Configuration.AccessLevel.PRIVATE);
        // Add more custom configurations as needed

        return modelMapper;
    }
}

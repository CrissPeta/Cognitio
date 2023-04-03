package com.construcc.cognitio.Conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;

@Configuration
public class confi {

    @Bean
    public Model model() {
        return new ExtendedModelMap();
    }

    // Encryptar
    /* @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder;
    } */
}
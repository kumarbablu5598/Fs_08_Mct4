package com.music.music;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MusicApplication {

	public static void main(String[] args) {

		SpringApplication.run(MusicApplication.class, args);
	}
//      @Bean
//
//	  BCryptPasswordEncoder bCryptPasswordEncoder() {
//
//		return new BCryptPasswordEncoder();
//	  }
}

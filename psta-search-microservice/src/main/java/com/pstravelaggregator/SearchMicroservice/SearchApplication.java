package com.pstravelaggregator.SearchMicroservice;
import okhttp3.OkHttpClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
public class SearchApplication {

	public static void main(String[] args) {
		SpringApplication.run(SearchApplication.class, args);

	}
	@Bean
	public OkHttpClient getOkHttpClient(){
		return new OkHttpClient().newBuilder()
				.build();
	}
}

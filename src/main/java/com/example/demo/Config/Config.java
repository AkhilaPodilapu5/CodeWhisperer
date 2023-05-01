// create a config class

package com.example.demo.Config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import software.amazon.awssdk.services.s3.S3Client;



@Configuration
public class Config {
	
	// create s3 client class to access s3
    // create a bean for s3client
    @Value("${aws.access_key_id}")
    private String accessKey;
    @Value("${aws.secret_access_key}")
    private String secretKey;

    // create a method to generate s3 client without credentials
    @Bean
    public S3Client getS3Client() {

    	return S3Client.builder().build();
    }
}
    
    
    
    

    
    
	
	




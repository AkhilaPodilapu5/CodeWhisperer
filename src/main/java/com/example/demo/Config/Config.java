// create a config class

package com.example.demo.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.sqs.SqsClient;
import com.fasterxml.jackson.databind.ObjectMapper;


@Configuration
public class Config {

    // create s3 client class to access s3
    // create a bean for s3client

    // create a method to generate s3 client without credentials
    @Bean
    public S3Client getS3Client() {
        return S3Client.builder().build();
    }
    @Bean
    public SqsClient getSqsClient() {
        return SqsClient.builder().build();
    }
    @Bean
    // create object mapper
    public ObjectMapper getObjectMapper() {
        return new ObjectMapper();
    }


}

package com.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
import software.amazon.awssdk.services.sqs.SqsClient;

import java.io.IOException;
import java.io.InputStream;

@Service
public class Services {
    // declare the bucket name

    @Autowired
    private S3Client s3Client;
    
    @Value("${aws.s3.bucket}")
    private String bucketName;
    @Autowired
    private SqsClient  sqsClient;
    @Value("${aws.sqs.queue}")
    private String queueName;
    // create the method for upload file

    public void saveFile(String fileName, InputStream streamData) throws IOException {
        s3Client.putObject(PutObjectRequest.builder()
                .bucket(bucketName) // generated wrong bucketName was wrapped in string
                .key(fileName)
                .build(), RequestBody.fromInputStream(streamData, streamData.available()));
    }
    // create a method to store messages to sqs
    public void sendMessage(String message) {
        sqsClient.sendMessage(builder -> builder
                .queueUrl(queueName)
                .messageBody(message)
        );
    }
}

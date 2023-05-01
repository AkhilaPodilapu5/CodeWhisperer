package com.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
// import aws sdk v2 package for request body

import software.amazon.awssdk.services.s3.model.PutObjectResponse;
import software.amazon.awssdk.core.Response;
import software.amazon.awssdk.core.sync.RequestBody;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

@Service
public class Services {
    // declare the bucket name

    @Autowired
    private S3Client s3Client;
    @Value("${aws.s3.bucket}")
    private String bucketName;
    // create the method for upload file
    
    
    public void saveFile(String fileName, InputStream streamData) throws IOException {

        s3Client.putObject(PutObjectRequest.builder()
                .bucket("bucketName")
                .key(fileName)
                .build(), RequestBody.fromInputStream(streamData, streamData.available()));
    }
    
}







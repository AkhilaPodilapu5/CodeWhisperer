// create a rest controller that stores pojo created to s3

package com.example.demo.Controller;
// import all packages to store response after file uploading to s3

import com.example.demo.Model.FileInfo;
import com.example.demo.Service.Services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import software.amazon.awssdk.core.Response;

import java.io.IOException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/file")
public class Controller {
    // inject service using autowired
    @Autowired
    private Services service;
	@Value("${aws.s3.bucket}")
    private String bucketName;
	@Autowired
	private ObjectMapper objectMapper;
    // create a post method
    @PostMapping("/upload")


    // create a  method to store response after file uploading to s3
    public ResponseEntity<Response> uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
        String fileObj = file.getOriginalFilename();
        // create a response object
        service.saveFile(fileObj, file.getInputStream()); // had to type
        // create FileInfo Object
		FileInfo fileInfo =  FileInfo.builder()
				.objectKey(fileObj)
				.bucketName(bucketName)
				.build();
		// convert fileinfo to json
		String json = objectMapper.writeValueAsString(fileInfo);
		// send json to sqs
		service.sendMessage(json);

		// return response
        return new ResponseEntity<>(HttpStatus.OK);
    }

}

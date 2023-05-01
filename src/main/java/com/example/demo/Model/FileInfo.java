package com.example.demo.Model;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;


@Data
@Builder(toBuilder = true)
@Jacksonized
public class FileInfo {
    String bucketName;
    String objectKey;
    // Date uploadTime;
}
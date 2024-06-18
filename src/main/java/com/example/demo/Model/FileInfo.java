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
    System.out.print("making change to fileinfo.java file i patch2branch");
    System.out.print("making change after enabling dependbot file i patch2branch");
}

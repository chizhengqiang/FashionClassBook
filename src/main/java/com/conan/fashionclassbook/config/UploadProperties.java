package com.conan.fashionclassbook.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@ConfigurationProperties(prefix = "upload")
@Data
@Component
@Primary
public class UploadProperties {

    private String baseUrl;
    private List<String> allowTypes;
}

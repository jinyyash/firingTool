package io.applova.config;

import io.applova.codec.BusinessDetailsCodec;
import io.applova.model.businessDetails.BusinessDetails;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class ConfigLoader {
    @Value("${request.business.pattern}")
    String requestPattern;
    private Logger logger = LogManager.getLogger(ConfigLoader.class);
    private BusinessDetailsCodec businessDetailsCodec;

    @Autowired
    public ConfigLoader(BusinessDetailsCodec businessDetailsCodec) {
        this.businessDetailsCodec = businessDetailsCodec;
    }

    @Bean
    public Map<String, BusinessDetails> getBusinessDetailsMap() {
        Map<String, BusinessDetails> businessDetailsMap = new HashMap<>();
        File folder = null;
        try {
            folder = new ClassPathResource("/config-files").getFile();
        } catch (Throwable e) {
            logger.error("Exception ocures while reading file :", e);
        }
        File[] listOfFiles = folder.listFiles();
        if (listOfFiles != null) {
            for (File file : listOfFiles) {
                BusinessDetails businessDetails = getBusinessDetails(file);
                businessDetailsMap.put(businessDetails.getBusinessId(), businessDetails);
            }
        }
        return businessDetailsMap;
    }

    @Bean
    public Map<String, Integer> getRequestPattern() {
        Map<String, Integer> requestPatternMap = new HashMap<>();
        String[] requestPatterns = requestPattern.split(",");
        for (String requestPattern : requestPatterns) {
            String[] requestPatternStrings = requestPattern.split(":");
            requestPatternMap.put(requestPatternStrings[0], Integer.parseInt(requestPatternStrings[1]));
        }
        return requestPatternMap;
    }

    private BusinessDetails getBusinessDetails(File file) {
        return businessDetailsCodec.decodeJsonFileToBusinessDetailsObj(file);
    }

}

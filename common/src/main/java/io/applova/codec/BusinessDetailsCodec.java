package io.applova.codec;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.applova.model.businessDetails.BusinessDetails;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.io.File;
@Component
public class BusinessDetailsCodec {
    private ObjectMapper mapper = new ObjectMapper();
    private Logger logger = LogManager.getLogger(BusinessDetailsCodec.class);

    public BusinessDetails decodeJsonFileToBusinessDetailsObj(File file) {
        BusinessDetails businessDetails = null;
        try {
            businessDetails = mapper.readValue(file, BusinessDetails.class);
        } catch (Throwable e) {
            logger.error("Exception obscures while converting file to json object");
        }
        return businessDetails;

    }
}

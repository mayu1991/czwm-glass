package com.czwm.common;

import org.apache.commons.codec.binary.Base64;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ser.FilterProvider;
import org.codehaus.jackson.map.ser.impl.SimpleBeanPropertyFilter;
import org.codehaus.jackson.map.ser.impl.SimpleFilterProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.util.FileCopyUtils;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by apple on 2017/5/18.
 */
public class Base64JsonHttpMessageConverter extends MappingJacksonHttpMessageConverter {
    private static final Logger log = LoggerFactory.getLogger(Base64JsonHttpMessageConverter.class);

    public Base64JsonHttpMessageConverter() {
        ObjectMapper mapper = this.getObjectMapper();
        mapper.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true)
                .configure(org.codehaus.jackson.map.SerializationConfig.Feature.FAIL_ON_EMPTY_BEANS,
                        false).configure(
                org.codehaus.jackson.map.SerializationConfig.Feature.WRITE_DATES_AS_TIMESTAMPS,
                false).getSerializationConfig()
                .setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
        Set<String> fliterSet = new HashSet();
        FilterProvider filterProvider = (new SimpleFilterProvider())
                .addFilter("filter", SimpleBeanPropertyFilter
                        .serializeAllExcept(fliterSet));
        mapper.setFilters(filterProvider);
    }

    protected void writeInternal(Object object, HttpOutputMessage outputMessage) throws IOException,
            HttpMessageNotWritableException {
        try {
            byte[] bytes = this.getObjectMapper().writeValueAsBytes(object);
            FileCopyUtils.copy(Base64.encodeBase64(bytes), outputMessage.getBody());
        } catch (JsonProcessingException var4) {
            log.error("Could not write JSON: " + var4.getMessage(), var4);
            throw new HttpMessageNotWritableException("Could not write JSON: " + var4.getMessage(),
                    var4);
        }
    }
}

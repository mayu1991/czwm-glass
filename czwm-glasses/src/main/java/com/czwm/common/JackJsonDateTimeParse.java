package com.czwm.common;

import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.JsonDeserializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class JackJsonDateTimeParse extends JsonDeserializer<Date> {
    private static final Logger LOG = LoggerFactory.getLogger(JackJsonDateTimeParse.class);

    @SuppressWarnings("deprecation")
    @Override
    public Date deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException,
            JsonProcessingException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = jp.getText();
        if ("000-00-00".equals(date.trim())) {
            return new Date("0000-00-00");
        }
        if (date == null || date.trim().length() == 0) {
            return null;
        }
        if (19 == date.trim().length()) {
            format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        }
        if (16 == date.trim().length()) {
            format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        }
        if (10 == date.trim().length() && date.trim().contains("-")) {
            format = new SimpleDateFormat("yyyy-MM-dd");
        }
        if (9 == date.trim().length() && date.trim().contains("-")) {
            String s = date.trim();
            if (s.lastIndexOf("-") == 7) {// 1990-10-1
                format = new SimpleDateFormat("yyyy-MM-d");
            } else { // //1990-1-10
                format = new SimpleDateFormat("yyyy-M-dd");
            }
        }
        if (8 == date.trim().length() && date.trim().contains("-")) {
            format = new SimpleDateFormat("yyyy-M-d");
        }
        if (5 == date.trim().length() && date.trim().contains(":")) {
            format = new SimpleDateFormat("HH:mm");
        }
        try {
            return format.parse(date);
        } catch (Exception e) {
            LOG.error("日期解析出错", e);
        }
        return null;
    }

}

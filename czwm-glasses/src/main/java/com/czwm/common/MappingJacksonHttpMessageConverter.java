//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.czwm.common;

import org.codehaus.jackson.JsonEncoding;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig.Feature;
import org.codehaus.jackson.map.type.TypeFactory;
import org.codehaus.jackson.type.JavaType;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.GenericHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.util.Assert;

import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.charset.Charset;

public class MappingJacksonHttpMessageConverter extends AbstractHttpMessageConverter<Object>
        implements GenericHttpMessageConverter<Object> {
    public static final Charset DEFAULT_CHARSET = Charset.forName("UTF-8");
    private ObjectMapper objectMapper = new ObjectMapper();
    private String jsonPrefix;
    private Boolean prettyPrint;

    public MappingJacksonHttpMessageConverter() {
        super(new MediaType[] { new MediaType("application", "json", DEFAULT_CHARSET),
                new MediaType("application", "*+json", DEFAULT_CHARSET) });
    }

    public void setObjectMapper(ObjectMapper objectMapper) {
        Assert.notNull(objectMapper, "ObjectMapper must not be null");
        this.objectMapper = objectMapper;
        this.configurePrettyPrint();
    }

    private void configurePrettyPrint() {
        if (this.prettyPrint != null) {
            this.objectMapper.configure(Feature.INDENT_OUTPUT, this.prettyPrint.booleanValue());
        }

    }

    public ObjectMapper getObjectMapper() {
        return this.objectMapper;
    }

    public void setJsonPrefix(String jsonPrefix) {
        this.jsonPrefix = jsonPrefix;
    }

    public void setPrefixJson(boolean prefixJson) {
        this.jsonPrefix = prefixJson ? "{} && " : null;
    }

    public void setPrettyPrint(boolean prettyPrint) {
        this.prettyPrint = Boolean.valueOf(prettyPrint);
        this.configurePrettyPrint();
    }

    public boolean canRead(Class<?> clazz, MediaType mediaType) {
        return this.canRead(clazz, (Class) null, mediaType);
    }

    public boolean canRead(Type type, Class<?> contextClass, MediaType mediaType) {
        JavaType javaType = this.getJavaType(type, contextClass);
        return this.objectMapper.canDeserialize(javaType) && this.canRead(mediaType);
    }

    public boolean canWrite(Class<?> clazz, MediaType mediaType) {
        return this.objectMapper.canSerialize(clazz) && this.canWrite(mediaType);
    }

    protected boolean supports(Class<?> clazz) {
        throw new UnsupportedOperationException();
    }

    protected Object readInternal(Class<?> clazz, HttpInputMessage inputMessage)
            throws IOException, HttpMessageNotReadableException {
        JavaType javaType = this.getJavaType(clazz, (Class) null);
        return this.readJavaType(javaType, inputMessage);
    }

    public Object read(Type type, Class<?> contextClass, HttpInputMessage inputMessage)
            throws IOException, HttpMessageNotReadableException {
        JavaType javaType = this.getJavaType(type, contextClass);
        return this.readJavaType(javaType, inputMessage);
    }

    private Object readJavaType(JavaType javaType, HttpInputMessage inputMessage) {
        try {
            return this.objectMapper.readValue(inputMessage.getBody(), javaType);
        } catch (IOException var4) {
            throw new HttpMessageNotReadableException("Could not read JSON: " + var4.getMessage(),
                    var4);
        }
    }

    protected void writeInternal(Object object, HttpOutputMessage outputMessage)
            throws IOException, HttpMessageNotWritableException {
        JsonEncoding encoding = this.getJsonEncoding(outputMessage.getHeaders().getContentType());
        JsonGenerator jsonGenerator = this.objectMapper.getJsonFactory()
                .createJsonGenerator(outputMessage.getBody(), encoding);
        if (this.objectMapper.getSerializationConfig().isEnabled(Feature.INDENT_OUTPUT)) {
            jsonGenerator.useDefaultPrettyPrinter();
        }

        try {
            if (this.jsonPrefix != null) {
                jsonGenerator.writeRaw(this.jsonPrefix);
            }

            this.objectMapper.writeValue(jsonGenerator, object);
        } catch (JsonProcessingException var6) {
            throw new HttpMessageNotWritableException("Could not write JSON: " + var6.getMessage(),
                    var6);
        }
    }

    protected JavaType getJavaType(Type type, Class<?> contextClass) {
        return contextClass != null ?
                TypeFactory.type(type, TypeFactory.type(contextClass)) :
                TypeFactory.type(type);
    }

    protected JsonEncoding getJsonEncoding(MediaType contentType) {
        if (contentType != null && contentType.getCharSet() != null) {
            Charset charset = contentType.getCharSet();
            JsonEncoding[] arr$ = JsonEncoding.values();
            int len$ = arr$.length;

            for (int i$ = 0; i$ < len$; ++i$) {
                JsonEncoding encoding = arr$[i$];
                if (charset.name().equals(encoding.getJavaName())) {
                    return encoding;
                }
            }
        }

        return JsonEncoding.UTF8;
    }
}

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.czwm.common;

import org.apache.commons.codec.binary.Base64;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.*;
import java.util.*;

public class Base64HttpServletRequestWrapper extends HttpServletRequestWrapper {
    private Map<String, String> parameters = new HashMap();
    private byte[] bytes;
    private boolean firstTime = true;
    private ObjectMapper objectMapper = new ObjectMapper();
    private String encoding = "UTF-8";

    public ObjectMapper getObjectMapper() {
        return this.objectMapper;
    }

    public void setObjectMapper(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public String getEncoding() {
        return this.encoding;
    }

    public void setEncoding(String encoding) {
        this.encoding = encoding;
    }

    public Base64HttpServletRequestWrapper(HttpServletRequest request) {
        super(request);

        try {
            this.parseParameters();
        } catch (IOException var3) {
            throw new RuntimeException("IOException", var3);
        }
    }

    protected void parseParameters() throws IOException {
        String method = this.getHttpServletRequest().getMethod();
        StringBuilder jsonstr = new StringBuilder();
        String str = null;
        if(!method.equalsIgnoreCase("GET") && !method.equalsIgnoreCase("DELETE")) {
            BufferedReader reader = this.getReader();

            String line;
            while((line = reader.readLine()) != null) {
                jsonstr.append(line);
            }

            str = jsonstr.toString();
        } else {
            jsonstr.append(this.getQueryString());
            str = jsonstr.toString();
        }

        if(jsonstr.length() > 0) {
            JsonNode node = this.objectMapper.readTree(str);
            Iterator fieldNames = node.getFieldNames();

            while(true) {
                while(fieldNames.hasNext()) {
                    String key = (String)fieldNames.next();
                    String value = node.get(key).toString();
                    if(value.length() > 2 && value.startsWith("\"")) {
                        this.parameters.put(key, value.substring(1, value.length() - 1));
                    } else {
                        this.parameters.put(key, value);
                    }
                }

                return;
            }
        }
    }

    private HttpServletRequest getHttpServletRequest() {
        return (HttpServletRequest)super.getRequest();
    }

    public String getParameter(String name) {
        return (String)this.parameters.get(name);
    }

    public String[] getParameterValues(String name) {
        String value = this.getParameter(name);
        return value != null?new String[]{value}:null;
    }

    public Map<String, String> getParameters() {
        return this.parameters;
    }

    public Enumeration<String> getParameterNames() {
        return new Base64HttpServletRequestWrapper.IteratorEnumeration(this.parameters.keySet());
    }

    public String getQueryString() {
        try {
            String str = super.getQueryString();
            String queryString = null;
            if(str != null) {
                queryString = URLdecode(str, "UTF-8");
            }

            return queryString != null?(Base64.isBase64(queryString)?new String(Base64.decodeBase64(queryString.getBytes(this.encoding)), this.encoding):queryString):null;
        } catch (UnsupportedEncodingException var3) {
            throw new RuntimeException("UnsupportedEncodingException", var3);
        }
    }

    public BufferedReader getReader() throws IOException {
        if(this.firstTime) {
            this.firstTime();
        }

        InputStreamReader isr = new InputStreamReader(new ByteArrayInputStream(this.bytes), this.encoding);
        return new BufferedReader(isr);
    }

    private void firstTime() throws IOException {
        this.firstTime = false;
        StringBuilder buffer = new StringBuilder();
        BufferedReader reader = this.getHttpServletRequest().getReader();

        String line;
        while((line = reader.readLine()) != null) {
            buffer.append(line);
        }

        byte[] originBytes = buffer.toString().getBytes(this.encoding);
        if(Base64.isBase64(originBytes)) {
            this.bytes = Base64.decodeBase64(originBytes);
        } else {
            this.bytes = originBytes;
        }

    }

    public ServletInputStream getInputStream() throws IOException {
        if(this.firstTime) {
            this.firstTime();
        }

        ServletInputStream sis = new ServletInputStream() {
            private int i;

            public int read() throws IOException {
                byte b;
                if(Base64HttpServletRequestWrapper.this.bytes.length > this.i) {
                    b = Base64HttpServletRequestWrapper.this.bytes[this.i++];
                } else {
                    b = -1;
                }

                return b;
            }
        };
        return sis;
    }

    private static String URLdecode(String s, String enc) throws UnsupportedEncodingException {
        boolean needToChange = false;
        int numChars = s.length();
        StringBuffer sb = new StringBuffer(numChars > 500?numChars / 2:numChars);
        int i = 0;
        if(enc.length() == 0) {
            throw new UnsupportedEncodingException("URLDecoder: empty string enc parameter");
        } else {
            byte[] bytes = (byte[])null;

            while(true) {
                while(i < numChars) {
                    char c = s.charAt(i);
                    switch(c) {
                    case '%':
                        try {
                            if(bytes == null) {
                                bytes = new byte[(numChars - i) / 3];
                            }

                            int pos = 0;

                            while(i + 2 < numChars && c == 37) {
                                bytes[pos++] = (byte)Integer.parseInt(s.substring(i + 1, i + 3), 16);
                                i += 3;
                                if(i < numChars) {
                                    c = s.charAt(i);
                                }
                            }

                            if(i < numChars && c == 37) {
                                throw new IllegalArgumentException("URLDecoder: Incomplete trailing escape (%) pattern");
                            }

                            sb.append(new String(bytes, 0, pos, enc));
                        } catch (NumberFormatException var9) {
                            throw new IllegalArgumentException("URLDecoder: Illegal hex characters in escape (%) pattern - " + var9.getMessage());
                        }

                        needToChange = true;
                        break;
                    case '+':
                        sb.append('-');
                        ++i;
                        needToChange = true;
                        break;
                    case '/':
                        sb.append('_');
                        ++i;
                        needToChange = true;
                        break;
                    default:
                        sb.append(c);
                        ++i;
                    }
                }

                return needToChange?sb.toString():s;
            }
        }
    }

    public class IteratorEnumeration<E> implements Enumeration {
        private Iterator<E> iterator;

        public IteratorEnumeration(Set<E> var1) {
            this.iterator = var1.iterator();
        }

        public boolean hasMoreElements() {
            return this.iterator.hasNext();
        }

        public E nextElement() {
            return this.iterator.next();
        }
    }
}

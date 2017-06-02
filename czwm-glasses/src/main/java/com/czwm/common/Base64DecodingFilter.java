package com.czwm.common;

import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

public class Base64DecodingFilter implements Filter {
    private PathMatcher matcher = new AntPathMatcher();
    private List<String> noDecodeList = new ArrayList();

    public Base64DecodingFilter() {
    }

    public void init(FilterConfig filterConfig) throws ServletException {
        String noDecodeStr = filterConfig.getInitParameter("noDecode");
        if (noDecodeStr != null) {
            StringTokenizer st = new StringTokenizer(noDecodeStr, ",");
            this.noDecodeList.clear();

            while (st.hasMoreTokens()) {
                this.noDecodeList.add(st.nextToken());
            }
        }

    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        if (this.ifContainsInNoDecodeList(req.getServletPath())) {
            chain.doFilter(req, resp);
        } else {
            Base64HttpServletRequestWrapper DecodingRequest = new Base64HttpServletRequestWrapper(
                    req);
            chain.doFilter(DecodingRequest, resp);
        }

    }

    public void destroy() {
    }

    private boolean ifContainsInNoDecodeList(String servletPath) {
        boolean ret = false;
        if (this.noDecodeList.contains(servletPath)) {
            ret = true;
        } else if (!this.noDecodeList.isEmpty()) {
            Iterator var4 = this.noDecodeList.iterator();

            while (var4.hasNext()) {
                String filtermapping = (String) var4.next();
                if (this.matcher.match(filtermapping, servletPath)) {
                    ret = true;
                    break;
                }
            }
        }

        return ret;
    }
}

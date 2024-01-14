package org.zzb.hot.model;

import java.util.Map;

public class RequestConfig {

    /**
     * 请求cookie （单独从请求题中拿出去）
     */
    private Map<String,Object> cookies;

    /**
     * 请求头
     */
    private Map<String, Object> headers;


    /**
     * 请求体
     */
    private String requestBody;


    /**
     * 请求方式 GET,POST
     */
    private String requestType;

    public Map<String, Object> getCookies() {
        return cookies;
    }

    public void setCookies(Map<String, Object> cookies) {
        this.cookies = cookies;
    }

    public String getRequestBody() {
        return requestBody;
    }

    public void setRequestBody(String requestBody) {
        this.requestBody = requestBody;
    }

    public Map<String, Object> getHeaders() {
        return headers;
    }

    public void setHeaders(Map<String, Object> headers) {
        this.headers = headers;
    }

    public String getRequestType() {
        return requestType;
    }

    public void setRequestType(String requestType) {
        this.requestType = requestType;
    }
}

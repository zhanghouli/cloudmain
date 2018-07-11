package com.springcloud.feigndemo.listence;

import feign.Request;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.NamedThreadLocal;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.LinkedHashMap;
import java.util.Map;
@Configuration
public class FeignBasicAuthRequestInterceptor implements RequestInterceptor {

    private static final ThreadLocal<RequestAttributes> requestAttributesHolder =
            new NamedThreadLocal<RequestAttributes>("Request attributes");

    @Override
    public void apply(RequestTemplate requestTemplate) {
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        if (requestAttributes == null) {
            return;
        }
        HttpServletRequest request = ((ServletRequestAttributes) requestAttributes).getRequest();
        System.out.println("----------------------");
        System.out.println(request.getHeader("token").toString());
        //requestTemplate.header("token", getHeaders(getHttpServletRequest()).get("token"));

        System.out.println("*****************");
    }

    private HttpServletRequest getHttpServletRequest() {
        System.err.println("))))))))");
        try {
            /*System.err.println(RequestContextHolder.getRequestAttributes());
            System.err.println(RequestContextHolder.getRequestAttributes() instanceof  ServletRequestAttributes);*/
            //return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
            return ((ServletRequestAttributes) requestAttributesHolder.get()).getRequest();
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("lslejf");
            return null;
        }
    }

    private Map<String, String> getHeaders(HttpServletRequest request) {
        Map<String, String> map = new LinkedHashMap<>();
        System.err.println(request.getHeader("token"));
        Enumeration<String> enumeration = request.getHeaderNames();
        System.err.println(enumeration);

        while (enumeration.hasMoreElements()) {
            String key = enumeration.nextElement();
            String value = request.getHeader(key);
            map.put(key, value);
        }
        return map;
    }

}
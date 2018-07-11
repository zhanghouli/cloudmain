package com.springcloud.servicezuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * 路由过滤器
 *
 * @author Holley
 * @create 2018-06-22 13:43
 **/
@Component
public class MyFilter extends ZuulFilter{

    private static Logger log = LoggerFactory.getLogger(MyFilter.class);
    /**
      * @Author holley
      * @Description 返回一个字符串代表过滤器的类型
      * @Date 2018/6/22 13:46
      * @Param
      * @return
      */
    @Override
    public String filterType() {
        /**
         * pre：路由之前
         * routing：路由之时
         * post： 路由之后
         * error：发送错误调用
         */
        return "pre";
    }

    /**
      * @Author holley
      * @Description 过滤的顺序
      * @Date 2018/6/22 13:55
      * @Param
      * @return
      */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
      * @Author holley
      * @Description 逻辑判断是否要过滤，返回true则表示需要进行过滤
      * @Date 2018/6/22 13:55
      * @Param
      * @return
      */
    @Override
    public boolean shouldFilter() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        String path = request.getRequestURL().toString();
        // 当地址包含ocalhost:8781/api-b/hi时，不进行过滤，直接放过
        if(path.contains("localhost:8781/api-b/hi")){
            return false;
        }
        return true;
    }
    /**
      * @Author holley
      * @Description 过滤器的具体逻辑
      * @Date 2018/6/22 14:16
      * @Param
      * @return
      */
    @Override
    public Object run() throws ZuulException {
        // 通过zuul的RequestContext获取请求
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        log.info(String.format("%s >>> %s",request.getMethod(),request.getRequestURL().toString()));
        Object accessToken = request.getParameter("token");
        if(accessToken == null){
            log.warn("token is empty !");
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            try{
                ctx.getResponse().getWriter().write("token is empty!");
            }catch(Exception e){
                log.error("token is empty ! " + e.getMessage());
            }
        }
        return null;
    }
}

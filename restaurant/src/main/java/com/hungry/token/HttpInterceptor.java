package com.hungry.token;



import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HttpInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 允许跨域，这里是运行所有的ip请求
        response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
        // 设置请求头允许的请求方式
     //   response.setHeader("Access-Control-Allow-Methods", "GET,POST,OPTIONS,PUT,DELETE");
        response.setHeader("Access-Control-Allow-Methods", "*");
        // 允许自定义请求头token(允许head跨域)
        response.setHeader("Access-Control-Allow-Headers", "token, Accept, Origin, X-Requested-With, Content-Type, Last-Modified,Authorization");
    
        response.setHeader("Access-Control-Allow-Credentials", "true");
       
    //    response.setHeader("Access-Control-Allow-Headers", "Content-Type,Access-Token");
        response.setHeader("Access-Control-Expose-Headers", "*");
        if (request.getMethod().equals("OPTIONS")) {
            //.setResponse(response, HttpStatus.OK.value(), null);
        	response.setStatus(HttpStatus.OK.value());       
			// hresp.setContentLength(0);
        	response.getWriter().write("OPTIONS returns OK");

            return true;
        } 
        return true;
        
      //内容类型：如果是post请求必须指定这个属性
     //   response.setHeader('Content-Type', 'application/json;charset=utf-8');
     //   return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}

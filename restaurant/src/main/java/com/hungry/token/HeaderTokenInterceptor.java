package com.hungry.token;

import com.alibaba.fastjson.JSON;
import org.apache.log4j.Logger;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HeaderTokenInterceptor implements HandlerInterceptor {

    private static final Logger LOG = Logger.getLogger(HeaderTokenInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object handler) throws Exception {
        ResponseData responseData = null;
        // 获取请求头中的token验证字符串
        String headerToken = request.getHeader("token");
        // 检测当前页面，设置当前页不是登录页面时就对其进行拦截
        // 具体方法就是检测URL中有没有login,register,validphone字符串
        if (!request.getRequestURI().contains("login")&&!request.getRequestURI().contains("register")&&!request.getRequestURI().contains("validPhone")) {   	
            if (headerToken == null) {
                // 如果没有token，返回错误信息
                responseData = ResponseData.customerError();
            }
//            try {
//                // 对token更新与验证
//                headerToken = JWTUtil.updateToken(headerToken);
//                LOG.debug("token验证通过，并且续期了");
//            } catch (Exception e) {
//                LOG.debug("token验证出现异常！");
//                // 这里的ResponseData类自定义的返回信息类
//                responseData = ResponseData.customerError();
//            }
        } 
        // 如果有错误信息
        if (responseData != null) {
            response.getWriter().write(JSON.toJSONString(responseData));
            return false;
        } else {
            // 将token加入返回的header中
            response.setHeader("token", headerToken);
            return true;
        }
    }

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		
	}
}
    


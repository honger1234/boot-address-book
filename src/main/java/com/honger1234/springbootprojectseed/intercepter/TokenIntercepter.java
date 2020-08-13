package com.honger1234.springbootprojectseed.intercepter;

import com.honger1234.springbootprojectseed.exception.TokenException;
import com.honger1234.springbootprojectseed.util.JWTUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import sun.rmi.runtime.Log;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author: zt
 */
@Slf4j
public class TokenIntercepter implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info(request.getRequestURI());
        String token = request.getHeader("token");
        if (StringUtils.isEmpty(token)){
            throw new TokenException("token不能为空");
        }
        //验证是否过期
        boolean expired = JWTUtil.isExpired(token);
        if (expired){
            throw new TokenException("token已过期");
        }
        return true;
    }
}

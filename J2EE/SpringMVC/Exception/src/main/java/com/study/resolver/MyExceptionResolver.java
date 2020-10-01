package com.study.resolver;

import com.study.exception.MyException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 周
 * @title MyExceptionResolver
 * @date 2020/6/28 21:02
 * @description
 */
public class MyExceptionResolver implements HandlerExceptionResolver {
    /**
     * @param req  请求
     * @param resp 响应
     * @param o
     * @param e    异常对象
     * @return 要跳转的错误视图信息
     */
    public ModelAndView resolveException(HttpServletRequest req, HttpServletResponse resp, Object o, Exception e) {
        ModelAndView mav = new ModelAndView();
        if (e instanceof MyException) {
            mav.addObject("info", "自定义异常");
            mav.setViewName("my-error");
        } else if (e instanceof ClassCastException) {
            mav.addObject("info", "类型转换异常");
            mav.setViewName("class-cast-error");
        } else {
            mav.setViewName("error");
        }
        return mav;
    }
}

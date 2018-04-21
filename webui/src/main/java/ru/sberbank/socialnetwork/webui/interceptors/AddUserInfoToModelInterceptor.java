package ru.sberbank.socialnetwork.webui.interceptors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import ru.sberbank.socialnetwork.webui.client.AuthServiceClient;
import ru.sberbank.socialnetwork.webui.client.UserServiceClient;
import ru.sberbank.socialnetwork.webui.models.UserInfo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddUserInfoToModelInterceptor implements HandlerInterceptor {
    @Autowired
    private UserServiceClient userServiceClient;

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                             Object o) throws Exception {
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                           Object o, ModelAndView modelAndView) throws Exception {
        String authToken = httpServletRequest.getHeader("Authorization");
        UserInfo user = userServiceClient.getUserByToken(authToken);
        modelAndView.addObject("user", user);
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                                Object o, Exception e) throws Exception {

    }
}
package interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class TeacherSecurityInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (request.getSession().getAttribute("username") == null || !request.getSession().getAttribute("role").equals("teacher") || !request.getSession().getAttribute("role").equals("admin")) {
            response.sendRedirect(request.getContextPath() + "/login.htm");
            return false;
        }
        return true;
    }
}

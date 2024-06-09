package interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class SuperAdminSecurityInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        String role = (String) session.getAttribute("role");
        String username = (String) session.getAttribute("username");
        if (username == null || !role.equals("admin")) {
            response.sendRedirect(request.getContextPath() + "/teacher/dashboard.htm");
            return false;
        }
        return true;
    }
}

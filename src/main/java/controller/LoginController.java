package controller;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import service.ConnectionService;
import service.MatcherService;

import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {
    @Autowired
    private ArrayList<String> Site;

    @RequestMapping("login")
    public String login(HttpServletRequest request) {
        request.getSession().invalidate();
        ConnectionService.closeConnection();
        request.getSession().setAttribute("listSite", Site);
        return "login";
    }

    @RequestMapping(value = "login-action", method = RequestMethod.POST)
    public String dangnhap(@RequestParam("username") String username,
            @RequestParam("password") String password,
            @RequestParam("databaseSite") String site,
            HttpServletRequest request,
            RedirectAttributes redirectAttributes) {

        String url = MatcherService.getSite(Integer.parseInt(site));
        String siteName = MatcherService.getSiteName(Integer.parseInt(site));
        Connection connection = ConnectionService.makeConnection(url, username, password);
        CallableStatement callableStatement = null;
        try {
            if(connection != null){
                request.getSession().setAttribute("username", username);
                request.getSession().setAttribute("role", ConnectionService.getRole());
                request.getSession().setAttribute("site", siteName);
                request.getSession().setMaxInactiveInterval(15 * 60);
                return "redirect:/teacher/dashboard.htm";
            }
            else{
                if(MatcherService.isStudent(username)){
                    connection = ConnectionService.makeConnection(url, "svlogin", "123456789");
                    String storedProcedureCall = "{call sp_xacMinhSINHVIEN(?, ?)}";
                    callableStatement = connection.prepareCall(storedProcedureCall);
                    callableStatement.setString(1, username);
                    callableStatement.setString(2, password);
                    ResultSet rs = callableStatement.executeQuery();
                    rs.next();
                    int val = rs.getInt(1);
                    if (val == 1) {
                        request.getSession().setAttribute("username", username);
                        request.getSession().setAttribute("role", ConnectionService.getRole());
                        request.getSession().setAttribute("site", siteName);
                        request.getSession().setMaxInactiveInterval(15 * 60);
                        return "redirect:/student/dashboard.htm";
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        ConnectionService.closeConnection();
        redirectAttributes.addFlashAttribute("message", "Sai tên đăng nhập/mật khẩu/khoa");
        return "redirect:/login.htm";
    }
}

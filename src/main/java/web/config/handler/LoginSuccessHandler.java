package web.config.handler;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import web.model.User;
import web.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

public class LoginSuccessHandler implements AuthenticationSuccessHandler {
    private UserService userService;
    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest,
                                        HttpServletResponse httpServletResponse,
                                        Authentication authentication) throws IOException, ServletException {
//        httpServletResponse.sendRedirect("/admin/list");
        Set<String> roles = AuthorityUtils.authorityListToSet(authentication.getAuthorities());
        String username = authentication.getName();
        User user = (User) authentication.getPrincipal();
        if (roles.contains("ROLE_admin")){
            httpServletResponse.sendRedirect("/admin/list");
        } else {
//            String email =  httpServletRequest.getParameter("email");
//            User user = userService.findUserByEmail(username);
//            long id = userService.
//            User user = (User) authentication.getPrincipal();
////            httpServletRequest.getSession().setAttribute ("email", username);
//            httpServletRequest.getSession().setAttribute("user", user);
            httpServletResponse.sendRedirect("/user");
//        httpServletRequest.getRequestDispatcher("/user").forward(httpServletRequest,httpServletResponse);
        }
    }
}

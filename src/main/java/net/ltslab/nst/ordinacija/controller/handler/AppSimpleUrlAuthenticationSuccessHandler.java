/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ltslab.nst.ordinacija.controller.handler;

import java.io.IOException;
import java.util.Collection;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

/**
 *
 * @author bobanlukic
 */
@Component
public class AppSimpleUrlAuthenticationSuccessHandler implements
        AuthenticationSuccessHandler {

    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        handleAuthSuccess(request, response, authentication);
        clearAuthAttributes(request);
    }

    private void handleAuthSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {

        String targetUrl = determineRedirectionUrl(authentication);

        if (response.isCommitted()) {
            return;
        }
        redirectStrategy.sendRedirect(request, response, targetUrl);
    }

    private void clearAuthAttributes(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session == null) {
            return;
        }
        session.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
    }

    public void setRedirectStrategy(RedirectStrategy redirectStrategy) {
        this.redirectStrategy = redirectStrategy;
    }

    protected RedirectStrategy getRedirectStrategy() {
        return redirectStrategy;
    }

    private String determineRedirectionUrl(Authentication authentication) {
        boolean isNurse = false;
        boolean isPhysician = false;
        boolean isAdmin = false;

        Collection<? extends GrantedAuthority> authorities
                = authentication.getAuthorities();
        for (GrantedAuthority grantedAuthority : authorities) {
            if (grantedAuthority.getAuthority().equals("NURSE")) {
                isNurse = true;
                break;
            } else if (grantedAuthority.getAuthority().equals("PHYSICIAN")) {
                isPhysician = true;
                break;
            } else if (grantedAuthority.getAuthority().equals("ADMIN")) {
                isAdmin = true;
                break;
            }
        }

        if (isNurse) {
            return "/nurse";
        } else if (isPhysician) {
            return "/physician";
        } else if (isAdmin) {
            return "/admin";
        } else {
            throw new IllegalStateException();
        }
    }
}

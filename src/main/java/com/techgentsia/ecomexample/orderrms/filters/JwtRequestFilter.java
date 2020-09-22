package com.techgentsia.ecomexample.orderrms.filters;

import com.techgentsia.ecomexample.orderrms.util.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

import static com.techgentsia.ecomexample.orderrms.constants.AuthConstants.AUTH_HEADER;
import static com.techgentsia.ecomexample.orderrms.constants.AuthConstants.AUTH_HEADER_PREFIX;

@Component
public class JwtRequestFilter extends OncePerRequestFilter {

    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    RestTemplate restTemplate;

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        final String authHeader = httpServletRequest.getHeader(AUTH_HEADER);

        if(authHeader != null && authHeader.startsWith(AUTH_HEADER_PREFIX)){
            final String token = authHeader.replace(AUTH_HEADER_PREFIX,"");
            final String id = jwtTokenUtil.extractUserId(token);
            if(id!=null && SecurityContextHolder.getContext().getAuthentication() == null){
                try {
                    UserDetails userDetails = new User(id,id, new ArrayList<>());
                    if (jwtTokenUtil.validateToken(token, userDetails)) {
                        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken
                                = new UsernamePasswordAuthenticationToken(userDetails,
                                token, userDetails.getAuthorities());
                        usernamePasswordAuthenticationToken
                                .setDetails(new WebAuthenticationDetailsSource().buildDetails(httpServletRequest));
                        SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
                    }
                }
                catch (Exception e) {
                    logger.error(e);
                }

            }
        }
        filterChain.doFilter(httpServletRequest,httpServletResponse);

    }
}

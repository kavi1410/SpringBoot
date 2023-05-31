package com.elan.BookStore.Utils;

import com.elan.BookStore.Repository.UserRepository;
import com.elan.BookStore.Service.CustomUserDetailsService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtAuthFilter extends OncePerRequestFilter {
    //oncePerRequestFilter --> it will filter only once for one request.
    // Filter --> GenericBeanFilter(it contains some extra methods) -->OnceperRequestFilter

    @Autowired
    Jwtservice jwtser;
    @Autowired
    CustomUserDetailsService userDetailsService;
    @Autowired
    UserRepository userRepository;
    @Override
    protected void doFilterInternal(
            @NonNull HttpServletRequest request,
            @NonNull HttpServletResponse response,
            @NonNull FilterChain filterChain) throws ServletException, IOException {
        System.out.println("Dofilter");
        String Authorization;
        String username;
        String token;

        Authorization = request.getHeader("Authorization");
        System.out.println("Auth"+Authorization);
        //to check whether the token is empty and it contains bearer
        if(Authorization == null || !(Authorization.startsWith("Bearer "))){
            filterChain.doFilter(request,response);
            System.out.println("NullAuthorize");
            //here we mention return because if the both condition is true then leave from here
            return;
        }
        // here separate the jwt token
        token = Authorization.substring(7);
        username = jwtser.extractUsername(token);
        if(username!=null && SecurityContextHolder.getContext().getAuthentication() == null){
            UserDetails userDetails = userDetailsService.loadUserByUsername(username);
            if(jwtser.isTokenValid(token,userDetails)){
                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
                        userDetails,null,userDetails.getAuthorities()
                );
                usernamePasswordAuthenticationToken.setDetails(
                        new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);

            }
        }
        filterChain.doFilter(request,response);
    }
}
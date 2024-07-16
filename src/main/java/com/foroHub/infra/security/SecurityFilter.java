package com.foroHub.infra.security;

import com.foroHub.domain.usuarios.UsuarioReposotory;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class SecurityFilter extends OncePerRequestFilter {

    @Autowired
    private TokenService tokenService;

    @Autowired
    private UsuarioReposotory usuarioReposotory;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        var token = request.getHeader("Authorization");
        if (token !=null){
            token = token.replace("Bearer", "");

            var subject = tokenService.getSubject(token);
            if (subject != null) {

                var usuario = usuarioReposotory.findByLogin(subject);
                var authentication = new UsernamePasswordAuthenticationToken(usuario, null,
                        usuario.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(authentication);

            }

    }
        filterChain.doFilter(request, response);
    }

}

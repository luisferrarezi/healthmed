package br.com.fiap.healthmed.infra.security;

import br.com.fiap.healthmed.adapter.repository.autenticacao.AutenticacaoRepository;
import br.com.fiap.healthmed.core.entity.autenticacao.Autenticacao;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Collections;

@Component
public class SecurityFilter extends OncePerRequestFilter {
    
    private final TokenService tokenService;
    private final AutenticacaoRepository repository;
    private final TokenBlacklist tokenBlacklist;

    public SecurityFilter(TokenService tokenService, AutenticacaoRepository repository, TokenBlacklist tokenBlacklist){
        this.tokenService = tokenService;    
        this.repository = repository;
        this.tokenBlacklist = tokenBlacklist;
    }

    @Override
    @SuppressWarnings("null") 
    protected void doFilterInternal(HttpServletRequest request, 
                                    HttpServletResponse response, 
                                    FilterChain filterChain) throws ServletException, IOException {
        var token = tokenService.recoverToken(request);
        var login = tokenService.validateToken(token);

        if(login != null){
            Autenticacao autenticacao = repository.loadAutenticacaoByLogin(login).orElseThrow(() -> new RuntimeException("Usuario não encontrado!"));
            var authorities = Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER"));
            var authentication = new UsernamePasswordAuthenticationToken(autenticacao, null, authorities);
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }

        if (token != null && tokenBlacklist.isBlacklisted(token)) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        } else {
            filterChain.doFilter(request, response);        
        }        
    }
}

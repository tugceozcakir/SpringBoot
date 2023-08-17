package com.example.salesproject.util.security;

import com.auth0.jwt.exceptions.JWTVerificationException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JWTFilter extends OncePerRequestFilter {

    // Kullanıcı detaylarını getiren hizmeti enjekte ediyoruz
    @Autowired
    private SecurityService userDetailsService;

    // JWT işlemleri için yardımcı sınıfı enjekte ediyoruz
    @Autowired
    private JWTUtil jwtUtil;

    // Her gelen HTTP isteğinde çalışacak olan metod
    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        // İstekteki "Authorization" başlığını alıyoruz
        String authHeader = request.getHeader("Authorization");

        // Başlık varsa ve "Bearer " ile başlıyorsa JWT'yi alıyoruz
        if (authHeader != null && !authHeader.isBlank() && authHeader.startsWith("Bearer ")) {
            String jwt = authHeader.substring(7);

            // JWT boş veya geçersizse hata döndürülüyor
            if (jwt == null || jwt.isBlank()) {
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid JWT Token in Bearer Header");
            } else {
                try {
                    // JWT'nin içeriği doğrulanıyor ve içinden e-posta (subject) alınıyor
                    String email = jwtUtil.validateTokenAndRetrieveSubject(jwt);

                    // Kullanıcı detaylarını yüklüyoruz
                    UserDetails userDetails = userDetailsService.loadUserByUsername(email);

                    // Kimlik doğrulama nesnesi oluşturuluyor ve güvenlik bağlamına ekleniyor
                    UsernamePasswordAuthenticationToken authToken =
                            new UsernamePasswordAuthenticationToken(email, userDetails.getPassword(), userDetails.getAuthorities());

                    // Eğer güvenlik bağlamında zaten kimlik doğrulama yoksa ekleniyor
                    if (SecurityContextHolder.getContext().getAuthentication() == null) {
                        SecurityContextHolder.getContext().setAuthentication(authToken);
                    }
                } catch (JWTVerificationException exc) {
                    // JWT doğrulama hatası durumunda hata döndürülüyor
                    response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid JWT Token");
                }
            }
        }

        // Filtre zincirinin devamını işle
        filterChain.doFilter(request, response);
    }
}

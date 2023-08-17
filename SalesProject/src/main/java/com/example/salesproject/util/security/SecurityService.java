package com.example.salesproject.util.security;

import com.example.salesproject.database.entity.UserEntity;
import com.example.salesproject.database.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;

@Service
public class SecurityService implements UserDetailsService {

    @Autowired
    UserRepository userEntityRepository;

    // Kullanıcı detaylarını e-posta (email) ile almak için kullanılan metod
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        // Veritabanında e-posta ile kullanıcı aranıyor
        Optional<UserEntity> user = userEntityRepository.findByEmail(email);

        // Kullanıcı bulunamazsa istisna (exception) fırlatılıyor
        if (user.isEmpty()) {
            throw new UsernameNotFoundException("Could not find user with email =" + email);
        }

        // Kullanıcı detayları oluşturularak döndürülüyor
        return new User(
                email,
                user.get().getPassword(),
                Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER"))
        );
    }
}

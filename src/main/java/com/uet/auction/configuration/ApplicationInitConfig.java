package com.uet.auction.configuration;

import com.uet.auction.entity.Role;
import com.uet.auction.entity.User;
import com.uet.auction.entity.enums.RoleName;
import com.uet.auction.repository.IRoleRepository;
import com.uet.auction.repository.IUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@RequiredArgsConstructor // automatically generate constructor
public class ApplicationInitConfig {
    @Autowired
    PasswordEncoder passwordEncoder;

    @Bean
    ApplicationRunner applicationRunner(IUserRepository userRepository, IRoleRepository roleRepository) {
        return args -> {
            for (RoleName roleName:
                 RoleName.values()) {
                if (roleRepository.findByRoleName(roleName).isEmpty()) {
                    Role role = Role.builder()
                            .id(roleName.getId())
                            .roleName(roleName)
                            .build();

                    roleRepository.save(role);
                }
            }

            if (userRepository.findByUsername("admin").isEmpty()) {
                Role role = Role.builder()
                        .id(1)
                        .roleName(RoleName.ADMIN)
                        .build();

                User user = User.builder()
                        .username("admin")
                        .password(passwordEncoder.encode("admin"))
                        .email("admin@gmail.com")
                        .role(role)
                        .build();

                userRepository.save(user);
            }

        };
    }
}

package inflearn.spring_security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class SecurityConfig {

    @Bean   // 빈으로 등록하게 되면 자동설정에 의한 SecurityFilterChain Bean 은 생성되지 않음
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws  Exception {
        // 모든 설정 코드는 람다 형식으로 작성해야 함 (스프링 시큐리티 7 버전 부터는 람다 형식만 지원 할 예정이다)
        http.authorizeHttpRequests(auth -> auth.anyRequest().authenticated())
                .formLogin(Customizer.withDefaults());
        return http.build();
    }

    // 사용자 추가 설정
    // application.yml 에 따로 설정을 해두었기 때문에 주석처리 함
//    @Bean
//    public UserDetailsService userDetailsService() {
//        UserDetails user = User.withUsername("user")
//                .password("{noop}0000")
//                .authorities("USER")
//                .build();
//        return new InMemoryUserDetailsManager(user);
//    }

}

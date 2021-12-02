package apap.tutorial.cineplux.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
<<<<<<< HEAD
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
=======

>>>>>>> 51154897d58f4e827f9eda373b239024c3e9b180

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/css/**").permitAll()
                .antMatchers("/js/**").permitAll()
<<<<<<< HEAD
                .antMatchers("/user/").hasAuthority("ADMIN")
                .antMatchers("/user/viewall").hasAuthority("ADMIN")
                .antMatchers("/user/add").hasAuthority("ADMIN")
                .antMatchers("/user/delete").hasAuthority("ADMIN")
                .antMatchers("/penjaga/add").hasAuthority("MANAGER")
                .antMatchers("/penjaga/update").hasAuthority("MANAGER")
                .antMatchers("/penjaga/delete").hasAuthority("MANAGER")
                .antMatchers("/user/changepassword").permitAll()
=======

>>>>>>> 51154897d58f4e827f9eda373b239024c3e9b180
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login").permitAll()
                .and()
                .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/login").permitAll();
    }

    @Bean
    public BCryptPasswordEncoder encoder(){
        return new BCryptPasswordEncoder();
    }
<<<<<<< HEAD

//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                .passwordEncoder(encoder())
//                .withUser("nontonfilm").password(encoder().encode("21cineplux"))
//                .roles("USER");
//    }

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(userDetailsService).passwordEncoder(encoder());
    }
}
=======
>>>>>>> 51154897d58f4e827f9eda373b239024c3e9b180

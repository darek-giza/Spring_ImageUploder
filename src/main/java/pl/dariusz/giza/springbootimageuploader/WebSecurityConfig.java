package pl.dariusz.giza.springbootimageuploader;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import pl.dariusz.giza.springbootimageuploader.model.AppUser;
import pl.dariusz.giza.springbootimageuploader.repository.AppUserRepository;


@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {


    private UserDetailsServiceImpl userDetailsService;
    private AppUserRepository appUserRepository;

    @Autowired
    public WebSecurityConfig(UserDetailsServiceImpl userDetailsService,AppUserRepository appUserRepository) {
        this.userDetailsService = userDetailsService;
        this.appUserRepository = appUserRepository;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/test1").hasAnyRole("USER","ADMIN")
                .antMatchers("/upload").hasRole("ADMIN")
                .antMatchers("/gallery").hasAnyRole("USER","ADMIN")
                .and()
                .formLogin().permitAll()
                .and()
                .csrf().disable();

    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @EventListener(ApplicationReadyEvent.class)
    public void get(){
        AppUser appUserUser=new AppUser("Darek",passwordEncoder().encode("root"),"ROLE_USER");
        AppUser appUserAdmin=new AppUser("Admin",passwordEncoder().encode("root"),"ROLE_ADMIN");
        appUserRepository.save(appUserUser);
        appUserRepository.save(appUserAdmin);
    }

}

package top.jinhaoplus.spittr.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.rememberme.InMemoryTokenRepositoryImpl;

// SpringSecurity的Web安全配置在这里进行配置
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    // configure(HttpSecurity) 重写这个方法可以配置拦截器如何保护请求
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                // 使用登陆表单且定义了表单的url路径
                .formLogin()
                .loginPage("/login")
                .and()
                // 定义登出成功后的跳转url路径
                .logout()
                .logoutSuccessUrl("/")
                .and()
                // 使用rememberMe功能并设置token过期时间和私钥
                // rememberMe功能使用通过MD5 hash之后的用户名密码过期时间私钥组成的token，请求通过携带cookie到达server的时候会校验token是否有效来判断是否要服务这个请求
                .rememberMe()
                .tokenRepository(new InMemoryTokenRepositoryImpl())
                .tokenValiditySeconds(2419200)
                .key("spittrKey")
                .and()
                // 使用HTTP BASIC认证来做restful接口的认证，在不携带认证信息的请求发起时会返回401的响应码
                .httpBasic()
                .realmName("Spittr")
                .and()
                // 认证鉴权信息的配置
                .authorizeRequests()
                // url / 需要登陆认证
                .antMatchers("/spitter/me").authenticated()
                // url /spitter/me 需要登陆认证而且拥有ROLE_SPITTER的角色
                .antMatchers("/spitter/me").hasRole("SPITTER")
                // url POST /spittles 需要登陆认证而且拥有user的权限
                .antMatchers(HttpMethod.POST, "/spittles").hasAuthority("user")
                // url /admin 需要登陆认证而且拥有ROLE_ADMIN的角色，antMatchers是风格的matcher，regexMatchers是正则风格的matcher
                // 还可以使用SpEL来限定更具体的认证鉴权规则，比如可以等价于这样 .antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')")
                .regexMatchers("/admin/.*").hasRole("ADMIN")
                // 其他请求无需认证即可直接访问
                .anyRequest().permitAll();
        // 默认打开的跨站请求伪造(CSRF)保护会检查随_csrf参数传入的token是否和服务端匹配，如果缺失这个参数或者参数不匹配则拒绝服务
    }

    // configure(AuthenticationManagerBuilder) 重写这个方法可以user-detail的来源服务
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser("jenny").password("password").roles("SPITTER").
                and().withUser("kent").password("password").roles("SPITTER").authorities("user");
    }


}

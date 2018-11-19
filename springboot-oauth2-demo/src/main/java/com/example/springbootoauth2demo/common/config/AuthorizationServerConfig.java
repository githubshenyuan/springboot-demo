package com.example.springbootoauth2demo.common.config;

import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;

/**
 * @author sh 2018/11/19 10:44
 * @version ideaIU-2018.2.5.win
 */
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory()
                .withClient("test") //客户端ID
                .authorizedGrantTypes("password", "refresh_token") //设置验证方式
                .scopes("read", "write")
                .secret("123456")
                .accessTokenValiditySeconds(10000) //token过期时间
                .refreshTokenValiditySeconds(10000); //refresh过期时间
    }

}

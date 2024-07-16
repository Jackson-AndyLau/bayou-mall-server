package com.huazai.bayou.admin.modules.sys.jwt;


import org.apache.shiro.authc.AuthenticationToken;

/**
 * token
 *
 * @author Mark who.seek.me@java98k.vip
 */
public class JWTToken implements AuthenticationToken {
    private String token;

    public JWTToken(String token){
        this.token = token;
    }

    @Override
    public String getPrincipal() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }
}

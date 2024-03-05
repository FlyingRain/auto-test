package com.flyingrain.autotest.facade.intf.results;

import com.flyingrain.autotest.facade.intf.model.AutoTestUser;

public class LoginResult {

    private String token;

    private AutoTestUser user;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public AutoTestUser getUser() {
        return user;
    }

    public void setUser(AutoTestUser user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "LoginResult{" +
                "token='" + token + '\'' +
                ", user=" + user +
                '}';
    }
}

package com.socket.an2t.mvppattern.models;

import com.socket.an2t.mvppattern.mvp_login.MVPLoginModule;

public class LoginRepository implements MVPLoginModule.Model {


    private LoginModel model;

    public LoginRepository(){
        this.model = new LoginModel();
    }


    @Override
    public void createUser(String username, String password) {
        if (this.model != null) {
            this.model.setUsername(username);
            this.model.setPassword(password);
        }
    }


    @Override
    public LoginModel getUser() {
        return this.model;
    }
}

package com.socket.an2t.mvppattern.presenter;

import com.socket.an2t.mvppattern.models.LoginModel;
import com.socket.an2t.mvppattern.models.LoginRepository;
import com.socket.an2t.mvppattern.mvp_login.MVPLoginModule;

public class LoginPresenter implements MVPLoginModule.Presenter {


    private MVPLoginModule.View view;
    private MVPLoginModule.Model model;


    public LoginPresenter(){
        this.model = new LoginRepository();
    }

    @Override
    public void onLoginClickedListener() {
        if (view != null) {
            if(view.getUsername().trim().equals("") || view.getPassword().trim().equals("")){
                // show error meessage
                view.showInputError();
            }else {
                model.createUser(view.getUsername(), view.getPassword());

                LoginModel mUser = model.getUser();
                view.setPassword(mUser.getPassword());
                view.setUsername(mUser.getUsername());
                view.showSuccesMessage();
            }
        }
    }

    @Override
    public void setView(MVPLoginModule.View view) {
        this.view = view;
    }
}

package com.socket.an2t.mvppattern.mvp_login;

import com.socket.an2t.mvppattern.models.LoginModel;

public interface MVPLoginModule {

    interface View {
        String getUsername();
        String getPassword();

        void setUsername(String username);
        void setPassword(String password);

        void showInputError();
        void showSuccesMessage();
    }


    interface Presenter{

        void onLoginClickedListener();
        void setView(MVPLoginModule.View view);



    }


    interface Model {
        void createUser(String username , String password);
        LoginModel getUser();
    }
}

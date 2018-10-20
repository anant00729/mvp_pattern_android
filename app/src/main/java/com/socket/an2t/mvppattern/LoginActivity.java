package com.socket.an2t.mvppattern;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.socket.an2t.mvppattern.databinding.ActivityMainBinding;
import com.socket.an2t.mvppattern.models.LoginModel;
import com.socket.an2t.mvppattern.mvp_login.MVPLoginModule;
import com.socket.an2t.mvppattern.presenter.LoginPresenter;

public class LoginActivity extends AppCompatActivity implements MVPLoginModule.View {


    private ActivityMainBinding mB;
    private LoginPresenter mLoginP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mB = DataBindingUtil.setContentView(this, R.layout.activity_main);

        mLoginP = new LoginPresenter();
        mB.btnSubmit.setOnClickListener(view -> {
            mLoginP.onLoginClickedListener();
        });



//        // View -> Presenter
//        String username = mB.inUsername.getText().toString();
//        // View -> Presenter
//        String password = mB.inPassword.getText().toString();
//
//
//        // Checking in Presenter
//
//        if(username.isEmpty() || password.isEmpty()){
//            // Checking unsucceful -> showInputError
//            // Presenter -> View
//            Toast.makeText(this, "Please fill username or password", Toast.LENGTH_SHORT).show();
//
//
//        }else {
//
//            // Presenter -> Model
//            LoginModel mLogin = new LoginModel(username , password);
//            // Model -> Presenter -> View
//            Toast.makeText(this, "usernmae " + mLogin.getUsername() + " password " + mLogin.getPassword(), Toast.LENGTH_SHORT).show();
//        }


    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mB != null) {
            mB.unbind();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        mLoginP.setView(this);
    }

    @Override
    public String getUsername() {
        return mB.inUsername.getText().toString();
    }

    @Override
    public String getPassword() {
        return mB.inPassword.getText().toString();
    }

    @Override
    public void setUsername(String username) {
        mB.tvShow.append(username);
    }

    @Override
    public void setPassword(String password) {
        mB.tvShow.append("\n" + password);
    }

    @Override
    public void showInputError() {
        Toast.makeText(this, "error with username and password", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showSuccesMessage() {
        Toast.makeText(this, "User saved successfully", Toast.LENGTH_SHORT).show();
    }
}

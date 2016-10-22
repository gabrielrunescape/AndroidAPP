package androidapp.gabrielrunescape.com.br.view;

import android.widget.*;
import android.os.Bundle;
import android.view.Window;
import androidapp.gabrielrunescape.com.br.R;
import android.support.v7.app.AppCompatActivity;
import androidapp.gabrielrunescape.com.br.controller.LoginController;

public class LoginActivity extends AppCompatActivity {
    private Button btnLogin;
    private EditText etLogin;
    private EditText etPassword;
    private Button btnLinkToRegister;
    private LoginController logincontroller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.supportRequestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_login);
    }

    @Override
    protected void onResume() {
        super.onResume();

        etLogin = (EditText) findViewById(R.id.etLogin);
        etPassword = (EditText) findViewById(R.id.etPassword);

        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnLinkToRegister = (Button) findViewById(R.id.btnLinkToRegister);

        logincontroller = new LoginController(btnLogin, btnLinkToRegister, etLogin, etPassword, this);

        btnLogin.setOnClickListener(logincontroller);
        btnLinkToRegister.setOnClickListener(logincontroller);
    }
}

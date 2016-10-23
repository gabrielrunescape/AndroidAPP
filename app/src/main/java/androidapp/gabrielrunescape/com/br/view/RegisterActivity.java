package androidapp.gabrielrunescape.com.br.view;

import android.widget.*;
import android.os.Bundle;
import android.view.Window;
import androidapp.gabrielrunescape.com.br.R;
import android.support.v7.app.AppCompatActivity;
import androidapp.gabrielrunescape.com.br.controller.RegisterController;

public class RegisterActivity extends AppCompatActivity {
    private EditText etLogin;
    private EditText etEmail;
    private Button btnRegister;
    private EditText etPassword;
    private EditText etPassConf;
    private Button btnLinkToLogin;
    private RegisterController registercontroller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.supportRequestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_register);
    }

    @Override
    protected void onResume() {
        super.onResume();

        etLogin = (EditText) findViewById(R.id.txtLogin);
        etEmail = (EditText) findViewById(R.id.etEmail);
        etPassword = (EditText) findViewById(R.id.etPassword);
        etPassConf = (EditText) findViewById(R.id.etPasswConf);

        btnRegister = (Button) findViewById(R.id.btnRegister);
        btnLinkToLogin = (Button) findViewById(R.id.btnLinkToLoginScreen);

        registercontroller = new RegisterController(btnRegister, btnLinkToLogin, etLogin, etEmail, etPassword, etPassConf, this);

        btnRegister.setOnClickListener(registercontroller);
        btnLinkToLogin.setOnClickListener(registercontroller);
    }
}

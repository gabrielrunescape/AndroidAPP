package androidapp.gabrielrunescape.com.br.view;

import android.view.View;
import android.widget.*;
import android.os.Bundle;
import android.view.Window;
import androidapp.gabrielrunescape.com.br.R;
import android.support.v7.app.AppCompatActivity;
import androidapp.gabrielrunescape.com.br.controller.RegisterController;

public class RegisterActivity extends AppCompatActivity {
    private EditText etName;
    private EditText etLogin;
    private EditText etEmail;
    private RadioButton rbMale;
    private Button btnRegister;
    private EditText etPassword;
    private EditText etPassConf;
    private RadioButton rbFemale;
    private Button btnLinkToLogin;
    private RadioGroup rgRegister;
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

        etName = (EditText) findViewById(R.id.etName);
        etEmail = (EditText) findViewById(R.id.etEmail);
        etLogin = (EditText) findViewById(R.id.txtLogin);
        etPassword = (EditText) findViewById(R.id.etPassword);
        etPassConf = (EditText) findViewById(R.id.etPasswConf);

        rbMale = (RadioButton) findViewById(R.id.rbMale);
        rbFemale = (RadioButton) findViewById(R.id.rbFemale);
        rgRegister = (RadioGroup) findViewById(R.id.rgRegister);

        btnRegister = (Button) findViewById(R.id.btnRegister);
        btnLinkToLogin = (Button) findViewById(R.id.btnLinkToLoginScreen);

        registercontroller = new RegisterController(this);

        registercontroller.setEtName(etName);
        registercontroller.setRbMale(rbMale);
        registercontroller.setEtEmail(etEmail);
        registercontroller.setEtLogin(etLogin);
        registercontroller.setRbFemale(rbFemale);
        registercontroller.setEtPassword(etPassword);
        registercontroller.setEtPassConf(etPassConf);
        registercontroller.setBtnRegister(btnRegister);
        registercontroller.setBtnLinkToLogin(btnLinkToLogin);

        btnRegister.setOnClickListener(registercontroller);
        btnLinkToLogin.setOnClickListener(registercontroller);
    }
}

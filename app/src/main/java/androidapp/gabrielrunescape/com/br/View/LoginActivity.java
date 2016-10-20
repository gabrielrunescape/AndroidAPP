package androidapp.gabrielrunescape.com.br.View;

import android.os.Bundle;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.support.v7.app.AppCompatActivity;

import androidapp.gabrielrunescape.com.br.Controller.LoginController;
import androidapp.gabrielrunescape.com.br.R;

public class LoginActivity extends AppCompatActivity {
    private Button btnLogin;
    private EditText etLogin;
    private EditText etPassword;
    private Button btnLinkToRegister;

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

        btnLogin.setOnClickListener(new LoginController(btnLogin, btnLinkToRegister, etLogin, etPassword));
    }
}

package androidapp.gabrielrunescape.com.br.Controller;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by gabriel on 19/10/16.
 */

public class LoginController implements View.OnClickListener {
    private Button btnLogin;
    private EditText etLogin;
    private EditText etPassword;
    private Button btnLinkToRegister;

    public LoginController(Button btn1, Button btn2, EditText et1, EditText et2) {
        this.etLogin = et1;
        this.btnLogin = btn1;
        this.etPassword = et2;
        this.btnLinkToRegister = btn2;
    }

    @Override
    public void onClick(View v) {
        int idView = v.getId();

        String login = etLogin.getText().toString();
        String senha = etPassword.getText().toString();

        if (login.isEmpty() || senha.isEmpty()) {
            Toast.makeText(v.getContext(), "Existem campos em branco!", Toast.LENGTH_LONG).show();
        } else {
            if (v.getId() == btnLogin.getId()) {
                if (login.equals(senha)) {
                    Toast.makeText(v.getContext(), "Login iguais!", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(v.getContext(), "Login diferentes!", Toast.LENGTH_LONG).show();
                }
            }
        }
    }
}

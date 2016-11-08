package androidapp.gabrielrunescape.com.br.controller;

import android.net.*;
import android.widget.*;
import android.content.*;
import android.view.View;
import android.app.Activity;
import androidapp.gabrielrunescape.com.br.R;
import androidapp.gabrielrunescape.com.br.model.UsuarioAsync;
import androidapp.gabrielrunescape.com.br.view.RegisterActivity;

/**
 *      Criado por GabrielRuneScape <gabrielfilipe@mail.ru> em 19/10/2016.
 *
 *      Classe controladora responsável por realizar o controle de todas as ações realizadas pela
 * `activity` de Login (activity_login.xml e LoginActivity.java).
 *      Todas as operações realizadas nessa activity serão controladas por esta classe. A conexão
 * com a internet sempre será necessária para poder prosseguir com as demais funções dentro da
 * aplicação.
 */

public class LoginController implements View.OnClickListener {
    private Button btnLogin;
    private EditText etLogin;
    private Activity activity;
    private EditText etPassword;
    private Button btnLinkToRegister;

    /***
     *      Método construtor do controlador. Devem ser passadas as valores já instânciadas e
     * iniciadas para que a todas as funções subsequentes sejam executadas sem problemas.
     *
     * @param btn1 - Botão de login
     * @param btn2 - Botão de registro
     * @param et1 - EditText de nome de usuário
     * @param et2 - EditText de senha
     * @param a - Activity de execução
     */
    public LoginController(Button btn1, Button btn2, EditText et1, EditText et2, Activity a) {
        this.activity = a;
        this.etLogin = et1;
        this.btnLogin = btn1;
        this.etPassword = et2;
        this.btnLinkToRegister = btn2;
    }

    /***
     *      Método sobrescrito para poder realizar as ações de `ClickListener`.
     *
     * @param v - Não necessário quando se chama o procedimento 'setOnClickListener'
     */
    @Override
    public void onClick(View v) {
        int idView = v.getId();

        if (v.getId() == btnLogin.getId()) {
            this.logar(v);
        } else {
            Intent intent = new Intent(activity, RegisterActivity.class);

            activity.startActivity(intent);
            activity.finish();
        }
    }

    /***
     *      Método para realizar a autenticação na aplicação. O método faz as verificações básicas
     * para ser possível acessar a activity seguinte, após autenticação.
     *
     * @param v - View que será usada para saber qual é o contexto para exibir o Toast
     */
    private void logar(View v) {
        String login = etLogin.getText().toString();
        String senha = etPassword.getText().toString();

        if (login.isEmpty() || senha.isEmpty()) {
            String msg = activity.getResources().getString(R.string.toastNull);
            Toast.makeText(v.getContext(), msg, Toast.LENGTH_LONG).show();
        } else {
            new UsuarioAsync(activity, "ARAB", login + "/" + senha).execute("http://192.168.180.135:3000/usuarios/");
        }
    }
}

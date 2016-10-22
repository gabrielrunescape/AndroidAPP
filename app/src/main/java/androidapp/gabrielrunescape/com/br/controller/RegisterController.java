package androidapp.gabrielrunescape.com.br.controller;

import android.net.*;
import android.widget.*;
import android.content.*;
import android.view.View;
import android.app.Activity;
import androidapp.gabrielrunescape.com.br.view.LoginActivity;

/**
 *      Criado por GabrielRuneScape <gabrielfilipe@mail.ru> em 22/10/2016.
 *
 *      Classe controladora responsável por realizar o controle de todas as ações realizadas pela
 * `activity` de Register (activity_register.xml e RegisterActivity.java).
 *      Todas as operações realizadas nessa activity serão controladas por esta classe. A conexão
 * com a internet sempre será necessária para poder prosseguir com as demais funções dentro da
 * aplicação.
 */

public class RegisterController implements View.OnClickListener {
    private EditText etLogin;
    private EditText etEmail;
    private Activity activity;
    private Button btnRegister;
    private EditText etPassword;
    private EditText etPassConf;
    private Button btnLinkToLogin;

    /**
     *      Método construtor do controlador. Devem ser passadas as valores já instânciadas e
     * iniciadas para que a todas as funções subsequentes sejam executadas sem problemas.
     *
     * @param b1 - Botão de registro
     * @param b2 - Botão de login
     * @param e1 - EditText de nome de usuário
     * @param e2 - EditText de e-mail
     * @param e3 - EditText de senha
     * @param e4 - EditText de confirmação de senha
     * @param a - Activity de execução
     */
    public RegisterController(Button b1, Button b2, EditText e1, EditText e2, EditText e3, EditText e4, Activity a) {
        this.etLogin = e1;
        this.etEmail = e2;
        this.activity = a;
        this.btnRegister = b1;
        this.etPassword = e3;
        this.etPassConf = e4;
        this.btnLinkToLogin = b2;
    }

    /***
     *      Método sobrescrito para poder realizar as ações de `ClickListener`.
     *
     * @param v - Não necessário quando se chama o procedimento 'setOnClickListener'
     */
    @Override
    public void onClick(View v) {
        int idView = v.getId();
        Context context = v.getContext();

        if (isConnected(v)) {
            if (v.getId() == btnRegister.getId()) {

            } else {
                Intent intent = new Intent(activity, LoginActivity.class);

                context.startActivity(intent);
                activity.finish();
            }
        }
    }

    /***
     *      Método para verificar se o dispositivo está conectado à Internet
     *
     * @param v - Usado para capturar o contexto no qual se basea a aplicação
     * @return - verdadeiro se tem acesso à internet, senão uma mensagem avisando ao usuário
     */
    public boolean isConnected(View v) {
        Context c = activity.getApplicationContext();

        ConnectivityManager connMgr = (ConnectivityManager) c.getSystemService(activity.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();

        if (networkInfo != null && networkInfo.isConnected()) {
            return true;
        } else {
            Toast toast = Toast.makeText(activity, "Você não está conectado!", Toast.LENGTH_LONG);
            toast.show();

            return false;
        }
    }
}

package androidapp.gabrielrunescape.com.br.controller;

import android.view.View;
import android.widget.Toast;
import android.widget.Button;
import android.content.Context;
import android.net.NetworkInfo;
import android.widget.EditText;
import android.net.ConnectivityManager;
import androidapp.gabrielrunescape.com.br.model.ConnectionAsync;

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
     */
    public LoginController(Button btn1, Button btn2, EditText et1, EditText et2) {
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

        if (isConnected(v)) {
            if (v.getId() == btnLogin.getId()) {
                this.logar(v);
            } else {
                new ConnectionAsync(v, "GET", "").execute("http://192.168.180.135:3000/users");
            }
        }
    }

    /***
     *      Método para verificar se o dispositivo está conectado à Internet
     *
     * @param v - Usado para capturar o contexto no qual se basea a aplicação
     * @return - verdadeiro se tem acesso à internet, senão uma mensagem avisando ao usuário
     */
    public boolean isConnected(View v){
        Context context = v.getContext();
        Context c = context.getApplicationContext();

        ConnectivityManager connMgr = (ConnectivityManager) c.getSystemService(context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();

        if (networkInfo != null && networkInfo.isConnected()) {
            return true;
        } else {
            Toast toast =  Toast.makeText(context, "Você não está conectado!", Toast.LENGTH_LONG);
            toast.show();

            return false;
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
            Toast.makeText(v.getContext(), "Existem campos em branco!", Toast.LENGTH_LONG).show();
        } else {
            new ConnectionAsync(v, "POST", login + "/" + senha).execute("http://192.168.180.135:3000/users/");
        }
    }
}

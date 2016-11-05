package androidapp.gabrielrunescape.com.br.controller;

import android.app.*;
import android.net.*;
import android.widget.*;
import android.content.*;
import android.view.View;

import androidapp.gabrielrunescape.com.br.R;
import androidapp.gabrielrunescape.com.br.model.*;
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
    private EditText etName;
    private EditText etLogin;
    private EditText etEmail;
    private Activity activity;
    private RadioButton rbMale;
    private Button btnRegister;
    private EditText etPassword;
    private EditText etPassConf;
    private RadioButton rbFemale;
    private RadioGroup rgRegister;
    private Button btnLinkToLogin;

    /**
     *      Método construtor do controlador. Todos os valores devem ser passados já instanciados
     * através dos métodos acessores (GET e SET).
     *
     * @param a - Activity de execução
     */
    public RegisterController(Activity a) {
        this.activity = a;
    }

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
                String e1 = etName.getText().toString().trim();
                String e2 = etLogin.getText().toString().trim();
                String e3 = etEmail.getText().toString().trim();
                String e4 = etPassword.getText().toString().trim();
                String e5 = etPassConf.getText().toString().trim();

                if (rbMale.isChecked() || rbFemale.isChecked()) {
                    if (e1.isEmpty() || e2.isEmpty() || e3.isEmpty() || e4.isEmpty() || e5.isEmpty()) {
                        String msg = activity.getResources().getString(R.string.toastNull);
                        Toast.makeText(activity, msg, Toast.LENGTH_SHORT).show();
                    } else {
                        if (e4.equals(e5)) {
                            String genre = "M";

                            if (rbFemale.isChecked()) {
                                genre = "F";
                            }

                            Usuario u = new Usuario(e1, e2, e3, genre, e4);

                            new UsuarioAsync(activity, "POST", u).execute("http://192.168.180.135:3000/usuarios/");
                        } else {
                            String msg = activity.getResources().getString(R.string.toastNotMatch);
                            Toast.makeText(activity, msg, Toast.LENGTH_SHORT).show();
                        }
                    }
                } else {
                    String msg = activity.getResources().getString(R.string.toastGenre);
                    Toast.makeText(activity, msg, Toast.LENGTH_SHORT).show();
                }
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
            String msg = activity.getResources().getString(R.string.toastConnect);

            Toast toast = Toast.makeText(activity, msg, Toast.LENGTH_LONG);
            toast.show();

            return false;
        }
    }

    public Button getBtnLinkToLogin() {
        return btnLinkToLogin;
    }

    public void setBtnLinkToLogin(Button btnLinkToLogin) {
        this.btnLinkToLogin = btnLinkToLogin;
    }

    public Button getBtnRegister() {
        return btnRegister;
    }

    public void setBtnRegister(Button btnRegister) {
        this.btnRegister = btnRegister;
    }

    public EditText getEtEmail() {
        return etEmail;
    }

    public void setEtEmail(EditText etEmail) {
        this.etEmail = etEmail;
    }

    public EditText getEtLogin() {
        return etLogin;
    }

    public void setEtLogin(EditText etLogin) {
        this.etLogin = etLogin;
    }

    public EditText getEtPassConf() {
        return etPassConf;
    }

    public void setEtPassConf(EditText etPassConf) {
        this.etPassConf = etPassConf;
    }

    public EditText getEtPassword() {
        return etPassword;
    }

    public void setEtPassword(EditText etPassword) {
        this.etPassword = etPassword;
    }

    public RadioButton getRbFemale() {
        return rbFemale;
    }

    public void setRbFemale(RadioButton rbFemale) {
        this.rbFemale = rbFemale;
    }

    public RadioButton getRbMale() {
        return rbMale;
    }

    public void setRbMale(RadioButton rbMale) {
        this.rbMale = rbMale;
    }

    public RadioGroup getRgRegister() {
        return rgRegister;
    }

    public void setRgRegister(RadioGroup rgRegister) {
        this.rgRegister = rgRegister;
    }

    public EditText getEtName() {
        return etName;
    }

    public void setEtName(EditText etName) {
        this.etName = etName;
    }
}

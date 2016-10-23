package androidapp.gabrielrunescape.com.br.controller;

import android.widget.*;
import android.view.View;
import android.app.Activity;
import android.content.Intent;
import androidapp.gabrielrunescape.com.br.model.Usuario;
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

public class MainController implements View.OnClickListener {
    private Usuario usuario;
    private Button btnLogout;
    private TextView tvLogin;
    private TextView tvEmail;
    private Activity activity;

    /**
     *      Método construtor do controlador. Deve ser passado o valor já instânciado e iniciado
     * para que todas as funções subsequentes sejam executadas sem problemas.
     *
     * @param usuario - Objeto de usuário
     * @param a - Activity de execução
     */
    public MainController(Usuario usuario, Activity a) {
        this.activity = a;
        this.usuario = usuario;
    }

    /**
     *      Método construtor do controlador. Devem ser passados os valores já instânciados e
     * iniciados para que todas as funções subsequentes sejam executadas sem problemas.
     *
     * @param b1 - Botão para realizar logout
     * @param txt1 - TextView para exibição do login
     * @param txt2 - TextView para exibição do e-mail
     */
    public MainController(Button b1, TextView txt1, TextView txt2) {
        this.btnLogout = b1;
        this.tvLogin = txt1;
        this.tvEmail = txt2;
    }

    /***
     *      Método sobrescrito para poder realizar as ações de `ClickListener`.
     *
     * @param v - Não necessário quando se chama o procedimento 'setOnClickListener'
     */
    @Override
    public void onClick(View v) {
        Intent intent = new Intent(activity, LoginActivity.class);

        activity.startActivity(intent);
        activity.finish();
    }
}

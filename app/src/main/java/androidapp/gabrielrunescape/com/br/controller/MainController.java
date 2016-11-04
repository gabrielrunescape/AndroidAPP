package androidapp.gabrielrunescape.com.br.controller;

import android.widget.*;
import android.view.View;
import android.app.Activity;
import android.content.Intent;
import androidapp.gabrielrunescape.com.br.model.Usuario;
import androidapp.gabrielrunescape.com.br.view.LoginActivity;
import androidapp.gabrielrunescape.com.br.view.MainActivity;

/**
 *      Criado por GabrielRuneScape <gabrielfilipe@mail.ru> em 22/10/2016.
 *
 *      Classe controladora responsável por realizar o controle de todas as ações realizadas pela
 * `activity` de Register (activity_register.xml e RegisterActivity.java).
 *      Todas as operações realizadas nessa activity serão controladas por esta classe. A conexão
 * com a internet sempre será necessária para poder prosseguir com as demais funções dentro da
 * aplicação.
 */

public class MainController implements AdapterView.OnItemClickListener {
    private Activity activity;
    private GridView gridview;

    /**
     *      Método construtor do controlador. Deve ser passado o valor já instânciado e iniciado
     * para que todas as funções subsequentes sejam executadas sem problemas.
     *
     * @param a Activity de execução.
     * @param g GridView com os itens já instânciados.
     */
    public MainController(Activity a, GridView g) {
        this.activity = a;
        this.gridview = g;
    }

    /**
     *      Método `callback` para realizar a ação de um item do AdapterView quando clicado. Quando
     * determinada posição é clicada é realizada uma ação.
     *
     * @param parent   O AdapterView quando o clique é feito.
     * @param view     A view na qual foi clicada.
     * @param position A posição da view no adaptador.
     * @param id       A linha do item que foi clicado.
     */
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        switch (position) {
            case 5: // Logout
                logout();
                break;
            default:
                Toast.makeText(activity, "Botão: " + position, Toast.LENGTH_SHORT).show();
                break;
        }
    }

    /**
     *      Método para se desconectar da seção ativa e regressar a tela de autenticação.
     */
    private void logout() {
        Intent intent = new Intent(activity, LoginActivity.class);

        activity.startActivity(intent);
        activity.finish();
    }
}

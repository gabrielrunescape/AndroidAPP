package androidapp.gabrielrunescape.com.br.model;

import android.app.*;
import org.json.JSONObject;
import android.widget.Toast;
import android.os.AsyncTask;
import android.content.Intent;
import org.json.JSONException;
import androidapp.gabrielrunescape.com.br.view.LoginActivity;
import androidapp.gabrielrunescape.com.br.view.MainActivity;

/**
 *      Criado por GabrielRuneScape <gabrielfilipe@mail.ru> em 20/10/16.
 *
 *      Classe de conexão assincrona, pois o desempenho de rede através do protóloco HTTP e HTTP
 * devem ser através de uma tarefa assincrona.
 *      O método de envio é descrito inicialmente através de cada função para que possa ser enviado
 * através do protocólo HTTP/HTTPS. Sempre se deve receber os valores em JSON do WebService ou de
 * qualquer um outro externo.
 *      O principal método da classe é o `doInBackground` onde tudo contido ali dentro será executada
 * pela classe, sendo assim, substituindo os tradicionais métodos de construção. Neste caso, ele é
 * usado como detentor do envio da requisição de acesso ao webservice e recebimento dos pacotes.
 */

public class ConnectionAsync extends AsyncTask<String, Void, String> {
    private String params;
    private String method;
    private Activity activity;
    private Usuario usuario = null;

    /**
     *      Método contrutor para incicializar a classe assincrona. Devem ser passados os paramêtros
     * para passar os valores para as variáveis encapsuladas para realizar as demais funções.
     *
     * @param a - Activity em execução
     * @param method - Protocolo de transfêrencia para solicitação
     * @param params - Valores passados pela query
     */
    public ConnectionAsync(Activity a, String method, String params) {
        this.method = method;
        this.params = params;
        this.activity = a;
    }

    /**
     *      Método contrutor para incicializar a classe assincrona. Devem ser passados os paramêtros
     * para passar os valores para as variáveis encapsuladas para realizar as demais funções.
     *
     * @param a - Activity em execução
     * @param method - Protocolo de transfêrencia para solicitação
     * @param usr - Valores passados pela query
     */
    public ConnectionAsync(Activity a, String method, Usuario usr) {
        this.activity = a;
        this.usuario = usr;
        this.method = method;
    }

    @Override
    protected String doInBackground(String... url) {
        String _return = Connection.request(method, params, usuario);

        return _return;
    }

    @Override
    protected void onPostExecute(String result) {
        try {
            JSONObject object = new JSONObject(result);

            if (object.has("usuario")) {
                if (method.equals("POST")) {
                    int id = object.getJSONObject("usuario").getInt("ID");
                    String nome = object.getJSONObject("usuario").getString("Nome");
                    String sexo = object.getJSONObject("usuario").getString("Sexo");
                    String email = object.getJSONObject("usuario").getString("Email");
                    String login = object.getJSONObject("usuario").getString("Login");
                    String senha = object.getJSONObject("usuario").getString("Senha");

                    Usuario usuario = new Usuario(id, email, login, nome, senha, sexo);

                    Intent main = new Intent(activity, MainActivity.class);
                    main.putExtra("lbl_name", nome);
                    main.putExtra("lbl_mail", email);

                    activity.startActivity(main);
                    activity.finish();
                }
            } else {
                String msg = object.getString("message");
                Toast.makeText(activity, msg, Toast.LENGTH_SHORT).show();
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}

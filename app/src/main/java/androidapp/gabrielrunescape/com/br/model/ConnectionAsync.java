package androidapp.gabrielrunescape.com.br.model;

import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONException;

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
    private JSONArray array;

    /**
     *      Método contrutor para incicializar a classe assincrona. Devem ser passados os paramêtros
     * para passar os valores para as variáveis encapsuladas para realizar as demais funções.
     *
     * @param method - Protocolo de transfêrencia para solicitação
     * @param params - Valores passados pela query
     */
    public ConnectionAsync(String method, String params) {
        this.method = method;
        this.params = params;
    }

    @Override
    protected String doInBackground(String... url) {
        try {
            String _return = Connection.request(method, params);
            array = new JSONArray(_return);

            return _return;
        } catch (JSONException e) {
            e.printStackTrace();

            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String result) {
        System.out.println(result);
    }
}

package androidapp.gabrielrunescape.com.br.model;

import java.io.*;
import java.net.*;
import org.json.*;
import android.net.*;
import android.app.*;
import android.content.*;
import android.view.View;
import android.os.AsyncTask;
import android.widget.Toast;

import androidapp.gabrielrunescape.com.br.R;
import androidapp.gabrielrunescape.com.br.view.*;

/**
 *       Criado por GabrielRuneScape <gabrielfilipe@mail.ru> em 04/11/16.
 *
 *       Classe que controla o fluxo de informação através do protocólo HTTP e HTTPS onde se encontra
 * o `webservice` da aplicação online.
 *      O método de envio é descrito inicialmente através de cada função para que possa ser enviado
 * através do protocólo HTTP/HTTPS. Sempre se deve receber os valores em JSON do WebService ou de
 * qualquer um outro externo.
 */

public class UsuarioAsync extends AsyncTask<String, Void, String> {
    private String params;
    private String method;
    private Activity activity;
    private Usuario usuario = null;
    private static String LINK = "http://192.168.180.135:3000/usuarios/";

    /**
     *      Método contrutor para incicializar a classe assincrona. Devem ser passados os paramêtros
     * para passar os valores para as variáveis encapsuladas para realizar as demais funções.
     *
     * @param a - Activity em execução
     * @param method - Protocolo de transfêrencia para solicitação
     * @param params - Valores passados pela query
     */
    public UsuarioAsync(Activity a, String method, String params) {
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
    public UsuarioAsync(Activity a, String method, Usuario usr) {
        this.activity = a;
        this.usuario = usr;
        this.method = method;
    }

    /**
     *      Sobreescreve o método especificando os parametros passado executando um link chamando a
     * a tarefa comunicando com o webservice.
     *
     * @param url O parametro da tarefa.
     * @return    O resultado da subtarefa da subclasse.
     */
    @Override
    protected String doInBackground(String... url) {
        String _return = "";

        if (isConnected()) {
            switch (method) {
                case "GET":
                    _return = get(params);
                    break;
                case "POST":
                    if (usuario == null) {
                        _return = post(params);
                    } else {
                        _return = post(usuario);
                    }
                    break;
                default:
                    break;
            }
        }

        return _return;
    }

    /**
     *      Sobreescreve o método especificando o parametros do resultado do método doInBackground()
     * para a tarefa da subclasse herdada.
     *
     * @param result O parametro da consulta.
     */
    @Override
    protected void onPostExecute(String result) {
        if (!result.equals("")) {
            try {
                JSONObject object = new JSONObject(result);

                if (object.has("usuario")) {
                    if (method.equals("POST") && usuario == null) {
                        Intent intent = new Intent(activity, MainActivity.class);

                        activity.startActivity(intent);
                        activity.finish();
                    } else {
                        String msg = object.getString("message") + "\nAutentique-se para continuar!";
                        Toast.makeText(activity, msg, Toast.LENGTH_LONG).show();

                        Intent intent = new Intent(activity, LoginActivity.class);

                        activity.startActivity(intent);
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

    /**
     *      Método para requimento (request) do tipo GET. Faz uma consulta no `WebService` para
     * realizar o retorno e processamento das informações obtidas através do mesmo.
     *
     * @param params Valores a serem filtratos pelo `WebService`
     * @return       Resposta do `WebService`.
     */
    private static String get(String params) {
        URL url;
        StringBuffer response = null;
        HttpURLConnection connection = null;

        try {
            url = new URL(LINK + params);
            connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("POST");

            connection.setRequestProperty("Content-type", "application/json");
            connection.setRequestProperty("Content-Lenguage", "pt-BR");
            connection.setRequestProperty("Accept-Charset", "UTF-8");

            InputStream in = connection.getInputStream();
            BufferedReader input = new BufferedReader(new InputStreamReader(in));

            String inputLine;
            response = new StringBuffer();

            while ((inputLine = input.readLine()) != null) {
                response.append(inputLine);
            }

            input.close();
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            connection.disconnect();
        }

        return response.toString();
    }

    /**
     *      Método para requimento (request) do tipo POST. Faz uma transmissão para o `WebService`
     * realizando o retorno das informações processadas através do mesmo.
     *
     * @param params Parametros de URL Query.
     * @return       Resposta do `WebService`.
     */
    private static String post(String params) {
        URL url;
        StringBuffer response = null;
        HttpURLConnection connection = null;

        try {
            url = new URL(LINK + params);
            connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("POST");

            connection.setRequestProperty("Content-Length", Integer.toString(params.getBytes().length));
            connection.setRequestProperty("Content-type", "application/x-www-form-urlencoded");
            connection.setRequestProperty("Content-Lenguage", "pt-BR");
            connection.setRequestProperty("Accept-Charset", "UTF-8");

            connection.setDoInput(true);
            connection.setDoOutput(true);

            DataOutputStream data = new DataOutputStream(connection.getOutputStream());
            data.writeBytes(params);
            data.flush();
            data.close();

            InputStream in = connection.getInputStream();
            BufferedReader input = new BufferedReader(new InputStreamReader(in));

            String inputLine;
            response = new StringBuffer();

            while ((inputLine = input.readLine()) != null) {
                response.append(inputLine);
            }

            input.close();
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return response.toString();
    }

    /**
     *      Método para requimento (request) do tipo POST. Faz uma transmissão para o `WebService`
     * do JSON com as informações do usuário e retornando os valores transmitidos caso haja êxito.
     *
     * @param usr Objeto Usuario para ser convertido em JSON.
     * @return    Resposta do `WebService`.
     */
    private static String post(Usuario usr) {
        URL url;
        StringBuffer response = null;
        HttpURLConnection connection = null;

        try {
            url = new URL(LINK);
            connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("POST");

            connection.setRequestProperty("Content-type", "application/json");
            connection.setRequestProperty("Content-Lenguage", "pt-BR");
            connection.setRequestProperty("Accept-Charset", "UTF-8");

            connection.setDoInput(true);
            connection.setDoOutput(true);

            JSONObject json = new JSONObject();
            json.put("nome", usr.getNome());
            json.put("sexo", usr.getSexo());
            json.put("login", usr.getLogin());
            json.put("email", usr.getEmail());
            json.put("senha", usr.getSenha());

            OutputStream os = connection.getOutputStream();
            BufferedWriter data = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));
            data.write(json.toString());
            data.flush();
            data.close();

            InputStream in = connection.getInputStream();
            BufferedReader input = new BufferedReader(new InputStreamReader(in));

            String inputLine;
            response = new StringBuffer();

            while ((inputLine = input.readLine()) != null) {
                response.append(inputLine);
            }

            input.close();
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return response.toString();
    }



    /***
     *      Método para verificar se o dispositivo está conectado à Internet
     *
     * @return Verdadeiro se tem acesso à internet, senão uma mensagem avisando ao usuário
     */
    public boolean isConnected(){
        Context c = activity.getApplicationContext();

        ConnectivityManager connMgr = (ConnectivityManager) c.getSystemService(activity.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();

        if (networkInfo != null && networkInfo.isConnected()) {
            try {
                URL url = new URL(LINK);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();

                connection.setRequestMethod("GET");

                connection.setRequestProperty("Content-type", "application/json");
                connection.setRequestProperty("Content-Lenguage", "pt-BR");
                connection.setRequestProperty("Accept-Charset", "UTF-8");

                return true;
            } catch (final Exception e) {
                activity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(activity, e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });

                return false;
            }
        } else {
            final String msg = activity.getResources().getString(R.string.toastConnect);

            activity.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(activity, msg, Toast.LENGTH_SHORT).show();
                }
            });

            return false;
        }
    }
}

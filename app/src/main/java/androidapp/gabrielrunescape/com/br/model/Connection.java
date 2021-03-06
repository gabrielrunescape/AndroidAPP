package androidapp.gabrielrunescape.com.br.model;

import java.io.*;
import java.net.*;
import org.json.*;

/**
 *      Criado por GabrielRuneScape <gabrielfilipe@mail.ru> em 19/10/2016.
 *
 *      Classe que controla o fluxo de informação através do protocólo HTTP e HTTPS onde se encontra
 * o `webservice` da aplicação online.
 *      O método de envio é descrito inicialmente através de cada função para que possa ser enviado
 * através do protocólo HTTP/HTTPS. Sempre se deve receber os valores em JSON do WebService ou de
 * qualquer um outro externo.
 */

public class Connection {
    private static String LINK = "http://192.168.180.135:3000/usuarios/";

    public static String request(String method, String params, Usuario usr) {
        String _return = null;

        switch (method) {
            case "GET":
                _return = get(params);
                break;
            case "POST":
                if (usr == null) {
                    _return = post(params);
                } else {
                    _return = post(usr);
                }
                break;
            case "PUT":
                put();
                break;
            case "DELETE":
                delete();
                break;
            default:

                break;
        }

        return _return;
    }

    /**
     *      Método para requimento (request) do tipo GET. Faz uma consulta no `WebService` para
     * realizar o retorno e processamento das informações obtidas através do mesmo.
     *
     * @param params - Valores a serem filtratos pelo `WebService`
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

    private static void put() {

    }

    private static void delete() {

    }
}

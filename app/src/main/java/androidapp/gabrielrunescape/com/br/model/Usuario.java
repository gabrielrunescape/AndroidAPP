package androidapp.gabrielrunescape.com.br.model;

/**
 * Created by gabriel on 21/10/16.
 */

public class Usuario {
    private String login;
    private String senha;
    private String email;

    public Usuario(String email, String login, String senha) {
        this.email = email;
        this.login = login;
        this.senha = senha;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

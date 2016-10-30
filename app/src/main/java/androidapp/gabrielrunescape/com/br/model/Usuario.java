package androidapp.gabrielrunescape.com.br.model;

/**
 *      Criado por GabrielRuneScape <gabrielfilipe@mail.ru> em 21/10/2016.
 *
 *      Objeto de usuário dentro do webservice.
 */

public class Usuario {
    private String _id;
    private String nome;
    private String sexo;
    private String login;
    private String senha;
    private String email;

    public Usuario(String login, String email, String senha) {
        this.email = email;
        this.login = login;
        this.senha = senha;
    }

    public Usuario(String id, String email, String login, String senha) {
        this._id = id;
        this.email = email;
        this.login = login;
        this.senha = senha;
    }

    public Usuario(String nome, String login, String email, String sexo, String senha) {
        this.nome = nome;
        this.sexo = sexo;
        this.email = email;
        this.login = login;
        this.senha = senha;
    }

    public String getID() {
        return _id;
    }

    public void setID(String id) {
        this._id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
}

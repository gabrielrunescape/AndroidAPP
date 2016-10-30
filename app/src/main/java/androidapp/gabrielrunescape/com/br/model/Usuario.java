package androidapp.gabrielrunescape.com.br.model;

/**
 *      Criado por GabrielRuneScape <gabrielfilipe@mail.ru> em 21/10/2016.
 *
 *      Objeto de usuário dentro do webservice.
 */

public class Usuario {
    private int _id;
    private String nome;
    private String sexo;
    private String login;
    private String senha;
    private String email;

    /**
     *      Método construtor para o objeto Usuario. Cria um Usuario copiando alguns para o objeto.
     *
     * @param id - Código identificador do usuário
     * @param email - E-mail do usuário
     * @param login - Nome de usuário
     * @param senha - Senha com hash do usuário
     */
    public Usuario(int id, String email, String login, String senha) {
        this._id = id;
        this.email = email;
        this.login = login;
        this.senha = senha;
    }

    /**
     *      Método construtor para o objeto Usuario. Cria um novo Usuario sem um ID.
     *
     * @param nome - Nome do usuário
     * @param login - Nome de usuário
     * @param email - E-mail do usuário
     * @param sexo - Sexo do usuário
     * @param senha - Senha com hash do usuário
     */
    public Usuario(String nome, String login, String email, String sexo, String senha) {
        this.nome = nome;
        this.sexo = sexo;
        this.email = email;
        this.login = login;
        this.senha = senha;
    }

    /**
     *      Método construtor para um objeto Usuario. Cria um novo Usuário com todas as informações.
     *
     * @param id - Código identificador do usuário
     * @param email - E-mail do usuário
     * @param login - Nome de usuário
     * @param nome - Nome do usuário
     * @param senha - Senha com hash do usuário
     * @param sexo - Sexo do usuário
     */
    public Usuario(int id, String email, String login, String nome, String senha, String sexo) {
        this._id = id;
        this.email = email;
        this.login = login;
        this.nome = nome;
        this.senha = senha;
        this.sexo = sexo;
    }

    public int getID() {
        return _id;
    }

    public void setID(int id) {
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

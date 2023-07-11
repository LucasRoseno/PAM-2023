package br.teste;

public class Contatos {

    private String nome;
    private String sobrenome;
    private String idade;

    public Contatos(String nome,String sobrenome,String idade)
    {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.idade = idade;
    }

    public void setNome(String nome)
    {
        this.nome = nome;
    }
    public String getNome()
    {
        return nome;
    }
    public void setSobrenome(String sobrenome)
    {
        this.sobrenome = sobrenome;
    }
    public String getSobrenome()
    {
        return sobrenome;
    }
    public void setIdade(String idade)
    {
        this.idade = idade;
    }
    public String getIdade()
    {
        return idade;
    }
}

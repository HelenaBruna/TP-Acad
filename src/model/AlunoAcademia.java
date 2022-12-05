package model;

public class AlunoAcademia {

    private String nome;
    private int idade;
    private float peso;
    private float altura;
    private String objetivo;

    public String getNome() {
        return this.nome;
    }

    public void setNome(String Nome) {
        this.nome = Nome;
    }

    public int getIdade() {
        return this.idade;
    }

    public void setIdade(int Idade) {
        this.idade = Idade;
    }

    public float getPeso() {
        return this.peso;
    }

    public void setPeso(float Peso) {
        this.peso = Peso;
    }

    public float getAltura() {
        return this.altura;
    }

    public void setAltura(float Altura) {
        this.altura = Altura;
    }

    public String getObjetivo() {
        return this.objetivo;
    }

    public void setObjetivo(String Obj) {
        this.objetivo = Obj;
    }

}
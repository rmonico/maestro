package zero.maestrocli.renderer;

import zero.easymvc.PositionalParameter;

public class TagCreateArguments {

    @PositionalParameter
    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}

import java.util.Random;

public class Dado {

    private int valorMaximo;
    private String cor;
    private boolean ativo;
    private int ultimoNumeroJogado;

    public Dado() {
        this.valorMaximo = 6;
        this.ativo = true;
    }

    public void jogarDado() {
        Random rand = new Random();
        this.ultimoNumeroJogado = rand.nextInt(this.valorMaximo) + 1;
    }

    public int getUltimoNumeroJogado() {
        return ultimoNumeroJogado;
    }

    public void setUltimoNumeroJogado(int ultimoNumeroJogado) {
        this.ultimoNumeroJogado = ultimoNumeroJogado;
    }

    public int getValorMaximo() {
        return valorMaximo;
    }

    public void setValorMaximo(int valorMaximo) {
        if (valorMaximo < 2) {
            this.valorMaximo = 2;
        }
        else {
            this.valorMaximo = valorMaximo;
        }
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

}

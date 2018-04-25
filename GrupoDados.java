import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GrupoDados {

    private List<Dado> dados;
    List<Integer> valoresJogados;
    private int quantidadeDadosAtivos;

    public GrupoDados() {
        dados = new ArrayList<Dado>();
        valoresJogados = new ArrayList<>();
        addDado(6);
        setQuantidadeDadosAtivos(1);
    }

    /**
     * Joga todos os dados ativos
     */
    public void jogarDados() {
        this.valoresJogados.clear();

        for (Dado dado : dados) {
            if (dado.isAtivo()) {
                dado.jogarDado();
                this.valoresJogados.add(dado.getUltimoNumeroJogado());
            }
        }
    }

    /**
     * Verifica qual foi o maior número jogado de todos os dados ativos
     *
     * @return maior número de um dado
     */
    public int maiorNumeroJogado() {
        return Collections.max(this.valoresJogados);
    }

    public int menorNumeroJogado() {
        return Collections.min(this.valoresJogados);
    }

    /**
     * Função que verifica qual é o valor de um dado
     *
     * @param numeroDado indice do dado
     * @return resultado do dado
     */
    public int resultadoDado(int numeroDado) {
        return dados.get(numeroDado).getUltimoNumeroJogado();
    }

    private void addDado(int quantidade) {
        int i = 1;
        while (i <= quantidade) {
            dados.add(new Dado());
            i++;
        }
    }

    public int getQuantidadeDadosAtivos() {
        return quantidadeDadosAtivos;
    }

    public void setQuantidadeDadosAtivos(int quantidadeDadosAtivos) {
        if (quantidadeDadosAtivos < 0) {
            this.quantidadeDadosAtivos = 1;
        }
        else {
            if (quantidadeDadosAtivos > 6) {
                this.quantidadeDadosAtivos = 6;
            }
            else {
                this.quantidadeDadosAtivos = quantidadeDadosAtivos;
            }
        }

        desativarTodosDados();

        for (int i = 0; i < this.quantidadeDadosAtivos; i++) {
            dados.get(i).setAtivo(true);
        }
    }

    private void desativarTodosDados() {
        for (Dado dado : dados) {
            dado.setAtivo(false);
        }
    }

    public int somaDadosJogados() {
        int total = 0;
        for (Dado dado : dados) {
            if (dado.isAtivo()) {
                total = total + dado.getUltimoNumeroJogado();
            }
        }
        return total;
    }

}

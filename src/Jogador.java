public class Jogador {
    private int pontuacao;
    private int jogadasFeitas;

    public Jogador() {
        pontuacao = 0;
        jogadasFeitas = 0;
    }

    public void adicionarPontos() {
        pontuacao = pontuacao + 10;
    }

    public void removerPontos() {
        pontuacao = pontuacao - 5;
    }

    public int getPontuacao() {
        return pontuacao;
    }
}

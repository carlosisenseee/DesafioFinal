public class Jogador {
    private int pontuacao;
    private int jogadasFeitas;

    public Jogador() {
        pontuacao = 0;
        jogadasFeitas = 0;
    }

    public void contadorDePontos(Mapa mapa, int linha, int coluna) {
        if (mapa.mapa[linha][coluna].equals(" T ")) {
            pontuacao += 10;
        }
        if (mapa.mapa[linha][coluna].equals(" A ")) {
            pontuacao -= 5;
        }
        jogadasFeitas++;
    }

    public int getPontuacao() {
        return pontuacao;
    }

    public int getJogadasFeitas() {
        return jogadasFeitas;
    }
}
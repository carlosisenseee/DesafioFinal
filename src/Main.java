import java.util.Scanner;

public class Main {
    static Scanner scan = new Scanner(System.in);
    static Mapa mapa  = new Mapa(8,8,8,5);
    static Jogador jogador = new Jogador();
    public static void main(String[] args) {
        /* Fazer o metodo de jogar onde:
        * 1 - Pegue a resposta da jogada
        * 2 - Leia e guarde os valores
        * 3 - Compare com as cooredenadas do mapaOculto e caso tenha algo, altere no mapa (mapa e mapaOcultos são os vetores da classe Mapa)
        * 4 - De ou retire os pontos dos jogador */
        mapa.preencherMapa();
        mapa.criaElementos(8, 5);
        int linha;
        int coluna;

        do {
            mapa.mostrarMapaOculto();
            System.out.println("Digite as coordenadas para a escavação (linha e coluna, separadas por espaço): ");
            linha = scan.nextInt();
            coluna = scan.nextInt();

            mapa.cavar(linha, coluna);
            jogador.contadorDePontos(mapa, linha, coluna);
            mapa.mostrarMapa();
            System.out.println("Pontuação atual: " + jogador.getPontuacao());

        } while (linha != 9 && coluna != 9);


    }
}

//FARINHA SUPER BRUHHHHHHHHHHHHHHHHH
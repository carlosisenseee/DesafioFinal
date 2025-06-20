import java.util.Scanner;

public class Main {
    static Scanner scan = new Scanner(System.in);
    static Mapa mapa  = new Mapa(8,8,8,5);
    static Jogador jogador = new Jogador();
    public static void main(String[] args) {
        mapa.preencherMapa();
        mapa.preencheMapaOculto();
        int linha;
        int coluna;

        do {
            System.out.println("Digite as coordenadas para a escavação (linha e coluna, separadas por espaço): ");
            linha = scan.nextInt();
            coluna = scan.nextInt();

            if (linha >= mapa.getLinhas() || coluna >= mapa.getColunas() || linha < 0 || coluna < 0) {
                System.out.println("Coordenadas Invalidas!\n");
            } else {
                if (Mapa.mapa[linha][coluna].equals(" ~ ")) {
                    mapa.cavar(linha, coluna);
                    jogador.contadorDePontos(mapa, linha, coluna);
                    mapa.mostrarMapa();
                    System.out.println("Pontuação atual: " + jogador.getPontuacao());

                    if (mapa.getTesourosEncontrados() == 8) {
                        System.out.println("Você venceu! ;)\n");
                        break;
                    }
                } else {
                    System.out.println("Você ja jogou nessa posição!\n");
                }

            }
        } while (jogador.getJogadasFeitas() != 25);

        if (jogador.getJogadasFeitas() == 25 && mapa.getTesourosEncontrados() != 8) {
            System.out.println("\nVocê perdeu! :(\n");
        }

        System.out.println("Mapa com as posições!");
        mapa.mostrarMapaOculto();
        if (jogador.getPontuacao() >= 70) {
            System.out.println("\nExplorador Lendário!");
        } else if (jogador.getPontuacao() >= 50 && jogador.getPontuacao() <= 69) {
            System.out.println("\nCaçador de Tesouros Experiente!");
        } else if (jogador.getPontuacao() >= 30 && jogador.getPontuacao() <= 49) {
            System.out.println("\nAventureiro Iniciante");
        } else {
            System.out.println("\nPrecisa de mais prática na exploração");
        }
    }
}
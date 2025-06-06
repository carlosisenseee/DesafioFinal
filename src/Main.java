public class Main {
    static Mapa mapa  = new Mapa(8,8,8,5);
    static Jogador jogador = new Jogador();
    public static void main(String[] args) {
        /* Fazer o metodo de jogar onde:
        * 1 - Pegue a resposta da jogada
        * 2 - Leia e guarde os valores
        * 3 - Compare com as cooredenadas do mapaOculto e caso tenha algo, altere no mapa (mapa e mapaOcultos são os vetores da classe Mapa)
        * 4 - De ou retire os pontos dos jogador */

        mapa.preencherMapa();

        mapa.mostrarMapa();

        mapa.criaElementos(8, 5);

        mapa.mostrarMapaOculto();
    }
}
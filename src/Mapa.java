import java.util.Random;

public class Mapa {
    private int linhas;
    private int colunas;
    public static String[][] mapa;
    public static String[][] mapaOculto;
    private int tesouros;
    private int bombas;
    private int tesourosEncontrados;
    Random gerador = new Random();

    public Mapa(int linhas, int colunas, int tesouros, int bombas) {
        setLinhas(linhas);
        setColunas(colunas);
        setTesouros(tesouros);
        setBombas(bombas);
        tesourosEncontrados = 0;

        mapa = new String[this.linhas][this.colunas];
        mapaOculto  = new String[linhas][colunas];
    }

    public void preencheMapaOculto() {
        int[] tesourosColunas = new int[tesouros + bombas]; //tesouros ficam ate o indice 7, e apartir disso são bombas
        int[] tesourosLinhas = new int[tesouros + bombas];
        int i = 0;

        while (i < (tesouros + bombas)) {
            int linha = gerador.nextInt(linhas);
            int coluna = gerador.nextInt(colunas);
            boolean repetido = false;
            for (int j = 0; j < i; j++) {
                if ((tesourosLinhas[j] == linha) && (tesourosColunas[j] == coluna)) {
                        repetido = true;
                        break;
                    }
                }
            if (!repetido) {
                tesourosLinhas[i] = linha;
                tesourosColunas[i] = coluna;
                if (i <= 7) {
                    mapaOculto[tesourosLinhas[i]][tesourosColunas[i]] = " t ";
                } else {
                    mapaOculto[tesourosLinhas[i]][tesourosColunas[i]] = " a ";
                }
                i++;
            }
        }
            //Cria a areia
            for (int x = 0; x < linhas; x++) {
                for (int j = 0; j < colunas; j++) {
                    if (mapaOculto[x][j] == null) {
                        mapaOculto[x][j] = " ~ ";
                    }
                }
            }
        }

    public void preencherMapa() {
        for (int i = 0; i < getLinhas(); i++) {
            for (int j = 0; j < getColunas(); j++) {
                if (mapa[i][j] == null) {
                    mapa[i][j] = " ~ ";
                }
            }
        }
    }

    public void mostrarMapa() {
        System.out.print("   0  1  2  3  4  5  6  7\n");
        for (int i = 0; i < getLinhas(); i++) {
            System.out.print(i + " ");
            for (int j = 0; j < getColunas(); j++) {
                System.out.print(mapa[i][j]);
            }
            System.out.println();
        }
    }

    public void mostrarMapaOculto() {
        System.out.print("   0  1  2  3  4  5  6  7\n");
        for (int i = 0; i < getLinhas(); i++) {
            System.out.print(i + " ");
            for (int j = 0; j < getColunas(); j++) {
                System.out.print(mapaOculto[i][j]);
            }
            System.out.println();
        }
    }

    public void cavar(int linha, int coluna) {
        if (mapaOculto[linha][coluna].equals(" t ")) {
            mapa[linha][coluna] = " T ";
            System.out.println("Você encontrou um tesouro!");
            tesourosEncontrados++;
        }
        if (mapaOculto[linha][coluna].equals(" a ")) {
            mapa[linha][coluna] = " A ";
            System.out.println("Você encontrou uma armadinha :(");
        }
        if (mapaOculto[linha][coluna].equals(" ~ ")) {
            mapa[linha][coluna] = " O ";
            System.out.println("Você errou, encontrou areia");
        }
    }

    public int getTesourosEncontrados() {
        return tesourosEncontrados;
    }
    public int getLinhas() {
        return linhas;
    }
    public void setLinhas(int linhas) {
        if (linhas <= 0) {
            System.out.println("Valor Invalido");
        } else {
            this.linhas = linhas;
        }
    }
    public int getColunas() {
        return colunas;
    }
    public void setColunas(int colunas) {
        if (colunas <= 0) {
            System.out.println("Valor Invalido");
        } else {
            this.colunas = colunas;
        }
    }
    public int getTesouros() {
        return tesouros;
    }
    public void setTesouros(int tesouros) {
        if (tesouros < 0) {
            System.out.println("Valor Invalido");
        } else {
            this.tesouros = tesouros;
        }
    }
    public int getBombas() {
        return bombas;
    }
    public void setBombas(int bombas) {
        if (bombas <= 0) {
            System.out.println("Valor Invalido");
        } else {
            this.bombas = bombas;
        }
    }
}
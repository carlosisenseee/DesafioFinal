import java.util.Random;

public class Mapa {
    private int linhas;
    private int colunas;
    public String[][] mapa;
    public String[][] mapaOculto;
    private int tesouros;
    private int bombas;
    Random gerador = new Random();

    public Mapa(int linhas, int colunas, int tesouros, int bombas) {
        setLinhas(linhas);
        setColunas(colunas);
        setTesouros(tesouros);
        setBombas(bombas);

        mapa = new String[this.linhas][this.colunas];
        mapaOculto  = new String[linhas][colunas];
    }

    public void criaElementos(int tesouros, int bombas) {
        int[] tesourosColunas = new int[tesouros + bombas]; //tesouros ficam ate o indice 7, e apartir disso são bombas!
        int[] tesourosLinhas = new int[tesouros + bombas];
        //Cria tesouros e bombas
        for (int i = 0; i < tesouros + bombas; i++) {
            int linha = gerador.nextInt(linhas);
            int coluna = gerador.nextInt(colunas);
            if (i <= 7) {
                for (int j = 0; j < i; j++) {
                    if (tesourosLinhas[j] == linha) {
                        if (tesourosColunas[j] == coluna) {
                            linha = gerador.nextInt(tesouros);
                            coluna = gerador.nextInt(tesouros);
                        }
                    }
                }
                tesourosLinhas[i] = linha;
                tesourosColunas[i] = coluna;
                mapaOculto[linha][coluna] = " t ";
            } else {
                for (int j = 0; j < i; j++) {
                    if (tesourosLinhas[j] == linha) {
                        if (tesourosColunas[j] == coluna) {
                            linha = gerador.nextInt(tesouros);
                            coluna = gerador.nextInt(tesouros);
                        }
                    }
                }
                tesourosLinhas[i] = linha;
                tesourosColunas[i] = coluna;
                mapaOculto[linha][coluna] = " a ";
            }
        }

        //Cria a areia
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                if (mapaOculto[i][j] == null) {
                    mapaOculto[i][j] = " ~ ";
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
        if (mapaOculto[linha][coluna] == " t ") {
            mapa[linha][coluna] = " T ";
        }
        if (mapaOculto[linha][coluna] == " a ") {
            mapa[linha][coluna] = " A ";
        }
        if (mapaOculto[linha][coluna] == " ~ ") {
            mapa[linha][coluna] = " O ";
        }
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

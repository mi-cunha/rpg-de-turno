public class Arqueiro extends Personagem {
    private int destreza;



    public Arqueiro(String nome, int pontosVida, int forca, int defesa, boolean vulnerabilidade, int destreza) {
        super(nome, pontosVida, forca, defesa, vulnerabilidade);
        this.destreza = destreza;
    }

    public int getDestreza() {
        return destreza;
    }

    public void setDestreza(int destreza) {
        this.destreza = destreza;
    }
    
}

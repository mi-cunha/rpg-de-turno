public class Guerreiro extends Personagem {
    private int resistencia;

    public Guerreiro(String nome, int pontosVida, int forca, int defesa, boolean vulnerabilidade, int resistencia) {
        super(nome, pontosVida, forca, defesa, vulnerabilidade);
        this.resistencia = resistencia;
    }

    public int getResistencia() {
        return resistencia;
    }

    public void setResistencia(int resistencia) {
        this.resistencia = resistencia;
    }
    
}

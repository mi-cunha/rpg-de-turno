public class Inimigo extends Personagem {
    private String tipo;
    private int recompensaXP;
    
    public Inimigo(String nome, int pontosVida, int forca, int defesa, boolean vulnerabilidade, String tipo,
            int recompensaXP) {
        super(nome, pontosVida, forca, defesa, vulnerabilidade);
        this.tipo = tipo;
        this.recompensaXP = recompensaXP;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getRecompensaXP() {
        return recompensaXP;
    }

    public void setRecompensaXP(int recompensaXP) {
        this.recompensaXP = recompensaXP;
    }

}

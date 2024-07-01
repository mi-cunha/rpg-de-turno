public class Cavaleiro extends Personagem {
    private int valentia;



    public Cavaleiro(String nome, int pontosVida, int forca, int defesa, boolean vulnerabilidade, int valentia) {
        super(nome, pontosVida, forca, defesa, vulnerabilidade);
        this.valentia = valentia;
    }

    public int getValentia() {
        return valentia;
    }

    public void setValentia(int valentia) {
        this.valentia = valentia;
    }
    
}

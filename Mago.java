public class Mago extends Personagem {
    private int inteligencia;

    public Mago(String nome, int pontosVida, int forca, int defesa, boolean vulnerabilidade, int inteligencia) {
        super(nome, pontosVida, forca, defesa, vulnerabilidade);
        this.inteligencia = inteligencia;
    }

    public int getInteligencia() {
        return inteligencia;
    }

    public void setInteligencia(int inteligencia) {
        this.inteligencia = inteligencia;
    }   
    
    
    public int UsarMagia(Personagem adv) {
        if(this.inteligencia >= 10) {
            int danoMagico = this.getForca() * 2 - adv.getDefesa();
            if(danoMagico > 0) {
                adv.setPontosVida(adv.getPontosVida() - danoMagico);
            } else {
                danoMagico = 0;
            }
            this.inteligencia -= 10;
            System.out.println(this.getNome() + " lançou magia!");
            return danoMagico;
            
        } else {
            System.out.println(this.getNome() + " não tem pontos de magia suficientes!");
            return 0;
        }
    }
    
}

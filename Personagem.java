import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Personagem {
    private String nome;
    private int pontosVida;
    private int forca;
    private int defesa;
    private boolean vulnerabilidade;
    private List<Habilidade> habilidades;

    public Personagem(String nome, int pontosVida, int forca, int defesa, boolean vulnerabilidade) {
        this.nome = nome;
        this.pontosVida = pontosVida;
        this.forca = forca;
        this.defesa = defesa;
        this.vulnerabilidade = false;
        this.habilidades = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPontosVida() {
        return pontosVida;
    }

    public void setPontosVida(int pontosVida) {
        this.pontosVida = pontosVida;
    }

    public int getForca() {
        return forca;
    }

    public void setForca(int forca) {
        this.forca = forca;
    }

    public int getDefesa() {
        return defesa;
    }

    public void setDefesa(int defesa) {
        this.defesa = defesa;
    }

    public boolean isVulneravel() {
        return vulnerabilidade;
    }

    public void setVulnerabilidade(boolean vulnerabilidade) {
        this.vulnerabilidade = vulnerabilidade;
    }    

    public List<Habilidade> getHabilidades() {
        return habilidades;
    }

    public void adicionarHabilidade(Habilidade habilidade) {
        this.habilidades.add(habilidade);
    }

    public int atacar(Personagem adv) {
        if (!this.estaVivo() || !adv.estaVivo()) {
            return 0;
        }

        Habilidade habilidade = selecionarHabilidade();
        int dano = calcularDano(habilidade, adv);

        adv.setPontosVida(adv.getPontosVida() - dano);
        return dano;
    }

    private Habilidade selecionarHabilidade() {
        if (habilidades.isEmpty()) {
            return new Habilidade("Ataque Básico", "Normal", forca);
        }
        return habilidades.get((int) (Math.random() * habilidades.size()));
    }

    private int calcularDano(Habilidade habilidade, Personagem adv) {
        int danoBase = habilidade.getDanoBase();
        int dano = danoBase - adv.getDefesa();

        if (habilidade.getTipo().equals("Fogo") && adv instanceof Mago) {
            dano *= 2; 
        } else if (habilidade.getTipo().equals("Gelo") && adv instanceof Guerreiro) {
            dano /= 2; 
        }

        return Math.max(dano, 0); 
    }

    public void defender() {
        System.out.println(this.nome + " está se defendendo.");
    }

    public boolean tentarFugir() {
        System.out.println(this.nome + " tentou fugir e está vulnerável!");
        this.vulnerabilidade = true;

        Random rand = new Random();
        return rand.nextBoolean(); // 50% de chance de sucesso
    }

    public boolean estaVivo() {
        return this.pontosVida > 0;
    }

    public void usarHabilidade() {
        System.out.println(this.nome + " não possui uma habilidade especial.");
    }
}

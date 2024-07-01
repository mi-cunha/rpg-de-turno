import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Batalha {
    private List<Personagem> personagens;

    public Batalha(List<Personagem> personagens) {
        this.personagens = personagens;
    }

    public void iniciar() {
        definirOrdem();
        executarCombate();
        exibirResultado();
        atualizarAtributos();
        determinarVencedor();
    }

    private void definirOrdem() {
        Collections.sort(personagens, new Comparator<Personagem>() {
            public int compare(Personagem p1, Personagem p2) {
                return p2.getForca() - p1.getForca();
            }
        });
    }

    private void executarCombate() {
        boolean combateAtivo = true;
        while (combateAtivo) {
            for (Personagem personagem : personagens) {
                if (personagem.estaVivo() && !personagem.isVulneravel()) {
                    Personagem adv = selecionarAdversario(personagem);
                    if (adv != null) {
                        int dano = personagem.atacar(adv);
                        System.out.println(personagem.getNome() + " atacou " + adv.getNome() + " causando " + dano + " de dano!");
                        if (!adv.estaVivo()) {
                            System.out.println(adv.getNome() + " foi derrotado!");
                            concederExperiencia(personagem, adv);
                        }
                    }
                } else if (personagem.isVulneravel()) {
                    personagem.setVulnerabilidade(false);
                }
            }
            combateAtivo = verificarCombateAtivo();
        }
    }

    private Personagem selecionarAdversario(Personagem atacante) {
        List<Personagem> adversarios = new ArrayList<>();
        for (Personagem p : personagens) {
            if (p != atacante && p.estaVivo()) {
                adversarios.add(p);
            }
        }
        if (adversarios.isEmpty()) {
            return null;
        }
        return adversarios.get((int) (Math.random() * adversarios.size()));
    }

    private boolean verificarCombateAtivo() {
        int vivos = 0;
        for (Personagem p : personagens) {
            if (p.estaVivo()) {
                vivos++;
            }
        }
        return vivos > 1;
    }

    public void turno(Personagem personagem) {
        if (personagem.isVulneravel()) {
            System.out.println(personagem.getNome() + " está vulnerável e não pode contra-atacar!");
            personagem.setVulnerabilidade(false);
            return;
        }
    }

    private void concederExperiencia(Personagem vencedor, Personagem derrotado) {
        System.out.println(vencedor.getNome() + " venceu " + derrotado.getNome() + " e ganhou 20 XP!");
    }

    private void exibirResultado() {
        System.out.println("Resultado da Batalha: ");
        for (Personagem p : personagens) {
            System.out.println(p.getNome() + ": " + p.getPontosVida() + " pontos de vida restantes.");
        }
    }

    private void atualizarAtributos() {
        for (Personagem p : personagens) {
            if (!p.estaVivo()) {
                p.setPontosVida(100); 
            }
        }
    }

    private void determinarVencedor() {
        for (Personagem p : personagens) {
            if (p.estaVivo()) {
                System.out.println(p.getNome() + " é o vencedor!");
                return;
            }
        }
        System.out.println("Não há vencedores!");
    }
}

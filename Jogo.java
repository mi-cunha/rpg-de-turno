import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Jogo {
    private List<Personagem> personagens;
    private List<Inimigo> inimigos;

    public Jogo() {
        this.personagens = new ArrayList<>();
        this.inimigos = new ArrayList<>();
        inicializarPersonagens();
        inicializarInimigos();
    }

    private void inicializarPersonagens() {
        Guerreiro guerreiro = new Guerreiro("Aragorn", 100, 20, 10, false, 20);
        Mago mago = new Mago("Gandalf", 80, 10, 5, false, 50);
        Arqueiro arqueiro = new Arqueiro("Legolas", 90, 15, 8, false, 25);
        Cavaleiro cavaleiro = new Cavaleiro("Camelot", 100, 50, 30, false, 30);

        personagens.add(arqueiro);
        personagens.add(guerreiro);
        personagens.add(mago);
        personagens.add(cavaleiro);
    }

    private void inicializarInimigos() {
        Inimigo inimigo1 = new Inimigo("Bowser", 100, 20, 15, false, "chefao", 20);
        Inimigo inimigo2 = new Inimigo("Orc", 70, 30, 20, false, "monstro", 20);

        inimigos.add(inimigo1);
        inimigos.add(inimigo2);
    }

    public void executarJogo() {
        while (!inimigos.isEmpty() && !personagens.isEmpty()) {
            System.out.println("\n=== Novo Combate ===\n");

            // Criar uma lista temporária para a batalha atual
            List<Personagem> personagensTemp = new ArrayList<>(personagens);
            personagensTemp.addAll(inimigos);

            // Criar uma nova instância de Batalha com a lista temporária
            Batalha batalha = new Batalha(personagensTemp);
            batalha.iniciar();

            // Remover inimigos derrotados da lista de inimigos
            Iterator<Inimigo> iterator = inimigos.iterator();
            while (iterator.hasNext()) {
                Inimigo inimigo = iterator.next();
                if (!inimigo.estaVivo()) {
                    iterator.remove();
                }
            }

            // Remover personagens derrotados da lista de personagens
            Iterator<Personagem> personagemIterator = personagens.iterator();
            while (personagemIterator.hasNext()) {
                Personagem personagem = personagemIterator.next();
                if (!personagem.estaVivo()) {
                    personagemIterator.remove();
                }
            }
        }

        // Exibir o resultado final do jogo
        System.out.println("\n=== Fim do Jogo ===\n");
        if (personagens.isEmpty()) {
            System.out.println("Todos os personagens foram derrotados!");
        } else {
            System.out.println("Os seguintes personagens sobreviveram:");
            for (Personagem personagem : personagens) {
                System.out.println(personagem.getNome() + " - " + personagem.getPontosVida() + " pontos de vida restantes");
            }
        }
    }

    public static void main(String[] args) {
        Jogo jogo = new Jogo();
        jogo.executarJogo();
    }
}

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Jogo {
    private List<Personagem> personagens;
    private List<Inimigo> inimigos;
    private Scanner scanner;

    public Jogo() {
        this.personagens = new ArrayList<>();
        this.inimigos = new ArrayList<>();
        this.scanner = new Scanner(System.in);
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
            System.out.println("\n=x= Novo Combate =x=\n");

            Personagem personagem = escolherPersonagem();
            if (personagem == null) continue;

            Inimigo inimigo = escolherInimigo();
            if (inimigo == null) continue;

                System.out.println("Escolha uma ação para " + personagem.getNome() + ":");
                System.out.println("1. Ataque");
                System.out.println("2. Defesa");
                System.out.println("3. Fugir");
                System.out.println("4. Magia");
                System.out.println("5. Usar Habilidade");
                int escolha = scanner.nextInt();

                switch (escolha) {
                    case 1:
                        atacar(personagem, inimigo);
                        break;
                    case 2:
                        defender(personagem);
                        break;
                    case 3:
                        tentarFugir(personagem);
                        break;
                    case 4:
                        usarMagia(personagem);
                        break;
                    case 5:
                        usarHabilidade(personagem);
                        break;
                    default:
                        System.out.println("Escolha inválida.");
                        break;
                }
            }

            removerDerrotados(personagens);
            removerDerrotados(inimigos);
        }

        private Personagem escolherPersonagem() {
            System.out.println("Escolha um personagem para jogar:");
            for (int i = 0; i < personagens.size(); i++) {
                Personagem personagem = personagens.get(i);
                System.out.println((i + 1) + ". " + personagem.getNome() + " - " + personagem.getPontosVida() + " pontos de vida");
            }
            int escolha = scanner.nextInt() - 1;
            if (escolha >= 0 && escolha < personagens.size()) {
                return personagens.get(escolha);
            } else {
                System.out.println("Escolha inválida.");
                return null;
            }
        }
    
        private Inimigo escolherInimigo() {
            System.out.println("Escolha um inimigo para enfrentar:");
            for (int i = 0; i < inimigos.size(); i++) {
                Inimigo inimigo = inimigos.get(i);
                System.out.println((i + 1) + ". " + inimigo.getNome() + " - " + inimigo.getPontosVida() + " pontos de vida");
            }
            int escolha = scanner.nextInt() - 1;
            if (escolha >= 0 && escolha < inimigos.size()) {
                return inimigos.get(escolha);
            } else {
                System.out.println("Escolha inválida.");
                return null;
            }
        }

    //     System.out.println("\n=== Fim do Jogo ===\n");
    //     if (personagens.isEmpty()) {
    //         System.out.println("Todos os personagens foram derrotados!");
    //     } else if (inimigos.isEmpty()) {
    //         System.out.println("Todos os inimigos foram derrotados!");
    //         System.out.println("Os seguintes personagens sobreviveram:");
    //         for (Personagem personagem : personagens) {
    //             System.out.println(personagem.getNome() + " - " + personagem.getPontosVida() + " pontos de vida restantes");
    //         }
    //     }
    // }

    private void atacar(Personagem personagem, Inimigo inimigo) {
        int dano = personagem.atacar(inimigo);
        System.out.println(personagem.getNome() + " atacou " + inimigo.getNome() + " causando " + dano + " de dano.");
    }

    // private void atacar(Personagem personagem) {
    //     System.out.println("Escolha um inimigo para atacar:");
    //     for (int i = 0; i < inimigos.size(); i++) {
    //         Inimigo inimigo = inimigos.get(i);
    //         System.out.println((i + 1) + ". " + inimigo.getNome() + " - " + inimigo.getPontosVida() + " pontos de vida");
    //     }
    //     int escolha = scanner.nextInt() - 1;
    //     if (escolha >= 0 && escolha < inimigos.size()) {
    //         Inimigo inimigo = inimigos.get(escolha);
    //         personagem.atacar(inimigo);
    //         System.out.println(personagem.getNome() + " atacou " + inimigo.getNome());
    //     } else {
    //         System.out.println("Escolha inválida.");
    //     }
    // }

    private void defender(Personagem personagem) {
        System.out.println(personagem.getNome() + " está se defendendo.");
        personagem.defender();
    }

    private void tentarFugir(Personagem personagem) {
        System.out.println(personagem.getNome() + " tentou fugir.");
        if (personagem.tentarFugir()) {
            System.out.println(personagem.getNome() + " conseguiu fugir.");
            personagens.remove(personagem);
        } else {
            System.out.println(personagem.getNome() + " não conseguiu fugir.");
        }
    }

    private void usarMagia(Personagem personagem) {
        if (personagem instanceof Mago) {
            Mago mago = (Mago) personagem;
            mago.UsarMagia(personagem);
        } else {
            System.out.println(personagem.getNome() + " não pode usar magia.");
        }
    }

    private void usarHabilidade(Personagem personagem) {
        personagem.usarHabilidade();
    }

    private void removerDerrotados(List<? extends Personagem> lista) {
        Iterator<? extends Personagem> iterator = lista.iterator();
        while (iterator.hasNext()) {
            Personagem personagem = iterator.next();
            if (!personagem.estaVivo()) {
                iterator.remove();
            }
        }
    }

    public static void main(String[] args) {
        Jogo jogo = new Jogo();
        jogo.executarJogo();
    }
}

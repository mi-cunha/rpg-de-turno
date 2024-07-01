import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Guerreiro guerreiro = new Guerreiro("Aragorn", 100, 20, 10, false, 20);
        Mago mago = new Mago("Gandalf", 80, 10, 5, false, 50);
        Arqueiro arqueiro = new Arqueiro("Legolas", 90, 15, 8, false, 25);
        Cavaleiro cavaleiro = new Cavaleiro("Camelot", 100, 50, 30, false, 30);

        List<Personagem> personagens = new ArrayList<>();
        personagens.add(arqueiro);
        personagens.add(guerreiro);
        personagens.add(mago);
        personagens.add(cavaleiro);

        Inimigo inimigo1 = new Inimigo("Bowser", 100, 20, 30, false, "chefao", 20);
        Inimigo inimigo2 = new Inimigo("Orc", 70, 30, 20, false, "monstro", 20);

        personagens.add(inimigo1);
        personagens.add(inimigo2);

        Batalha batalha = new Batalha(personagens);
        batalha.iniciar();
}
}

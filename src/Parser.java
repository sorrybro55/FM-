import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Parser {

    public void parse(){
        List<String> linhas = lerFicheiro("dados.csv");
        String[] linhaPartida;
        for (String linha : linhas) {
            linhaPartida = linha.split(":", 2);
            switch(linhaPartida[0]){
                case "Guarda-Redes":
                    GoalKeeper j = parseGoalKeeper(linhaPartida[1]);
                    System.out.println(j.toString());
                    break;

                default:
                    System.out.println("Linha invÃ¡lida.");
                    break;
            }
        }
        System.out.println("done!");
    }

    public List<String> lerFicheiro(String nomeFich) {
        List<String> lines;
        try { lines = Files.readAllLines(Paths.get(nomeFich), StandardCharsets.UTF_8); }
        catch(IOException exc) { lines = new ArrayList<>(); }
        return lines;
    }

    public GoalKeeper parseGoalKeeper(String input){
        String[] campos = input.split(",");
        String nome = campos[0];
        int numCamisola = Integer.parseInt(campos[1]);
        int velocidade = Integer.parseInt(campos[2]);
        return new GoalKeeper();
    }
}


import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Parser {

    public static void parse() throws LinhaIncorretaException {
        List<String> linhas = lerFicheiro("output.txt");
        Map<String, FootballTeam> equipas = new HashMap<>(); //nome, equipa
        Map<Integer, FootballPlayer> jogadores = new HashMap<>(); //numero, jogador
        List<FootballMatch> jogos = new ArrayList<>();
        FootballTeam ultima = null; FootballPlayer j = null;
        String[] linhaPartida;
        for (String linha : linhas) {
            linhaPartida = linha.split(":", 2);
            switch(linhaPartida[0]){
                case "Equipa":
                    FootballTeam e = FootballTeam.parse(linhaPartida[1]);
                    equipas.put(e.getName(), e);
                    ultima = e;
                    break;
                case "Guarda-Redes":
                    j = GoalKeeper.parse(linhaPartida[1]);
                    jogadores.put(j.getNumber(), j);
                    if (ultima == null) throw new LinhaIncorretaException(); //we need to insert the player into the team
                    ultima.addPlayer(j.clone()); //if no team was parsed previously, file is not well-formed
                    break;
                case "Defesa":
                    j = Defender.parse(linhaPartida[1]);
                    jogadores.put(j.getNumber(), j);
                    if (ultima == null) throw new LinhaIncorretaException(); //we need to insert the player into the team
                    ultima.addPlayer(j.clone()); //if no team was parsed previously, file is not well-formed
                    break;
                case "Medio":
                    j = MidFielder.parse(linhaPartida[1]);
                    jogadores.put(j.getNumber(), j);
                    if (ultima == null) throw new LinhaIncorretaException(); //we need to insert the player into the team
                    ultima.addPlayer(j.clone()); //if no team was parsed previously, file is not well-formed
                    break;
                case "Lateral":
                    j = Winger.parse(linhaPartida[1]);
                    jogadores.put(j.getNumber(), j);
                    if (ultima == null) throw new LinhaIncorretaException(); //we need to insert the player into the team
                    ultima.addPlayer(j.clone()); //if no team was parsed previously, file is not well-formed
                    break;
                case "Avancado":
                    j = Striker.parse(linhaPartida[1]);
                    jogadores.put(j.getNumber(), j);
                    if (ultima == null) throw new LinhaIncorretaException(); //we need to insert the player into the team
                    ultima.addPlayer(j.clone()); //if no team was parsed previously, file is not well-formed
                    break;
                case "Jogo":
                    FootballMatch jo = FootballMatch.parse(linhaPartida[1]);
                    jogos.add(jo);
                    break;
                default:
                    throw new LinhaIncorretaException();

            }
        }

        //debug
        for (FootballTeam e: equipas.values()){
            System.out.println(e.toString());
        }
        for (FootballMatch jog: jogos){
            System.out.println(jog.toString());
        }


    }

    public static List<String> lerFicheiro(String nomeFich) {
        List<String> lines;
        try { lines = Files.readAllLines(Paths.get(nomeFich), StandardCharsets.UTF_8); }
        catch(IOException exc) { lines = new ArrayList<>(); }
        return lines;
    }


}

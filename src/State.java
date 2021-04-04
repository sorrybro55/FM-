import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeSet;

public class State {

    TreeSet<FootballPlayer> players;
    TreeSet<FootballTeam> teams;

    public State(){
        this.players = new TreeSet<FootballPlayer>();
        this.teams = new TreeSet<FootballTeam>();
    }

    public State(TreeSet<FootballPlayer> players, TreeSet<FootballTeam> teams){
        setPlayers(players);
        setTeams(teams);

    }

    public State(State state){
        setPlayers(state.getPlayers());
        setTeams(state.getTeams());
    }

    public TreeSet<FootballPlayer> getPlayers() {
        TreeSet<FootballPlayer> ret = new TreeSet<FootballPlayer>();
        for (FootballPlayer fp : this.players)
            ret.add(fp.clone());
        return ret;
    }



    public void setPlayers(TreeSet<FootballPlayer> players){
        for(FootballPlayer fp : players)
            this.players.add(fp.clone());
    }

    public TreeSet<FootballTeam> getTeams() {
        TreeSet<FootballTeam> ret = new TreeSet<FootballTeam>();
        for (FootballTeam t : this.teams)
            ret.add(t.clone());
        return ret;
    }



    public void setTeams(TreeSet<FootballTeam> teams){
        for(FootballTeam t : teams)
            this.teams.add(t.clone());
    }

    public State clone(){
        return new State(this);
    }

    public boolean equals(Object o){
        if(o == this)
            return true;
        if(o == null || o.getClass() != this.getClass())
            return false;
        State state = (State) o;
        return this.players.equals(state.getPlayers()) && this.teams.equals(state.getTeams());
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Numero de Jogadores:").append(players.size()).append("\n");
        sb.append("Numero de Equipas: ").append(teams.size());
        return sb.toString();

    }

    private String showPlayer(FootballPlayer fp){
        StringBuilder sb =  new StringBuilder();
        sb.append(fp.getName()).append(" ").append(fp.getAge()).append(" ").append(fp.getPosition()).append(" ").append(fp.getTeam());
        return sb.toString();
    }


    public String showPlayers(){
        int index = 1;
        StringBuilder sb =  new StringBuilder();
        for(FootballPlayer fp : players)
            sb.append(index++).append(" ").append(showPlayer(fp)).append("\n");
        return sb.toString();
    }

    public String showTeam(FootballTeam team){
        return team.getName();
    }

    public String showTeams(){
        int index = 1;
        StringBuilder sb =  new StringBuilder();
        for(FootballTeam t : teams)
            sb.append(index++).append(" ").append(showTeam(t)).append("\n");
        return sb.toString();
    }

    public void addPlayer(FootballPlayer fp){
        if(this.players.contains(fp))
            updatePlayer(fp);
        else
            this.players.add(fp);
    }

    public void addTeam(FootballTeam team){
        if(this.teams.contains(team))
            updateTeam(team);
        else
            this.teams.add(team);
    }

    public void removePlayer(FootballPlayer fp){
        this.players.remove(fp);
    }

    public void removeTeam(FootballTeam team){
        this.teams.remove(team);
    }

    public void updatePlayer(FootballPlayer fp){
        if(players.contains(fp)){
            players.remove(fp);
            players.add(fp.clone());
        }
    }

    public void updateTeam(FootballTeam team){
        if(teams.contains(team)){
            teams.remove(team);
            teams.add(team.clone());
        }
    }

    public FootballPlayer getPlayer(int index){
        if(index < players.size()){
            Iterator<FootballPlayer> it = this.players.iterator();
            FootballPlayer ret = it.next();
            while(it.hasNext() && index >0) {
                ret = it.next();
                index--;
            }
                return ret.clone();
        }
        return null;
    }

    public FootballTeam getTeam(int index){
        if(index < teams.size()){
            Iterator<FootballTeam> it = this.teams.iterator();
            FootballTeam ret = it.next();
            while(it.hasNext() && index >0) {
                ret = it.next();
                index--;
            }
            return ret.clone();
        }
        return null;
    }






}

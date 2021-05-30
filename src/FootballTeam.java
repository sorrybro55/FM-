import java.io.Serializable;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Write a description of class Team here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class FootballTeam implements Serializable, Comparable<FootballTeam>
{

    private String name;
    private HashMap< Integer , FootballPlayer> squad;

    public FootballTeam(){
        this.name = "Sem Nome";
        this.squad = new HashMap<>();
    }
    
    public FootballTeam(String name, Map<Integer, FootballPlayer> squad){
        this.name = name;
        setSquad(squad);
    }
    
    public FootballTeam(FootballTeam team){
        this.name = team.getName();
        setSquad(team.getSquad());
    }
    
    public String getName(){
        return this.name;
    }
    
    public void setName(String name){
        this.name = name;
    }
    

    
    public void setSquad(Map<Integer, FootballPlayer> squad){
        this.squad = new HashMap<>();
        for (Map.Entry <Integer, FootballPlayer> m : squad.entrySet())
            this.squad.put(m.getKey(), m.getValue().clone());
    }

    public Map <Integer, FootballPlayer> getSquad(){
        return this.squad.values().stream().collect(Collectors.toMap(FootballPlayer::getNumber, FootballPlayer::clone));
    }

    public FootballTeam clone(){
        return new FootballTeam(this);
    }

    public boolean equals(Object o){
        if (o == this) return true;
        if(o == null || o.getClass() != this.getClass()) return false;
        FootballTeam t = (FootballTeam) o;
        return t.getName() == this.name && t.getSquad().equals(this.getSquad());
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(this.name).append("\n\nPlantel:\n\n");
        Iterator<Map.Entry<Integer, FootballPlayer>> it = squad.entrySet().iterator();
        Map.Entry<Integer, FootballPlayer> me = null;
        while (it.hasNext()) {
            me = it.next();
            FootballPlayer fp = me.getValue();
            sb.append(me.getKey()).append(". ").append(fp.getName()).append(" | ").append(fp.getPosition()).append("\n").append(fp.stats()).append("\n");
            if(it.hasNext())
                sb.append("\n");
        }
        return sb.toString();
    }


    public void addPlayer(FootballPlayer fp){
        if (this.squad.containsKey(fp.getNumber())){
            selectNewNumber(fp);
        }
        squad.put(fp.getNumber(), fp.clone());

    }

    private void selectNewNumber(FootballPlayer fp){
        int i =1;
        while(this.squad.containsKey(i))
            i++;
        fp.setNumber(i);
    }

    public FootballPlayer getPlayer(Integer number){
        FootballPlayer ret = this.squad.get(number);
        if (ret != null)
            return  ret.clone();
        return null;
    }


    public FootballPlayer removePlayer(Integer number){
            return this.squad.remove(number);
    }

    public void updatePlayer(FootballPlayer fp){
        if(this.squad.containsValue(fp))
            this.squad.replace(fp.getNumber(), fp.clone());
    }

    public int compareTo(FootballTeam team){
        return this.getName().compareTo(team.getName());
    }

    public boolean isComplete(){
        if (this.squad.size() < 11)
            return false;
        for (FootballPlayer fp : this.squad.values()){
            if(fp instanceof GoalKeeper)
                return true;
        }
            return false;
    }


    public static FootballTeam parse(String input){
        String[] campos = input.split(",");
        return new FootballTeam(campos[0], new HashMap<>());
    }







   
}

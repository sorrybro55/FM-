import com.sun.source.tree.BreakTree;

import java.io.Serializable;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Write a description of class Team here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class FootballTeam implements Serializable, Comparable<FootballTeam> {

    private String name;
    private Map<Integer, FootballPlayer> squad;

    public FootballTeam() {
        this.name = "Sem Nome";
        this.squad = new TreeMap<>();
    }

    public FootballTeam(String name, Map<Integer, FootballPlayer> squad) {
        this.name = name;
        setSquad(squad);
    }

    public FootballTeam(FootballTeam team) {
        this.name = team.getName();
        setSquad(team.getSquad());
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public void setSquad(Map<Integer, FootballPlayer> squad) {
        this.squad = new TreeMap<>();
        for (Map.Entry<Integer, FootballPlayer> m : squad.entrySet())
            this.squad.put(m.getKey(), m.getValue().clone());
    }

    public Map<Integer, FootballPlayer> getSquad() {
        return this.squad.values().stream().collect(Collectors.toMap(FootballPlayer::getNumber, FootballPlayer::clone));
    }

    public FootballTeam clone() {
        return new FootballTeam(this);
    }

    public boolean equals(Object o) {
        if (o == this) return true;
        if (o == null || o.getClass() != this.getClass()) return false;
        FootballTeam t = (FootballTeam) o;
        return t.getName() == this.name && t.getSquad().equals(this.getSquad());
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.name).append("\nOverall :").append((int)this.overall()).append("\n\nPlantel:\n\n");
        Iterator<Map.Entry<Integer, FootballPlayer>> it = squad.entrySet().iterator();
        Map.Entry<Integer, FootballPlayer> me = null;
        while (it.hasNext()) {
            me = it.next();
            FootballPlayer fp = me.getValue();
            sb.append(me.getKey()).append(". ").append(fp.getName()).append(" | ").append(fp.getPosition()).append("\n").append(fp.stats()).append("\n");
            if (it.hasNext())
                sb.append("\n");
        }
        return sb.toString();
    }


    public void addPlayer(FootballPlayer fp) {
        if (this.squad.containsKey(fp.getNumber())) {
            selectNewNumber(fp);
        }
        squad.put(fp.getNumber(), fp.clone());

    }

    private void selectNewNumber(FootballPlayer fp) {
        int i = 1;
        while (this.squad.containsKey(i))
            i++;
        fp.setNumber(i);
    }

    public FootballPlayer getPlayer(Integer number) {
        FootballPlayer ret = this.squad.get(number);
        if (ret != null)
            return ret.clone();
        return null;
    }


    public FootballPlayer removePlayer(Integer number) {
        return this.squad.remove(number);
    }

    public void updatePlayer(FootballPlayer fp) {
        if (this.squad.containsValue(fp))
            this.squad.replace(fp.getNumber(), fp.clone());
    }

    public int compareTo(FootballTeam team) {
        return this.getName().compareTo(team.getName());
    }

    public boolean isComplete() {
        if (this.squad.size() < 11)
            return false;
        for (FootballPlayer fp : this.squad.values()) {
            if (fp instanceof GoalKeeper)
                return true;
        }
        return false;
    }

    public List<Integer> bestEleven() {
        List<Integer> allNumbers = new ArrayList<>(this.squad.keySet());
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < 11; i++)
            result.add(0);
        Comparator<FootballPlayer> c = (p1, p2) -> p1.overall() - p2.overall();
        List<FootballPlayer> goalKeepers = this.squad.values().stream().filter(p -> p instanceof GoalKeeper).sorted(c).collect(Collectors.toList());
        List<FootballPlayer> defenders = this.squad.values().stream().filter(p -> p instanceof Defender).sorted(c).collect(Collectors.toList());
        List<FootballPlayer> wingers = this.squad.values().stream().filter(p -> p instanceof Winger).sorted(c).collect(Collectors.toList());
        List<FootballPlayer> midfielders = this.squad.values().stream().filter(p -> p instanceof MidFielder).sorted(c).collect(Collectors.toList());
        List<FootballPlayer> strikers = this.squad.values().stream().filter(p -> p instanceof Striker).sorted(c).collect(Collectors.toList());
        if (goalKeepers.size() >= 1) {
            result.set(0, goalKeepers.get(0).getNumber());
            allNumbers.remove(result.get(0));
        }
        if (defenders.size() >= 1) {
            result.set(1, defenders.get(0).getNumber());
            allNumbers.remove(result.get(1));
        }

        if (defenders.size() >= 2) {
            result.set(2, defenders.get(1).getNumber());
            allNumbers.remove(result.get(2));
        }

        if (wingers.size() >= 1) {
            result.set(3, wingers.get(0).getNumber());
            allNumbers.remove(result.get(3));
        }

        if (wingers.size() >= 2) {
            result.set(4, wingers.get(1).getNumber());
            allNumbers.remove(result.get(4));
        }

        if (midfielders.size() >= 1) {
            result.set(5, midfielders.get(0).getNumber());
            allNumbers.remove(result.get(5));
        }

        if (midfielders.size() >= 2) {
            result.set(6, midfielders.get(1).getNumber());
            allNumbers.remove(result.get(6));
        }

        if (midfielders.size() >= 3) {
            result.set(7, midfielders.get(2).getNumber());
            allNumbers.remove(result.get(7));
        }

        if (midfielders.size() >= 4) {
            result.set(8, midfielders.get(3).getNumber());
            allNumbers.remove(result.get(8));
        }

        if (strikers.size() >= 1) {
            result.set(9, strikers.get(0).getNumber());
            allNumbers.remove(result.get(9));
        }

        if (strikers.size() >= 2) {
            result.set(10, strikers.get(1).getNumber());
            allNumbers.remove(result.get(10));
        }
        for (int i = 0; i < result.size(); i++) {
            if (result.get(i) == 0) {
                result.set(i, allNumbers.get(0));
                allNumbers.remove(0);
            }
        }

        return result;

    }

    public double overall() {
        double result = 0;
        for (FootballPlayer fp : this.squad.values())
            result += fp.overall();
        result /= this.squad.size();
        return result;
    }



    public static FootballTeam parse(String input){
        String[] campos = input.split(",");
        return new FootballTeam(campos[0], new TreeMap<>());
    }







   
}

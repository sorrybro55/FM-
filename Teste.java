

public class Teste
{
    public static void main(){
        FootballPlayer fp = new FootballPlayer();
        GoalKeeper gk = new GoalKeeper();
        //System.out.println(fp);
        //System.out.println();
        //System.out.println(gk);
        //System.out.println();
        FootballTeam t1 = new FootballTeam();
        t1.addPlayer(gk);
        //t1.addPlayer(fp);
   
        Position pos = Position.GOALKEEPER;
       
        
        GoalKeeper gk1 = (GoalKeeper) t1.getPlayer(0);
        gk1.setStamina(80);
        t1.updatePlayer(0,gk1);
        GoalKeeper gk2  = (GoalKeeper) t1.getPlayer(0);
        
        

        System.out.println(t1);
        System.out.println(t1.defensiveOverall());
        
        
    
    }
   
}



public class Test
{

    public static void main(String[] args) {


        MidFielder md = new MidFielder();
        GoalKeeper gk = new GoalKeeper();
        //System.out.println(fp);
        //System.out.println();
        //System.out.println(gk);
        //System.out.println();
        FootballTeam t1 = new FootballTeam();
        t1.squadAddPlayer(gk);
        t1.squadAddPlayer(md);
        System.out.println(t1.getStarting());
        t1.moveToBench(md);

        System.out.println("\n\n" + t1.getStarting());

        System.out.println("\n\n" + t1.getBench());
        //System.out.println(t1.getBench());

        //Position pos = Position.GOALKEEPER;


        //GoalKeeper gk1 = (GoalKeeper) t1.getPlayer(0);
        //gk1.setStamina(80);
        //t1.updatePlayer(0, gk1);
        //GoalKeeper gk2 = (GoalKeeper) t1.getPlayer(0);


        //System.out.println(t1);
        //System.out.println(t1.defensiveOverall());
        //Menu.Initial();
    }
        
        
    

   
}

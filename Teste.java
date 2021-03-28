

public class Teste
{
    public static void main(){
        FieldPlayer fp = new FieldPlayer();
        GoalKeeper gk = new GoalKeeper();
        System.out.println(fp);
        System.out.println();
        System.out.println(gk);
        System.out.println(gk.stats());
        System.out.println();
        Team t1 = new Team();
        t1.addFootballPlayer(gk);
   
        Position pos = Position.GOALKEEPER;
        
        

        System.out.println(t1);
        
    
    }
   
}

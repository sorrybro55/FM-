
import java.util.Iterator;
import java.util.TreeSet;

public class Test
{

    public static void main(String[] args) {

        State state = new State();
        try {
            state.parse("logs.txt");
        } catch (LinhaIncorretaException e) {
            System.out.println(e.getMessage());
        }
        //System.out.println(state);
        Controller controller = new Controller(state);
        controller.run();
    }
}



import java.io.IOException;
import java.util.Iterator;
import java.util.TreeMap;

public class Main
{

    public static void main(String[] args) {



        State state = new State();
        try {
            state.parse("logs.txt");
        } catch (LinhaIncorretaException  |IOException e) {
            System.out.println("Não Foi Possivel Carregar Dados!");
        }
        Controller controller = new Controller(state);
        controller.run();





    }
}



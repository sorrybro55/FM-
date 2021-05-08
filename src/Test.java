
import java.util.Iterator;
import java.util.TreeSet;

public class Test
{

    public static void main(String[] args) {


        try {
            Parser.parse();
        } catch (LinhaIncorretaException e) {
            System.out.println(e.getMessage());
        }
    }
}



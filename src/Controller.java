import java.util.ArrayList;

public class Controller {

    public static void run(State state) {


    while (true) {
            int option = IO.initialMenu();
            switch (option) {
                case 0:
                    return;
                case 1:
                    //GameController.makeGame(state);
                    break;
                case 2:
                    PlayersController.run(state);
                    break;
                case 3:
                    TeamsController.run(state);
                    break;
                case 4:
                    StateController.load(state);
                    break;
                case 5:
                    StateController.save(state);
                    break;
            }

        }
    }




}






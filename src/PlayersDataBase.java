import java.util.ArrayList;

public class PlayersDataBase {

	//stats retiradas do site "fminside.net"
	// age, speed, stamina, agility, heading, finishing, passing
	// a tatica escolhida foi 4-2-3-1
	//
	//heading, finishing, elasticity - falta o finishing e o heading dos gk, para elasticity foi usado reflexes 
	//					, reflexes 
	// para speed foi usado o pace
	
	ArrayList<String> carrer = new ArrayList<>();
	
	//PORTO
	FootballPlayer MoussaMarega 		= new Striker("Moussa Marega", 29, 17, 16, 8, 14, 13, 8, "Porto", carrer);
	FootballPlayer Evanilson	 		= new Striker("Evanilson", 20, 15, 12, 13, 12, 14, 13, "Porto", carrer);
	FootballPlayer ToniMartinez	 		= new Striker("Toni Martinez", 23, 13, 14, 12, 13, 13, 12, "Porto", carrer);

	FootballPlayer JesusCorona 			= new Winger("Jesus Corona", 27, 15, 13, 17, 5, 10, 14, "Porto", carrer);
	FootballPlayer FelipeAnderson 		= new Winger("Felipe Anderson", 27, 15, 11, 15, 5, 13, 14, "Porto", carrer);
	FootballPlayer Otavio 				= new Winger("Otavio", 25, 14, 12, 15, 7, 10, 15, "Porto", carrer);
	FootballPlayer LuisDiaz 			= new Winger("Luis Diaz", 23, 15, 13, 17, 8, 12, 13, "Porto", carrer);

	FootballPlayer MateusUribe 			= new MidFielder("Mateus Uribe", 29, 12, 15, 13, 13, 10, 14, "Porto", carrer);
	FootballPlayer SergioOliveira 		= new MidFielder("Sergio Oliveira", 28, 12, 14, 12, 8, 8, 15, "Porto", carrer);
	FootballPlayer RomarioBaro   		= new MidFielder("Romario Baro", 20, 13, 15, 14, 8, 8, 13, "Porto", carrer);

	FootballPlayer WilsonManafa 		= new Defender("Wilson Manafa", 26, 16, 16, 14, 8, 8, 12, "Porto", carrer);
	FootballPlayer Pepe 				= new Defender("Pepe", 37, 13, 13, 13, 15, 8, 13, "Porto", carrer);
	FootballPlayer IvanMarcano 			= new Defender("Ivan Marcano", 33, 12, 12, 13, 15, 9, 13, "Porto", carrer);
	FootballPlayer ZaiduSanusi			= new Defender("Zaidu Sanusi", 23, 17, 15, 13, 14, 8, 10, "Porto", carrer);
	FootballPlayer DiogoLeite       	= new Defender("Diogo Leite", 21, 13, 14, 13, 13, 8, 14, "Porto", carrer);
	FootballPlayer MalangSarr       	= new Defender("Malang Sarr", 21, 15, 15, 14, 13, 7, 13, "Porto", carrer);

	FootballPlayer AgustinMarchesin 	= new GoalKeeper("Agustín Marchesín", 32, 12, 12, 13, 0, 0, 12, 16,"Porto", carrer);
	FootballPlayer DiegoCosta 			= new GoalKeeper("Diego Costa", 20, 13, 11, 13, 0, 0, 12, 14,"Porto", carrer);
	//PORTO
	
	//SPORTING
	FootballPlayer AndrazSporar 		= new Striker("Andraz Sporar", 26, 14, 13, 12, 14, 14, 10, "Sporting", carrer);
	FootballPlayer YoussefChermiti  	= new Striker("Youssef Chermiti", 16, 10, 8, 9, 9, 13, 11, "Sporting", carrer);
	FootballPlayer PauloAgostinho 		= new Striker("Paulo Agostinho", 17, 10, 11, 12, 8, 12, 9, "Sporting", carrer);

	FootballPlayer JoaoMario 			= new Winger("Joao Mario", 27, 13, 14, 13, 7, 11, 16, "Sporting", carrer);
	FootballPlayer JovaneCabral     	= new Winger("Jovane Cabral", 22, 15, 12, 14, 6, 13, 12, "Sporting", carrer);
	FootballPlayer NunoSantos 			= new Winger("Nuno Santos", 25, 15, 13, 14, 8, 13, 15, "Sporting", carrer);
	FootballPlayer MatheusNunes			= new Winger("Matheus Nunes", 21, 13, 13, 13, 8, 8, 14, "Sporting", carrer);

	FootballPlayer JoaoPalhinha     	= new MidFielder("Joao Palhinha", 25, 12, 14, 11, 15, 8, 13, "Sporting", carrer);
	FootballPlayer PedroGoncalves 		= new MidFielder("Pedro Goncalves", 22, 13, 12, 15, 8, 13, 13, "Sporting", carrer);
	FootballPlayer DanielBraganca   	= new MidFielder("Daniel Braganca", 21, 12, 13, 13, 5, 11, 15, "Sporting", carrer);

	FootballPlayer PedroPorro       	= new Defender("Pedro Porro", 20, 15, 15, 14, 8, 10, 10, "Sporting", carrer);
	FootballPlayer SebastianCoates  	= new Defender("Sebastian Coates", 29, 12, 14, 10, 16, 9, 13, "Sporting", carrer);
	FootballPlayer GoncaloCosta 		= new Defender("Goncalo Costa", 20, 13, 12, 12, 6, 6, 11, "Sporting", carrer);
	FootballPlayer EduardoQuaresma 		= new Defender("Eduardo Quaresma", 18, 12, 13, 12, 11, 7, 13, "Sporting", carrer);
	FootballPlayer Antunes		 		= new Defender("Antunes", 33, 13, 12, 11, 9, 9, 13, "Sporting", carrer);
	FootballPlayer ZouhairFeddal    	= new Defender("Zouhair Feddal", 30, 13, 14, 11, 13, 7, 11, "Sporting", carrer);

	FootballPlayer AntonioAdan      	= new GoalKeeper("Antonio Adan", 33, 11, 12, 13, 0, 0, 8, 16,"Sporting", carrer);
	FootballPlayer LuisMaximiano 		= new GoalKeeper("Luis Maximiano", 21, 12, 13, 14, 0, 0, 10, 15,"Sporting", carrer);
	//SPORTING

	//BENFICA
	FootballPlayer LucaWaldschmidt 	    = new Striker("Luca Waldschmidt", 24, 13, 12, 15, 11, 15, 15, "Benfica", carrer);
	FootballPlayer DarwinNunez     	    = new Striker("Darwin Núñez", 21, 17, 14, 13, 11, 14, 12, "Benfica", carrer);
	FootballPlayer GoncaloRamos 		= new Striker("Goncalo Ramos", 19, 13, 12, 13, 13, 13, 12, "Benfica", carrer);

	FootballPlayer Pizzi	 			= new Winger("Pizzi", 30, 12, 12, 13, 7, 16, 16, "Benfica", carrer);
	FootballPlayer Rafa		 			= new Winger("Rafa", 27, 17, 13, 16, 5, 11, 13, "Benfica", carrer);
	FootballPlayer EvertonCebolinha 	= new Winger("Everton Cebolinha", 24, 15, 14, 16, 9, 14, 13, "Benfica", carrer);
	FootballPlayer Chiquinho 			= new Winger("Chiquinho", 25, 13, 12, 15, 7, 9, 14, "Benfica", carrer);

	FootballPlayer JulianWeigl 			= new MidFielder("Julian Weigl", 24, 12, 15, 14, 10, 8, 16, "Benfica", carrer);
	FootballPlayer AdelTaarabt 			= new MidFielder("Adel Taarabt", 31, 12, 11, 14, 4, 8, 16, "Benfica", carrer);
	FootballPlayer Gabriel  			= new MidFielder("Gabriel", 26, 12, 14, 12, 12, 10, 16, "Benfica", carrer);

	FootballPlayer AndreAlmeida  		= new Defender("Andre Almeida", 29, 12, 15, 12, 11, 9, 13, "Benfica", carrer);
	FootballPlayer NicolasOtamendi		= new Defender("Nicolas Otamendi", 32, 12, 17, 13, 15, 10, 13, "Benfica", carrer);
	FootballPlayer JanVertonghen 		= new Defender("Jan Vertonghen", 33, 9, 11, 11, 16, 8, 14, "Benfica", carrer);
	FootballPlayer AlexGrimaldo  		= new Defender("Alex Grimaldo", 24, 13, 14, 15, 9, 10, 15, "Benfica", carrer);
	FootballPlayer Ferro     			= new Defender("Ferro", 23, 11, 15, 12, 13, 9, 15, "Benfica", carrer);
	FootballPlayer JeanClair        	= new Defender("Jean-Clair", 20, 17, 12, 14, 12, 7, 14, "Benfica", carrer);

	FootballPlayer OdysseasVlachodimos  = new GoalKeeper("Odysseas Vlachodimos", 26, 11, 11, 15, 0, 0, 12, 17,"Benfica", carrer);
	FootballPlayer MileSvilar 	 		= new GoalKeeper("Mile Svilar", 20, 13, 11, 12, 0, 0, 11, 15,"Benfica", carrer);
	//BENFICA

	//BRAGA
	FootballPlayer Paulinho 			= new Striker("Paulinho", 27, 12, 13, 12, 14, 16, 15, "Braga", carrer);
	FootballPlayer AbelRuiz 			= new Striker("Abel Ruiz", 20, 14, 12, 14, 13, 15, 12, "Braga", carrer);
	FootballPlayer GuilhermeSchettine 	= new Striker("Guilherme Schettine", 24, 13, 12, 12, 12, 15, 11, "Braga", carrer);

	FootballPlayer Galeno 				= new Winger("Galeno", 22, 18, 12, 16, 7, 13, 10, "Braga", carrer);
	FootballPlayer RicardoHorta 		= new Winger("Ricardo Horta", 25, 15, 12, 16, 7, 14, 13, "Braga", carrer);
	FootballPlayer NicolasGaitan		= new Winger("Nicolas Gaitan", 32, 13, 11, 14, 7, 11, 15, "Braga", carrer);
	FootballPlayer AndreHorta 	 		= new Winger("Andre Horta", 27, 14, 13, 15, 7, 10, 15, "Braga", carrer);

	FootballPlayer Fransergio 			= new MidFielder("Fransergio", 29, 13, 15, 13, 14, 11, 13, "Braga", carrer);
	FootballPlayer NunoCunha 			= new MidFielder("Nuno Cunha", 19, 13, 10, 11, 5, 7, 12, "Braga", carrer);
	FootballPlayer Berna	 			= new MidFielder("Berna", 17, 8, 11, 14, 5, 7, 12, "Braga", carrer);

	FootballPlayer RicardoEsgaio  		= new Defender("Ricardo Esgaio", 27, 13, 14, 13, 7, 9, 13, "Braga", carrer);
	FootballPlayer BrunoViana	  		= new Defender("Bruno Viana", 25, 13, 13, 14, 12, 7, 13, "Braga", carrer);
	FootballPlayer RaulSilva  		    = new Defender("Raul Silva", 30, 12, 11, 11, 16, 7, 13, "Braga", carrer);
	FootballPlayer NunoSequeira  		= new Defender("Nuno Sequeira", 29, 14, 14, 12, 12, 9, 14, "Braga", carrer);
	FootballPlayer Tormena		  		= new Defender("Tormena", 24, 12, 13, 11, 14, 7, 12, "Braga", carrer);
	FootballPlayer DavidCarmo	  		= new Defender("David Carmo", 21, 13, 13, 9, 13, 8, 14, "Braga", carrer);

	FootballPlayer Matheus				= new GoalKeeper("Matheus", 28, 12, 13, 13, 0, 0, 12, 17,"Braga", carrer);
	FootballPlayer LukasHornicek 		= new GoalKeeper("Lukas Hornicek", 18, 10, 4, 13, 0, 0, 7, 12,"Braga", carrer);
	//
	//BRAGA

}





















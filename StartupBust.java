package Startups;

import java.util.ArrayList;

public class StartupBust {
    private GameHelper helper;
    private ArrayList<Startup> startups = new ArrayList<Startup>(3);
    private int numOfGuesses;

    void setUpGame() {
        Startup STARTUPone = new Startup();
        Startup STARTUPtwo = new Startup();
        Startup STARTUPthree = new Startup();

        STARTUPone.setName("FIITJEE");
        STARTUPtwo.setName("Akaash");
        STARTUPthree.setName("Byjus");

        startups.add(STARTUPone);
        startups.add(STARTUPtwo);
        startups.add(STARTUPthree);

        helper = new GameHelper();

        for(int i = 0; i!=3; i++){
            if(i==0){
                ArrayList<String> locationsStartup1 = helper.placeStartup();
                STARTUPone.setLocations(locationsStartup1);
                continue;
            }
            if(i==1){
                while (true) {
                    ArrayList<String> locationsStartup2 = helper.placeStartup();

                    ArrayList<String> locationsStartup1 = STARTUPone.getLocations();
                    if (   locationsStartup2.contains(locationsStartup1.get(0)) == false
                        && locationsStartup2.contains(locationsStartup1.get(1)) == false
                        && locationsStartup2.contains(locationsStartup1.get(2)) == false) {
                        STARTUPtwo.setLocations(locationsStartup2);
                        break;
                    }
                }
                continue;
            }
            if(i==2){
                while(true){
                    ArrayList<String> locationsStartup3 = helper.placeStartup();
                    
                    ArrayList<String> locationsStartup1 = STARTUPone.getLocations();
                    ArrayList<String> locationsStartup2 = STARTUPtwo.getLocations();
                    if (   locationsStartup3.contains(locationsStartup1.get(0)) == false
                        && locationsStartup3.contains(locationsStartup1.get(1)) == false
                        && locationsStartup3.contains(locationsStartup1.get(2)) == false
                        && locationsStartup3.contains(locationsStartup2.get(0)) == false
                        && locationsStartup3.contains(locationsStartup2.get(1)) == false
                        && locationsStartup3.contains(locationsStartup2.get(2)) == false) {
                        STARTUPthree.setLocations(locationsStartup3);
                        break;
                    }
                }
                continue; 
            }
        }
    }

    void startPlaying() {
        String guess;
        System.out.println("Your goal is to sink all the startups in the least number of guesses");
        System.out.println("Have a go!");

        while(   startups.get(0).getLifeState() == true
              || startups.get(1).getLifeState() == true
              || startups.get(2).getLifeState() == true){
            String message = "Make a guess";
            guess = helper.getUserInput(message);
            checkUserGuess(guess);
        }
        finishGame();
    }

    void checkUserGuess(String userGuess) {
        numOfGuesses++;
        String result = "Miss";
        for(int i = 0; i!=3; i++){
            Startup containerOuter = startups.get(i);
            ArrayList<String> container = startups.get(i).getLocations();
            if(containerOuter.getLifeState() == true){
                if(container.contains(userGuess)){
                    result = "Hit";
                    container.remove(i);
                    if(container.isEmpty()){
                        result = "Kill";
                        containerOuter.setLifeState(false);

                    }
                }
            }
        }
        System.out.println(result);
    }

    void finishGame() {
        System.out.println("Game over! You wrecked all the startups! It took you " + numOfGuesses + " guesses");
        if(numOfGuesses>40){
            System.out.println("Bro made sure to nuke every survivor");
        } else if (numOfGuesses>30 && numOfGuesses<20){
            System.out.println("You're learning.. i guess?");
        } else if (numOfGuesses>20 && numOfGuesses<15){
            System.out.println("Wow! You're pretty good eh?");
        } else if (numOfGuesses<15){
            System.out.println("Chill out bruh there's no need to speedrun this");
        }
    }

    public static void main(String[] args) {
        StartupBust game = new StartupBust();
        game.setUpGame();
        game.startPlaying();
    }
}

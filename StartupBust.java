import java.util.ArrayList;
public class StartupBust{
    private GameHelper ghelper = new GameHelper();
    private ArrayList<Startup> startups = new ArrayList();
    private int numOfGuesses = 0;

    StartupBust(){
        this.setUpGame();
        this.startPlaying();
    }
    
    private void setUpGame() {
        Startup s1 = new Startup("Bro1");
        Startup s2 = new Startup("Bro2");
        Startup s3 = new Startup("Bro3");
        startups.add(s1);
        startups.add(s2);
        startups.add(s3);
        System.out.println("Your goal is to sink the three startups by typing out their coordinates.");
        System.out.println("The grid has 7 rows and 7 columns, where the rows range from 1-7 and columns range from A-G");
        System.out.println("Example coordinate: J8");
        System.out.println("Good Luck!");
        
        for(Startup startup: startups){
            while(true){
                boolean conflict = false;
                ArrayList<String> locationToSet = ghelper.generateLocation(3);
                for(Startup s: startups){
                    if (s.getLocation() == null || s.getLocation().isEmpty()) {continue;}

                    ArrayList<String> locationToCompare= s.getLocation();                 
                    for(String pos1:locationToCompare){
                        for(String pos2: locationToSet){
                            if(pos1.equals(pos2)){
                                conflict=true;
                                break;
                            }
                        }
                        if(conflict){break;}
                    }
                    if(conflict){break;}
                }
                if(!conflict){
                    startup.setLocation(locationToSet);
                    break;
                }
            }
        }

        for(Startup startup:startups){
            System.out.println("Startup "+ startup.getName() + " was placed at:");
            for(String pos: startup.getLocation()){
                System.out.println(pos);
            }
        }
    }

    private void startPlaying(){
        while(!startups.isEmpty()){
            String guess = ghelper.getUserInput("Enter a guess");
            checkUserGuess(guess);
        }
        finishGame();
    }

    private void checkUserGuess(String guess){
        numOfGuesses++;
        String result = "miss";

        for(Startup s: startups){
            result = s.checkYourself(guess);
            if(result.equals("hit")){
                break;
            } else if(result.equals("kill")){
                startups.remove(s);
                break;
            }
        }
        System.out.println(result);

    }
    private void finishGame(){
        System.out.println("Game over!");
        System.out.println("You took "+ numOfGuesses + " Guesses!");
        if(numOfGuesses>=18){
            System.out.println("Zero thoughts in that brain");
        } else if (numOfGuesses>= 10){
            System.out.println("Good boy");
        } else if (numOfGuesses==9){
            System.out.println("Perfectionist ahh");
        } else {
            System.out.println("Wtf");
        }
    }

    public static void main(String[] args){
        new StartupBust();
    }

}

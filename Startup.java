import java.util.ArrayList;
public class Startup{
    private String name;
    private ArrayList<String> location = new ArrayList(3);
    
    Startup(String startupName){
        setName(startupName);
    }

    public void setName(String n){
        name = n;
    }
    public String getName(){
        return name;
    }
    public void setLocation(ArrayList<String> loc){
        location = loc;
    }
    public ArrayList<String> getLocation(){
        return location;
    }

    public String checkYourself(String userInput){
        String toReturn = "miss";
        for(String pos: location){
            if(userInput.equals(pos)){
                toReturn = "hit";
                location.remove(pos);
                break;
            }   
        }
        if(location.isEmpty()){
            toReturn="kill";
            System.out.println("You sunk "+ name+ "!");
        }
        return toReturn;
        
    }
}

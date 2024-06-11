package Startups;

import java.util.ArrayList;

public class Startup {
    private String name;
    private ArrayList<String> locations;
    private boolean isAlive = false;

    public void setName(String n){
        name = n;
    }

    public String getName(){
        return name;
    }

    public void setLocations(ArrayList<String> locs){
        locations = locs;
    }

    public ArrayList<String> getLocations(){
        return locations;
    }

    public void setLifeState(boolean trueOrFalse){
        isAlive = trueOrFalse;
    }

    public boolean getLifeState(){
        return isAlive;
    }
}

package Startups;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class GameHelper {
    ArrayList<String> placeStartup() {
        ArrayList<String> finalPositions = new ArrayList<String>(3);
        Random random = new Random();
        String finalPos1, finalPos2, finalPos3;
        String Y1 = "Null", Y2 = "Null", Y3 = "Null", X1 = "Null", X2 = "Null", X3 = "Null";
        byte oldhorizontalPos;
        char horizontalPos;
        byte verticalPos;
        boolean staySameXRow;

        boolean firstVerticalPos = false, lastVerticalPos = false, firstHorizontalPos = false, lastHorizontalPos = false;

        oldhorizontalPos = (byte) random.nextInt(0, 6);
        verticalPos = (byte) random.nextInt(1, 7);
        staySameXRow = random.nextBoolean();

        switch (oldhorizontalPos) {
            case 0:
                horizontalPos = 'A';
            case 1:
                horizontalPos = 'B';
            case 2:
                horizontalPos = 'C';
            case 3:
                horizontalPos = 'D';
            case 4:
                horizontalPos = 'E';
            case 5:
                horizontalPos = 'F';
            case 6:
                horizontalPos = 'G';
            default:
                horizontalPos = 'Z';
                System.out.println("Error in switch case GameHelper.placeStartup()");
        }

        if (verticalPos == 1) {
            firstVerticalPos = true;
        } else if (verticalPos == 7) {
            lastVerticalPos = true;
        }
        if (horizontalPos == 'A') {
            firstHorizontalPos = true;
        } else if (horizontalPos == 'G') {
            lastHorizontalPos = true;
        }

        //checks
        if(firstHorizontalPos){
            lastHorizontalPos = false;
        } else if (lastHorizontalPos){
            firstHorizontalPos = false;
        }
        if(firstVerticalPos){
            lastVerticalPos = false;
        } else if (lastVerticalPos){
            firstVerticalPos = false;
        }
        

        if (firstHorizontalPos == false && lastHorizontalPos == false && firstVerticalPos == false && lastVerticalPos == false ) {
            // then we can take it as mid pos
            X2 = String.valueOf(horizontalPos);
            Y2 = String.valueOf(verticalPos);
        
            if(staySameXRow==true){
                X1 = String.valueOf(horizontalPos);
                Y1 = String.valueOf(verticalPos - 1);

                X3 = String.valueOf(horizontalPos);
                Y3 = String.valueOf(verticalPos + 1);
            } else {
                X1 = String.valueOf(horizontalPos - 1);
                Y1 = String.valueOf(verticalPos);

                X3 = String.valueOf(horizontalPos + 1);
                Y3 = String.valueOf(verticalPos);
            }
        } else if (firstHorizontalPos == false && lastHorizontalPos == false && firstVerticalPos == true && lastVerticalPos == false) {
            if(staySameXRow==true){
                //then we can take it as the first pos on the edge of the bottom x row edge
                X1 = String.valueOf(horizontalPos);
                Y1 = String.valueOf(verticalPos);
                
                X2 = String.valueOf(horizontalPos);
                Y2 = String.valueOf(verticalPos + 1);

                X3 = String.valueOf(horizontalPos);
                Y3 = String.valueOf(verticalPos + 2);                
            } else{
                //then we can take it as the mid pos on the bottom X row edge
                X1 = String.valueOf(horizontalPos - 1);
                Y2 = String.valueOf(verticalPos);

                X2 = String.valueOf(horizontalPos);
                Y1 = String.valueOf(verticalPos);

                X3 = String.valueOf(horizontalPos + 1);
                Y3 = String.valueOf(verticalPos);
            }
        } else if (firstHorizontalPos == false && lastHorizontalPos == false && firstVerticalPos == false && lastVerticalPos == true){
            if(staySameXRow==true){
                //then we can take it as the first pos on the edge of the top x row edge
                X1 = String.valueOf(horizontalPos);
                Y1 = String.valueOf(verticalPos);
                
                X2 = String.valueOf(horizontalPos);
                Y2 = String.valueOf(verticalPos - 1);

                X3 = String.valueOf(horizontalPos);;
                Y3 = String.valueOf(verticalPos - 2);                
            } else{
                //then we can take it as the mid pos on the top X row edge
                X1 = String.valueOf(horizontalPos - 1);
                Y1 = String.valueOf(verticalPos);

                X2 = String.valueOf(horizontalPos);
                Y2 = String.valueOf(verticalPos);

                X3 = String.valueOf(horizontalPos + 1);
                Y3 = String.valueOf(verticalPos);
            }
        } else if (firstHorizontalPos == true && lastHorizontalPos == false && firstVerticalPos == false && lastVerticalPos == false){
            if(staySameXRow==true){
                //then we can take it as the mid pos on the edge of the first y row edge
                X1 = String.valueOf(horizontalPos);
                Y1 = String.valueOf(verticalPos - 1);
                
                X2 = String.valueOf(horizontalPos);
                Y2 = String.valueOf(verticalPos);

                X3 = String.valueOf(horizontalPos);;
                Y3 = String.valueOf(verticalPos + 1);                
            } else{
                //then we can take it as the first pos on the first y row edge
                X1 = String.valueOf(horizontalPos);
                Y1 = String.valueOf(verticalPos);

                X2 = String.valueOf(horizontalPos + 1);
                Y2 = String.valueOf(verticalPos);

                X3 = String.valueOf(horizontalPos + 2);
                Y3 = String.valueOf(verticalPos);
            }
        }else if (firstHorizontalPos == false && lastHorizontalPos == true && firstVerticalPos == false && lastVerticalPos == false){
            if(staySameXRow==true){
                //then we can take it as the mid pos on the edge of the last y row edge
                X1 = String.valueOf(horizontalPos);
                Y1 = String.valueOf(verticalPos - 1);
                
                X2 = String.valueOf(horizontalPos);
                Y2 = String.valueOf(verticalPos);

                X3 = String.valueOf(horizontalPos);;
                Y3 = String.valueOf(verticalPos + 1);                
            } else{
                //then we can take it as the first pos on the last y row edge
                X1 = String.valueOf(horizontalPos);
                Y1 = String.valueOf(verticalPos);

                X2 = String.valueOf(horizontalPos - 1);
                Y2 = String.valueOf(verticalPos);

                X3 = String.valueOf(horizontalPos - 2);
                Y3 = String.valueOf(verticalPos);
            }
        } else if(firstHorizontalPos == true && lastHorizontalPos == false && firstVerticalPos == true && lastVerticalPos == false){
            //then we can take it as the first pos on the corner of the first x and first y row
            if(staySameXRow==true){
                X1 = String.valueOf(horizontalPos);
                Y1 = String.valueOf(verticalPos);
                
                X2 = String.valueOf(horizontalPos);
                Y2 = String.valueOf(verticalPos + 1);

                X3 = String.valueOf(horizontalPos);;
                Y3 = String.valueOf(verticalPos + 2);                
            } else{
                X1 = String.valueOf(horizontalPos);
                Y1 = String.valueOf(verticalPos);

                X2 = String.valueOf(horizontalPos + 1);
                Y2 = String.valueOf(verticalPos);

                X3 = String.valueOf(horizontalPos + 2);
                Y3 = String.valueOf(verticalPos);
            }
        } else if (firstHorizontalPos == true && lastHorizontalPos == false && firstVerticalPos == false && lastVerticalPos == true){
            //then we can take it as the first pos on the corner of the first x and last y row
            if(staySameXRow==true){
                X1 = String.valueOf(horizontalPos);
                Y1 = String.valueOf(verticalPos);
                
                X2 = String.valueOf(horizontalPos);
                Y2 = String.valueOf(verticalPos - 1);

                X3 = String.valueOf(horizontalPos);;
                Y3 = String.valueOf(verticalPos - 2);                
            } else{
                X1 = String.valueOf(horizontalPos);
                Y1 = String.valueOf(verticalPos);

                X2 = String.valueOf(horizontalPos + 1);
                Y2 = String.valueOf(verticalPos);

                X3 = String.valueOf(horizontalPos + 2);
                Y3 = String.valueOf(verticalPos);
            }
        } else if (firstHorizontalPos == false && lastHorizontalPos == true && firstVerticalPos == true && lastVerticalPos == false){
            //then we can take it as the first pos on the corner of the last x and first y row
            if(staySameXRow==true){
                X1 = String.valueOf(horizontalPos);
                Y1 = String.valueOf(verticalPos);
                
                X2 = String.valueOf(horizontalPos);
                Y2 = String.valueOf(verticalPos + 1);

                X3 = String.valueOf(horizontalPos);;
                Y3 = String.valueOf(verticalPos + 2);                
            } else{
                X1 = String.valueOf(horizontalPos);
                Y1 = String.valueOf(verticalPos);

                X2 = String.valueOf(horizontalPos - 1);
                Y2 = String.valueOf(verticalPos);

                X3 = String.valueOf(horizontalPos - 2);
                Y3 = String.valueOf(verticalPos);
            }
        } else if (firstHorizontalPos == false && lastHorizontalPos == true && firstVerticalPos == false && lastVerticalPos == true){
            //then we can take it as the first pos on the corner of the last x and last y row
            if(staySameXRow==true){
                X1 = String.valueOf(horizontalPos);
                Y1 = String.valueOf(verticalPos);
                
                X2 = String.valueOf(horizontalPos);
                Y2 = String.valueOf(verticalPos - 1);

                X3 = String.valueOf(horizontalPos);;
                Y3 = String.valueOf(verticalPos - 2);                
            } else{
                X1 = String.valueOf(horizontalPos);
                Y1 = String.valueOf(verticalPos);

                X2 = String.valueOf(horizontalPos - 1);
                Y2 = String.valueOf(verticalPos);

                X3 = String.valueOf(horizontalPos - 2);
                Y3 = String.valueOf(verticalPos);
            }
        }

        finalPos1 = Y1 + X1;
        finalPos2 = Y2 + X2;
        finalPos3 = Y3 + X3;

        finalPositions.add(finalPos1);
        finalPositions.add(finalPos2);
        finalPositions.add(finalPos3);

        return finalPositions;
    }

    public String getUserInput(String message){
        Scanner sc = new Scanner(System.in);
        System.out.println(message);
        sc.close();
        return sc.next();
    }
}

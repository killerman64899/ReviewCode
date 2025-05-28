import java.util.*;
public class GameHelper{
    private static final String ALPHABET = "ABCDEFG";
    private static final char[] alphaArray = ALPHABET.toCharArray();
    private final Random random = new Random();
    private final Scanner scanner = new Scanner(System.in);

    public ArrayList<String> generateLocation(int length){
        boolean horizontalOrientation = random.nextBoolean();
        ArrayList<String> positions = new ArrayList(length);
        int xStart, yStart; char yStartAlpha; String coords;
        if(horizontalOrientation){
            xStart = random.nextInt(0,8-length);
            yStart = random.nextInt(0,7);
            yStartAlpha = alphaArray[yStart];
            String y = String.valueOf(yStartAlpha);
            for(int i = 0; i<length; i++){
                coords = y + String.valueOf(xStart+1+i) ;
                positions.add(coords);
            }
        } else {
            xStart = random.nextInt(0,7);
            yStart = random.nextInt(0,8-length);
            String x = String.valueOf(xStart+1);
            for(int i = 0; i<length; i++){
                yStartAlpha = alphaArray[yStart+i];
                coords = String.valueOf(yStartAlpha) + x;
                positions.add(coords);
            }
        }
        return positions;
    }

    public String getUserInput(String displayText){
        System.out.println(displayText);
        String input = scanner.nextLine();
        return input.toUpperCase();
    }
}

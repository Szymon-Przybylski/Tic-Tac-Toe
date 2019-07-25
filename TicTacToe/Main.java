import java.util.Scanner;

public class Main {
	
	// expected input length: 11
	// input example "O OXXO XX"
	// input example "OXO  X OX"
	
	// draws game field
    private static void drawField() {
    	
        String[] gameField = inputHandler();
        
        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
        	System.out.print("| ");
        	System.out.print(gameField[i].replaceAll(".(?!$)", "$0 "));
        	System.out.println(" |");
        }
        System.out.println("---------");
    }
    
    // handles incorrect input (will, soonTM), creates rows for the game
    private static String[] inputHandler() {
    	
    	int rowLength = 3; // this is expected row length (see expected input)
    	
    	System.out.print("Enter cells: ");
    	
        Scanner input = new Scanner(System.in).useDelimiter("\\n");
        String inputString = input.next().replace("\"", "");
        
        String[] rows = new String[inputString.length() / rowLength];
    	int startPos = 0;
    	int endPos = rowLength;
    	
        for (int i = 0; i < rowLength; i++) {
        	rows[i] = inputString.substring(startPos, endPos);
        	startPos += rowLength;
        	endPos += rowLength;
        }
        
        input.close();
        return rows;
    }

    public static void main(String[] args) {
        drawField();
    }
}
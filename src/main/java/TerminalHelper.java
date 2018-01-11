import java.util.Scanner;

public class TerminalHelper {

    // making these fields and methods static allowed me to use them in the other files without creating an instance
    // of the RunnerHelper class, which would have looked awkward to do in the game file.
    private static Scanner scanner = new Scanner(System.in);

    public static void flushMacScreen(){
        // H means move the caret to the top of screen
        // 2J means clear entire screen (through newlines)
        // Uses Ansi escape codes
        // Apparently does not work on Windows?
        System.out.print("\033[H\033[2J");
    }

    public static String getInput(){
        String playerResponse = scanner.nextLine().toLowerCase().trim();
        checkQuit(playerResponse);
        return playerResponse;
    }

    public static void checkQuit(String response){
        if (response.contains("quit")) {
            // see RunnerHelp for details of below sout
            flushMacScreen();
            System.exit(0);
        }
    }

}

/* 
 * Horse Race Program
 * Object Oriented Programming
 * Edwin Sanchez
 *  
 * Description:
 * A program that allows you to use the terminal to race horses!
 * From the terminal, you can:
 * - Select a horse to bet on
 * - Race the horses
 * - Add/subtract earnings/losses from your account after a race
*/


// Dependencies
import java.util.Scanner;
import java.util.concurrent.TimeUnit;


// Defines the HorseRace Class. This class uses the Horse class to make a horse race.
public class HorseRace {
    private static int HORSE_COUNT = 4;
    private static Horse horses[] = new Horse[HORSE_COUNT]; // allocate array for HORSE_COUNT horses
    private static int TRACK_LENGTH = 15; // the length of the race track
    
    private static Scanner iScanner = new Scanner(System.in); // reads input from the terminal

    private static int SLEEP_TIME_SECONDS = 1;


    // main function - program starts here
    public static void main(String[] args) {
        float bankAccount = 1000.00f; // initialize the bank account
        String input = ""; // used to store the user's input

        // loop over the menu until the user is done with the program
        boolean keepGoing = true;
        while(keepGoing) {
            // print the menu
            printMenu();

            // get user input
            input = iScanner.nextLine();
            
            // parse input
            if(input.equals("0")) { // the user wants to exit the program

                System.out.println("Final Balance: $" + bankAccount + "\n");
                System.out.println("Thanks for Playing!");
                keepGoing = false;

            } else if(input.equals("1")) { // print out the user's current bank account balance
                System.out.println("Current Balance: $" + bankAccount + "\n");
            } else if(input.equals("2")) { // start a race

                if(bankAccount > 100.00f) { // user has enough money
                    bankAccount = initRace(bankAccount);
                } else { // user doesn't have enough money to place a bet
                    System.out.println("You don't have enough money to place a bet.");
                } // end if
                System.out.println("\nCurrent Balance: $" + bankAccount + "\n");

            } else { // base case - the user give an invalid input
                System.out.println("Invalid input: '" + input + "'. Please select an option from the menu.");
            } // end if
        } // end while
    } // end main


    // starts a race
    public static float initRace(float bankAccount) {
        // create variable to store input
        int selectedHorseIndex = -1;

        // init the horses
        initHorses();
        
        boolean keepGoing = true;
        while(keepGoing) {
            // print out some helpful info
            System.out.println("****************************");
            System.out.println("Your current balance is: $" + bankAccount + "\n");

            // prompt the user to pick a horse to bet on
            System.out.println("Select a horse to bet on:\n");
            System.out.println("0) " + horses[0].getName());
            System.out.println("1) " + horses[1].getName());
            System.out.println("2) " + horses[2].getName());
            System.out.println("3) " + horses[3].getName() + "\n");

            System.out.println("Which horse would you like to bet on?: ");
            
            // trying to get an integer - need a safety net for potential error
            try {
                // get user input, parse to integer (if possible)
                selectedHorseIndex = Integer.parseInt(iScanner.nextLine());
                
                // check for valid integer selection
                if(selectedHorseIndex >= HORSE_COUNT) {
                    System.out.println("Please select an integer between 0 and 3, inclusive");
                } else if(selectedHorseIndex < 0) {
                    System.out.println("Please select an integer between 0 and 3, inclusive");
                } else { // the user gave a valid input
                    // run the race - get whether the user won the race or not
                    boolean isWinner = runRace(selectedHorseIndex);

                    // if the user won, give them 100 dollars. if not, subtract 100.
                    if(isWinner) {
                        bankAccount += 100.00f;
                        System.out.println("You made a winning bet!");
                    } else {
                        bankAccount -= 100.00f;
                        System.out.println("You made a losing bet!");
                    } // end if

                    // end while loop and exit initRace
                    keepGoing = false;
                } // end if
            } catch(NumberFormatException err) {
                System.out.println("Please enter an integer.\n");
            } // end try catch
        } // end while
        
        // return new bank account balance after race
        return bankAccount;
    } // end startRace 


    // runs the race given a bet index. returns true if the player won, false otherwise
    public static boolean runRace(int betIndex) {
        System.out.println("'" + horses[betIndex].getName() + "'" + "(Horse " + betIndex + ") has been selected!");
        System.out.println("The race will begin shortly!");
        
        // sleep for 3 seconds
        sleepForSec(SLEEP_TIME_SECONDS);
        
        System.out.println("Track Length: " + TRACK_LENGTH);

        // print out starting track
        printTrack();
        sleepForSec(SLEEP_TIME_SECONDS);
        System.out.println("...On Your Mark...");
        sleepForSec(SLEEP_TIME_SECONDS);
        System.out.println("...Get Set...");
        sleepForSec(SLEEP_TIME_SECONDS);
        System.out.println("...Go!");

        // begin the race. keep looping until a horse has won
        boolean keepGoing = true;
        while(keepGoing) {
            // move horses
            for(int i = 0; i < HORSE_COUNT; i++) {
                horses[i].randMoveForward();
            } // end for

            // print out track
            printTrack();

            // check if a horse has finished the race
            for(int i = 0; i < HORSE_COUNT; i++) {
                if(horses[i].getCurrentPosition() == TRACK_LENGTH) {
                    System.out.println(horses[i].getName() + " (Horse " + i + ") won the race!\n");
                    if(i == betIndex) {
                        return true;
                    } else {
                        return false;
                    } // end if
                } // end if
            } // end for

            sleepForSec(SLEEP_TIME_SECONDS);
        } // end while

        // Should not get to this!
        return false;
    } // end runRace


    public static void sleepForSec(int seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException err) {
            System.out.println("Error sleeping for x seconds");
        } // end try catch
    } // end sleepForSec


    // setup horses for a race
    public static void initHorses() {
        // initialize horses
        for(int i = 0; i < HORSE_COUNT; i++) {
            horses[i] = new Horse();
        } // end for

        // set names of the horses
        horses[0].setName("Betty");
        horses[1].setName("Bartholomew");
        horses[2].setName("Henry");
        horses[3].setName("Solomon");

        // make sure the positions are set to zero
        for(int i = 0; i < HORSE_COUNT; i++) {
            horses[i].resetPosition();
        } // end for
    } // end setupHorses


    // print a track for a single horse based on the horse's position
    public static String generateHorsePath(Horse horse, int horseIndex) {
        // create String to represent the path of the horse
        String track = Integer.toString(horseIndex) + ") > ";

        // loop over the length of the track, generating the path
        for(int i = 1; i < TRACK_LENGTH; i++) {
            // set the character based on the position of the horse
            if(i < horse.getCurrentPosition()) { // the horse has passed this point
                track += "*";
            } else if(i == horse.getCurrentPosition()) { // the horse is at this point
                track += Integer.toString(horseIndex);
            } else { // the horse hasn't gotten this far yet
                track += ".";
            } // end if
            track += " "; // add spacing between each point on the path
        } // end for

        track += "|"; // signify the finish line

        return track;
    } // end generateTrack

    
    // generate the track for a single instance of the race
    public static void printTrack() {
        System.out.println("----------------------------------");

        // print out path for each horse w/ each horse's current position
        for(int i = 0; i < HORSE_COUNT; i++) {
            System.out.println(generateHorsePath(horses[i], i));
        } // end for

        System.out.println("----------------------------------\n");
    } // end generateTrack

    
    // prints the menu for the user to see
    public static void printMenu() {
        System.out.println("****************************");
        System.out.println("******* Horse Race *********");
        System.out.println("****************************\n");
        System.out.println("0) Quit");
        System.out.println("1) View Account");
        System.out.println("2) Start Race\n");

        System.out.println("Please Select an Option: ");
    } // end printMenu
} // end Main
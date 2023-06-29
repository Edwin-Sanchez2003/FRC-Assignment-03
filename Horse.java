/* 
 * Horse Race Program
 * Object Oriented Programming
 * Horse Class
 * Edwin Sanchez
 *  
 * Description:
 * This class contains the Horse's functionality for the Horse Race program.
 * The horse should have:
 * - A name
 * - a current position (on the race track)
 * - functions for:
 *      - getting the name
 *      - setting the name
 *      - getting the current position
 *      - random decision to move forward during the race
*/


// Dependencies
import java.lang.Math;


// The horse class. Used in the HorseRace program to keep track of each horse in the race.
public class Horse {
    /* Class Variables */ 
    private String name = "Horse"; // name of the horse
    private int position = 0; // position of the horse on the track
    
    private static double THRESHHOLD = 0.5;
    
    /* Functions */ 
    public static void main(String[] args) {} // end main

    // get the name of the horse
    public String getName() {
        return name;
    } // end getName

    // set the name of the horse
    public void setName(String newName) {
        this.name = newName;
    } // end sewName

    // get the current position of the horse in the race
    public int getCurrentPosition() {
        return position;
    } // end getCurrentPosition

    // reset the position of the horse
    public void resetPosition() {
        this.position = 0;
    } // end resetPostition

    // randomly decide if the horse should move forward
    public int randMoveForward() {
        // decide if the horse should move forward
        if(Math.random() >= THRESHHOLD) {
            this.position += 1;
        } // end if

        // return the current position of the horse
        return this.position;
    } // end randMoveForward
} // end Horse class

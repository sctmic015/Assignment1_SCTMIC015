/** Class that represent a Load Shedding object
* @author SCTMIC015
*/

import java.io.*;

public class LSItems {

   private String information;
   private String areas;

   /** Creates a Load Shedding object containing information for the "stage, date, and start time" and for the Corresponding Areas
   * @param information String for the stage, date and start time.
   * @param areas String for the areas experiencing load shedding
   */
   public LSItems(String information, String areas) {
      this.information = information;
      this.areas = areas;
   }

   /** Returns a string represnetation for the Load Shedding object
   */
   public String toString() {
      return "Load Shedding Inforamtion: " + this.information + ": Corresponding Areas: " + this.areas;
   }

   /** Getter method that returns a string for the stage, date andd start time for the load shedding object
   */
   public String getInformation() {
      return this.information;
   }

   /** Getter method that returns a string representation of the areas for the load shedding object
   */
   public String getAreas() {
      return this.areas;
   }

   /** Method that tests whether the information of two load shedding objects are the same.
   * returns true if they are the same and false if they are not the same.
   * @param LSItems object.
   */
   public boolean equal(LSItems other) {
      if (this.information.equals(other.getInformation()))
         return true;
      else
         return false;
   }

}

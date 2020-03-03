import java.io.*;

public class LSItems {

   private String information;
   private String areas;

   public LSItems(String information, String areas) {
      this.information = information;
      this.areas = areas;
   }

   public void printArea() { // this method is fucking out
      for (int i = 0; i < this.areas.length(); i ++) {
         System.out.print(this.information.charAt(i) + " ");
         System.out.print(this.areas.charAt(i));
      }
   }

   public String toString() {
      return "Load Shedding Inforamtion: " + this.information + ": Corresponding Areas: " + this.areas;
   }

   public String getInformation() {
      return this.information;
   }

   public String getAreas() {
      return this.areas;
   }

   public boolean equal(LSItems other) {
      if (this.information.equals(other.getInformation()))
         return true;
      else
         return false;
   }

}

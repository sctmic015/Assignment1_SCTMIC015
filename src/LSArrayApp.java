import java.io.*;
import java.util.*;

public class LSArrayApp {

   private static int opCount = 0;
   private static LSItems[] LSItemsArray;


   public static void main(String[] args) throws IOException {

      File file = new File("Load_Shedding_All_Areas_Schedule_and_Map.clean.final.txt");

      LSItemsArray = new LSItems[2976];
      Scanner scan;
      //Scanner scan = new Scanner(file);

      try {
         scan = new Scanner(file);
         int count = 0;
         while (scan.hasNextLine()){
            String line = scan.nextLine();
            String[] splitString = splitString(line);
            //System.out.println(Arrays.toString(splitString));
            LSItems lsItem = new LSItems(splitString[0], splitString[1]);
            LSItemsArray[count] = lsItem;
            count++;
         }
         scan.close();

      }
      catch(FileNotFoundException e) {
         throw new RuntimeException(e);
      }


      if (args.length != 0) {
         printAreas(args[0]);
         try {
            writeOperationsToTxt(args[0], opCount);
         }
        catch(FileNotFoundException e) {
          throw new RuntimeException(e);
        }
      }
      else
        printAllAreas();



      //WriteOperationsToTxt("2, 13, 04", 4);

   }

   public static String[] splitString(String str) {
      String line = str.trim();
      String info = "";
      String areas = "";
      for (int i = 0; i < line.length(); i ++) {
         if (i <= 6)
            info += line.charAt(i);
         else
            areas += line.charAt(i);
      }
      info = info.trim();
      areas = areas.trim();
      String[] splitString = new String[]{info, areas};
      return splitString;
   }

   public static void printAreas(String information) {
      //String information = stage + "_" + day + "_" + startTime;
      boolean bool = false;
      for (int i = 0; i <= 2976; i ++) {
         opCount++;
         if (LSItemsArray[i].getInformation().equals(information)){
            System.out.println("Load Shedding Inforamtion: " + LSItemsArray[i].getInformation()
                + ": Corresponding Areas: " + LSItemsArray[i].getAreas());
            bool = true;
            break;
         }

      }
      if (bool == false)
            System.out.println("Areas not found");
   }

   public static void printAllAreas() {
	      for (int i = 0; i <= 2967; i++) {
	         System.out.println("Load Shedding Inforamtion: " + LSItemsArray[i].getInformation()
                + ": Corresponding Areas: " + LSItemsArray[i].getAreas());

	      }
	   }

	   public static void writeOperationsToTxt(String information, int opCount) throws IOException {
	      FileWriter fileWriter = new FileWriter("OpCount.txt", true);
        BufferedWriter buffer = new BufferedWriter(fileWriter);
	      buffer.write("Data Structure: Array" + '\n'
            + "Stage, date and start time tested: " + information + '\n' + "Operations counted: "
            + Integer.toString(opCount) + '\n');


	   }

}

import java.io.*;
import java.util.*;

public class LSArrayAppTest {

   private static int opCount = 0;
   private static LSItems[] LSItemsArray;

   /** Main method for reading in Load shedding data set and printing out the eoperation count for the corresponding
   stage, day and start time. Prints out a list of all times if no paramters given
   * @param args the stage, day and start time to search for
   */

   public static void main(String[] args) throws IOException {

     File file = new File("subset:0.txt");
      //File file = new File(args[0]);

      LSItemsArray = new LSItems[lineCounter("subset:0.txt")];
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
      for (int i = 0; i < LSItemsArray.length; i++){
        opCount = 0;
        printAreas(LSItemsArray[i].getInformation());
      }

      for (int i = 0; i < LSItemsArray.length; i++){
        LSItems item = LSItemsArray[i];
        opCount = 0;
        FinalPrintThing(item.getInformation());

      }

   }

   /** Method to split each line in the file so that it can be read into the Array
   */
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

   public static void FinalPrintThing(String information){
     boolean bool = false;
     for (int i = 0; i < LSItemsArray.length; i ++){
       LSItems item = LSItemsArray[i];
       opCount ++;
       if (item.getInformation().equals(information)){
         bool = true;
         try {writeOperationsToCSV(information, opCount);}
         catch (IOException e){throw new RuntimeException(e);}
       }
       break;
     }
   }

   /** Method to print out the Areas of the given the corresponding date, stage and start time.
   * Returns Areas not found if there is no match
   * @param String information String value for the stage, day and time queried.
   */
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

   /** Method to print out all the "day, stage and start time" and their corresponding areas.
   */
   public static void printAllAreas() {
	      for (int i = 0; i <= 2967; i++) {
	         System.out.println("Load Shedding Inforamtion: " + LSItemsArray[i].getInformation()
                + ": Corresponding Areas: " + LSItemsArray[i].getAreas());

	      }
	   }

	   /*public static void writeOperationsToTxt(String information, int opCount) throws IOException {
       FileWriter fileWriter = new FileWriter("OpCount.txt");
       BufferedWriter buffer = new BufferedWriter(fileWriter);
       PrintWriter printer = new PrintWriter(buffer);
       printer.println("Data Structure: Tree" + '\n' + "Stage, date and start time tested: "
           + information + '\n' + "Operations counted: "
           + Integer.toString(opCount) + '\n');
        buffer.close();
      }  */

      /** Method that writes the number of operations used to find an area when given the corresponding stage, day and start time.
      * @throws IOException if fails to write the paramters to file
      * @param String information String value for the stage, day and time queried.
      * @param int opCount int value for number of operations used
      */
      public static void writeOperationsToTxt(String information, int opCount) throws IOException{
        FileWriter fw = null;
        BufferedWriter bw = null;
        PrintWriter pw = null;

        try {
            fw = new FileWriter("opCountArray", true);
            bw = new BufferedWriter(fw);
            pw = new PrintWriter(bw);

            pw.println("Data Structure: Array" + '\n' + "Stage, date and start time tested: "
                + information + '\n' + "Operations counted: "
                + Integer.toString(opCount) + '\n');
            pw.flush();

        } finally {
            try {
                pw.close();
                bw.close();
                fw.close();
            } catch (IOException io) {// can't do anything }
            }

        }

      }


      public static void writeOperationsToCSV(String information, int opCount) throws IOException{
        FileWriter fw = null;
        BufferedWriter bw = null;
        PrintWriter pw = null;

        try {
            fw = new FileWriter("opCountArrayTest.csv", true);
            bw = new BufferedWriter(fw);
            pw = new PrintWriter(bw);

            //pw.println("Data Structure: Array" + '\n' + "Stage, date and start time tested: "
              //  + information + '\n' + "Operations counted: "
                //+ Integer.toString(opCount) + '\n');

            pw.println(information + " , " + Integer.toString(opCount));
            pw.flush();

        } finally {
            try {
                pw.close();
                bw.close();
                fw.close();
            } catch (IOException io) {// can't do anything }
            }

        }
      }

      public static int lineCounter(String file){
        Scanner scan = new Scanner(file);
        int count = 0;
        while (scan.hasNextLine()){
          count++;
        }
        return count;
      }

}

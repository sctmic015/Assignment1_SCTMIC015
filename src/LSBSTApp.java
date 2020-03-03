import java.io.*;
import java.util.*;

public class LSBSTApp {

   private static BST tree;
   private static int opCount = 0;

   public static void main(String[] args) throws IOException {
      File file = new File("Load_Shedding_All_Areas_Schedule_and_Map.clean.final.txt");

      tree = new BST();
      Scanner scan;


      try {
         scan = new Scanner(file);
         int count = 0;
         while (scan.hasNextLine()){
            String line = scan.nextLine();
            String[] splitString = splitString(line);
            //System.out.println(Arrays.toString(splitString));
            LSItems lsItem = new LSItems(splitString[0], splitString[1]);
            tree.insert(lsItem);
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
               writeOperationsToTxt(args[0], tree.opCount);
            }
            catch(FileNotFoundException e) {
               throw new RuntimeException(e);
            }
      }
      else
         printAllAreas();

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
      LSItems searchLS = tree.search(information);
      if (searchLS != null)
         System.out.println(searchLS);
      else
         System.out.println("information not found");
    }

    public static void printAllAreas() {
	   tree.inorder(tree.root);
	   }

	   /*public static void writeOperationsToTxt(String information, int opCount) throws IOException {
	      FileWriter fileWriter = new FileWriter("OpCount.txt");
        BufferedWriter buffer = new BufferedWriter(fileWriter);
        PrintWriter printer = new PrintWriter(buffer);
	      printer.println("Data Structure: Tree" + '\n' + "Stage, date and start time tested: "
            + information + '\n' + "Operations counted: "
            + Integer.toString(opCount) + '\n');
         buffer.close();
	   } */

     public static void writeOperationsToTxt(String information, int opCount) throws IOException{
       FileWriter fw = null;
       BufferedWriter bw = null;
       PrintWriter pw = null;

       try {
           fw = new FileWriter("opCountTree", true);
           bw = new BufferedWriter(fw);
           pw = new PrintWriter(bw);

           pw.println("Data Structure: Tree" + '\n' + "Stage, date and start time tested: "
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

}

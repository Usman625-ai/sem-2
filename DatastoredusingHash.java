import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class DatastoredusingHash {
    public static void main(String[] args){
        String path = "EVE01Sales.txt";
        String line;
        Scanner obj = null;
        HashMap<String,Integer> salesmonth = new HashMap<>();
        try {
            File file = new File(path);
            obj = new Scanner(file);
            String[] fields;
            line = obj.nextLine();
            fields = line.split("\t");
            while (obj.hasNextLine()){
                line = obj.nextLine();
                fields = line.split("\t");
                String[] date = fields[0].split("-");
                String month = date[1];
                if (salesmonth.containsKey(month)){
                    int total = salesmonth.get(month);
                    int qty = Integer.parseInt(fields[5]) * Integer.parseInt(fields[4]);
                    total += qty;
                    salesmonth.put(month,total);
                }
                else{
                    int qty = Integer.parseInt(fields[5]) * Integer.parseInt(fields[4]);
                    salesmonth.put(month,qty);
                }
            }
            // loop through all keys in this case keys are month; this for loop will run for no of month(like if month are 5 it will run for 5 times) times;
            for (Map.Entry<String, Integer> entry : salesmonth.entrySet()) {
                String month = entry.getKey();
                Integer total = entry.getValue();
                System.out.println("Month : " + month + " Total Sales : " + total);
            }
            obj.close();

        } catch(FileNotFoundException e){
            System.out.println("file not found " + e.getMessage());
        } catch(Exception e){
            System.out.println("Error reading file" + e.getMessage());
        }
    }
}
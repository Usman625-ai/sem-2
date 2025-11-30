import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

// its a random question to practice filehandling 
// ask user name ebno and subject marks then append it into file after every student record change line
public class FileHandlingPracticeQuestion {
    public static void main(String[] args) {
        String outputFile = "StudentsData.txt";
        try (FileWriter writer = new FileWriter(outputFile, true);
                Scanner obj = new Scanner(System.in)) {
            writer.write("name" + "\t" + "Eb-no" + "\t" + "physics" + "\t" + "calculas" +
                    "\t" + "English" + "\t" + "Islamiat" + "\t" + "ICT" + "\t" +"\t" + "PF" + "\n");
            boolean completed = false;
            while (!completed) {
                System.out.println("Your name : ");
                String name = obj.nextLine();

                System.out.println("Your EB-No : ");
                String Ebno = obj.nextLine();

                System.out.println("Physics Marks : ");
                int physics = obj.nextInt();

                System.out.println("Calculas Marks : ");
                int Calculas = obj.nextInt();

                System.out.println("English Marks : ");
                int English = obj.nextInt();

                System.out.println("Islamiat Marks : ");
                int Islamiat = obj.nextInt();

                System.out.println("ICT Marks : ");
                int ICT = obj.nextInt();

                System.out.println("PF Marks : ");
                int PF = obj.nextInt();
                writer.write(name + "\t" + Ebno + "\t" + "\t" + physics + "\t" + "\t" + Calculas + 
                    "\t" + "\t" + English + "\t"+ "\t"  + Islamiat + "\t" + "\t" + "\t" + ICT + "\t" + "\t" + PF + "\n");

                System.out.println("Finished! your data is stored in a file : ");
                System.out.println("Another student data ? : True or False ? ");
                completed = obj.nextBoolean();
                completed = !completed;
            }
             System.out.println("Data saved successfully in file: " + outputFile);

        } catch (IOException e) {
            System.out.println("Error while writing to file: " + e.getMessage());
        }
    }
}

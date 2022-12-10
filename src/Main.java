import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    private static ArrayList<String> list = new ArrayList<String>(); // arraylist

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); // scanner instance to take inputs from user

        String str;
        System.out.println("Please enter a command (O, S, C, V, or quit): ");
        while (!(str = input.nextLine()).equals("quit")) {
            if (str.equals("O")) {
                // code to open a list file from disk
                openListFile(input);
            } else if (str.equals("S")) {
                // code to save the current list file to disk
                saveListFile();
            } else if (str.equals("C")) {
                list.clear();
                System.out.println("The list has been cleared.");
            } else if (str.equals("V")) {
                // code to print the current list
                System.out.println("This is your list: " + list);
                System.out.println("Your list has " + list.size() + " items");
            } else {
                System.out.println("Invalid command. Please enter a valid command (O, S, C, V, or quit): ");
            }
        }
    }

    public static void openListFile(Scanner input) {
        System.out.println("Enter the name of the file you would like to open: ");
        String filename = input.nextLine();
        File file = new File(filename);
        try {
            Scanner fileInput = new Scanner(file);
            while (fileInput.hasNextLine()) {
                String line = fileInput.nextLine();
                list.add(line);
            }
            System.out.println("The file has been opened and its contents have been added to the list.");
        } catch (IOException e) {
            System.out.println("An error occurred while opening the file. Please check the filename and try again.");
        }
    }

    public static void saveListFile() {
        System.out.println("Enter the name of the file you would like to save: ");
        String filename = input.nextLine();
        File file = new File(filename);
        try {
            FileWriter writer = new FileWriter(file);
            for (String item : list) {
                writer.write(item + "\n");
            }
            writer.close();
            System.out.println("The file has been saved.");
        } catch (IOException e) {
            System.out.println("An error occurred while saving the file. Please check the filename and try again.");
        }
    }
}

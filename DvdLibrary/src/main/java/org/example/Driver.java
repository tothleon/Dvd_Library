package org.example;
import java.io.*;
import java.util.Scanner;

public class Driver {
    //Starts the application.
    public static void main(String[] args) {
        //Reads file and loads data in the DVD object
        readFile("dvd.txt");
        //App loop
        runApp();
    }

    public static void runApp() {
        //Prints out all data
        printAllDvds();
        //Displays menu and accepts inputs
        menu();
    }

    public static void menu() {
        Scanner in = new Scanner(System.in);
        int selected = 0;

        System.out.print("1: ADD, 2: REMOVE, 3: EDIT, 4: SEARCH, 5: SAVE & QUIT \nEnter number here: ");
        //Test if the input is an integer
        try {
            selected = in.nextInt();
        } catch (Exception e) {
            System.out.println("INVALID INPUT!!!");
            menu();
        }
        //Routes selected module
        switch (selected) {
            case 1 -> add();
            case 2 -> remove();
            case 3 -> edit();
            case 4 -> search();
            case 5 -> quit();
            //Return the user if integer is out of range
            default -> {
                System.out.println("INVALID INPUT!!!");
                menu();
            }
        }
    }

    public static void add() {
        //Pre asigns new DVD id
        int id = DVDs.AllDvds.size() + 1;

        Scanner integer = new Scanner(System.in);
        Scanner str = new Scanner(System.in);

        System.out.print("Enter title here: ");
        String title = str.nextLine();

        System.out.print("Please enter release date in format ddmmyyyy here: ");
        String releaseDate = str.nextLine();

        int mpaaRating = 0;
        System.out.print("Please enter MPAA rating: ");
        try {
            mpaaRating = integer.nextInt();
        } catch (Exception e) {
            mpaaRating = 0;
        }

        System.out.print("Please enter director name: ");
        String director = str.nextLine();

        System.out.print("Please enter studio name: ");
        String studio = str.nextLine();

        System.out.print("Please enter rating or note: ");
        String rating = str.nextLine();

        //Creates new DVD
        DVDs temp = new DVDs(id, title, releaseDate, mpaaRating, director, studio, rating);
        //Add new object to ArrayList
        DVDs.AllDvds.add(temp);

        //Returns to the start page
        runApp();
    }

    public static void remove() {
        Scanner rmId = new Scanner(System.in);
        System.out.print("Enter item ID to be removed: ");
        int removeId = 0;

        //checks if input is int
        try {
            removeId = rmId.nextInt();
        } catch (Exception e) {
            System.out.println("INVALID INPUT!!!");
            runApp();
        }

        //checks if id is in range
        if (removeId > 0 && removeId <= DVDs.AllDvds.size()) {
            //finds the item with the selected ID to be removed
            for (int i = 0; i < DVDs.AllDvds.size(); i++) {
                if (removeId == DVDs.AllDvds.get(i).getId()) {
                    System.out.println("Item with id \n" + DVDs.AllDvds.get(i) + "\nhas ben removed.");
                    //removes DVD
                    DVDs.AllDvds.remove(i);
                    //resets the ID-s of the remaining DVD-s
                    resetIndexes();
                    break;
                }
            }
        } else {
            System.out.println("INPUT NOT IN RANGE...\n Try again.");
            remove();
        }
        //Returns to the start screen
        runApp();

    }
    public static void edit() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter item ID to be edited: ");
        int editId = -1;

        //Checks if input is int
        try {
            editId = input.nextInt();
        } catch (Exception e) {
            System.out.println("INVALID INPUT!!!");
            runApp();
        }

        //Checks if input is in range
        if (editId > 0 && editId <= DVDs.AllDvds.size()) {

            int index = -1;

            //Finds the index of the selected object
            for (int i = 0; i < DVDs.AllDvds.size(); i++) {
                if (editId == DVDs.AllDvds.get(i).getId()) {
                    index = i;
                }
            }

            System.out.print("Edit 1: Title, 2: Release date, 3: MPAA rating, 4: Director's name, 5: Studio name, 6: User rating or note\n" +
                    "Enter here: ");

            int option = 0;
            //Checks if input is int
            try {
                option = input.nextInt();
            } catch (Exception e) {
                System.out.println("INVALID INPUT!!!");
                runApp();
            }

            Scanner modifier = new Scanner(System.in);

            //Selects the correct data field to be modified, makes a prompt, asks for input and refactors the field
            switch (option) {
                case 1 -> {
                    System.out.print("Input new title here: ");
                    String title = modifier.nextLine();
                    DVDs.AllDvds.get(index).setTitle(title);
                }
                case 2 -> {
                    System.out.print("Input new release here: ");
                    String release = modifier.nextLine();
                    DVDs.AllDvds.get(index).setReleaseDate(release);
                }
                case 3 -> {
                    System.out.print("Input MPAA rating here: ");
                    int mpaa = 0;
                    //Checks if input is int
                    try {
                        mpaa = modifier.nextInt();
                    } catch (Exception e) {
                        System.out.println("INVALID INPUT!!!");
                        edit();
                    }
                    DVDs.AllDvds.get(index).setMpaaRating(mpaa);
                }
                case 4 -> {
                    System.out.print("Input new Director's name here: ");
                    String director = modifier.nextLine();
                    DVDs.AllDvds.get(index).setDirectorName(director);
                }
                case 5 -> {
                    System.out.print("Input new Studio name here: ");
                    String studio = modifier.nextLine();
                    DVDs.AllDvds.get(index).setStudioName(studio);
                }
                case 6 -> {
                    System.out.print("Input new User rating or note here: ");
                    String rating = modifier.nextLine();
                    DVDs.AllDvds.get(index).setUserRating(rating);
                }
                default -> {
                    System.out.println("INVALID INPUT!!!");
                    edit();
                }
            }
        } else {
            System.out.println("INPUT NOT IN RANGE...\n Try again.");
            edit();
        }
        //Returns to the front page
        runApp();
    }

    public static void search() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter search term by title here: ");
        String prompt = input.nextLine();

        for (int i = 0; i < DVDs.AllDvds.size(); i++) {
            //Takes input and checks if anny DVD-s title contains the input string while converting them to lower case
            if (DVDs.AllDvds.get(i).getTitle().toLowerCase().contains(prompt.toLowerCase())) {
                System.out.println("\nFOUND: " + DVDs.AllDvds.get(i));
            }
        }
        runApp();
    }
    //Quits the program and saves the DVD-S to the same file from where was read from
    public static void quit() {
        //Defines the file path
        File fileNameOut = new File("dvd.txt");
        try {
            FileWriter fw = new FileWriter(fileNameOut);
            BufferedWriter bw = new BufferedWriter(fw);

            //Iterates over the ArrayList and writes line by line the DVDs
            for (DVDs dvd: DVDs.AllDvds)
            {
                bw.write(dvd.toWrite());
            }
            bw.flush();
            bw.close();
        } catch (Exception e) {
            System.out.println("ERROR WHILE WRITING...");
        }
        System.out.println("SAVED!");
    }
    //Refreshes the ID-s of the DVD-s
    public static void resetIndexes() {
        for (int i = 0; i < DVDs.AllDvds.size(); i++) {
            DVDs.AllDvds.get(i).setId(i + 1);
        }
    }
    //Prints out all the DVD-s
    public static void printAllDvds() {
        System.out.println("____________________________________________________________________________________________");
        for (int i = 0; i < DVDs.AllDvds.size(); i++) {
            System.out.print(DVDs.getAllDvds().get(i));
        }
        System.out.println("____________________________________________________________________________________________\n");
    }
    //File reader method
    public static void readFile(String path) {
        //defines file path
        File file = new File(path);
        FileReader fileReader = null;
        String[] line;
        int idNumber = 1;
        try {
            fileReader = new FileReader(file);
            BufferedReader reader = new BufferedReader(fileReader);
            String currentLine = reader.readLine();

            while (currentLine != null) {
                line = currentLine.split(",");
                //Loads in the data in a DVD instance
                int id = idNumber;
                String title = line[0];
                String releaseDate = line[1];
                int mpaaRating = Integer.parseInt(line[2]);
                String director = line[3];
                String studio = line[4];
                String rating = line[5];

                //Loads in the data in a DVD instance
                DVDs temp = new DVDs(id, title, releaseDate, mpaaRating, director, studio, rating);
                //Appends the new DVD to the ArrayList
                DVDs.AllDvds.add(temp);
                //Iterates
                currentLine = reader.readLine();
                //Iterates ID numbers
                idNumber++;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
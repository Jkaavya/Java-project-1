package com.company;
import java.io.*;
import java.util.*;

public class LockedME {

    static Scanner Inputfromuser = new Scanner(System.in);


    public static void menu() {
        System.out.println("------------------");
        System.out.println("Welcome to the Lockedme \n");
        System.out.println("Developed by Kavya.J  \n");
        System.out.println("Select any one of the following options ,enter the number associated with it:");
        System.out.println("1:View all the files\n" + "2:See the options menu \n" + "3:Application exit \n");

        try {

            int a = Inputfromuser.nextInt();
            if (a == 1) {
                AllFilesDisplay();
            } else if (a == 2) {
                Optionsmenu();
            } else if (a == 3) {
                System.out.println("thank you");
                System.exit(0);
            } else {
                System.out.println("input is invalid ,try again");
            }
        } catch (InputMismatchException e) {
            System.out.println(" input is invalid");
            Inputfromuser.nextLine();
        }
    }

    public static void Optionsmenu() {
        System.out.println("Welcome to the options menu");
        System.out.println("select one of the following options and the number associated with it : \n");
        System.out.println("1: add a file \n" + "2 : delete a file \n" + "3: search a file \n" + "4: Go back to the main menu \n" + " 5: Application exit");

        int x = Inputfromuser.nextInt();
        try {
            if (x == 1) {
                add();
            } else if (x == 2) {
                Delete();
            } else if (x == 3) {
                search();
            } else if (x == 4) {
                menu();

            } else if (x == 5) {
                System.out.println("thank you");
                System.exit(0);
            } else {
                System.out.println("input is invalid try again");
            }
        } catch (InputMismatchException e) {
            e.printStackTrace();
            System.out.println("input is invalid");
        }
    }

    static void add() {
        System.out.println("enter the name of the file you want to create along with file extension like .pdf,.txt");
        String Addtn = Inputfromuser.next();
        try {
            File f = new File("C:\\kavya11\\" + Addtn);
            boolean flag = f.createNewFile();
            if (flag) {
                System.out.println("File" + f.getName() + " is created at the specified location");

            } else {
                System.out.println("File already exits ");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void Delete() {
        System.out.println("Enter the name of file to be deleted along with file extention .txt,pdf");
        String delt = Inputfromuser.next();
        File file = new File("C:\\kavya11\\"  + delt);

        if (file.delete()) {
            System.out.println("File deleted successfully" + file.getName());
        } else {
            System.out.println("Failed to delete the file");
        }
    }

    public static void search() {
        System.out.println("Please enter the name of the file you want to search along with the file extension. (.txt , .pdf etc etc..)");
        String initials =Inputfromuser.next();

        File directory = new File("C:\\kavya11\\");

        String[] flist = directory.list();
        int flag = 0;
        if (flist == null) {
            System.out.println("Empty directory.");
        } else {
            for (int i = 0; i < flist.length; i++) {
                String filename = flist[i];
                if (filename.equals(initials)) {
                    System.out.println(filename + " found");
                    flag = 1;
                }
            }
        }
        if (flag == 0) {
            System.out.println("File Not Found");
        }
    }





        public static void AllFilesDisplay() {
            File folder = new File("C:\\kavya11\\" );
            List flist = Arrays.asList(folder.list());
            Collections.sort(flist);
            System.out.println("File name is sorted in ascending order");
            for (Object file : flist) {
                System.out.println(file);
            }
        }


        public static void main(String[] args) {
            while (true) {
                menu();
            }
        }
    }


package add;

import java.io.*;
import java.util.Scanner;

public class addTask        //to add records to the task list
{
    public static void addRecord(String fname, String task, String hr , String min )     //to write to the respective text files
    {
        try
        {
            BufferedWriter data=new BufferedWriter(new FileWriter(fname,true));    //writes to the file using BufferedWriter
            data.write(task+" "+hr+" "+min+"\n");
            data.close();
        }
        catch(IOException e)
        {
            System.out.println("exception occured" + e);
        }
    } 
    public static void add(String up)  
    {
        try
        {
        String fname;
        String task;
        String hr;
        String min;
        int l;
        int c,t;
        Scanner sc=new Scanner(System.in);
        clrscr();                         //calling clearScreen() method
        System.out.println("\nFILES AVAILABLE TO ADD RECORD");
        System.out.println("______________________________");
        System.out.println("1. PRODUCTIVE TASKS");
        System.out.println("2. NON-PRODUCTIVE BUT ESSENTIAL TASKS");
        System.out.println("3. NON-PRODUCTIVE AND NON-ESSENTIAL TASKS");
        System.out.println("\nEnter the file number to which the record is to be added:");
        c=sc.nextInt();
        System.out.println("Enter the number of tasks you want to add:");
        t=sc.nextInt();

        switch(c)
        {
            case 1: clrscr();
                    System.out.println("\nFILE : PRODUCTIVE TASKS");
                    System.out.println("________________________");
                    for(l=0;l<t;l++)
                    {
                        System.out.println("\nENTER DETAILS FOR TASK NUMBER "+(l+1)+":");
                        fname="C:\\Users\\sarth\\Desktop\\Unguided Project\\unguided_39\\unguided_39\\txt_files\\productive_"+up+".txt";
                        System.out.println("Enter the task done:");
                        task=sc.next();
                        System.out.println("Enter the time taken to do the task(in hours and minutes):");
                        System.out.print("Hours-");
                        hr=sc.next();
                        System.out.print("Minutes-");
                        min=sc.next();
                        addRecord(fname,task,hr,min);      //calling addRecord() method to write the input into the file
                    }
                    System.out.println("\nTHE RECORD HAS BEEN ADDED SUCCESSFULLY!!!");
                    System.in.read();
                    break;

            case 2: clrscr();
                    System.out.println("\nFILE : NON-PRODUCTIVE BUT ESSENTIAL TASKS");
                    System.out.println("__________________________________________");
                    for(l=0;l<t;l++)
                    {
                        System.out.println("\nENTER DETAILS FOR TASK NUMBER "+(l+1)+":");
                        fname="C:\\Users\\sarth\\Desktop\\Unguided Project\\unguided_39\\unguided_39\\txt_files\\nonproductive_essential_"+up+".txt";
                        System.out.println("Enter the task done:");
                        task=sc.next();
                        System.out.println("Enter the time taken to do the task(in hours and minutes):");
                        System.out.print("Hours-");
                        hr=sc.next();
                        System.out.print("Minutes-");
                        min=sc.next();
                        addRecord(fname,task,hr,min);      //calling addRecord() method to write the input into the file
                    }
                    System.out.println("\nTHE RECORD HAS BEEN ADDED SUCCESSFULLY!!!");
                    System.in.read();
                    break;

            case 3: clrscr();
                    System.out.println("\nFILE : NON-PRODUCTIVE AND NON-ESSENTIAL TASKS");
                    System.out.println("⎺⎺⎺⎺⎺⎺⎺⎺⎺⎺⎺⎺⎺⎺⎺⎺⎺⎺⎺⎺⎺⎺⎺⎺⎺⎺⎺⎺⎺⎺⎺⎺⎺⎺⎺⎺⎺⎺⎺⎺⎺⎺⎺⎺⎺");
                    for(l=0;l<t;l++)
                    {
                        System.out.println("\nENTER DETAILS FOR TASK NUMBER "+(l+1)+":");
                        fname="C:\\Users\\sarth\\Desktop\\Unguided Project\\unguided_39\\unguided_39\\txt_files\\nonproductive_nonessential_"+up+".txt";
                        System.out.println("Enter the task done:");
                        task=sc.next();
                        System.out.println("Enter the time taken to do the task(in hours and minutes):");
                        System.out.print("Hours-");
                        hr=sc.next();
                        System.out.print("Minutes-");
                        min=sc.next();
                        addRecord(fname,task,hr,min);      //calling addRecord() method to write the input into the file
                    }
                    System.out.println("\nTHE RECORD HAS BEEN ADDED SUCCESSFULLY!!!");
                    System.in.read();
                    break;
            
            default: System.out.println("\nSORRY! WRONG FILENAME...");
                     System.in.read();
                     clrscr();
                     System.exit(0);        
        }
        clrscr();
        }
        catch(IOException e)
        {
            System.out.println("exception occured" + e);
        }
    }

    public static void clrscr()//Clears Screen in java
    {
    try 
    {
        if (System.getProperty("os.name").contains("Windows"))
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        else
            Runtime.getRuntime().exec("clear");
    } catch (IOException | InterruptedException ex) {}
}
}
package display;

import java.io.*;
import java.util.Scanner;

public class displayFile
{
    public static void display(String up) 
    {
        int c;
        Scanner sc= new Scanner(System.in);
        clrscr();                       //calling clearScreen() method
        System.out.println("\nFILES AVAILABLE");
        System.out.println("________________");
        System.out.println("1. PRODUCTIVE TASKS");
        System.out.println("2. NON-PRODUCTIVE BUT ESSENTIAL TASKS");
        System.out.println("3. NON-PRODUCTIVE AND NON-ESSENTIAL TASKS");
        System.out.println("\nEnter the file number which is to be displayed:");
        c=sc.nextInt();
        
        try
        {
            String fname,str;
            if(c==1)
            {
                fname="C:\\Users\\sarth\\Desktop\\Unguided Project\\unguided_39\\unguided_39\\txt_files\\productive_"+up+".txt";
                BufferedReader in=new BufferedReader(new FileReader(fname));
                clrscr();
                System.out.println("\nFILE : PRODUCTIVE TASKS");
                System.out.println("________________________");
                System.out.println("\nTHE FILE CONTENTS ARE ON THE SCREEN:");
               
                while((str=in.readLine())!=null)          //reading the file contents line by line
                {
                    String task=str.split(" ")[0];
                    String hrs = str.split(" ")[1];
                    String mins=str.split(" ")[2];
                    System.out.println(task+" -> "+hrs+" hours "+mins+" minutes");     
                }
                System.in.read();       //used to hold the screen
                clrscr();
            }
            else if(c==2)
            {
                fname="C:\\Users\\sarth\\Desktop\\Unguided Project\\unguided_39\\unguided_39\\txt_files\\nonproductive_essential_"+up+".txt";
                BufferedReader in=new BufferedReader(new FileReader(fname));
                clrscr();
                System.out.println("\nFILE : NON-PRODUCTIVE BUT ESSENTIAL TASKS");
                System.out.println("__________________________________________");
                System.out.println("\nTHE FILE CONTENTS ARE ON THE SCREEN:");
                
                while((str=in.readLine())!=null)
                {
                    String task=str.split(" ")[0];
                    String hrs = str.split(" ")[1];
                    String mins=str.split(" ")[2];
                    System.out.println(task+" -> "+hrs+" hours "+mins+" minutes");
                }
                System.in.read();
                clrscr();
            }
            else if(c==3)
            {
                fname="C:\\Users\\sarth\\Desktop\\Unguided Project\\unguided_39\\unguided_39\\txt_files\\nonproductive_nonessential_"+up+".txt";
                BufferedReader in=new BufferedReader(new FileReader(fname));
                clrscr();
                System.out.println("\nFILE : NON-PRODUCTIVE AND NON-ESSENTIAL TASKS");
                System.out.println("______________________________________________");
                System.out.println("\nTHE FILE CONTENTS ARE ON THE SCREEN:");
                
                while((str=in.readLine())!=null)
                {
                    String task=str.split(" ")[0];
                    String hrs = str.split(" ")[1];
                    String mins=str.split(" ")[2];
                    System.out.println(task+" -> "+hrs+" hours "+mins+" minutes");
                }
                System.in.read();
                clrscr();
            }
            else
            {
                System.out.println("\nSORRY! WRONG FILENAME...");
                System.in.read();
                clrscr();
                System.exit(0);
            }
        }
        catch(IOException e)
        {
            System.out.println("Exception occured"+ e);
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
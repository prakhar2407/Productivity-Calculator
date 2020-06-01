package calculator;

import java.io.*;
import java.util.Scanner;

public class calculator
{
    public static void calculate(String up) //throws FileNotFoundException 
    {
        try
        {
        int timeLeft,h,m;
        timeLeft=chkTime(up);
        Scanner sc = new Scanner(System.in);
        int choice;
        clrscr();                         //calling clearScreen() method
        System.out.println("\nFILES AVAILABLE");
        System.out.println("________________");
        System.out.println("1. PRODUCTIVE TASKS");
        System.out.println("2. NON-PRODUCTIVE BUT ESSENTIAL TASKS");
        System.out.println("3. NON-PRODUCTIVE AND NON-ESSENTIAL TASKS");
        System.out.println("\nEnter the file number for which the calculation is to be done: ");
        choice=sc.nextInt();

        switch (choice) 
        {
            case 1: clrscr();
                    System.out.println("\nFILE : PRODUCTIVE TASKS");
                    System.out.println("________________________");
                    calc("C:\\Users\\sarth\\Desktop\\Unguided Project\\unguided_39\\unguided_39\\txt_files\\productive_"+up+".txt");
                    break;

            case 2: clrscr();
                    System.out.println("\nFILE : NON-PRODUCTIVE BUT ESSENTIAL TASKS");
                    System.out.println("__________________________________________");
                    calc("C:\\Users\\sarth\\Desktop\\Unguided Project\\unguided_39\\unguided_39\\txt_files\\nonproductive_essential_"+up+".txt");
                    break;

            case 3: clrscr();
                    System.out.println("\nFILE : NON-PRODUCTIVE AND NON-ESSENTIAL TASKS");
                    System.out.println("______________________________________________");
                    calc("C:\\Users\\sarth\\Desktop\\Unguided Project\\unguided_39\\unguided_39\\txt_files\\nonproductive_nonessential_"+up+".txt");
                    break;
        }

        h=timeLeft/60;
        m=timeLeft%60;
        System.out.println("\nThe total time of the day left which could be used productively is "+h+" hours "+m+" minutes");
        System.in.read();
        clrscr();
        }
        catch (IOException e) 
        {
            e.printStackTrace();
        }
    }

    public static void calc(String filepath) //throws FileNotFoundException 
    {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(filepath));
            String line = reader.readLine();
            int n=0;
            int hrsum = 0;
            int minsum = 0;
            int hr[] = new int[100];
            int min[] = new int[100];
            while (line != null) 
            {
                String hrs = line.split(" ")[1];
                String mins=line.split(" ")[2];
                for (int i = n; i < 100; i++) 
                {
                    hr[i] = Integer.parseInt(hrs);
                    min[i] = Integer.parseInt(mins);
                    hrsum = hrsum + hr[i];
                    minsum = minsum + min[i];
                    break;
                }
                line = reader.readLine();
                n++;
                if(line==null)
                {
                    break;
                }
            }
            if(minsum>=60)
            {
                hrsum+=minsum/60;
                minsum=minsum%60;
            }
            System.out.println("The total time spent is "+hrsum+" hrs "+minsum+" mins.");
            reader.close();
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
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

    public static int chkTime(String up)
    {
        int t=0,m=0;
        try
        {
            String f1="C:\\Users\\sarth\\Desktop\\Unguided Project\\unguided_39\\unguided_39\\txt_files\\productive_"+up+".txt";
            String f2="C:\\Users\\sarth\\Desktop\\Unguided Project\\unguided_39\\unguided_39\\txt_files\\nonproductive_essential_"+up+".txt";
            String f3="C:\\Users\\sarth\\Desktop\\Unguided Project\\unguided_39\\unguided_39\\txt_files\\nonproductive_nonessential_"+up+".txt";
            BufferedReader r1 = new BufferedReader(new FileReader(f1));
            BufferedReader r2 = new BufferedReader(new FileReader(f2));
            BufferedReader r3 = new BufferedReader(new FileReader(f3));
            int n;
            int hrsum = 0;
            int minsum = 0;
            int hr[] = new int[100];
            int min[] = new int[100];
            String line;
            n=0;
            line = r1.readLine();
            while (line != null) 
            {
                String hrs = line.split(" ")[1];
                String mins=line.split(" ")[2];
                for (int i = n; i < 100; i++) 
                {
                    hr[i] = Integer.parseInt(hrs);
                    min[i] = Integer.parseInt(mins);
                    hrsum = hrsum + hr[i];
                    minsum = minsum + min[i];
                    break;
                }
                line = r1.readLine();
                n++;
                if(line==null)
                {
                    break;
                }
            }
            n=0;
            line = r2.readLine();
            while (line != null) 
            {
                String hrs = line.split(" ")[1];
                String mins=line.split(" ")[2];
                for (int i = n; i < 100; i++) 
                {
                    hr[i] = Integer.parseInt(hrs);
                    min[i] = Integer.parseInt(mins);
                    hrsum = hrsum + hr[i];
                    minsum = minsum + min[i];
                    break;
                }
                line = r2.readLine();
                n++;
                if(line==null)
                {
                    break;
                }
            }
            n=0;
            line = r3.readLine();
            while (line != null) 
            {
                String hrs = line.split(" ")[1];
                String mins=line.split(" ")[2];
                for (int i = n; i < 100; i++) 
                {
                    hr[i] = Integer.parseInt(hrs);
                    min[i] = Integer.parseInt(mins);
                    hrsum = hrsum + hr[i];
                    minsum = minsum + min[i];
                    break;
                }
                line = r3.readLine();
                n++;
                if(line==null)
                {
                    break;
                }
            }
            m=(hrsum*60)+minsum;
            if(m>1440)
            {
                clrscr();
                System.out.println("SORRY!!! THE TIME ACCORDING TO YOUR ROUTINE ENTERED EXCEEDS THE TIME LIMIT OF 24 HOURS A DAY.");
                System.out.println("\nPRESS ANY KEY TO EXIT...");
                System.in.read();
                clrscr();
                System.exit(0);
            }
            System.in.read();
        t=1440-m;
        return t;
        }
        catch (IOException e) 
        {
            e.printStackTrace();
        }
        return 0;
    }
}

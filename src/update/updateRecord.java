package update;

import java.util.Scanner;
import java.io.*;

public class updateRecord        //to modify the existing records in the task list
{
    public static void update(String up)
    {
        try
        {
            int c;
            String task,str,fname,hrs,mins,t;
            BufferedReader in=null;
            Scanner sc=new Scanner(System.in);
            clrscr();                      //calling clearScreen() method
            System.out.println("\nFILES AVAILABLE");
            System.out.println("________________");
            System.out.println("1. PRODUCTIVE TASKS");
            System.out.println("2. NON-PRODUCTIVE BUT ESSENTIAL TASKS");
            System.out.println("3. NON-PRODUCTIVE AND NON-ESSENTIAL TASKS");
            System.out.println("\nEnter the file number which is to be modified:");
            c=sc.nextInt();

            switch(c)
            {
                case 1: fname="C:\\Users\\sarth\\Desktop\\Unguided Project\\unguided_39\\unguided_39\\txt_files\\productive_"+up+".txt";
                        in=new BufferedReader(new FileReader(fname));
                       clrscr(); 
                        System.out.println("\nFILE : PRODUCTIVE TASKS");
                        System.out.println("________________________");
                        System.out.println("\nTHE FILE CONTENTS ARE ON THE SCREEN:");
                    
                        while((str=in.readLine())!=null)        //reading the file contents line by line
                        {
                            task=str.split(" ")[0];
                            hrs = str.split(" ")[1];
                            mins=str.split(" ")[2];
                            System.out.println(task+" -> "+hrs+" hours "+mins+" minutes");
                        }
                        System.out.println("\nEnter the task name for which the record is to be updated:");
                        t=sc.next();

                        modifyRecord(c,t,up);  //calling modifyRecord() method to search for the record to be updated and execute the updation
                        break;
   
                case 2: fname="C:\\Users\\sarth\\Desktop\\Unguided Project\\unguided_39\\unguided_39\\txt_files\\nonproductive_essential_"+up+".txt";
                        in=new BufferedReader(new FileReader(fname));
                       clrscr(); 
                        System.out.println("\nFILE : NON-PRODUCTIVE BUT ESSENTIAL TASKS");
                        System.out.println("__________________________________________");
                        System.out.println("\nTHE FILE CONTENTS ARE ON THE SCREEN:");
                   
                        while((str=in.readLine())!=null)
                        {
                            task=str.split(" ")[0];
                            hrs = str.split(" ")[1];
                            mins=str.split(" ")[2];
                            System.out.println(task+" -> "+hrs+" hours "+mins+" minutes"); 
                        }
                        System.out.println("\nEnter the task name for which the record is to be updated:");
                        t=sc.next();
 
                        modifyRecord(c,t,up);
                        break;
                    
                case 3: fname="C:\\Users\\sarth\\Desktop\\Unguided Project\\unguided_39\\unguided_39\\txt_files\\nonproductive_nonessential_"+up+".txt";
                        in=new BufferedReader(new FileReader(fname));
                        clrscr(); 
                        System.out.println("\nFILE : NON-PRODUCTIVE AND NON-ESSENTIAL TASKS");
                        System.out.println("______________________________________________");
                        System.out.println("\nTHE FILE CONTENTS ARE ON THE SCREEN:");
                  
                        while((str=in.readLine())!=null)
                        {
                            task=str.split(" ")[0];
                            hrs = str.split(" ")[1];
                            mins=str.split(" ")[2];
                            System.out.println(task+" -> "+hrs+" hours "+mins+" minutes"); 
                        }
                        System.out.println("\nEnter the task name for which the record is to be updated:");
                        t=sc.next();

                        modifyRecord(c,t,up);
                        break; 

                default: System.out.println("\nSORRY!!! WRONG FILENAME...");
                         System.in.read();     //used to hold the screen
                         clrscr(); 
                         System.exit(0);                        
            }
        }
        catch(IOException e)
        {
            System.out.println("Exception occured"+ e); 
        }
       clrscr(); 
    }

    public static void modifyRecord(int c, String t, String up)
    {
       Scanner sc=new Scanner(System.in); 
       int flag=0,l;
       String p;
        Inner:
        try
        {
            String fname,tsk,h,m;
            if(c==1)
            {
                fname="C:\\Users\\sarth\\Desktop\\Unguided Project\\unguided_39\\unguided_39\\txt_files\\productive_"+up+".txt";
                File tempFile=new File("temp.txt");
                File oldFile = new File(fname);
                String line,record;
        
                FileWriter fw = new FileWriter(tempFile, true);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter pw = new PrintWriter(bw);
                FileReader fr = new FileReader(fname);
                BufferedReader br = new BufferedReader(fr);

                while((line = br.readLine()) != null)       //reading the file line by line
                {
                    record=line.split(" ")[0];
                    if(t.equalsIgnoreCase(record))     //line matches the record to be updated
                    {
                        flag=1;
                        clrscr();
                        System.out.println("\nMODIFY RECORD");
                        System.out.println("______________");
		                System.out.println("Enter the new task name:");
		                tsk=sc.next();
		                System.out.println("Enter the time(in hours and minutes):");
		                System.out.print("Hours-");
		                h=sc.next();
		                System.out.print("Minutes-");
		                m=sc.next();
                        bw.write(tsk+" "+h+" "+m+" ");
                        bw.newLine();
                    }
                    else        //line does not match the record to be deleted
                    {
                        pw.println(line);      //writing line by line into the temp file using PrintWriter
                    }
                }
                
                pw.flush();
                pw.close();
                fr.close();
                br.close();
                bw.close();
                fw.close();

                oldFile.delete();      //deleting the old file
                tempFile.renameTo(oldFile);     //renaming the temp file with the name of the old file

                if(flag==1)    //if record is found
                {
                    System.out.println("\nTHE RECORD HAS BEEN UPDATED SUCCESSFULLY!!!");
                    System.in.read();
                }
                else
                {
                    System.out.println("\nSORRY! THE RECORD ENTERED DOES NOT EXIST...");
                    System.in.read();
                }
            }

            else if(c==2)
            {
                fname="C:\\Users\\sarth\\Desktop\\Unguided Project\\unguided_39\\unguided_39\\txt_files\\nonproductive_essential_"+up+".txt";
                File tempFile=new File("temp.txt");
                File oldFile = new File(fname);
                String line,record;
        
                FileWriter fw = new FileWriter(tempFile, true);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter pw = new PrintWriter(bw);
                FileReader fr = new FileReader(fname);
                BufferedReader br = new BufferedReader(fr);

                while((line = br.readLine()) != null)       //reading the file line by line
                {
                    record=line.split(" ")[0];
                    if(t.equalsIgnoreCase(record))     //line matches the record to be updated
                    {
                        flag=1;
                        clrscr(); 
                        System.out.println("\nMODIFY RECORD");
                        System.out.println("______________");
                        System.out.println("Enter the new task name:");
                        tsk=sc.next();
                        System.out.println("Enter the time(in hours and minutes):");
                        System.out.print("Hours-");
                        h=sc.next();
                        System.out.print("Minutes-");
                        m=sc.next();
                        bw.write(tsk+" "+h+" "+m+" ");
                        bw.newLine();
                    }
                    else        //line does not match the record to be deleted
                    {
                        pw.println(line);      //writing line by line into the temp file using PrintWriter
                    }
                }

                pw.flush();
                pw.close();
                fr.close();
                br.close();
                bw.close();
                fw.close();

                oldFile.delete();
                tempFile.renameTo(oldFile);

                if(flag==1)
                {
                    System.out.println("\nTHE RECORD HAS BEEN UPDATED SUCCESSFULLY!!!");
                    System.in.read();
                }
                else
                {
                    System.out.println("\nSORRY! THE RECORD ENTERED DOES NOT EXIST...");
                    System.in.read();
                }
            }

            else if(c==3)
            {
                fname="C:\\Users\\sarth\\Desktop\\Unguided Project\\unguided_39\\unguided_39\\txt_files\\nonproductive_nonessential_"+up+".txt";
                File tempFile=new File("temp.txt");
                File oldFile = new File(fname);
                String line,record;
        
                FileWriter fw = new FileWriter(tempFile, true);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter pw = new PrintWriter(bw);
                FileReader fr = new FileReader(fname);
                BufferedReader br = new BufferedReader(fr);

                while((line = br.readLine()) != null)       //reading the file line by line
                {
                    record=line.split(" ")[0];
                    if(t.equalsIgnoreCase(record))     //line matches the record to be updated
                    {
                        flag=1;
                        clrscr(); 
                        System.out.println("\nMODIFY RECORD");
                        System.out.println("______________");
                        System.out.println("Enter the new task name:");
                        tsk=sc.next();
                        System.out.println("Enter the time(in hours and minutes):");
                        System.out.print("Hours-");
                        h=sc.next();
                        System.out.print("Minutes-");
                        m=sc.next();
                        bw.write(tsk+" "+h+" "+m+" ");
                        bw.newLine();
                    }
                    else        //line does not match the record to be deleted
                    {
                        pw.println(line);      //writing line by line into the temp file using PrintWriter
                    }
                }

                pw.flush();
                pw.close();
                fr.close();
                br.close();
                bw.close();
                fw.close();

                oldFile.delete();
                tempFile.renameTo(oldFile);

                if(flag==1)
                {
                    System.out.println("\nTHE RECORD HAS BEEN UPDATED SUCCESSFULLY!!!");
                    System.in.read();
                }
                else
                {
                    System.out.println("\nSORRY! THE RECORD ENTERED DOES NOT EXIST...");
                    System.in.read();
                }
                
            }
        
        }
        catch(Exception e)
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
}
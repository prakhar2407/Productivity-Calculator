package delete;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class deleteTask{
    private static Scanner sc;
//    public static void delete1(){
//        Scanner input=new Scanner(System.in);
//
//        String filepath="C:\\Users\\sarth\\Desktop\\Calculator.txt";
//        String task_to_delete;
//        System.out.print("ENTER TASK TO DELETE:");
//        task_to_delete=input.nextLine();
//        removeRecord(filepath,task_to_delete);
//    }

    public static void removeRecord(String filepath,String removeTerm){
        String tempfile="C:\\Users\\sarth\\Desktop\\unguided_39\\unguided_39\\txt_files\\temp.txt";
        File oldFile=new File(filepath);
        File newFile=new File(tempfile);
        String task="";String hr="";String min="";

        try {
            FileWriter fw=new FileWriter("C:\\Users\\sarth\\Desktop\\unguided_39\\unguided_39\\txt_files\\temp.txt");
            BufferedWriter bw=new BufferedWriter(fw);
            PrintWriter pw=new PrintWriter(bw);
            sc=new Scanner(new File(filepath));
            sc.useDelimiter("[,\n]");

            while (sc.hasNext()){
                task=sc.next();
                hr=sc.next();
                min=sc.next();
                if(!task.equals(removeTerm)){
                    pw.println(task+ "," +hr+ ","+min);
                }
            }
            sc.close();
            pw.flush();
            pw.close();
            oldFile.delete();
            File dump=new File(filepath);
            newFile.renameTo(dump);
        }catch(Exception e){

            System.out.println("Error");

        }
    }
    public static void deleteMain(){
        Scanner scc=new Scanner(System.in);
        System.out.println("[1]PRODUCTIVE TASK");
        System.out.println("[2]NONPRODUCTIVE ESSENTIAL");
        System.out.println("[3]NONPRODUCTIVE NONESSENTIAL");
        int choice;
        System.out.print("Confirm your choice");
        choice=scc.nextInt();

        switch (choice){
            case 1:
                Scanner input=new Scanner(System.in);
                String filepath1="C:\\Users\\sarth\\Desktop\\unguided_39\\unguided_39\\txt_files\\productive.txt";
                String task_to_delete1;
                System.out.print("ENTER TASK TO DELETE:");
                task_to_delete1=input.nextLine();
                removeRecord(filepath1,task_to_delete1);
                break;

            case 2:
                Scanner sc2=new Scanner(System.in);
                String filepath2="C:\\Users\\sarth\\Desktop\\unguided_39\\unguided_39\\txt_files\\nonproductive_essestial.txt";
                String task_to_delete2;
                System.out.print("ENTER TASK TO DELETE:");
                task_to_delete2=sc2.nextLine();
                removeRecord(filepath2,task_to_delete2);
                break;

            case 3:
                Scanner sc3=new Scanner(System.in);
                String filepath3="C:\\Users\\sarth\\Desktop\\unguided_39\\unguided_39\\txt_files\\nonproductive_nonessential.txt";
                String task_to_delete3;
                System.out.print("ENTER TASK TO DELETE:");
                task_to_delete3=sc3.nextLine();
                removeRecord(filepath3,task_to_delete3);
                break;
        }

    }
}
package main;

//import Validators.*;
//import exceptions.*;
import add.*;
import delete.*;
import update.*;
import display.*;
import calculator.*;

import java.io.*;
import java.util.*;

public class main
{
    public static void main(String[] args)  
    {
        try
        {
            Scanner sc=new Scanner(System.in);

            addTask at1;                 //creating objects for all classes
            at1=new addTask();
            displayFile df1;
            df1=new displayFile();
            updateRecord ur1;
            ur1=new updateRecord();
            deleteTask dt1;
            dt1=new deleteTask();
            calculator c1;
            c1=new calculator();
            registrationAndLogin rg1;
            rg1=new registrationAndLogin();
                    
            String a,b,up;
            String Username,Password;
            
            do
            {
                clrscr();
                System.out.println("\n=================================================");
                System.out.println("********** PRODUCTIVITY CALCULATOR APP **********");
                System.out.println("=================================================");
                System.out.println("\n[1] SIGNIN");
                System.out.println("[2] SIGNUP");
                System.out.println("[3] EXIT");
                System.out.print("\nENTER YOUR CHOICE: ");

                int choice;
                choice=sc.nextInt();

                switch (choice)
                {
                    case 1: up=rg1.login();
                            clrscr();
                            System.out.println("\nLOGIN SUCCESSFUL");
                            System.out.println("=================");
                            System.out.println("\nPRESS ANY KEY AND YOU WILL BE DIRECTED TO THE FILE OPERATIONS PAGE...");
                            System.in.read();
                            clrscr();
                            
                            Outer:
                            do
                            {
                                clrscr();
                                System.out.println("\n=================================================");
                                System.out.println("**************** FILE OPERATIONS ****************");
                                System.out.println("=================================================");

                                System.out.println("\n[1] ADD RECORD");
                                System.out.println("[2] UPDATE RECORD");
                                System.out.println("[3] DELETE RECORD");
                                System.out.println("[4] DISPLAY FILE");
                                System.out.println("[5] CALCULATE");
                                System.out.println("[6] GO TO MAIN MENU");
                                System.out.println("[7] EXIT PROGRAM");
                                System.out.print("\nENTER YOUR CHOICE: ");

                                int choice2;
                                choice2=sc.nextInt();
                        
                                switch (choice2)
                                {
                                    case 1: clrscr();
                                            System.out.println("\nADD RECORD");
                                            System.out.println("===========");
                                            at1.add(up);
                                            clrscr();
                                            break ;

                                    case 2: clrscr();
                                            System.out.println("\nUPDATE RECORD");
                                            System.out.println("==============");
                                            ur1.update(up);
                                            clrscr();
                                            break ;

                                    case 3: clrscr();
                                            System.out.println("\nDELETE RECORD");
                                            System.out.println("==============");
                                            dt1.deleteMain(up);
                                            clrscr();
                                            break ;

                                    case 4: clrscr();
                                            System.out.println("\nDISPLAY FILES");
                                            System.out.println("==============");
                                            df1.display(up);
                                            clrscr();
                                            break ;

                                    case 5: clrscr();
                                            System.out.println("\nCALCULATOR");
                                            System.out.println("===========");
                                            c1.calculate(up);
                                            clrscr();
                                            break ;

                                    case 6: clrscr();
                                            break Outer; 

                                    case 7: clrscr();
                                            System.out.println("PRESS ANY KEY TO EXIT...");
                                            System.in.read();
                                            clrscr();
                                            System.exit(0);

                                    default: clrscr();
                                             System.out.println("\nINVALID CHOICE");
                                             System.out.println("===============");
                                             break;           
                                }
                           
                                System.out.println("DO YOU WANT TO CONTINUE WITH FILE OPERATIONS?? y/n");
                                b = sc.next();
                                clrscr();
          
                            } while( b.equalsIgnoreCase("y") );
                            //end of do-while loop for file operations
                            break;
                    
                    case 2: clrscr();
                            System.out.println("\n=================================================");
                            System.out.println("************** REGISTRATION PORTAL **************");
                            System.out.println("=================================================");
                            System.out.println("\nWELCOME TO OUR REGISTRATION PORTAL");
                            String user,pass;
                            System.out.println("\nEnter Username:");
                            user=sc.next();
                            System.out.println("\nEnter Password:");
                            pass=sc.next();
                            rg1.register(user,pass);
                           clrscr();
                            break;

                    case 3: clrscr();
                            System.out.println("PRESS ANY KEY TO EXIT...");
                            System.in.read();
                            clrscr();
                            System.exit(0);

                    default: System.out.println("\nINVALID CHOICE");
                             System.out.println("===============");
                             break;
                }

                System.out.println("DO YOU WANT TO CONTINUE WITH MAIN MENU?? y/n");
                a = sc.next();
               clrscr();
          
            } while( a.equalsIgnoreCase("y") );
            //end of do-while loop for main menu
                
        }
        catch (IOException ioe) 
        {
            ioe.printStackTrace();
        }
    }//end of main

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
}//end of class main

//code for password masking starts                
class PasswordField 
{
    public static String readPassword (String prompt)      //method called from login->input password
    {
        int c;
        EraserThread et = new EraserThread(prompt);
        Thread mask = new Thread(et);
        mask.start();
                  
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String password = "";

        try 
        {
            password = in.readLine();
        } 
        catch (IOException ioe) 
        {
            ioe.printStackTrace();
        }

        et.stopMasking();
        return password;
    }
}   
class EraserThread implements Runnable 
{
    private boolean stop;
    int c;
    public EraserThread(String prompt) 
    {
        System.out.print(prompt);
    }

    public void run () 
    {
        while (!stop)
        {
            System.out.print("\010*");
            try 
            {
                Thread.currentThread().sleep(0);     //used to pause the execution of current thread
            } 
            catch(InterruptedException ie) 
            {
                ie.printStackTrace();
            }
        }
    }

    public void stopMasking() 
    {
        this.stop = true;
    }
}
//code for password masking ends

class registrationAndLogin 
{
    Scanner sc=new Scanner(System.in);

    private String username = null;
    private String password = null;
    private String ID = null;
    private Properties prop = null;

    File file = new File("C:\\Users\\sarth\\Desktop\\Unguided Project\\unguided_39\\unguided_39\\properties\\Username_Password.properties");

    public String login() 
    {
        int i;
        String id,p;
        String up;

        FileReader inputStream = null;
        
        try 
        {
            for(i=1;i<=3;i++)
            {
                clrscr();
                System.out.println("\n================================================");
                System.out.println("***************** LOGIN PORTAL *****************");
                System.out.println("================================================");
                
                System.out.println("\nEnter Username:");
                id=sc.next();
                
                p=PasswordField.readPassword("Enter the password\n");     //calling readPassword() method for password masking
                up=id +"_"+ p;

                if (!(file.exists()))
                    file.createNewFile();

                inputStream = new FileReader(file);
                prop = new Properties();
                prop.load(inputStream);    //reading a java properties file using inputStream
                            
                if (prop.getProperty(id).split(",")[0].equals(p)) 
                {
                    username = id;
                    password=p;
                    ID = prop.getProperty(id).split(",")[1];
                    return up;
                } 
                else
                {
                    if(i<3)
                    {
                        int ch;
                       clrscr();
                        System.out.println("\nINVALID LOGIN!!!");
                        System.out.println("=================");
                        System.out.println("Options:");
                        System.out.println("1)Login again");
                        System.out.println("2)Exit");
                        ch=sc.nextInt();
                        switch(ch)
                        {
                            case 1:continue;
                            case 2:System.exit(0);
                        }
                    }

                    else
                    {
                       clrscr();
                        System.out.println("\nINVALID LOGIN!!!");
                        System.in.read();
                        System.exit(0);
                    }
                }
                if(i==3)
                    System.exit(0);
            }
        }        
        catch (IOException e) 
        {
            System.out.println(e);
        } 
        catch (NullPointerException e) 
        {
                        System.out.print("Invalid Username!!!");
        }
        return null;
    }//end of login  
                
    public String getID() 
    {
        return ID;
    }

    public String getUsername() 
    {
        return username;
    }

    public boolean register(String user, String pass) //throws wrongUsernameException, wrongPasswordException
    {
                    /*if (registrationValidators.checkUsername(Username))
                        return false;
                    if (!(registrationValidators.checkPassword(Password)))
                        return false;
                    */    
        username = user;
        password = pass;
                    
        try 
        {
            prop=new Properties();
            FileReader in=new FileReader(file);
            prop.load(in);
            in.close();
            FileWriter out=new FileWriter(file);

            prop.setProperty(username,password+","+"PC");

            prop.store(out,null);       //method writes to the property list
            out.close();
        } 
        catch (IOException e) 
        {
            System.out.println(e);
        }

        try
        {
            prop=new Properties();
            clrscr();
            System.out.println("\nSUCCESSFULLY REGISTERED!!!");
            System.in.read();
        }
        catch (IOException e) 
        {
            System.out.println(e);
        }
        
        return true;    //successfully registered
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
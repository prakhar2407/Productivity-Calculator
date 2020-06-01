package validators;

import exceptions.*;
import java.io.*;
import java.util.*;

public class registrationValidators 
{
        public static void isFileMissing() 
        {
            File f1=new File("C:/Users/hp/Desktop/copy/copy/properties/Username_Password.properties");

        }
        public static boolean checkUsername(String Username) throws wrongUsernameException 
        {
            try 
            {
                FileReader in=new FileReader("C:\\Users\\sarth\\Desktop\\Unguided Project\\unguided_39\\unguided_39\\properties\\Username_Password.properties");
                Properties prop=new Properties();
                //FileInputStream input= new FileInputStream("C:/Users/hp/Desktop/copy/copy/properties/exceptions.properties");
                prop.load(in);
                if(prop.getProperty(Username).equals(null))
                {
                    in.close();
                    throw new wrongUsernameException("A User with the same Name exists!!!\n>>Try another name.");
                }
            }
            catch (IOException e) 
            {
                System.out.println(e);
            }
            catch(NullPointerException e)
            {
                return false;
            } 
            catch (wrongUsernameException e) 
            {
                System.out.println(e);
                return true;
            }

            return true;
        }

        public static boolean checkPassword(String pass) throws wrongPasswordException 
        {
            try 
            {
                Properties prop=new Properties();
                if(pass.length()>6)
                    throw new wrongPasswordException("Password length greater than 6");

                if(pass.contains(" "))
                    throw new wrongPasswordException("It Should not have Spaces");

            }
            catch(wrongPasswordException e) 
            {
                System.out.println(e);
                return false;
            }
            return true;
        }
    }


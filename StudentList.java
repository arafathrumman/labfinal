import java.io.*;
import java.text.*;
import java.util.*;
import ase.Constants.*;
public class StudentList {
    public static void main(String[] args) {
        //early guard during argument pass
        //        Check arguments
        if(args.length != 1)
        {
            System.out.println("Usage: java StudentList a|r|c|?student1|+word");
        }
//        Check arguments
        if(args[0].equals(ShowAll))
        {
            System.out.println(Loading data ...);            
            try
            {
                BufferedReader studentlistall = new BufferedReader(
                new InputStreamReader(
                new FileInputStream(DataFile)));
                String alllines = studentlistall.readLine();
                String words[] = alllines.split(",");
                for(String word : words)
                {
                    System.out.println(word);
                }
            }
            catch (Exception e)
            {}
            System.out.println(EndDialog);
        }
        else if(args[0].equals(ShowRandow))
        {
            System.out.println(Loading data ...);            
            try
            {
                BufferedReader studentlistall = new BufferedReader(
                new InputStreamReader(
                new FileInputStream(DataFile)));
                String alllines = studentlistall.readLine();
                //System.out.println(r);
                String words[] = alllines.split(",");
                Random x = new Random();
                int y = x.nextInt(1);
                System.out.println(words[y]);
            }
            catch (Exception e)
            {}
            System.out.println(EndDialog);            
        }
        else if(args[0].contains(addWord)){
            System.out.println(Loading data ...);            
            try
            {
                BufferedWriter studentlistall = new BufferedWriter(
                new FileWriter(DataFile, true));
                String individualstring = args[0].substring(1);
                Date datenow = new Date();
                String df = DateFormat;
                DateFormat dateFormat = new SimpleDateFormat(df);
                String fd= dateFormat.format(datenow);
                studentlistall.write(", "+individualstring+"\nList last updated on "+fd);
                studentlistall.close();
            }
            catch (Exception e)
            {}
            System.out.println(EndDialog);    
        }
        else if(args[0].contains(query))
        {
            System.out.println(Loading data ...);            
            try
            {
                BufferedReader studentlistall = new BufferedReader(
                new InputStreamReader(
                new FileInputStream(DataFile)));
                String alllines = studentlistall.readLine();
                String words[] = alllines.split(",");
                boolean done = false;
                String individaulstring = args[0].substring(1);
                for(int indexlocation = 0; indexlocation<words.length && !done; indexlocation++)
                {
                if(words[indexlocation].equals(individaulstring)) {
                System.out.println("Success");
                done=true;
                }
            }
            }
            catch (Exception e)
            {}
            System.out.println(EndDialog);                
        }
        else if(args[0].contains(count))
        {
            System.out.println(Loading data ...);            
            try
            {
                BufferedReader studentlistall = new BufferedReader(
                new InputStreamReader(
                new FileInputStream(DataFile)));
                String readlines = studentlistall.readLine();
                char charactararray[] = readlines.toCharArray();
                boolean in_word = false;
                int count=0;
                for(char eachcharactar:charactararray)
                {
                if(eachcharactar ==' ')
                {
                if (!in_word) {    count++; in_word =true;    }
                else
                    {
                        in_word=false;
                    }
                }
            }
            System.out.println(count +" word(s) found " + charactararray.length);
            }
            catch (Exception e)
            {}
            System.out.println(EndDialog);                
        }
    }
}



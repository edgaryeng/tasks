
package task4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;



public class Task4 {

 
    public static void main(String[] args) throws IOException, FileNotFoundException, ParseException {
        File file = new File(args[0]);
        
       String l = "";
      int size = 0;
      //defines the length of forcoming arrays
        BufferedReader reader = new BufferedReader(new FileReader(file)); 
          while((l = reader.readLine())!= null){
              size++;
          }
          
        String line = "";
        
      //creating 2 arrays for begginings and endings for each interval
      float [] begin = new float [size];
      float [] end = new float [size];
      String [] intervals = new String[size];
                
      
      int index= 0;
      BufferedReader br = new BufferedReader(new FileReader(file));
          while((line = br.readLine())!= null){
                                                    
              String s = line.substring(0, (line.length()-2));
              intervals[index] = s;
             
              s = s.replace(":", ".");
         
              String [] t = s.split(" ");
                                            
              begin[index] = Float.parseFloat(t[0].trim());
              end[index] = Float.parseFloat(t[1].trim());
               index++;
         }
          
          int [] cusNum = new int [begin.length]; // array with counts of customers in each interval 
          int ind = 0;
          for (int i = 0; i < begin.length; i++) {
            int t = customerCount(begin, end, i);
            cusNum[ind] = t;
            ind++;
        }
          int maxValue = 0;
          int maxIndex = 0; 
         for (int i = 0; i < cusNum.length; i++) {// finding the index with maximum count of customers
            if(cusNum[i] > maxValue){
            maxValue = cusNum[1];
            maxIndex = i;
            }
             
        }
         System.out.println(intervals[maxIndex]);
      }
    // gets two arrays and indext for creatin a test interval array 
    //retuns the count of customers being in the bank at the given interval
    public static int customerCount(float [] begin, float [] end,  int ind){
    int count = 0;
    float [] test = {(begin[ind]),(end[ind])};
        for (int i = 0; i < test.length; i++) {
            for (int j = 0; j < begin.length; j++) {
                for (int k = 0; k < end.length; k++) {
                                       
                    if((test[i] <= begin[j]) && (test[i] <= end[k]))
                        count++;
                     }
                  }
            }
      return count;
    }
}



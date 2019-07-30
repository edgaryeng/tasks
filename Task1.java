
package task1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Arrays;



public class Task1 {

  
    public static void main(String[] args) throws FileNotFoundException, IOException {
        if (args.length == 0) {
            System.out.println("no arguments were given.");
        }
        
       String filePath = args[0];
       int linesCount = 0;
        int index = 0;
     
           BufferedReader br = new BufferedReader(new FileReader(filePath));
           String line= "";
              try{
                  while(br.readLine()!=null)
                      linesCount++;
                 
              }catch(Exception ex){
                  ex.printStackTrace();
              }     
              
           BufferedReader in  = new BufferedReader(new FileReader(filePath));
           short [] arr = new short [linesCount];  
           while((line = in.readLine())!=null)
           arr[index++] = Short.parseShort(line);
             
                                  
     
        
        DecimalFormat df = new DecimalFormat("###.00");
        
        double median = median(arr);
        double persentile = percentile(arr, 90);
        double minValue = minValue(arr);
        double avg = avg(arr);
        
        System.out.println(df.format(persentile));
        System.out.println(df.format(median));
        System.out.println(df.format(maxValue(arr)));
        System.out.println(df.format(minValue));
        System.out.println(df.format(avg));
     
    }
         
   public static double percentile(short [] values, double percentile) {
       Arrays.sort(values);
       int index = (int) Math.ceil((percentile / 100) * values.length); 
    return values[index - 1]; 
   }
   
   public static double median(short [] values){
       int middle = values.length/2;
       int medianValue = 0;  
        if (values.length%2 != 0) 
    medianValue = values[middle];
        else{
  medianValue = values[((values.length-1)/2)+1];
        }
        return medianValue;
   }
   
   public static double maxValue(short [] values){
   double maxValue = values[0];
       for (int i = 0; i < values.length; i++) {
           if(values[i]>maxValue){
               maxValue = values[i];
           }
       }
   
   return maxValue;
   }
   public static double minValue(short [] values){
   double minValue = values[0];
       for (int i = 0; i < values.length; i++) {
           if(values[i]< minValue){
           minValue = values[i];
           }
       }
   return minValue;
   }
   
   public static double avg(short [] values){
   double avg = 0;
   double sum = 0;
       for (int i = 0; i < values.length; i++) {
           sum =sum+values[i];
           }
       avg = sum/values.length;
       return avg;
   }
}


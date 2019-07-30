package task3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;



public class Task3 {

       public static void main(String[] args) throws IOException {
                          
           File file1 = new File(args[0]); //passing files as arguments
           File file2 = new File(args[1]);
           File file3 = new File(args[2]);
           File file4 = new File(args[3]);
           File file5 = new File(args[4]);
           
           float [][] arr = new float [5][16]; 
                   
         arr[0] = readFile(file1);

         arr[1] = readFile(file2);
         arr[2] = readFile(file3);
         arr[3] = readFile(file4);
         arr[4] = readFile(file5);
         
                 
          float [] res = columnSum(arr); 
          
          float maxValue = res[0]; // the max value and it's index
          int maxIndex = 0;
           for (int i = 0; i < res.length; i++) {
               if(res[i] > maxValue){
               maxValue = res[i];
               maxIndex = i+1;
               }
           }
                    
          
           System.out.println(maxIndex);
                
       }
       
     //sum the columnes of 2D array
       public static float[] columnSum(float [][] array){ 

    int size = array[0].length; 
    float temp[] = new float[size];

    for (int i = 0; i < array.length; i++){
        for (int j = 0; j < array[i].length; j++){
            temp[j] += array[i][j]; 
        }
    }

   
    return temp; 
}
       //reads file and puts values into a new array
  public static float [] readFile(File file) throws FileNotFoundException, IOException{ 
      String line = "";
      float [] arr = new float [16];
      int index= 0;
      BufferedReader br = new BufferedReader(new FileReader(file));
          while((line = br.readLine())!= null){
              
              String s = line.substring(0, (line.length()-2));
              String [] temp = s.split(" ");
                            
                  arr[index++] = Float.parseFloat(temp[0].trim());
                }
      return arr;
  }
}
    



package task2;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;




public class Task2 {

  
    public static void main(String[] args) throws FileNotFoundException, IOException {
          if (args.length == 0) {
            System.out.println("no arguments were given.");
        }
          String fileVert = args[0];
          String filePoints = args[1];
          
          String line;
          int lineCount=0;
          List<Float> vertXCo = new ArrayList<>();
          List<Float> vertYCo = new ArrayList<>();
         
          
          BufferedReader br = new BufferedReader(new FileReader(fileVert));
          while((line = br.readLine())!= null){
              lineCount++;
              String s = line.substring(0, (line.length()-2));
              String [] temp = s.split(" ");
             
                         
          float x = Float.parseFloat(temp [0].trim());
          float y = Float.parseFloat(temp [1].trim());
          vertXCo.add(x);
          vertYCo.add(y);
          }
          
         // Points point = new Points();
      
          String str;
          List<Float> pointX = new ArrayList<>();
          List<Float> pointY = new ArrayList<>();
          
          BufferedReader reader = new BufferedReader(new FileReader(filePoints));
          while((str=reader.readLine())!= null){
          String str2 = str.substring(0, (str.length()-2));
          String [] t = str2.split(" ");
          System.out.println("tis " + Arrays.toString(t));
                              
         float px = (Float.parseFloat(t[0].trim()));
         float py = (Float.parseFloat(t[1].trim()));
         pointX.add(px);
         pointY.add(py);
          
             
             
              
          }
      
        System.out.println("xCoord" + vertXCo);
        System.out.println("pointX" + pointX);
       
    }
   public static boolean compare(int nvert, float [] vertx, float [] verty, float testx, float testy){
          int i, j; 
          boolean isIn = false;
  for (i = 0, j = nvert-1; i < nvert; j = i++) {
    if ( ((verty[i]>testy) != (verty[j]>testy)) &&
     (testx < (vertx[j]-vertx[i]) * (testy-verty[i]) / (verty[j]-verty[i]) + vertx[i]) )
       isIn = false;
  }
  return isIn;
}
        }
                        
          
                  
    
                   
               
        
    

       


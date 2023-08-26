import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FourWilliams{
  public static byte[] getFileBytes(String path){
    byte[] bytes = null;
    try{
      bytes = Files.readAllBytes(Paths.get(path));
    } catch(IOException e){
      e.printStackTrace();
    }
    return bytes;
  }

  public static void main(String[] args){
    double startTime = System.nanoTime();
    byte[] bytes = getFileBytes("half_gaps.bin");
    long[] gaps = new long[bytes.length];
    for(int i = 0; i < bytes.length; i++){
      gaps[i] = Byte.toUnsignedLong(bytes[i]);
    }
    long cumsum = 0;
    for(int i = 0; i < bytes.length; i++){
      cumsum = (2 * gaps[i] + 3) + cumsum;
    }
    long newNumber = cumsum;
    double duration = System.nanoTime() - startTime;
    duration = duration / 1000;

    //print duration
    System.out.println("Time taken: " + duration + " in seconds.");
    // first 15 elements
    System.out.println("First 15:");
    for (int i = 0; i < 15; i++) {
      System.out.print(gaps[i] + " ");
    }
    System.out.println();

    // last 5 elements
    System.out.println("Last 5:");
    for (int i = gaps.length - 5; i < gaps.length; i++) {
      System.out.print(gaps[i] + " ");
    }
  }  
}

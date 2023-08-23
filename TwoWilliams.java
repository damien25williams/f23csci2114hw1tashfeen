public class TwoWilliams{
  public class TwoTashfeen{
  public static void main(String[] args){
    //check for argument
    if(args.length < 1){
      System.out.println("Need an argument!");
      return;
    }
    // given string number converted to an int
    int n = Integer.parseInt(args[0]);
    
    //displays arguments
    for(int i = 0; i < args.length; i++){
      System.out.println(args[i]);
    }

    int[] fibonacciArray = new int[n];
    fibonacciArray[0] = 0;
    int maxNumberWidth = 0;
    if (n > 1){
      fibonacciArray[1] = 1;
      for(int i = 2; i < n; i++){
        fibonacciArray[i] = fibonacciArray[i - 1] + fibonacciArray[i - 2];
      }
    }
     for (int i = 0; i < n; i++) {
      int currentWidth = String.valueOf(fibonacciArray[i]).length();
      if (currentWidth > maxNumberWidth) {
        maxNumberWidth = currentWidth;
      }
    }

    int NumbersInRow = 7;
    for (int i = 0; i < n; i++) {
      String formattedNumber = String.format("%" + maxNumberWidth + "d", fibonacciArray[i]);
      System.out.print(formattedNumber + " ");
      if ((i + 1) % NumbersInRow == 0) {
        System.out.println();
      }
    }  
 }
}

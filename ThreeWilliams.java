public class ThreeWilliams{
  public static boolean[] eratosthenes(int n) {
    
    boolean[] prime = new boolean[n + 1];
    for (int i = 2; i < n; i++){
      prime[i] = true;
    }
    for(int i = 2; i * i <= n; i++){
      if(prime[i]){
        for(int j = i*i; j < n; j+=i){
          prime[j] = false;
        }
      }
    }
    return prime;
  }
  public static void main(String[] args){
    int n = Integer.parseInt(args[0]);
    double startTime = System.nanoTime();
    boolean[] prime = eratosthenes(n);
    for(int i = 0; i < prime.length; i++){
      if(prime[i]){
        System.out.println(i);
      }    
    }
    double duration = System.nanoTime() - startTime;
    duration = duration / (60 * Math.pow(10,9));

    int[] newPrimes = new int[prime.length];
    int count = 0;
    for (int i = 2; i <= n; i++) {
      if (prime[i]) {
        newPrimes[count++] = i;
      }
    }
    int[] largestPrimes = new int[Math.min(5, count)];
    for (int i = 0; i < largestPrimes.length; i++) {
      largestPrimes[i] = newPrimes[count - 1 - i];
    }
    

    System.out.println("Largest prime numbers: ");
    for (int finalPrime : largestPrimes) {
      System.out.println(finalPrime);
    }
    System.out.println();
    System.out.println("Time taken: " + duration + " minutes");
  }
}
  

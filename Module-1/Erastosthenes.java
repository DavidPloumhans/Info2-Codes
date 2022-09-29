import java.util.BitSet;

public class Erastosthenes {
    public static BitSet bits; //You should work on this BitSet

    public static int numberOfPrime(int n){
        // I ll use cardinality ro return the number of bits set to true
        n++;  // to have the right size when initializing bits
        bits = new BitSet(n);
        // let's set all bits to true
        bits.set(0, n-1, true);
        // System.out.println("length : " + bits.length());
        // System.out.println(bits.get(0));
        // let's use the sieve of Eratosthenes and set all of aderent bits to False, then I'll use cardinality to get the number of prime numbers
        // System.out.println(bits.length());
        boolean isTrue = true;
        int p = 2;
        int index = 2;
        while (p < n/2) {
            // multiples of p
            while (index * p < n) {
                // System.out.println("values set to false :" + (index * p-1));
                bits.set(index * p-1, false);
                index ++;
            }
            // let's reinitialize the index and look for the next p
            index = 2;
            boolean isTrue2 = true;
            while (p <= n & isTrue2) {
                p++;
                if (bits.get(p - 1)) {
                    // System.out.println("p : "+ p);
                    isTrue2 = false;
                }
            }

        }

        return bits.cardinality() - 1; // minus 1 if you don't count '1' as a prime number
    }

    public static void main(String[] args) {
        int j = numberOfPrime(100);
        System.out.println(j);
    }
}
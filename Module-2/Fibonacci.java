public class Fibonacci {


    public static int fiboRecursive(int index){
        if (index == 0) {
            return 0;
        }
        else if(index == 1) {
            return 1;
        }
        return fiboRecursive(index-1) + fiboRecursive(index-2);
    }


    public static int fiboIterative(int index){
        int n = 2;
        int fn = 0;
        if (index == 0) {
            return fn;
        }
        else if(index == 1) {
            return fn=1;
        }
        int fn_2 = 0;
        int fn_1 = 1;

        while (n<=index) {
            fn = fn_1 + fn_2;
            fn_2 = fn_1;
            fn_1 = fn;
            n++;
        }
        return fn;

    }

    public static void main(String[] args) {
        System.out.println("\n" + fiboRecursive(20));
        System.out.println("\n" + fiboIterative(20));
    }

}

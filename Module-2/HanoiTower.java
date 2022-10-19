import java.util.Stack;

public class HanoiTower {
    /**
     * Solve the Tower of Hanoi puzzle
     *
     * @param n The number of disks to move
     * @param a The tower from which we want to move the disks
     * @param b An intermediate tower
     * @param c The tower to which we want to move the disks
     */
    public static int[] moves = new int[]{0};
    public static void towerOfHanoi(int n, Stack<Disk> a, Stack<Disk> b, Stack<Disk> c) {
        if (n>0) {
            towerOfHanoi(n-1, a, c, b);
            c.add(a.pop());
            moves[0]+=1;
            towerOfHanoi(n-1, b, a, c);
        }

    }

    public static int numberOfMoves(int stackSize){
        if (stackSize == 1) {
            return 1;
        }
        else {
            return 2*numberOfMoves(stackSize-1);
        }
    }

}

public class Search {

    /**
     * @param tab is an ordered array of int.
     * @return index of elem or -1
     */
    public static int search(int[] tab, int elem) {
        //binary search
        // variables
        int start = 0;
        int end = tab.length;
        int res;
        // borders
        if (elem == tab[0]) {
            return 0;
        } else if (elem == tab[tab.length - 1]) {
            return tab.length - 1;
        }
        while (end-start > 1) { // end-start > 1 in case elem is a value non-present in tab and the search gets stuck
            res = (start + end) / 2;
            if (tab[res] < elem) {
                start = res;
            } else if (tab[res] > elem) {
                end = res;
            }
            else if (tab[res] == elem) {
                return res;
            }
        }
        return -1;
    }

    public static void main(String[] args){
        System.out.println(search(new int[]{1, 20, 30, 34, 45, 53, 56, 57, 62, 1023}, 46));
    }
}

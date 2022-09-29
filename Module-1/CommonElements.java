public class CommonElements {
    /**
     *
     * @param tab1 is a non null array
     * @param tab2 is a non null array
     * @return the number of elements that are the same at the same index
     *         more exactly the size of set {i such that tab1[i] == tab2[i]}
     *         for instance count([1,3,5,5],[1,2,5,5,6]) = 3
     */
    public static int count(int [] tab1, int [] tab2) {
        int counted = 0;
        for (int i = 0; i < tab1.length; i++) {
            try {
                if (tab1[i] == tab2[i]) {
                    counted++;  // add 1 to counted
                }
            } catch (IndexOutOfBoundsException e) {  // in case both tables don't have the same length
                return counted;
            }
        }
        return counted;
    }

    /**
     *
     * @param tab1 is a non null 2D array
     * @param tab2 is a non null 2D array
     * @return the number of elements that are the same at the same index
     *         more exactly the size of set {(i,j) such that tab1[i][j] == tab2[i][j]}
     */
    public static int count(int [][] tab1, int [][] tab2) {
        int counted = 0;
        for (int i = 0; i < tab1.length; i++) {
            for (int j = 0; j < tab1[i].length; j++) {
                try {
                    try {
                        if (tab1[i][j] == tab2[i][j]) {
                            counted ++;
                        }
                    } catch (IndexOutOfBoundsException e) {
                        j = tab1.length;  // exit current for loop to run i++ because 2nd dimension didn't match anymore
                    }
                } catch (IndexOutOfBoundsException e){ // exit current loop and return counted because 1st dimension didn't match anymore
                    return counted;
                }
            }
        }
        return counted;  // in case everything goes well => tab1 & tab2 have the same dimensions
    }
}

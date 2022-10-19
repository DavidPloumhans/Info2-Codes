public class Valley {
    /**
     * Compute the deepest valley and highest mountain
     *
     * @param slopes A non-empty array of slope
     * @return An array of two element. The first is the
     *         depth of the deepest valley and the second
     *         the height of the highest mountain
     */
    public static int[] valley (int[] slopes){
        boolean up;
        int up_count = 0;
        int down_count = 0;
        int highest_moutain = 0;
        int deepest_valley = 0;
        if (slopes[0] == 1) {
            up = true;
        } else {
            up = false;
        }

        for (int slope : slopes) {
            if (slope == 1 && up) {
                up_count += 1;
                deepest_valley = Math.max(highest_moutain, Math.min(up_count, down_count));
            } else if (slope == 1 && !up) {
                up_count = 1;
                up = true;
            } else if (slope == -1 && up) {
                down_count = 1;
                up = false;
            } else { // slope == -1 && !up
                down_count += 1;
                highest_moutain = Math.max(highest_moutain, Math.min(up_count, down_count));
            }
        }
        return new int[]{deepest_valley, highest_moutain};
    }

    public static void main(String[] args) {
        System.out.println(valley(new int[]{1, 1, 1, -1, -1, -1, -1, -1, 1, 1, 1, 1, 1, 1, -1, -1})[0]);
    }
}

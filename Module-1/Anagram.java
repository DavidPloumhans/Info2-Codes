public class Anagram {
    static char[] alphabet = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

    /**
     * Count the number of occurrences of each letter of the alphabet
     * (from 'A' to 'Z') in the given string. The function must return
     * an array containing 26 elements: The item with index 0 contains
     * the number of 'A' in the string, the item with index 1 contains
     * the number of 'B', and so on.
     *
     * This function must be case-insensitive, i.e. the character 'f'
     * must be considered as the same as character 'F'.
     *
     * Characters that are neither in the range 'a' to 'z', nor in the
     * range 'A' to 'Z' must be ignored.
     * 
     * @param s The string of interest.
     * @return An array counting the number of occurrences of each
     * letter.
     **/
    public static int[] countAlphabet(String s) {
        s = s.toLowerCase();
        int[] result = new int[26];
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < 26; j++) {
                if (s.charAt(i) == alphabet[j]) {
                    result[j]++;
                }
            }
        }
        return result;
    }


    /**
     * Check whether one string is an anagram of another string. It is
     * strongly advised to use the function "countAlphabet()" as a
     * building block for function "isAnagram()".
     * @param s1 The first string.
     * @param s2 The second string.
     * @return <code>true</code> iff. the two strings are anagrams.
     **/
    public static boolean isAnagram(String s1, String s2) {
        int[] ana1 = countAlphabet(s1);
        int[] ana2 = countAlphabet(s2);
        if (ana1.length != ana2.length) {
            return false;
        }
        for(int i = 0; i < ana2.length; i++) {
            if (ana1[i] != ana2[i]) {
                return false;
            }
        }
        return true;
    }

    static void printTable(int[] table) { // used to facilitate testing
        System.out.print("[");
        for(int i:table) {
            System.out.print(i);
            System.out.print(", ");
        }
        System.out.print("]");
        System.out.println();
    }

    public static void main(String[] args) { // for testing outside of AnagramTest.java
        int[] myTable = countAlphabet("A");
        printTable(myTable);
        myTable = countAlphabet("Listen");
        printTable(myTable);
        myTable = countAlphabet("Silent");
        printTable(myTable);

    }
}

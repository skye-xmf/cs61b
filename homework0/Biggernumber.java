public class Biggernumber {
    /**Return the maximum value of the array m.*/
    public static int max(int[] m) {
        int l = m.length - 1;
        int n = 0;
        for (int s = 0; s <= l; s = s + 1){
            if (n <= m[s]){
                n = m[s];
            }else{
                n = n;
            }
        }
        return n;
    }

    public static void main(String[] args) {
        int[] numbers = new int[]{3, 12, 22, 7, 19};
        System.out.print("the maxmium value of the array m is " + max(numbers));
    }
}
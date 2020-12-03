public class Sum {
    public static void windowPosSum(int[] a, int n) {
        int l = a.length - 1;
        int sum = 0;
        int q = 0;
        for (int s = 0; s <= l; s = s + 1){
            if (a[s] < 0){
                continue;
            }
            for (int m = 1; m <= n; m = m +1){
                q = s + m;
                if (q > l){
                    break;
                }
                a[s] = a[s] + a[q];
                }
            }
        }

    public static void main(String[] args) {
        int[] a = {1, 2, -3, 4, 5, 4};
        int n = 3;
        windowPosSum(a, n);

        // Should print 4, 8, -3, 13, 9, 4
        System.out.println(java.util.Arrays.toString(a));
    }
}

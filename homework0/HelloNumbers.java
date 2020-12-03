public class HelloNumbers {
    public static void DrawTriangle(int N) {
        int col = 0;
        int row = 0;
        int SIZE = N;
        while (row < SIZE){
            while (col < row){
                System.out.print('*');
                col = col + 1;
            }
            row = row + 1;
            col = 0;
            System.out.println("*");
        }
    }
    public static void main(String[] args){
        DrawTriangle(10);
    }
}

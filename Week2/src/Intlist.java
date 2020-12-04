public class Intlist {
    public int first;
    public Intlist rest;
    int s = 1;

    public Intlist(int f, Intlist r){
        first = f;
        rest = r;
    }

    public int size(){
        while (rest != null){
            s += 1;
            rest = this.rest.rest;
        }
        return s;
    }

    public static void main(String[] args){
        Intlist L =new Intlist(5, null);
        L = new Intlist(10, L);
        L = new Intlist(15, L);
        L = new Intlist(20, L);
        System.out.println(L.size());
    }
}

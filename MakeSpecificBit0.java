public class MakeSpecificBit0 {
    public static void main(String[] args){
        int no = 10;
        int bit = 2;
        int result = no & ~(1 << 3);
        System.out.println(result);
    }
}

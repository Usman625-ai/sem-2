class CountNoOf1Bits{
    public static void main(String[] args) {
        int no = 17;
        int count = 0;
        while(no > 0){
            count += no & 1;
            no >>= 1;
        }
        System.out.println(count);
    }
}
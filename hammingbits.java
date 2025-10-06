public class hammingbits {
    public static void main(String[] args) {
        int[] msg = {2, 9, 9, 1, 9, 1, 0, 0, 9, 0, 0, 1, 1, 1, 0, 0, 9, 1};
        String parityScheme = "ODD"; // or "EVEN"

        System.out.println("H1 = " + calculateParity(msg, 1, parityScheme));
        System.out.println("H2 = " + calculateParity(msg, 2, parityScheme));
        System.out.println("H3 = " + calculateParity(msg, 4, parityScheme));
    }

    public static int calculateParity(int[] msg, int start, String parityScheme) {
        int msgLength = msg.length;
        int set = 0;

        // Standard Hamming pattern: skip and take 'start' bits alternately
        for (int i = start; i < msgLength; i += 2 * start) {
            int k = i;
            int j = 0;
            while (j < start && k < msgLength) {
                if (msg[k] != 9) { // 9 = placeholder for parity bit
                    set += msg[k];
                }
                k++;
                j++;
            }
        }

        int parityBit;
        if (parityScheme.equalsIgnoreCase("ODD")) {
            parityBit = (set % 2 == 0) ? 1 : 0; // Odd parity : make total count odd
        } else {
            parityBit = (set % 2 == 0) ? 0 : 1; // Even parity : make total count even
        }

        System.out.println("Sum for parity " + start + " = " + set);
        return parityBit;
    }
}

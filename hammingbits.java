public class hammingbits {
    public static void main(String[] args) {
        // -1 used to skip checking hamming 0th index
        int[] msg = {-1, 9, 9, 1, 9, 1, 0, 0, 9, 0, 0, 1, 1, 1, 0, 0, 9, 1};

        String parityScheme = "EVEN"; 

        // CALCULATE PARITY BITS
        int h1 = calculateParity(msg, 1, parityScheme);
        int h2 = calculateParity(msg, 2, parityScheme);
        int h3 = calculateParity(msg, 4, parityScheme);

        // place parity bits
        msg[1] = h1;
        msg[2] = h2;
        msg[4] = h3;

        System.out.println("\n Encoded stream:");
        for(int x : msg) System.out.print(x+" ");
        System.out.println();

        // flipping bit to see if verification process is working fine
        msg[7] ^= 1;  // flip bit for testing
        System.out.println(" Error inserted at bit 7");
        for(int x : msg) System.out.print(x+" ");
        System.out.println();

        // CHECK RECEIVED DATA
        int c1 = calculateParity(msg, 1, parityScheme);
        int c2 = calculateParity(msg, 2, parityScheme);
        int c3 = calculateParity(msg, 4, parityScheme);

        // left shift is for multiplication
        int errorpos = (c3 << 2) | (c2 << 1) | c1;

        if(errorpos == 0) {
            System.out.println("\n No error detected");
        } else {
            System.out.println("\n Error at position: " + errorpos);
            msg[errorpos] ^= 1; // bit flip
        }

        System.out.println("\nCorrected message:");
        for(int x : msg) System.out.print(x+" ");
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
            // its like if condition ? means if condition is true and : means else this
            parityBit = (set % 2 == 0) ? 0 : 1; // Even parity : make total count even
        }

        System.out.println("Sum for parity " + start + " = " + set);
        return parityBit;
    }
}

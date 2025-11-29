class matrixmultiplication{
    public static void main(String[] args){
        int[][] matrixA = {
            {1, 2, 4},  // Row 0
            {5, 6, 7},  // Row 1
            {7, 3, 2}   // Row 2
        };
        int[][] matrixB = {
            {2 , 1},
            {4 , 2},
            {4 , 6}
        };
        int[][] result = new int[matrixA.length][matrixB[0].length];
        for(int i = 0 ; i < matrixA.length ; i++ ){
            // middle loop
            for(int j = 0 ; j < matrixB[0].length ; j++){
                // very inside loop
                for(int k = 0 ; k < matrixB.length ; k++){
                    result[i][j] += matrixA[i][k] * matrixB[k][j];
                }
            }
        }
        for(int i = 0 ; i < result.length ; i++){
            System.out.print("[ ");
            for(int j = 0 ; j < result[0].length ; j++){
                System.out.print(result[i][j] + " ");
            }
            System.out.print("]");
            System.out.println();
        }
    }
}
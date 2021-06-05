public class FunctionReverse {
    public static void main(String[] args) {
        System.out.println(Integer.MIN_VALUE);
        System.out.println(reverseSmallSig1(smallSig1(Integer.MIN_VALUE)));
    }
    private static int bigSig1(int x) {
        return Integer.rotateRight(x, 6)
                ^ Integer.rotateRight(x, 11)
                ^ Integer.rotateRight(x, 25);
    }

    private static int reverseBigSig1(int x) {
        for(int i = 0;i<=Integer.MAX_VALUE;i++){
            if(x == bigSig1(i))
                return i;
        }
        return -1;
    }


    private static int bigSig0(int x) {
        return Integer.rotateRight(x, 2)
                ^ Integer.rotateRight(x, 13)
                ^ Integer.rotateRight(x, 22);
    }

    private static int reverseBigSig0(int x) {
        for(int i = 0;i<=Integer.MAX_VALUE;i++){
            if(x == bigSig0(i))
                return i;
        }
        return -1;
    }


    private static int smallSig0(int x) {
        return Integer.rotateRight(x, 7)
                ^ Integer.rotateRight(x, 18)
                ^ (x >>> 3);
    }

    private static int reverseSmallSig0(int x) {
        for(int i = 0;i<=Integer.MAX_VALUE;i++){
            if(x == smallSig0(i))
                return i;
        }
        return -1;
    }

    private static int smallSig1(int x) {
        return Integer.rotateRight(x, 17)
                ^ Integer.rotateRight(x, 19)
                ^ (x >>> 10);
    }

    private static int reverseSmallSig1(int x) {
        for(int i = 0;i<=Integer.MAX_VALUE;i++){
            if(x == smallSig1(i))
                return i;
        }
        return -1;
    }

}

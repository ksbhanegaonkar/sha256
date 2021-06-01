import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestSha {
    public static void main(String[] args) {

        createStepTowFormula();

    }

    private static void createStepTowFormula(){
        Map<String, String> map = new HashMap<>();
        String[] TEMP = new String[8];
        String[] H = new String[8];
        for (int i=0;i<8;i++){
            TEMP[i] = "W'"+i;
            H[i] = "W'"+i;
        }

        for (int t = 0, u=0; t < 64; ++t) {
            if(t==32){
                System.out.println("hi");
            }
            String t1 = TEMP[7] +"+"+ "bigSig1("+TEMP[4]+")+" + "ch("+TEMP[4]+","+ TEMP[5] + ","+ TEMP[6]+")+" + "K["+t+"]+" + "W["+t+"]";
            String t2 = "bigSig0("+TEMP[0]+")+" + "maj("+TEMP[0]+","+ TEMP[1]+","+ TEMP[2]+")";
            System.arraycopy(TEMP, 0, TEMP, 1, TEMP.length - 1);
            TEMP[4] +="+" + t1;
            TEMP[0] = t1 +"+"+ t2;
            for (int i=0;i<8;i++){
                if(TEMP[i].contains("+")){
                    map.put("W"+u,TEMP[i]);
                    TEMP[i] = "W"+u;
                    u++;
                }
            }
        }

        for (int t = 0; t < 8; ++t) {
            H[t] += "+"+TEMP[t];
        }
        System.out.println(H[4]);
        //System.out.println(map.get("W62"));
//        for(int i=0;i<map.size();i++){
//            System.out.println("W"+i+"=>"+map.get("W"+i));
//        }
        String temp = map.get("W127");
        for(int i=map.size()-2;i>=0;i--){
            temp = temp.replace("W"+i, map.get("W"+i));
        }
        System.out.println(temp);
    }


    private static void createStepOneFormula(){
        List<String> lst = new ArrayList<>(64);
        for(int i=0;i<15;i++){
            lst.add(""+i);
        }
        lst.add("x");

        for (int i=16;i<64;i++){
            String calc = lst.get(i-16) +
                    "+s0(" + lst.get(i-15) + ")" +
                    "+" + lst.get(i-7) +
                    "+s1(" + lst.get(i-2) + ")";
            lst.add(i,calc);
        }

        System.out.println(lst.get(63));
    }

    private static int ch(int x, int y, int z) {
        return (x & y) | ((~x) & z);
    }

    private static int maj(int x, int y, int z) {
        return (x & y) | (x & z) | (y & z);
    }

    private static int bigSig0(int x) {
        return Integer.rotateRight(x, 2)
                ^ Integer.rotateRight(x, 13)
                ^ Integer.rotateRight(x, 22);
    }

    private static int bigSig1(int x) {
        return Integer.rotateRight(x, 6)
                ^ Integer.rotateRight(x, 11)
                ^ Integer.rotateRight(x, 25);
    }

    private static int smallSig0(int x) {
        return Integer.rotateRight(x, 7)
                ^ Integer.rotateRight(x, 18)
                ^ (x >>> 3);
    }

    private static int smallSig1(int x) {
        return Integer.rotateRight(x, 17)
                ^ Integer.rotateRight(x, 19)
                ^ (x >>> 10);
    }
}

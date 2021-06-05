import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;

public class Sha256Runner {
    public static void main(String[] args) throws DecoderException {
        byte [] hexString = Hex.decodeHex("0200000017975b97c18ed1f7e255adf297599b55330edab87803c81701000000000000008a97295a2747b4f1a0b3948df3990344c0e19fa6b2b92b3a19c8e6badc141787358b0553535f011948750833");
        byte [] hash = Sha256.hash(Sha256.hash(hexString));
        System.out.println(Hex.encodeHexString(Sha256.hash(hexString)));
        System.out.println(Hex.encodeHexString(hash));

//        for (int i=16;i<100;i++){
//            System.out.println(i+"-"+Hex.encodeHexString(Sha256.hash(Hex.decodeHex(Integer.toHexString(i)))));
//        }
//        System.out.println(Hex.encodeHexString(Sha256.hash(Hex.decodeHex("00000000000000000000000000000003"))));
    }

    private static byte [] calculateNones(String shaString){
        return null;
    }
}
//58f497690a6c578e958567f29795f8ebc463c0da7678b1a74afb169ec3e905b8
//58f497690a6c578e958567f29795f8ebc463c0da7678b1a74afb169ec3e905b8
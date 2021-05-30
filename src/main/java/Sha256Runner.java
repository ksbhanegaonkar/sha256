import org.apache.commons.codec.binary.Hex;

public class Sha256Runner {
    public static void main(String[] args) {

        System.out.println(Hex.encodeHexString(Sha256.hash("58f497690a6c578e958567f29795f8ebc463c0da7678b1a74afb169ec3e905b858f497690a6c578e958567f29795f8ebc463c0da7678b1a74afb169ec3e905b8".getBytes())));
    }
}
//58f497690a6c578e958567f29795f8ebc463c0da7678b1a74afb169ec3e905b8
//58f497690a6c578e958567f29795f8ebc463c0da7678b1a74afb169ec3e905b8
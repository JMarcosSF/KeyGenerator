import org.nem.core.crypto.KeyPair;
import org.nem.core.crypto.PublicKey;
import org.nem.core.model.Address;
import org.nem.core.model.NetworkInfos;

/**
 * Created by skizmic on 7/5/17.
 */
public class KeyGenerator {
    public static void main(String[] args) {

//        PublicKey pk = new PublicKey("d58ef695964dcd90a4702058fbbe2ef17f810baf18475c0adaaff46253d00b6c".getBytes());
//        System.out.println();
        while (true) {
            final KeyPair someKey = new KeyPair();
            final Address anAddress = Address.fromPublicKey(
                    NetworkInfos.getMainNetworkInfo().getVersion(),
                    someKey.getPublicKey());

//            System.out.println(someKey.getPublicKey().getRaw());
            System.out.println(new PublicKey(someKey.getPublicKey().getRaw()));
            System.out.println(someKey.getPublicKey() + "\n");

            if (anAddress.getEncoded().contains("SK")) {
                printKey(someKey, anAddress);
                break;
            }
        }
    }

    private static void printKey(KeyPair someKey, Address anAddress) {
        System.out.println(String.format("Private key: %s", someKey.getPrivateKey()));
        System.out.println(String.format(" Public key: %s", someKey.getPublicKey()));
        System.out.println(String.format("    Address: %s", anAddress));
    }
}
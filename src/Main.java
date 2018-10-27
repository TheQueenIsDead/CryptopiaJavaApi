
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws Exception {

        CryptopiaApi cryptopiaApi = new CryptopiaApi();
        cryptopiaApi.readAuth("/src/authDetails.json");
        System.out.println(cryptopiaApi.getUnixTime());

        CryptopiaPublicApi cryptopiaPublicApi = new CryptopiaPublicApi();
        System.out.println(cryptopiaPublicApi.getTradePairs());


    }
}

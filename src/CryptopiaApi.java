import jdk.nashorn.internal.parser.JSONParser;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.time.Instant;

public class CryptopiaApi {

    Integer nonce = 0;

    String apiKey = null;
    String apiSecret = null;

    String apiBaseUrl = "https://www.cryptopia.co.nz/Api/";

    public void createAmxHeader(){
        /*
        *   Create string with all data
        *       - APP Id, Method, URI, TimeStamp, Nonce, Base64 request payload
        * 
        *
        *
        *
        *
        */
    }

    public void readAuth(String filename) throws IOException, ParseException {
//        String basePath = new File("").getAbsolutePath();
//        JSONObject auth = (JSONObject) new JSONParser().parse(new FileReader(basePath + filename));
//        apiKey = (String) auth.get("api_key");
//        apiSecret = (String) auth.get("api_secret");
//        System.out.println("Loaded auth from file");
    }

    public String signature(String key) throws NoSuchAlgorithmException, InvalidKeyException, UnsupportedEncodingException {
        Mac sha256_HMAC = Mac.getInstance("HmacSHA256");
        SecretKeySpec secret_key = new SecretKeySpec(key.getBytes("UTF-8"), "HmacSHA256");
        sha256_HMAC.init(secret_key);

            //return Hex.encodeHexString(sha256_HMAC.doFinal(data.getBytes("UTF-8")));

        return "Not created";
    }

    public String getNonce(){
        return nonce.toString();
    }

    public long getUnixTime() {
        return Instant.now().getEpochSecond();
    }
}

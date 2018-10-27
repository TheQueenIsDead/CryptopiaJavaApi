import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class CryptopiaPublicApi extends CryptopiaApi {


    /*
    Meagre documentation here:
    https://support.cryptopia.co.nz/csm?id=kb_article&sys_id=40e9c310dbf9130084ed147a3a9619eb
     */



    private CryptopiaResponse sendRequest(String method, String endpoint) throws IOException {

        // Craft the URL
        URL requestUrl = new URL(apiBaseUrl + endpoint);

        // Set up the connection and relevant headers
        HttpURLConnection connection = (HttpURLConnection) requestUrl.openConnection();
        connection.setRequestMethod(method);
        connection.setRequestProperty("Content-Type", "application/json");

        // If the request was ok
        if (connection.getResponseCode() == 200){

            // Read the response message
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuffer content = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();

            // Create response object from JSON
            Gson gson = new Gson();
            CryptopiaResponse cryptopiaResponse = gson.fromJson(content.toString(), CryptopiaResponse.class);
            return cryptopiaResponse;
        }

        return null;
    }

    public CryptopiaResponse getCurrencies() throws IOException {
        return sendRequest("GET", "/GetCurrencies");
    }

    public CryptopiaResponse getTradePairs() throws Exception {
        return sendRequest("GET", "/GetTradePairs");
    }

    public CryptopiaResponse getMarket() throws Exception {
        return sendRequest("GET", "/GetMarket");
    }

    public CryptopiaResponse getMarkets() throws Exception {
        return sendRequest("GET", "/GetMarkets");
    }

    public CryptopiaResponse getMarketHistory() throws Exception {
        return sendRequest("GET", "/GetMarketHistory");
    }

    public CryptopiaResponse getMarketOrders() throws Exception {
        return sendRequest("GET", "/GetMarketOrders");
    }

    public CryptopiaResponse getMarketOrderGroups() throws Exception {
        return sendRequest("GET", "/GetMarketOrderGroups");
    }
}

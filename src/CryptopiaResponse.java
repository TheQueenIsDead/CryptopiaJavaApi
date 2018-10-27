import java.util.ArrayList;
import java.util.Map;

public class CryptopiaResponse {

    public CryptopiaResponse(){

    }

    Boolean Success;
    String Message;
    ArrayList<Map<String, String>> Data;

    public String toString(){
        return Data.toString();
    }
}

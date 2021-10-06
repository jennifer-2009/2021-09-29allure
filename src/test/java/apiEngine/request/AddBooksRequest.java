package apiEngine.request;
import java.util.ArrayList;
import java.util.List;

public class AddBooksRequest {

    public String userId;
    public List<ISBN> collectionIsbn;

    public AddBooksRequest(String userId, ISBN isbn){
        this.userId = userId;
        this.collectionIsbn = new ArrayList<ISBN>();
        this.collectionIsbn.add(isbn);
    }

}

package apiEngine.request;

public class AuthorizationRequest {

    public String username;
    public String password;

    public AuthorizationRequest(String username, String password){
        this.username = username;
        this.password = password;
    }

    public String setUsername(String username){
        return username;
    }

    public String setPassword(String password){
        return password;
    }
}

package excep;

public class NotFoundError extends Exception {


    private String key;

    public NotFoundError(String key){
        super();
        this.key = key;
    }

    public String getKey() {
        return key;
    }
}

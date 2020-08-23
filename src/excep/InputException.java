package excep;

public class InputException extends Exception {

    private String message = "Invalid $key$. Try to insert a valid one";



    public InputException(String key){
        super();
        this.message = this.message.replace("$key$",key);
    }

    @Override
    public String getMessage(){
        return this.message;
    }
}

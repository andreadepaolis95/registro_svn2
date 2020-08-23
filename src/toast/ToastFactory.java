package toast;

public class ToastFactory {

    public ToastFactory() {
        //factory
    }

    public Toast createErrorToast(String message){
        return new ToastError(message);
    }

    public Toast createSuccessToast(String message){
        return new ToastSuccess(message);
    }

}

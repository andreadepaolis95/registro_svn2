package toast;



import service.Validator;

public class ToastSuccess implements Toast {

    private String title = "Success";
    private String message = "$key$";
    private String build = "<div id=\"toast\" class=\"succ\"><h3>$title$</h3>$message$</div>";

    ToastSuccess(String key){
        Validator v = new Validator();
        String temp = v.validateString(key)? key : "Unexpected Error";
        this.message = this.message.replace("$key$",temp);
        this.build = this.build.replace("$title$",this.title);
        this.build = this.build.replace("$message$",this.message);
    }

    @Override
    public String show(){
        return this.build + this.getScript();
    }


    private String getScript(){
        return "<script>setTimeout(function(){" +
                "showToast()},500)</script>";
    }


}

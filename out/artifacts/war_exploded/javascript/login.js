

var isProfessor = false;

window.onload = function(){
    let p = document.getElementById("show_name");
    p.innerHTML = getOtherName();
}

function cust(){

    isProfessor = !isProfessor;
    document.getElementById("show_name").innerHTML = getName();

    let hide = document.getElementById("flag");
    if(hide.value === "false") hide.value = "true";

    else hide.value = "false";


    let d = document.getElementById("cnt");
    if(d.classList.contains("app"))
        d.classList.remove("app")
    else
        d.classList.add("app")
    let c = document.getElementById("sbc");
    if(c.classList.contains("prof"))
        c.classList.remove("prof")
    else
        c.classList.add("prof")

    let lg1 = document.getElementById("lg1");
    let lg2 = document.getElementById("lg2");

    if(lg2.classList.contains("hide")){
        lg1.classList.add("hide");
        setTimeout(function(){
            lg2.classList.remove("hide");

        } ,1000)
    }else {
        lg2.classList.add("hide");
        setTimeout(function(){
            lg1.classList.remove("hide");

        },1000)
    }
}

function getName(){
    return isProfessor? "Login as Professor" : "Login as Student";
}
function getOtherName() {
    return !isProfessor? "Login as Student" : "Login as Professor";

}


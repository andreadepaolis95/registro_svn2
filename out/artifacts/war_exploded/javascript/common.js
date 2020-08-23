const showToast = function(){
    let d = document.getElementById("toast");
    d.classList.add("show");

    setTimeout(function () {
        d.classList.remove("show");
        d.remove();
    },3000);
}


$(function(){
    yes(say,"hi,js");
    var time = new Date();
    $("#time").val(time);
    var time2 = time.getTime();
    $("#time2").val(time2);
    var time3 = new Date(time2).toLocaleString();
    $("#time3").val(time3);
});
function say (value) {
    alert(value);
}
function yes(someFuntion,value){
    someFuntion(value);
}

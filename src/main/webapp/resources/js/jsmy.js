
$(function myFunction() {
    var x = document.getElementById("myInput");
    if (x.type === "password") {
        x.type = "text";
    } else {
        x.type = "password";
    }
}
$(function(){

    /***** Показать/скрыть пароль *****/

    $('.show-pass').click(function(){
        if($(this).hasClass('showing')){
            $(this).attr('title', 'show characters');
            $(this).removeClass('showing');
            $('#password').attr('type', 'password');
        }else{
            $(this).attr('title', 'hide characters');
            $(this).addClass('showing');
            $('#password').attr('type', 'text');
        }
    });

    /***** ПАРАЛЛАКС *****/

    var moveSpeed = 0.05;

    var login = $('.login-wrapper');
    var transX = $('.x-wrapper');
    var transY = $('.y-wrapper');

    var winMidX = $(window).width()/2;
    var winMidY = $(window).height()/2;

    $(window).resize(function(){
        winMidX = $(window).width()/2;
        winMidY = $(window).height()/2;
    });

    $(window).mousemove(function(e){
        var mX = e.pageX;
        var mY = e.pageY;
        var xDif = winMidX - mX;
        var yDif = winMidY - mY;

        login.css({
            marginTop: yDif*moveSpeed,
            marginLeft: xDif*moveSpeed,
        });

        transX.css({
            "-webkit-transform": 'rotateX('+(yDif*moveSpeed)*-1+'deg)',
            "-moz-transform": 'rotateX('+(yDif*moveSpeed)*-1+'deg)',
            "transform": 'rotateX('+(yDif*moveSpeed)*-1+'deg)'
        });

        transY.css({
            "-webkit-transform": 'rotateY('+(xDif*moveSpeed)*-1+'deg)',
            "-moz-transform": 'rotateY('+(xDif*moveSpeed)*-1+'deg)',
            "transform": 'rotateY('+(xDif*moveSpeed)*-1+'deg)'
        });

    });

})
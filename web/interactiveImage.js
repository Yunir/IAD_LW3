$(document).ready(function () {
    var lastx;
    var lasty;
    var lastWidth;
    var lastHeight;
    $('#graph').click(function (e) {
        var x=e.pageX;
        var y=e.pageY;
        var top=$(this).offset().top;
        var left=$(this).offset().left;
        var height=document.getElementById("graph").clientHeight;
        var width=document.getElementById("graph").clientWidth;
        var right=left+width;
        var bottom=top+height;
        var r;
        if($('#enterR').val().length>=1) r=parseFloat($('#enterR').val());
        var yCoor=(1-(y-top)/(height/2))*1.25*r;
        var xCoor=-(1-(x-left)/(width/2))*1.25*r;
        var color = '#2c7a0f';
        var size = '8px';
        if(r>=2 & r<=5){
            var order = {
                enterX: xCoor,
                enterY: yCoor,
                enterR: r,
                code: 1
            };
            $.ajax({
                url: 'http://localhost:8080/2labaIAD_war_exploded/WelcomeApp',
                type: 'POST',
                data: order,
                error : function(data){
                    alert("OOPS");
                }
            });
            setTimeout(function () {
                jQuery('#refresh').trigger('click');
            }, 300);
        }
        else alert("R is undefined. Cannot do calculations!")
        if ($('#point').length) {
            $("#point").remove();
        }
        $("body").append(
            $('<div id="point"></div>')
                .css('position', 'absolute')
                .css('top', (y-4) + 'px')
                .css('left', (x-4) + 'px')
                .css('width', size)
                .css('height', size)
                .css('background-color', color)
                .css('border-radius', '3px')
        );
        lastx=x-left;
        lasty=y-top;
        lastWidth=width;
        lastHeight=height;
        $("#results").load('http://localhost:8080/2labaIAD_war_exploded/WelcomeApp' + ' #results');
    })
    $('#refresh').click(function (e) {
        $('.result').css('display', 'block');
        $('#clear').css('display', 'block');
        $("#results").load('http://localhost:8080/2labaIAD_war_exploded/WelcomeApp' + ' #results');
    })
    $('#clear').click(function (e) {
        var order = {
            code: 3
        };
        $.ajax({
            url: 'http://localhost:8080/2labaIAD_war_exploded/WelcomeApp',
            type: 'POST',
            data: order,
            error : function(data){
                alert("OOPS");
            }
        });
        $('.result').css('display', 'none');
        $('#clear').css('display', 'none');
        $("#results").load('http://localhost:8080/2labaIAD_war_exploded/WelcomeApp' + ' #results');
    })
    $(window).resize(function() {
        if ($('#point').length) {
            $("#point").remove();
        }
        var color = '#2c7a0f';
        var size = '8px';
        var width=document.getElementById("graph").clientWidth;
        var x=lastx*width/lastWidth;
        var height=document.getElementById("graph").clientHeight;
        var y=lasty*height/lastHeight;
        y=y+document.getElementById("graph").offsetTop;
        x=x+document.getElementById("graph").offsetLeft;
        $("body").append(
            $('<div id="point"></div>')
                .css('position', 'absolute')
                .css('top', y + 'px')
                .css('left', x + 'px')
                .css('width', size)
                .css('height', size)
                .css('background-color', color)
                .css('border-radius', '3px')
        );
    });
});

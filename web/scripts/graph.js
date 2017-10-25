$(document).ready(function(){
    var x;
    var y;
    var R = '-1';

    //Graph
    var plot_canvas = document.getElementById("plot");
    var plot_context = plot_canvas.getContext("2d");
    plot_context.beginPath();
    plot_context.arc(150, 150, 50, Math.PI, 3*Math.PI/2);
    plot_context.lineTo(150, 150);
    plot_context.closePath();
    plot_context.rect(150, 100, 100, 50);
    plot_context.fillStyle = '#3BA4C7';
    plot_context.fill();
    plot_context.beginPath();
    plot_context.moveTo(150, 150);
    plot_context.lineTo(150, 200);
    plot_context.lineTo(200, 150);
    plot_context.lineTo(150, 150);
    plot_context.closePath();
    plot_context.fillStyle = '#3BA4C7';
    plot_context.fill();
    plot_context.beginPath();

    //Ox
    plot_context.moveTo(30, 150);
    plot_context.lineTo(270, 150);
    plot_context.lineTo(260, 140);
    plot_context.moveTo(270, 150);
    plot_context.lineTo(260, 160);

    //Oy
    plot_context.moveTo(150, 30);
    plot_context.lineTo(140, 40);
    plot_context.moveTo(150, 30);
    plot_context.lineTo(160, 40);
    plot_context.moveTo(150, 30);
    plot_context.lineTo(150, 270);
    plot_context.moveTo(30, 150);
    plot_context.closePath();
    plot_context.stroke();

    //Buttons
    document.getElementById("r1").addEventListener("click", changeR(1), false);
    document.getElementById("r2").addEventListener("click", changeR(2), false);
    document.getElementById("r3").addEventListener("click", changeR(3), false);
    document.getElementById("r4").addEventListener("click", changeR(4), false);
    document.getElementById("r5").addEventListener("click", changeR(5), false);
    plot_canvas.addEventListener("click", drawPoint, false);

    function drawPoint(e) {
        if(R == '-1') {
            alert("Выберите какое-нибудь значение R");
        } else {
            var cell = getCursorPosition(e);
            plot_context.beginPath();
            plot_context.rect(x, y, 5, 5);
            x -= 150;
            y -= 150;
            y *= -1;
            x = x/100*R;
            y = y/100*R;
            plot_context.fillStyle = 'gray';
            if (checkArea(x, y, R) == 1) plot_context.fillStyle = 'white';
            plot_context.fill();
            plot_context.closePath();
            document.getElementById("canvaForm:canvaX").value = x;
            document.getElementById("canvaForm:canvaY").value = y;
            canvaReady();
        }
    }

    function checkArea(x, y, r){
        if((x >= 0 && y >= 0) && (x <= r) && (y <= (r/2))){
            return 1;
        } else if(x >= 0 && y <= 0 && y >= (x-(r/2))){
            return 1;
        } else if (x <= 0 && y >= 0 && (r/2) >= Math.sqrt(y*y+x*x)){
            return 1;
        } else {
            return 0;
        }
    }

    function getCursorPosition(e) {
        if (e.pageX != undefined && e.pageY != undefined) {
            x = e.pageX;
            y = e.pageY;
        } else {
            x = e.clientX + document.body.scrollLeft +
                document.documentElement.scrollLeft;
            y = e.clientY + document.body.scrollTop +
                document.documentElement.scrollTop;
        }
        x -= plot_canvas.offsetLeft ;
        y -= plot_canvas.offsetTop ;
    }

    function changeR(r) {
        R = r;
        document.getElementById("infoR").innerHTML = "You set R = " + r;
    }

});
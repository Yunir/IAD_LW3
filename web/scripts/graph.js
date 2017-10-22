$(document).ready(function(){
    var plot_canvas = document.getElementById("plot");
    var plot_context = plot_canvas.getContext("2d");
    var rr = document.getElementById("r");
    plot_context.beginPath();
    plot_context.arc(150, 150, 100, 0, Math.PI/2);
    plot_context.lineTo(150, 150);
    plot_context.closePath();
    plot_context.rect(50, 150, 100, 50);
    plot_context.fillStyle = 'red';
    plot_context.fill();
    plot_context.beginPath();
    plot_context.moveTo(150, 150);
    plot_context.lineTo(150, 100);
    plot_context.lineTo(200, 150);
    plot_context.lineTo(150, 150);
    plot_context.closePath();
    plot_context.fillStyle = 'red';
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
    var x;
    var y;
    var R = '-1';
    rr.addEventListener("click", changeR, false);
    plot_canvas.addEventListener("click", drawPoint, false);
    function drawPoint(e) {
        //$('#if').hide();
        if(R == '-1') {
            alert("Выберите какое-нибудь значение R");
        } else {
            var cell = getCursorPosition(e);
            plot_context.beginPath();
            plot_context.rect(x, y, 5, 5);
            plot_context.fillStyle = 'yellow';
            plot_context.fill();
            x -= 150;
            y -= 150;
            y *= -1;
            x = x/100*R;
            y = y/100*R;
            //alert(x + " " + y);
            $.ajax({
                type:'post',//тип запроса: get,post либо head
                url:'controller',//url адрес файла обработчика
                data:{'x55':x, 'y':y, 'r':R},//параметры запроса
                response:'text',//тип возвращаемого ответа text либо xml
                error: function (message) {
                    console.log(message);
                    $('#results1').text(message);
                    alert("Error " + message);
                },
                success:function (data) {//возвращаемый результат от сервера
                    console.log(data);
                    $('#results1').html(data);
                    /*$("#if").attr(
                        "src", "data:text/html;charset=utf-8," + data
                    );*/
                    ifr =   document.getElementById('if').contentDocument;
                    ifr.open();
                    ifr.writeln(data);
                    ifr.close();
                    //$('#if').html(data);
                    /*alert("Correct " + message);
                    $$('result',$$('result').innerHTML+'<br />'+data);*/
                }
            });
        }
    }
    function getCursorPosition(e) {
        if (e.pageX != undefined && e.pageY != undefined) {
            x = e.pageX;
            y = e.pageY;
        }
        else {
            x = e.clientX + document.body.scrollLeft +
                document.documentElement.scrollLeft;
            y = e.clientY + document.body.scrollTop +
                document.documentElement.scrollTop;
        }
        x -= plot_canvas.offsetLeft ;
        y -= plot_canvas.offsetTop ;
    }
    function changeR(e) {
        if (document.getElementById('r1').checked) {
            R = document.getElementById('r1').value;
        }
        if (document.getElementById('r2').checked) {
            R = document.getElementById('r2').value;
        }
        if (document.getElementById('r3').checked) {
            R = document.getElementById('r3').value;
        }
        if (document.getElementById('r4').checked) {
            R = document.getElementById('r4').value;
        }
        if (document.getElementById('r5').checked) {
            R = document.getElementById('r5').value;
        }
    }
});
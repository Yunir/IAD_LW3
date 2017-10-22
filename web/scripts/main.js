$(document).ready(function () {
    function updateClock() {
        var now = new Date(), // current date
            months = ['January', 'February', '...']; // you get the idea
        var time = now.getHours() + ':' + now.getMinutes() + ':' + now.getSeconds();// again, you get the idea

            // a cleaner way than string concatenation
        var date = [now.getDate(),
                now.getMonth()+1,
                now.getFullYear()].join('.');

        // set the content of the element with the ID time to the formatted string
        document.getElementById('time').innerHTML = [time, date].join(' | ');

        // call this function again in 1000ms
        setTimeout(updateClock, 12000);
    }

    updateClock();
});
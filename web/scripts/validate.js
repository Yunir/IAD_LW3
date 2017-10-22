$(document).ready(function(){
  $("#form").validate({
    rules: {
      enterY: {
        required: true,
        number: true,
        min: -5,
        max: 5
      }
    },
    messages: {
      enterY: {
     	required: "<br/>Enter Y",
        number: "<br/>Enter a Number",
        min: "<br/>Enter a value greater than -5",
        max: "<br/>Enter a value less than 5"
      }
    }
  });
});
$(document).ready(function(){
  $("#myForm").validate({
    rules: {
      enterR: {
        required: true,
        number: true,
        min: 2,
        max: 5
      },
      enterY: {
        required: true,
        number: true,
        min: -3,
        max: 3
      },
      'enterX[]': { required: true },
    },
    messages: {
      enterR: {
        required: "<br/>Enter R",
        number: "<br/>Enter a Number",
        min: "<br/>Enter a value greater than 2",
        max: "<br/>Enter a value less than 5"
      },
      enterY: {
     	required: "<br/>Enter Y",
        number: "<br/>Enter a Number",
        min: "<br/>Enter a value greater than -3",
        max: "<br/>Enter a value less than 3"
      },
      'enterX[]': { required: ""},
    }
  });
});
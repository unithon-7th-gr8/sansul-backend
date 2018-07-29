$(function () {
  console.log("ready!");

  // timer

  // create new room
  // get roomId

  // redirect

  // request POST rooms 
  function createRoom() {
    $.ajax({
      type: 'POST',
      contentType: 'application/json',
      url: '/rooms',
      success: function (data, status) {
        console.log(data, status);
      },
      error: function (error) {
        console.log(error);
      }
    });
  }
});





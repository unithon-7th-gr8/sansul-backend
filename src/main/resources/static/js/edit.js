$(function () {
  console.log("ready!");

  // roomId = 6;
  // userData = {
  //   name: 'userName',
  //   tags: ['LATE', 'EARLY']
  // }
  // requestToCreateUser(roomId, userData);
  // requsetToDeleteUser(roomId, 79);
  // requestToGetRoom(6);  

  // POST /rooms/{roomId}/users
  function requestToCreateUser(roomId, user) {
    $.ajax({
      type: 'POST',
      contentType: 'application/json',
      url: '/rooms/' + roomId + '/users',
      data: JSON.stringify(user),
      success: function (data, status) {
        console.log(data, status);
      },
      error: function (error) {
        console.log(error);
      }
    });
  }

  // DELETE /rooms/{roomId}/users/{userId}
  function requsetToDeleteUser(roomdId, userId) {
    $.ajax({
      type: 'DELETE',
      url: '/rooms/' + roomId + '/users/' + userId,
      success: function (data, status) {
        console.log(data, status);
      },
      error: function (error) {
        console.log(error);
      }
    });
  }

  // GET /rooms/{roomId}
  function requestToGetRoom(roomId) {
    $.ajax({
      type: 'GET',
      url: '/rooms/' + roomId,
      success: function (data, status) {
        console.log(data, status);
      },
      error: function (error) {
        console.log(error);
      }
    });
  }
  
});

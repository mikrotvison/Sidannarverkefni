$(function() {
  $('.slot').click(function(){
    var idVal = $(this).attr('id');		// Get what grid was clicked
    var id = "#" + idVal;

    $.ajax({
	url: '/api/game',
      success: function(data) {
        $(id).text(data);
      }
    });
  });
});

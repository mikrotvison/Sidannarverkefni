$(function() {
  $('.box').click(function(){
    var idVal = $(this).attr('id');		// Get what grid was clicked
    var content = "." + idVal;
    $.ajax({
	url: '/api/game?slot=' + idVal,		// idVal equals the slot that was clicked on
      success: function(data) {
        $(content).text(data);
      }
    });
  });
});

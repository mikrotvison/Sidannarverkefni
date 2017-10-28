$(document).ready(function() {
	$(function() {
  		$('.box').click(function(){
    			var idVal = $(this).attr('id');					// Get what grid was clicked
    			var content = "." + idVal;
    			$.ajax({
				url: '/api/game?slot=' + idVal,				// idVal equals the slot that was clicked on
      				success: function(data) {
					if (data != "invalid") {		
						if (data == "Xw")			// Player X has won the game
						{
                                                        $("#status").text("Player X has won!");
                                                        $(content).text("X");							
						}
						else if (data == "Ow")			// Player O has won the game
						{
                                                        $("#status").text("Player O has won!");
                                                        $(content).text("O");
						}
						else if (data == "draw")		// The game has ended in a draw
						{
							$("#status").text("Draw, Play again!");	
							$(content).text("X");
						}
						else
						{	
	        					$(content).text(data);
						}
					}

      				}
    			});
			return false;
  		});
	});
});

$(document).on('click', "#new-game", function() {
	$.ajax({
                url: '/api/refresh',                               			// Refresh page when new game button is clicked
                success: function(data) {
                        if (data == "refresh") {
                                window.location.reload();
                        }
                }
	});
});

$(window).on('beforeunload', function(){
	$.ajax({
		url: 'api/refresh',
		success: function(data) {
			if (data == "refreash") {
				window.location.reload();
			}
		}
	});
});


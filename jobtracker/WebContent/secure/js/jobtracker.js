

var contact_details  = {image:"",user_name:""};

function display_connected_status () {
	   $("#status_image").attr("src", "images/connected.jpg");
	  // $("#image_wrapper").attr("class","icon_wrapper");

};

function display_disconnected_status() {
	   $("#status_image").attr("src","images/disconnected.jpg");
	  // $("#image_wrapper").attr("class","icon_wrapper");
};

function display_login_status() { 	
	$("#user_image").html('<img src="'+contact_details.image+'" alt="'+contact_details.user_name+'">');
	$("#logout_button").show();
};

function display_unknown_status() {
   $("#user_image").html(""); 
   $("#logout_button").hide();
   
};

function ping() {
    $.ajax({
      cache: false,
      type: 'GET',
      url: '/jobtracker/jobtracker-service/ping',
      timeout: 1000,
      success: function(data, textStatus, XMLHttpRequest) {
    	  
        if (data != 'alive') {
          display_disconnected_status();
        } else {
          display_connected_status();
        }
      },
      error: function (xhr,status,errorThrown) {
    	 
    	  display_disconnected_status();
       }
    });

  }

$.urlParam = function(name) {
	var results = new RegExp('[\\?&]' + name + '=([^&#]*)')
			.exec(window.location.href);
	if (results == null) {
		return null;
	} else {
		return results[1] || 0;
	}
};

function getRealContentHeight(){
	var header = $("div[data-role='header']:visible");
    var footer = $("div[data-role='footer']:visible");
    var content = $("div[data-role='content']:visible:visible");
    var viewport_height = $(window).height();

    var content_height = viewport_height - header.outerHeight() - footer.outerHeight();
    if((content.outerHeight() - header.outerHeight() - footer.outerHeight()) <= viewport_height) {
        content_height -= (content.outerHeight() - content.height());
        content.height(content_height);
    } 
    return content_height - 3;
}

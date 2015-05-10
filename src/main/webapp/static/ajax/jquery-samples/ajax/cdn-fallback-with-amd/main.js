require.config({
    paths: {
        jquery: [ 
            "//ajax.googleapis.com/ajax/libs/jquery/1.10.1/jquery.min.js",
            //Fallback to local script
            "../../../js/jquery"
        ]
    }
});

require(["jquery"], function($) { 
    $("#content").html("Script loaded!"); 
});
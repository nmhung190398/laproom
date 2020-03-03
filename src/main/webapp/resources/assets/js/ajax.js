function ajaxGet(url,cb) {
    $.ajax({
        url : url,
        type : 'GET',
        dataType : 'json',
        success : cb,
        error : function(data) {

        }
    });
}

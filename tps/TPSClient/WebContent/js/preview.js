/**
 * Created by Ganga on 9/25/2016.
 */
$('body').on('click', '.preview-hotel', function () {
//            var id = $(this).data('id');
//    alert($(this).data('id'));

    /*function getContextPath() {
        return window.location.pathname.substring(0, window.location.pathname.indexOf("/",2));
    }
    alert(getContextPath());*/

    var contextPath = window.location.pathname.substring(0, window.location.pathname.indexOf("/",2));
    var hotelId = $(this).data('id');
    var page = $(this).data('page');
    var actionUrl = contextPath+"/hotelDetail/preview";
    if(page== 'approved'){
        actionUrl = contextPath+"/hotelDetail/previewPushedHotel";
    }


    console.log("contextPath "+contextPath+"id"+hotelId);


        $('<form action="'+actionUrl+'" method="post">' +
            '<input type="text" name="hotelDetailId" value="'+hotelId+'">' +
            '<input type="text" name="page" value="'+page+'"></form>').appendTo('body').submit();

    /*$.ajax({
        method: "POST",
        url: actionUrl,
        data: {hotelDetailId: hotelId, page: page},
        dataType: "html",
        beforeSend: function () {
            $('.loading-img').css('display', 'block');
        },
        success: function (data) {
//                    alert("fasdfasdf");
//            dropdown-menu
//            $(".nav").childen().removeClass('active');
            //$(".preview").parent().addClass('active');
            $(".hotelName").remove();
            $(".page-title").html("Preview");
            $(".wrapper-content").empty();
            $(".wrapper-content").append(data);


        },

        complete: function (data) {
//                   console.log(data);
            $('.loading-img').css('display', 'none');

        }

    });*/
});
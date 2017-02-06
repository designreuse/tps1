

<script src="${pageContext.request.contextPath}/js/jquery-2.1.1.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/js/plugins/metisMenu/jquery.metisMenu.js"></script>
<script src="${pageContext.request.contextPath}/js/plugins/slimscroll/jquery.slimscroll.min.js"></script>

<%--JQuery Validation--%>
<script src="${pageContext.request.contextPath}/js/plugins/validate/jquery.validate.min.js"></script>

<!-- Toastr script -->
<script src="${pageContext.request.contextPath}/js/plugins/toastr/toastr.min.js"></script>
<script src="${pageContext.request.contextPath}/js/plugins/dataTables/datatables.min.js"></script>

<!-- Custom and plugin javascript -->
<script src="${pageContext.request.contextPath}/js/inspinia.js"></script>
<script src="${pageContext.request.contextPath}/js/plugins/pace/pace.min.js"></script>
<c:forEach items="${siteContent.js}" var="js">
    <script src="${pageContext.request.contextPath}/js/plugins/${js}"></script>
</c:forEach>

<script type="text/javascript">
//    pass deleteing  id to delete confirm model


    $(document).on("click", ".open", function () {
     var id = $(this).data('id');
     $(".modal-body #deleteId").val(id);



     });

    $(".datatable").DataTable();
    if($('.nav li').hasClass('active')){
        $(".page-title").text($(".active").children().html());
        $('.active').parent().parent().addClass('active');
    }

    $("#toggleBtn").click(function(){
        var currentUrl = window.location.pathname;
        if(currentUrl.substr(currentUrl.length-1)!="#"){
            currentUrl=currentUrl+"#";
        }
       /* if(window.location.pathname.substr(window.location.pathname.length-1=='#')){
            alert("success");
        }*/
        $(this).attr("href", currentUrl);
    });

</script>

<script type="text/javascript">

    $(document).ready(function () {
//
        <%--console.log('${response}');--%>
       responseMessage("${response.status}","${response.msg}");



    });

    function responseMessage(status, message){
        if(status=="SUCCESS"){
            toastr.success(status,message);
        }else if(status=="UNSUCCESS"){
            toastr.error(status,message);
        }
    }

    $('body').popover({
        placement: 'bottom',
        container: 'body',
        html : true,
        selector: '#popover',
        title: function() {
            return $("#popover-head").html();
        },
        content: function() {
            return $("#popover-content").html();
        }
    });

//    $('.summernote').summernote();

</script>


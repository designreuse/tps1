<%--
  Created by IntelliJ IDEA.
  User: Ganga
  Date: 6/17/2016
  Time: 11:37 AM
  To change this template use File | Settings | File Templates.
--%>
<%@include file="/WEB-INF/includes/header.jsp" %>

<div id="wrapper">
    <%@include file="/WEB-INF/includes/adminLeftNavigation.jsp" %>
    <div id="page-wrapper" class="gray-bg">
        <%@include file="/WEB-INF/includes/topNavigation.jsp" %>

            <link href="${pageContext.request.contextPath}/css/plugins/jsTree/style.min.css" rel="stylesheet">
        <div class="wrapper wrapper-content animated fadeIn">
            <div class="row">
                <div class="col-lg-6" id="tree">

                </div>
                <div class="col-lg-6">
                    <form method="post" id="form1" class="form-horizontal">

                        <div class="form-group"><label class="col-sm-4 control-label">Description</label>
                            <input type="hidden" id="parentId" name="parentRoomTypeId">
                            <input type="hidden" id="nodeId" name="roomTypeId">

                            <div class="col-sm-6"><input type="text" class="form-control" id="nodeName1"
                                                         name="roomTypeDesc"
                                                         required></div>
                        </div>

                        <div class="form-group col-sm-6">
                            <div class="col-sm-4 col-sm-offset-2">
                                <a id="update-btn" class="btn btn-primary">Update</a>
                            </div>
                            <div class="col-sm-4 col-sm-offset-2">
                                <a class="btn btn-danger" id="delete-btn" style="display: none">Delete</a>
                            </div>
                        </div>
                    </form>
                </div>
            </div>


        </div>
    </div>
</div>
<%@include file="/WEB-INF/includes/script.jsp" %>
<script src="${pageContext.request.contextPath}/js/plugins/jsTree/jstree.min.js"></script>
<%--<c:forEach items="${siteContent.js}" var="js">
    <script src="${pageContext.request.contextPath}/js/plugins/${js}"></script>
</c:forEach>--%>
<%--<script src="${pageContext.request.contextPath}/js/jquery-2.1.1.js"></script>--%>
<script type="text/javascript">
    $(function () {
        jQuery.validator.addMethod("alphaNumeric", function (value, element) {
            // return true - means the field passed validation
            // return false - means the field failed validation and it triggers the error
            return this.optional(element) || /^([\w\s]+)$/.test(value);
        }, "Only alphanumeric value and underscore is allowed!");

//	 	   $( "#addform" ).validate();
        $('#form1').validate({
            rules: {
                roomTypeDesc: {
                    required: true,
                    alphaNumeric: true
                }
            }
        });
    });

<%--console.log(JSON.parse('${tree}'));--%>

   $('#tree').jstree({ 'core' : {

       'data' : JSON.parse('${tree}'),
       check_callback : true
   } });

   $('#tree')
   // listen for event
           .on('changed.jstree', function (e, data) {
               var i, j, r = [];
               console.log(data);
               $('#parentId').val(data.node.parent);
               $('#nodeName1').val(data.node.text);
               $('#nodeId').val(data.node.id);
//               $('#delete-btn').attr("href", "delete/"+data.node.id);

               if(data.node.id.indexOf("x")==-1){
                   var childrenCount = data.node.children.length;

                   if(childrenCount == 0) {
                       $('#delete-btn').show();
                   }else if(childrenCount == 1 && data.node.children[0].indexOf("x") == -1){
                       $('#delete-btn').hide();
                   }else if(childrenCount == 1 && data.node.children[0].indexOf("x") != -1){
                       $('#delete-btn').show();
                   }else{
                       $('#delete-btn').hide();
                   }
//                   $('#delete-btn').show();
//                   $('#delete-btn').attr("href", "delete/"+data.node.id);
                   if(data.node.children.indexOf(data.node.id+'x') == -1 && data.node.parents.length <= "${level}"){
                       $('#tree').jstree().create_node(data.node.id ,  { "id" : data.node.id+"x", "text" : "new Node", "parent":data.node.parent}, "last");
                   }
               }else{
                   $('#delete-btn').hide();
               }
               $("#tree").jstree("open_node", data.node);
           })
           // create the instance
           .jstree();

    $("#update-btn").click(function(){

        var newTitle = $('#nodeName1').val();
        $.ajax({
            method: "POST",
            url: "update",
            data: { roomTypeId: $("#nodeId").val(), parentRoomTypeId: $("#parentId").val(), roomTypeDesc: $('#nodeName1').val() },
            dataType: "json",
            beforeSend: function(xhr, opts){
                if($("#form1").valid()==false){
                    xhr.abort();
                }
            },
            success: function(data){

                if($("#nodeId").val().indexOf("x")==-1){
                    $('#tree').jstree('rename_node', {"id": data.room_type_id}, newTitle);
                }else{


                    $('#tree').jstree().create_node($("#parentId").val(), {
                        "id": data.room_type_id,
                        "text": newTitle,
                        "type": $("#type").val(),
                        "parent": $("#parentId").val()
                    }, "last");
                    $("#nodeId").val(data.room_type_id);
                }

//                console.log(data);
            }
        });
    });

    $("#delete-btn").click(function(){
        $.ajax({
            method: "POST",
            url: "delete",
            data: { roomTypeId: $("#nodeId").val()},
            dataType: "json",
            success: function(data){
                $('#tree').jstree('delete_node', {"id": data.room_type_id});
                document.getElementById("form1").reset();
                $("#tree-form").hide();
//            $("#form1").reset();
            }

        });
    });

/*$("#address").submit(function(){
    var nodeId = $("#nodeId").val();
    if(nodeId.substr(nodeId.length-1)=='x'){
        document.getElementById('address').action="add";
    }else{
        document.getElementById('address').action="update";
    }
});*/



</script>

</body>
</html>

</body>
</html>

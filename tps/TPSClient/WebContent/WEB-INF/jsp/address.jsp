<%--
  Created by IntelliJ IDEA.
  User: Ganga
  Date: 6/17/2016
  Time: 11:37 AM
  To change this template use File | Settings | File Templates.
--%>
<%@include file="/WEB-INF/includes/header.jsp" %>

<div id="wrapper">
    <%@include file="/WEB-INF/includes/leftNavigation.jsp" %>
    <div id="page-wrapper" class="gray-bg">
        <%@include file="/WEB-INF/includes/topNavigation.jsp" %>

        <link href="${pageContext.request.contextPath}/css/plugins/jsTree/style.min.css" rel="stylesheet">

        <div class="wrapper wrapper-content animated fadeIn">
            <div class="col-lg-6">
                <div id="tree"></div>
            </div>
            <div class="col-lg-6" id="tree-form" style="display: none">
                <form method="post" action="update" class="form-horizontal" id="addressForm">
                   <%-- <div class="form-group"><label class="col-sm-4 control-label">Type</label>
                        <input type="hidden" id="parentId" name="parentAddressId">
                        <input type="hidden" id="addressId" name="addressId">

                        <div class="col-sm-6"><input type="text" class="form-control"
                                                     name="type" id="type"
                                                     readonly></div>
                    </div>--%>
                       <input type="hidden" id="parentId" name="parentAddressId">
                       <input type="hidden" id="addressId" name="addressId">
                       <input type="hidden" id="level" name="level">
                    <div class="form-group"><label class="col-sm-4 control-label">Node Name</label>

                        <div class="col-sm-6"><input type="text" class="form-control" id="addressName"
                                                     name="addressName"
                                                     required></div>
                    </div>
                    <div class="form-group col-sm-6">
                        <div class="col-sm-4 col-sm-offset-2">
                            <%--<button type="submit" class="btn btn-primary" id="update-btn">Update</button>--%>
                                <a id="update-btn" class="btn btn-primary">Update</a>
                        </div>
                        <div class="col-sm-4 col-sm-offset-2">
                            <%--<button class="btn btn-danger" id="delete-btn">Delete</button>--%>
                            <a class="btn btn-danger" id="delete-btn" style="display: none">Delete</a>
                        </div>
                    </div>
                </form>
            </div>
            <div class="clear-fix"></div>

        </div>
    </div>
</div>
<%@include file="/WEB-INF/includes/script.jsp" %>
<script src="${pageContext.request.contextPath}/js/plugins/jsTree/jstree.min.js"></script>
<script src="${pageContext.request.contextPath}/js/plugins/validate/jquery.validate.min.js"></script>
<%--<c:forEach items="${siteContent.js}" var="js">
    <script src="${pageContext.request.contextPath}/js/plugins/${js}"></script>
</c:forEach>--%>
<%--<script src="${pageContext.request.contextPath}/js/jquery-2.1.1.js"></script>--%>
<script type="text/javascript">

    /*jquery form validation*/
    $(function () {
        jQuery.validator.addMethod("alphaNumeric", function (value, element) {
            // return true - means the field passed validation
            // return false - means the field failed validation and it triggers the error
            return this.optional(element) || /^([\w\s]+)$/.test(value);
        }, "Only alphanumeric value and underscore is allowed!");


        $('#addressForm').validate({
            rules: {
                addressName: {
                    required: true,
                    alphaNumeric: true
                }
            }
        });
    });
    <%--console.log(JSON.parse('${tree}'));--%>

    $('#tree').jstree({
        'core': {
            'data': JSON.parse('${tree}'),
            check_callback : true
        }
    });

    $('#tree')
    // listen for event
            .on('changed.jstree', function (e, data) {
                $("#tree-form").show();
                var i, j, r = [];
                console.log(data);
                /*for(i = 0, j = data.selected.length; i < j; i++) {
                 r.push(data.instance.get_node(data.selected[i]).text);

                 }*/
//                console.log(data.inst.get_path().length)
//                $('#type').val(data.node.original.type);
                $('#level').val(data.node.original.level);
                $('#parentId').val(data.node.parent);
                $('#addressName').val(data.node.text);
                $('#addressId').val(data.node.id);
//                $('#delete-btn').attr("href", "delete/" + data.node.id);

                if (data.node.id.indexOf("x") == -1) {

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

//                    $('#delete-btn').attr("href", "delete/" + data.node.id);
                    if (data.node.children.indexOf(data.node.id + 'x') == -1 && data.node.parents.length <= "${level}") {

                         $('#tree').jstree().create_node(data.node.id, {
                            "id": data.node.id + "x",
                            "text": "new Node",
                            "level": data.node.parents.length,
                            "type": data.node.original.type,
                            "parent": data.node.parent
                        }, "last");
                    }
                } else {
                    $('#delete-btn').hide();
                }


                $("#tree").jstree("open_node", data.node);


            })
            // create the instance
            .jstree();


      $('#update-btn').click(function(e){
        e.preventDefault();
        var newTitle = $('#addressName').val();
       $.ajax({
            method: "POST",
            url: "update",
            data: { addressId: $("#addressId").val(), parentAddressId: $("#parentId").val(), level: $("#level").val(), addressName: $('#addressName').val() },
            dataType: "json",
            beforeSend: function(xhr, opts){
                if($("#addressForm").valid()==false){
                    xhr.abort();
                }

                /*alert("test");*/
            },
            success: function(data){
                if($("#addressId").val().indexOf("x")==-1){
                    $('#tree').jstree('rename_node', {"id": data.address_id}, newTitle);
                }else{
                    $('#tree').jstree().create_node($("#parentId").val(), {
                        "id": data.address_id,
                        "text": $('#addressName').val(),
                        "level": $("#level").val(),
                        "parent": $("#parentId").val()
                    }, "last");
                }

//                console.log(data);
            }
        });
    });

    $("#delete-btn").click(function(){
        var newTitle = $('#addressName').val();
        $.ajax({
            method: "POST",
            url: "delete/",
            data: { addressId: $("#addressId").val()},
            dataType: "json",
            success: function(data){
                $('#tree').jstree('delete_node', {"id": data.address_id});
                $("#tree-form").hide();


//                console.log(data);
            }

        });
    });



</script>

</body>
</html>

</body>
</html>

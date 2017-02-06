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
            <div class="col-lg-6" id="tree-form" style="display: none">
                <form method="post" id="form1" class="form-horizontal" enctype="multipart/form-data">

                    <div class="form-group"><label class="col-sm-4 control-label">Description</label>
                        <input type="hidden" id="parentId" name="parentAmenityId">
                        <input type="hidden" id="nodeId" name="amenityId">

                        <div class="col-sm-6" ><input type="text" class="form-control" id="nodeName1"
                                                     name="amenityDesc"
                                                     required></div>
                    </div>
                   <%-- <div class="form-group priority"><label class="col-sm-4 control-label">Web Priority</label>
                        <div class="col-sm-6"><input type="text" class="form-control" id="webPrior"
                                                     name="webPrior"
                        ></div>
                    </div>
                    <div class="form-group priority"><label class="col-sm-4 control-label">Mobile Priority</label>
                        <div class="col-sm-6"><input type="text" class="form-control" id="mobPrior"
                                                     name="mobPrior"
                        ></div>
                    </div>--%>
                    <%--<div class="form-group"><label class="col-sm-4 control-label">Icon Type</label>--%>

                        <%--<div class="col-sm-6">--%>

                            <%--<label>--%>
                                <%--<input type="radio" name="type" id="fontAwesome" value="fontAwesome">--%>
                                <%--Font Awesome Icons--%>
                            <%--</label>--%>

                            <%--<label>--%>
                                <%--<input type="radio" name="type" id="custom" value="custom" >--%>
                                <%--Custom Icons--%>
                            <%--</label></div>--%>
                    <%--</div>--%>
                    <div class="form-group" id="fontAwesome-icon"><label class="col-sm-4 control-label">Icon</label>
                        <div class="col-sm-6"><input type="text" class="form-control" id="icon"
                                                     name="icon"
                        ></div>
                    </div>
                   <%-- <div class="form-group" id="custom-icon"><label class="col-sm-4 control-label">Image</label>
                        <input type="hidden" name="image1" id="image1"/>
                        <div class="col-sm-6"><input type="file" name="image"></div>
                    </div>--%>

                    <div class="form-group col-sm-6">
                        <div class="col-sm-4 col-sm-offset-2">
                            <button type="submit" class="btn btn-primary" formaction="update">Update</button>
                                <%--<a id="update-btn" class="btn btn-primary">Update</a>--%>
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
   /* $("#custom-icon").hide();
    $("#fontAwesome-icon").hide();*/

    $('#icon').iconpicker({
        selected: true,
        hideOnSelect: true,
        icons:$.merge([
                    'tps-ac',
                    'tps-airport',
                    'tps-amenity',
                    'tps-bar',
                    'tps-bath-tub',
                    'tps-bbq',
                    'tps-bus',
                    'tps-carpet',
                    'tps-cd-player',
                    'tps-cloth-rack',
                    'tps-computer',
                    'tps-cycling',
                    'tps-dart',
                    'tps-dive',
                    'tps-food-drink',
                    'tps-free-cancellation',
                    'tps-hair-drier',
                    'tps-hiking',
                    'tps-laptop',
                    'tps-media-technology',
                    'tps-outdoor',
                    'tps-parking',
                    'tps-pay',
                    'tps-restaurant',
                    'tps-slipper',
                    'tps-sofa',
                    'tps-spa',
                    'tps-supper-market',
                    'tps-swim',
                    'tps-taxi',
                    'tps-tennis',
                    'tps-toilet-paper',
                    'tps-wifi'
                ],
                $.iconpicker.defaultOptions.icons),
        fullClassFormat: function(val){
            if(val.match(/^fa-/)){

                return 'fa '+val;
            }else{
                return 'glyphicon '+val;
            }
        }
    });



    /*jquery form validation*/
    $(function () {
        jQuery.validator.addMethod("alphaNumeric", function (value, element) {
            // return true - means the field passed validation
            // return false - means the field failed validation and it triggers the error
            return this.optional(element) || /^([\w\s]+)$/.test(value);
        }, "Only alphanumeric value and underscore is allowed!");


        $('#form1').validate({
            rules: {
                amenityDesc: {
                    required: true,
                    alphaNumeric: true
                }
            }
        });


    });


            $('#tree').jstree({ 'core' : {

       'data' : JSON.parse('${tree}'),
       check_callback : true
   },
           "plugins" : [ "search" ]
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
               if(data.node.parents.length > "${level}"){
                   $(".priority").show();
               }else{
                   $(".priority").hide();
               }
               $('#parentId').val(data.node.parent);
               var textValue = data.node.text;
               $('#nodeName1').val(textValue);
               $('#nodeId').val(data.node.id);
               $("#icon").val(data.node.original.icons);
              /* $("#image1").val(data.node.original.image);
               if(typeof (data.node.original.icons) != 'undefined'){

                   $("#fontAwesome").prop("checked", true);
                   $("#fontAwesome-icon").show();
                   $("#custom-icon").hide();
               }else if(typeof (data.node.original.image) != 'undefined'){
//                   $("#im").val(data.node.original.image);
                   $("#custom").prop("checked", true);
                   $("#custom-icon").show();
                   $("#fontAwesome-icon").hide();
               }else{
                   $("#fontAwesome").prop("checked", false);
                   $("#custom").prop("checked", false);
                   $("#custom-icon").hide();
                   $("#fontAwesome-icon").hide();
               }*/

               /*var web = "";
               var mob = "";
               if(textValue.indexOf('(')==-1){
                   $('#nodeName1').val(textValue);
               }else{
                   $('#nodeName1').val(textValue.substring(0,textValue.indexOf('(')));
                   if(textValue.indexOf('web') > -1){
                       web = textValue.substring(textValue.indexOf('web')+3, textValue.indexOf("-"));
//                       $('#webPrior').val(textValue.substring(textValue.indexOf('web')+3, textValue.indexOf("-")));
                   }
                   if(textValue.indexOf('mob') > -1){
                       mob = textValue.substring(textValue.indexOf('mob')+3, textValue.indexOf(")"));
                   }
               }
               $('#webPrior').val(web);
               $('#mobPrior').val(mob);*/
              /* if(data.node.icon!= true){
                   $("#icon").val(data.node.icon);
               }else
                   $("#icon").val(null);
               $('#nodeId').val(data.node.id);*/
//               $('#delete-btn').attr("href", "delete/"+data.node.id);
console.log(data.node.original.deletedFlag);
               if(data.node.id.indexOf("x") != -1){
                   $('#delete-btn').hide();
               }else{
                   var childrenCount = data.node.children.length;

                   if(childrenCount == 0 && data.node.original.deletedFlag != "U"){
                       $('#delete-btn').show();
                   }else if(childrenCount == 1 && data.node.children[0].indexOf("x") == -1){
                       $('#delete-btn').hide();
                   }else if(childrenCount == 1 && data.node.children[0].indexOf("x") != -1){
                       $('#delete-btn').show();
                   }else if(data.node.original.deletedFlag == "U"){
                       $('#delete-btn').hide();
                   }else{
                       $('#delete-btn').hide();
                   }

//                   $('#delete').attr("href", "delete/"+data.node.id);
                   if(data.node.children.indexOf(data.node.id+'x') == -1 && data.node.parents.length <= "${level}"){
                       $('#tree').jstree().create_node(data.node.id ,  { "id" : data.node.id+"x", "text" : "new Node", "type": data.node.original.type , "parent":data.node.parent}, "last");
                   }
               }
               /*if(data.node.id.indexOf("x")==-1){
                   $('#delete-btn').show();
//                   $('#delete').attr("href", "delete/"+data.node.id);
                   if(data.node.children.indexOf(data.node.id+'x') == -1 && data.node.parents.length <= "${level}"){
                       $('#tree').jstree().create_node(data.node.id ,  { "id" : data.node.id+"x", "text" : "new Node", "type": data.node.original.type , "parent":data.node.parent}, "last");
                   }
               }else{
                   $('#delete-btn').hide();
               }*/
               $("#tree").jstree("open_node", data.node);
           })
           // create the instance
           .jstree();

    $('#tree').on('ready.jstree', function (e, data) {
        if('${id}' != ""){
            $("#tree").jstree('select_node', '${id}');
            $("#tree").jstree('open_node', '${id}')

        }
    }).jstree();


    $('input[name=type]').change(function(){
        x = $(this).val();
        if($(this).val()== 'fontAwesome'){
            $("#fontAwesome-icon").show();
            $("#custom-icon").hide();

        }else{
            $("#fontAwesome-icon").hide();
            $("#custom-icon").show();
        }
    });


$("#delete-btn").click(function(){
    $.ajax({
        method: "POST",
        url: "delete",
        data: { amenityId: $("#nodeId").val()},
        dataType: "json",
        success: function(data){
            $('#tree').jstree('delete_node', {"id": data.amenity_id});
            document.getElementById("form1").reset();
            $("#tree-form").hide();


//                console.log(data);
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

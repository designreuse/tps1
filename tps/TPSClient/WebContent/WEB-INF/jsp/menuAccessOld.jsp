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

        <div class="wrapper wrapper-content animated fadeIn">
            <div class="row">
                <form action="update" method="post" id="form1" class="form-horizontal">

                    <div class="form-group priority"><label class="col-sm-4 control-label">Role</label>


                        <div class="col-sm-6"><select name="role" class="form-control m-b" id="role">
                            <option value="">Select</option>
                            <c:forEach items="${roleList}" var="data">
                                <option value="${data.roleId}">${data.roleDesc}</option>
                            </c:forEach>
                        </select></div>
                    </div>
                    <%--<div class="form-group col-sm-6">
                        <div class="col-sm-4 col-sm-offset-2">
                            &lt;%&ndash;<button type="submit" class="btn btn-primary" id="update-btn">Update</button>&ndash;%&gt;
                                <a id="update-btn" class="btn btn-primary">Update</a>
                        </div>
                        <div class="col-sm-4 col-sm-offset-2">
                            <a class="btn btn-danger" id="delete-btn" style="display: none">Delete</a>
                        </div>
                    </div>--%>
                </form>
            </div>
            <div class="row">
                <table class="table table-striped table-bordered">
                    <thead>
                    <tr>
                        <th>S.No</th>
                        <th>Menu</th>
                        <th>Action</th>
                    </tr>
                    </thead>
                    <tbody id="menuList">

                    </tbody>
                </table>

            </div>

        </div>
    </div>
</div>
<%@include file="/WEB-INF/includes/script.jsp" %>
<script type="text/javascript">
    function checkBox(i){
        var parent=true;
        $(".child"+i).each(function(){
            if(this.checked!=true){
//                alert("test");
                parent=false;
                return;

            }

        });
//        alert(parent);
        $("#parent"+i).prop("checked",parent);
    }


    $("#role").change(function(e){
        var parentCount = 0;
        $("tbody#menuList").empty();
        $.ajax({
            method: "POST",
            url: "menuList",
            data: { roleId: $(this).val()},
            dataType: "json",
            success: function(data){
//                console.log("respones "+ data);

                var tableRow="";
                var i=0;
                var j = 1;

                $.each(data, function () {
                    var checked ="";
                    if(data[i].menuAccessId != null){
                        checked="checked";
                    }

                    if(data[i].menuUrl == null){
                        parentCount++;
                        tableRow = tableRow+'<tr><td colspan="2">'+data[i].menuDesc+'</td>' +
                                '<td><input type="checkbox" name="active" class="i-checks" id="parent'+parentCount+'"></td>'+
                                '</tr>';
                        i++;

                    }else{
                        tableRow=tableRow+'<tr><td>'+j+'</td><td>'+data[i].menuDesc+'</td>' +
                                '<td><input type="checkbox" name="active" class="i-checks active child'+parentCount+'"' +
                                'value="'+i+'" '+ checked+'>'+
                                '<input type="hidden" value="'+data[i].menuId+'" id="menuId'+i+'"><input type="hidden" value="'+data[i].menuAccessId+'" id="menuAccessId'+i+'"></td></tr>';
                        i++;
                        j++;
                    }

                });

                $("tbody#menuList").append(tableRow);

                console.log("ganga");

                for(k = 1;k < parseInt(parentCount);k++){
                    checkBox(k);

                }

            }

        });

        $("[id^='parent']").each(function (element) {
            alert("ganga");

            $(this).click(function () {
                var idName = $(this).attr("id");
                var num = idName.replace(/[^0-9]/g, '');
                $(".child"+num).prop('checked', $(this).prop("checked"));
            });

        });
//        alert(parentCount);
//        var k=0;
//        var x = parentCount;
        /*alert(parentCount);
        console.log(parentCount);*/
//        alert(k);

        e.preventDefault();
    });


    /*$(document).ready(function(){

        alert(parentCount);

        <%--<c:forEach var="i" begin="1" end="${parentCount}">--%>
        for(var k=1;k <= parentCount;k++){
            checkBox(k);
           /!* $("#parent"+k).change(function(){
                $(".child"+k).prop('checked', $(this).prop("checked"));
            });

            checkBox(k);

            $(".child"+k).change(function(){
                checkBox(k);
            });*!/
        }


        <%--</c:forEach>--%>
    });*/

    /*$('tbody').on('click', '.active', function() {
    });*/




    $('tbody').on('click', '.active', function(){
        var active='N';
        if($(this).is(":checked")) {
            active='Y';
        }else{
            active='N';
        }
        var className = $(this).attr("class");
        var num = className.replace(/[^0-9]/g, '');
        var index = $(this).val();
//        alert("ganga");
        $.ajax({
            method: "POST",
            url: "update",
            data: { roleId: $("#role").val(), menuId: $("#menuId"+index).val(), menuAccessId: $("#menuAccessId"+index).val(), active: active},
            dataType: "json",
            success: function(data){
                checkBox(num);
            }

        });
    });
</script>


</body>
</html>



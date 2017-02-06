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

                <table class="table table-striped table-bordered bootstrap-datatable">
                    <thead>
                    <tr>
                        <th rowspan="2">S.N</th>
                        <th colspan="2">Web</th>
                        <th colspan="2"> Mobile</th>
                    </tr>
                    <tr>
                        <th>Activity</th>
                        <th>Amenity</th>
                        <th>Activity</th>
                        <th>Amenity</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="rows" begin="1" end="${size}" varStatus="count">
                        <tr><td>${count.count}<%--<input type="hidden" value="${count.count}" class="priority">--%></td>
                            <td><select name="activityWebPriority" class="form-control m-b" id="activityWebPriority${count.count}"><option value="">Select</option></select></td>
                            <td><select name="amenityWebPriority" class="form-control m-b" id="amenityWebPriority${count.count}"><option value="">Select</option></select></td>
                            <td><select name="activityMobPriority" class="form-control m-b" id="activityMobPriority${count.count}"><option value="">Select</option></select></td>
                            <td><select name="amenityMobPriority" class="form-control m-b" id="amenityMobPriority${count.count}"><option value="">Select</option></select></td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>

        </div>
    </div>
</div>
<%@include file="/WEB-INF/includes/script.jsp" %>
<script type="text/javascript">

   var selectedActivityList = eval('('+'${selectedActivityList}'+')');
    var webActivityList = eval('('+'${webActivityList}'+')');
    var mobActivityList = eval('('+'${mobActivityList}'+')');

   var selectedAmenityList = eval('('+'${selectedAmenityList}'+')');
   var webAmenityList = eval('('+'${webAmenityList}'+')');
   var mobAmenityList = eval('('+'${mobAmenityList}'+')');

   console.log(webAmenityList);

   for(var i=0; i<Object.keys(selectedActivityList).length; i++){
       var option='<option value="'+selectedActivityList[i].activityId+'" selected>'+selectedActivityList[i].activityDesc+'</option>';
       $("#activityWebPriority"+selectedActivityList[i].webPrior).remove;
       $("#activityWebPriority"+selectedActivityList[i].webPrior).append(option);
       $("#activityMobPriority"+selectedActivityList[i].mobPrior).remove;
       $("#activityMobPriority"+selectedActivityList[i].mobPrior).append(option);
       $("#activityWebPriority"+selectedActivityList[i].webPrior).addClass("activityWebSelect");
       $("#activityMobPriority"+selectedActivityList[i].mobPrior).addClass("activityMobSelect");
   }

    $("[id^='activityWebPriority']").each(function (index) {
        var replaceItem;
        $(this).focus(function(){
            var selectedId = $(this).attr("id");
            var selectedValue = $(this).val();
            var selectedText =$("#"+selectedId+" option:selected").text();
           replaceItem= {"activityId":selectedValue, "activityDesc":selectedText};

            $('option', this).not(':selected').remove();
            if($(this).is('.activityWebSelect:last')){
                $("#"+selectedId).prepend('<option value="">Select</option>');
            }
            webActivityOption(selectedId);
        });

        $(this).change(function(){
            var priority = $(this).closest('tr').children('td:first').text();
            var id = $(this).attr("id");
            $.ajax({
                method: "POST",
                url: "update",
                data: { activityId: $(this).val(), priority: priority, type: 'web' },
                dataType: "json",
                success: function(data){
                    console.log(data);

                    if(typeof(data.activity_id)==='undefined'){
                        $("#"+id).removeClass("activityWebSelect");
                    }else{
                        console.log("web");
                        console.log(webActivityList);
                        $("#"+id).addClass("activityWebSelect");

                    }
console.log(replaceItem);
                    searchById(data.activity_id,webActivityList,replaceItem);
                    console.log(webActivityList)


                }
            });
        });
    });

   $("[id^='activityMobPriority']").each(function (index, element) {
       var replaceItem;
       $(this).focus(function(){
           var selectedId = $(this).attr("id");
           var selectedValue = $(this).val();
           var selectedText =$("#"+selectedId+" option:selected").text();
           replaceItem= {"activityId":selectedValue, "activityDesc":selectedText};

           $('option', this).not(':selected').remove();
           if($(this).is('.activityMobSelect:last')){
               $("#"+selectedId).prepend('<option value="">Select</option>');
           }
//           $('option', this).not(':eq(0), :selected').remove();
           mobActivityOption(selectedId);
       });

       $(this).change(function(){
           var priority = $(this).closest('tr').children('td:first').text();
           var id = $(this).attr("id");
//            var x = $(this).parent().sibling().find('.priority').val();
           $.ajax({
               method: "POST",
               url: "update",
               data: { activityId: $(this).val(), priority: priority, type: 'mob' },
               dataType: "json",
               success: function(data){

                   console.log(data);

                   if(typeof(data.activity_id)==='undefined'){
                       $("#"+id).removeClass("activityMobSelect");
                   }else{
                       console.log("mob");
                       console.log(mobActivityList);
                       $("#"+id).addClass("activityMobSelect");

                   }
                   console.log(replaceItem);
                   searchById(data.activity_id,mobActivityList,replaceItem);
                   console.log(mobActivityList)
               }
           });
       });
   });


    function webActivityOption(id){
        var option="";
        for(var j=0; j<Object.keys(webActivityList).length;j++){
            option=option+'<option class="appended" value="'+webActivityList[j].activityId+'">'+webActivityList[j].activityDesc+'</option>';
        }
        $("#"+id).append(option);
    }
   function mobActivityOption(id){
       var option="";
       for(var j=0; j<Object.keys(mobActivityList).length;j++){
           option=option+'<option class="appended" value="'+mobActivityList[j].activityId+'">'+mobActivityList[j].activityDesc+'</option>';
       }
       $("#"+id).append(option);
   }

   function searchById(idValue,list, replacedItem){
       console.log(replacedItem);
       if(typeof(idValue)==="undefined"){
           console.log("undefined");
           list.splice(Object.keys(list).length, 0, replacedItem);
       }
       for(var j=0; j<Object.keys(list).length;j++){

           if(list[j].activityId==idValue && replacedItem.activityId!=""){
               list.splice(j, 1, replacedItem);
           }
           if(list[j].activityId==idValue && replacedItem.activityId==""){

               list.splice(j, 1);
           }

       }
   }

    /*amenity */

   for(i=0; i<Object.keys(selectedAmenityList).length; i++){
//       alert();
       var option='<option value="'+selectedAmenityList[i].amenityId+'" selected>'+selectedAmenityList[i].amenityDesc+'</option>';
       $("#amenityWebPriority"+selectedAmenityList[i].webPrior).remove;
       $("#amenityWebPriority"+selectedAmenityList[i].webPrior).append(option);
       $("#amenityMobPriority"+selectedAmenityList[i].mobPrior).remove;
       $("#amenityMobPriority"+selectedAmenityList[i].mobPrior).append(option);
       $("#amenityWebPriority"+selectedAmenityList[i].webPrior).addClass("amenityWebSelect");
       $("#amenityMobPriority"+selectedAmenityList[i].mobPrior).addClass("amenityMobSelect");
   }

   $("[id^='amenityWebPriority']").each(function (index) {
       var replaceItem;
       $(this).focus(function(){
           var selectedId = $(this).attr("id");
           var selectedValue = $(this).val();
           var selectedText =$("#"+selectedId+" option:selected").text();
           replaceItem= {"amenityId":selectedValue, "amenityDesc":selectedText};

           $('option', this).not(':selected').remove();
           if($(this).is('.amenityWebSelect:last')){
               $("#"+selectedId).prepend('<option value="">Select</option>');
           }
//            $('option', this).not(':eq(0), :selected').remove();
           webAmenityOption(selectedId);
       });


       $(this).change(function(){
           var priority = $(this).closest('tr').children('td:first').text();
           var id = $(this).attr("id");
//            var x = $(this).parent().sibling().find('.priority').val();
           $.ajax({
               method: "POST",
               url: "updateAmenity",
               data: { amenityId: $(this).val(), priority: priority, type: 'web' },
               dataType: "json",
               success: function(data){
                   console.log(data);
                   if(typeof(data.amenity_id)==='undefined'){
                       $("#"+id).removeClass("amenityWebSelect");
                   }else{
                       console.log("mob");
                       console.log(webAmenityList);
                       $("#"+id).addClass("amenityWebSelect");

                   }
                   console.log("ganga"+replaceItem);
                   searchAmenityById(data.amenity_id,webAmenityList,replaceItem);
//                   console.log(webAmenityList);
               }

           });
       });
   });

   $("[id^='amenityMobPriority']").each(function (index, element) {

       $(this).focus(function(){
           var selectedId = $(this).attr("id");
           var selectedValue = $(this).val();
           var selectedText =$("#"+selectedId+" option:selected").text();
           replaceItem= {"amenityId":selectedValue, "amenityDesc":selectedText};
           $('option', this).not(':selected').remove();
           if($(this).is('.amenityMobSelect:last')){
               $("#"+selectedId).prepend('<option value="">Select</option>');
           }
//           $('option', this).not(':eq(0), :selected').remove();
           mobAmenityOption(selectedId);
       });

       $(this).change(function(){
           var priority = $(this).closest('tr').children('td:first').text();
           var id = $(this).attr("id");
//            var x = $(this).parent().sibling().find('.priority').val();
           $.ajax({
               method: "POST",
               url: "updateAmenity",
               data: { amenityId: $(this).val(), priority: priority, type: 'mob' },
               dataType: "json",
               success: function(data){
                   if(typeof(data.amenity_id)==='undefined'){
                       $("#"+id).removeClass("amenityMobSelect");
                   }else{
                       $("#"+id).addClass("amenityMobSelect");

                   }
                   console.log("ganga"+replaceItem);
                   searchAmenityById(data.amenity_id,mobAmenityList,replaceItem);


               }
           });
       });
   });


   function webAmenityOption(id){
       var option="";
       for(var j=0; j<Object.keys(webAmenityList).length;j++){
           option=option+'<option class="appended" value="'+webAmenityList[j].amenityId+'">'+webAmenityList[j].amenityDesc+'</option>';
       }
       $("#"+id).append(option);
   }
   function mobAmenityOption(id){
       var option="";
       for(var j=0; j<Object.keys(mobAmenityList).length;j++){
           option=option+'<option class="appended" value="'+mobAmenityList[j].amenityId+'">'+mobAmenityList[j].amenityDesc+'</option>';
       }
       $("#"+id).append(option);
   }

   function searchAmenityById(idValue,list, replacedItem){
       console.log(replacedItem);
       if(typeof(idValue)==="undefined"){
//           console.log("undefined");
           list.splice(Object.keys(list).length, 0, replacedItem);
       }
       for(var j=0; j<Object.keys(list).length;j++){

           if(list[j].amenityId==idValue && replacedItem.amenityId!=""){
               list.splice(j, 1, replacedItem);
           }
           if(list[j].amenityId==idValue && replacedItem.amenityId==""){

               list.splice(j, 1);
           }

       }
   }
</script>

</body>
</html>



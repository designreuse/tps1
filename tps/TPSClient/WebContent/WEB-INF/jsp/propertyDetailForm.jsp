<c:if test="${mode eq 'view'}">
    <div class="row">
        <c:if test="${sessionScope.get('role')=='[ADMIN]'}"> <a href="add" class="btn btn-primary" id="add" >Add Hotel</a></c:if>

        <div class="row">

            <table class="table table-striped table-bordered bootstrap-datatable datatable" id="hotelDetail">
                <thead>
                <tr>
                    <th>S.N</th>
                    <th>Hotel</th>
                    <%--<th>Type</th>--%>
                    <th>Star Rating</th>
                    <th>Phone No.</th>
                    <th>Address</th>
                    <th>Total Room</th>
                   <c:if test="${sessionScope.get('role')=='[ADMIN]'}"> <th>Active</th></c:if>
                    <th>Action</th>

                </tr>
                </thead>
                <tbody>
                <c:forEach items="${hotelDetailList}" var="data" varStatus="count">
                    <c:if test="${sessionScope.get('role')!='[ADMIN]' && data.active=='Y'}">

                    </c:if>

                    <tr>
                        <td>${count.count}.</td>

                        <td>${data.hotelName}</td>
                        <%--<td>${data.hotelType}</td>--%>
                        <td>${data.starRating}</td>
                        <td>${data.hotelPhNo1}<br>
                                ${data.hotelPhNo2}<br>
                                ${data.hotelPhNo3}</td>
                        <td>${data.streetAddress}</td>
                        <td>${data.totalRoom}</td>
                        <c:if test="${sessionScope.get('role')=='[ADMIN]'}">
                        <td class="active">
                        <c:choose><c:when test="${data.active=='Y'}">Active</c:when><c:when test="${data.active=='N'}">Inactive</c:when></c:choose> </td>
                        </c:if>
                        <td class="center">
                            <c:if test="${sessionScope.get('role')=='[ADMIN]'}"> <a class="btn btn-primary" title="<c:choose><c:when test="${data.active=='Y'}">Active</c:when><c:when test="${data.active=='N'}">Inactive</c:when></c:choose>"
                                                                                         id="checkbox${count.count}"
                                                                                         data-rel="tooltip">
                                <c:choose><c:when test="${data.active=='Y'}"><i class="fa fa-check-square-o" aria-hidden="true"></i>
                                </c:when><c:when test="${data.active=='N'}"><i class="fa fa-square-o" aria-hidden="true"></i>
                                </c:when></c:choose>
                                    <%--<i class="fa fa-edit"></i>--%>
                            </a>
                                <input type="hidden" class="hotelDetailId" value="${data.hotelDetailId}"/>
                            </c:if>


                            <a class="btn btn-info" href="edit/${data.hotelDetailId}" title="Edit"
                               data-rel="tooltip">
                                <i class="fa fa-edit"></i>
                            </a>

                            <a class="open btn btn-danger" title="Delete" data-toggle="modal"
                               data-target="#myModal_del"
                               data-id="${data.hotelDetailId}" data-rel="tooltip">
                                <i class="fa fa-trash"></i>
                            </a>

                            <%--<input type="checkbox" name="active" <c:if test="${data.active=='Y'}">checked</c:if> value="Y" id="checkbox${count.count}">--%>

                        </td>
                    </tr>
                  <%--  <tr class="desc"><td colspan="7">
                        <table>
                            <tr><td>Full name:</td><td>Cedric Kelly</td></tr>
                            <tr><td>Extension number:</td><td>6224</td></tr>
                            <tr><td>Extra info:</td><td>And any further details here</td></tr>
                        </table>
                    </td></tr>--%>


                </c:forEach>


                </tbody>
            </table>
        </div>
    </div>
</c:if>
    <c:if test="${mode eq 'update'}">
        <div class="row">
                <form class="form-horizontal" method="post" action="<c:choose><c:when test="${base!=null}">update</c:when><c:otherwise>hotelDetail/update</c:otherwise></c:choose> " id="propertyDetailForm">
                    <input type="hidden" name="tokenId"
                           value="${hotelDetailMap.tokenId}">

                    <input type="hidden" name="hotelDetailId"
                           value="${hotelDetailMap.hotelDetailId}">

                    <input type="hidden" name="step"
                    <c:if test="${sessionScope.get('token')!=null}"> value="1" </c:if> >

                    <div class="form-group"><label class="col-sm-2 control-label">Hotel Name</label>

                        <div class="col-sm-3"><input type="text" class="form-control"
                                                     placeholder="Hotel Name" name="hotelName"
                                                     value="${hotelDetailMap.hotelName}" required>

                        </div>

                    </div>
                    <div class="hr-line-dashed"></div>
                    <div class="form-group"><label class="col-sm-2 control-label">Star
                        Rating</label>

                        <div class="col-sm-3">
                            <select name="starRating" class="form-control m-b" required>
                                <option <c:if test="${hotelDetailMap.starRating=='1'}"> selected </c:if> value="1">*</option>
                                <option <c:if test="${hotelDetailMap.starRating=='2'}"> selected </c:if> value="2">* *</option>
                                <option <c:if test="${hotelDetailMap.starRating=='3'}"> selected </c:if> value="3">* * *</option>
                                <option <c:if test="${hotelDetailMap.starRating=='4'}"> selected </c:if> value="4">* * * *</option>
                                <option <c:if test="${hotelDetailMap.starRating=='5'}"> selected </c:if> value="5">* * * * *</option>
                                <option <c:if test="${hotelDetailMap.starRating=='0'}"> selected </c:if> value="0">No Rating</option>

                            </select></div>
                            <%--<input type="text" class="form-control"
                                                     placeholder="Star Rating" name="starRating"
                                                     value="${hotelDetailMap.starRating}"></div>--%>
                    </div>
                    <div class="hr-line-dashed"></div>

                    <%--<div class="form-group"><label class="col-sm-2 control-label">Hotel Type</label>

                        <div class="col-sm-3">
                            <select name="hotelType" class="form-control m-b" required>
                                <option <c:if test="${hotelDetailMap.starRating=='1'}"> selected </c:if> value="1">Standard</option>
                                <option <c:if test="${hotelDetailMap.starRating=='2'}"> selected </c:if> value="2">Budget</option>
                                <option <c:if test="${hotelDetailMap.starRating=='3'}"> selected </c:if> value="3">Delux</option>

                            </select></div>
                            &lt;%&ndash;<input type="text" class="form-control"
                                                     placeholder="Star Rating" name="starRating"
                                                     value="${hotelDetailMap.starRating}"></div>&ndash;%&gt;
                    </div>
                    <div class="hr-line-dashed"></div>--%>

                    <div class="form-group"><label class="col-sm-2 control-label">Phone
                        Number</label>

                        <div id="phoneNo" class="phoneNo col-sm-10">
                            <div class="phone-input col-sm-3">
                                <input type="text" class="form-control hotelPhone" placeholder="Phone Number" name="hotelPhNo1"
                                       value="${hotelDetailMap.hotelPhNo1}" required>
                                <c:if test="${hotelDetailMap.hotelPhNo2!=null}">
                                    <input type="text" class="form-control hotelPhone" placeholder="Phone Number"
                                           name="hotelPhNo2" value="${hotelDetailMap.hotelPhNo2}" required>
                                </c:if>
                                <c:if test="${hotelDetailMap.hotelPhNo3!=null}">
                                    <input type="text" class="form-control hotelPhone" placeholder="Phone Number"
                                           name="hotelPhNo3" value="${hotelDetailMap.hotelPhNo3}" required>
                                </c:if>
                            </div>
                            <div class="col-sm-3">
                                <button value="Add" class="add">
                                    <i class="fa fa-plus"></i>
                                </button>

                                <button value="Remove" class="removeRow">
                                    <i class="fa fa-minus"></i>
                                </button>
                            </div>




                        </div>
                    </div>
                    <div class="hr-line-dashed"></div>
                    <div class="form-group"><label class="col-sm-2 control-label">Postal Code</label>

                        <div class="col-sm-3"><input type="text" class="form-control"
                                                     placeholder="Zip Code" name="zipCode"
                                                     value="${hotelDetailMap.zipCode}" required></div>
                    </div>
                    <div class="hr-line-dashed"></div>

                    <div class="form-group" id="parentAddress"><label class="col-sm-2 control-label">Address</label>
                        <c:set var="i" value="${fn:length(keyList)-1}"/>
                        <div class="col-sm-10">
                            <div class="col-sm-2"><small>Country</small>
                                <select name="country" class="form-control m-b" required id="country">
                                        <%--<option value="">Select</option>--%>
                                    <c:forEach items="${countryList}" var="country">
                                        <option value="${country.addressId}" <c:if test="${country.addressId==addressIdList[i]}">selected</c:if>>${country.addressName}</option>
                                    </c:forEach>
                                </select>
                            </div>

                            <c:forEach items="${keyList}" var="keyValue" varStatus="index">
                                <%--<c:out value="${keyList[i]}"/>--%>
                                <c:choose><c:when test="${keyList[i]== 'DEVELOPMENT_REGION'}"><c:set var="key" value="Development Region"/></c:when>
                                    <c:when test="${keyList[i]== 'ZONE'}"><c:set var="key" value="Zone"/></c:when>
                                    <c:when test="${keyList[i]== 'DISTRICT'}"><c:set var="key" value="District"/></c:when>
                                    <c:when test="${keyList[i]== 'CITY'}"><c:set var="key" value="City"/></c:when>
                                    <c:when test="${keyList[i]== 'AREA'}"><c:set var="key" value="Area"/></c:when></c:choose>
                                <div class="col-sm-2 addres"><small>${key}</small><select <c:if test="${index.count eq 5}"> name="addressId" </c:if> class="form-control m-b" required id="address${index.count}">
                                    <option value="">Select</option>
                                    <c:forEach items="${addressList[keyList[i]]}" var="value">
                                        <option value="${value.addressId}" class="appendedField" <c:if test="${value.addressId==addressIdList[i]}">selected</c:if> >${value.addressName}</option>
                                    </c:forEach>
                                </select></div>
                                <c:set var="i" value="${i-1}"/>
                            </c:forEach>
                            <c:if test="${fn:length(keyList)==1}">
                                <div class="col-sm-2 addres"><small>Zone</small><select class="form-control m-b" required id="address2">
                                    <option value="">Select</option>
                                </select></div>
                                <div class="col-sm-2 addres"><small>District</small><select class="form-control m-b" required id="address3">
                                    <option value="">Select</option>
                                </select></div>
                                <div class="col-sm-2 addres"><small>City</small><select class="form-control m-b" required id="address4">
                                    <option value="">Select</option>
                                </select></div>
                                <div class="col-sm-2 addres"><small>Area</small><select class="form-control m-b" required id="address5" name="addressId">
                                <option value="">Select</option>
                            </select></div>
                            </c:if>


                            <div class="col-sm-2" id="streetAddress"><small>Street Address</small><input type="text" class="form-control"
                                                                                                         placeholder="Street Address" name="streetAddress"
                                                                                                         value="${hotelDetailMap.streetAddress}" required></div>
                            <input type="hidden" name="lat" id="latitude" value="${hotelDetailMap.lat}">
                            <input type="hidden" name="lng" id="longitude" value="${hotelDetailMap.lng}">
                        </div>
                    </div>
                    <div class="hr-line-dashed"></div>
                        <%--<div class="form-group"><label class="col-sm-2 control-label">Latitude-Longitude</label>

                            <div class="col-sm-3"><input type="url" class="form-control"
                                                         placeholder="La" name="url"
                                                         value="${hotelDetailMap.url}" required></div>
                        </div>
                        <div class="hr-line-dashed"></div>--%>

                    <div class="form-group"><label class="col-sm-2 control-label">Website</label>

                        <div class="col-sm-3"><input type="url" class="form-control"
                                                     placeholder="Website Url" name="url"
                                                     value="${hotelDetailMap.url}" required></div>
                    </div>
                    <div class="hr-line-dashed"></div>

                    <div class="form-group"><label class="col-sm-2 control-label">Number of
                        Rooms</label>

                        <div class="col-sm-3"><input type="text" class="form-control"
                                                     placeholder="Number of Rooms"
                                                     name="totalRoom"
                                                     value="${hotelDetailMap.totalRoom}" required></div>
                    </div>
                    <div class="hr-line-dashed"></div>


                    <div class="form-group"><label class="col-sm-2 control-label">Description</label>
                        <div class="col-sm-10">
                            <textarea class="summernote" name="description" id="description">${hotelDetailMap.description}</textarea>
                            <%--<div class="summernote">
                                <h3>Lorem Ipsum is simply</h3>
                                dummy text of the printing and typesetting industry. <strong>Lorem Ipsum has been the industry's</strong> standard dummy text ever since the 1500s,
                                when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic
                                typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with
                                <br/>
                                <br/>
                                <ul>
                                    <li>Remaining essentially unchanged</li>
                                    <li>Make a type specimen book</li>
                                    <li>Unknown printer</li>
                                </ul>
                            </div>--%>
                        </div>

                    </div>
                    <div class="hr-line-dashed"></div>




                    <div id="map">

                    </div>
                    <div class="form-group">
                        <div class="col-sm-4 col-sm-offset-2">
                                <%--<button type="reset" class="btn btn-white">Reset</button>--%>
                            <button type="submit" class="btn btn-primary">Update</button>

                        </div>
                    </div>
                </form>
            </div>

    </c:if>

        <%@include file="/WEB-INF/includes/script.jsp"%>

        <%--property Detail--%>
        <script type="text/javascript">

            /*$('.desc').hide();
            // Add event listener for opening and closing details
            $('#hotelDetail tbody').on('click', 'td', function () {
                var tr = $(this).parent().next('tr');
                alert(tr.is(":visible"));
                if(tr.is(":visible")){
                    tr.hide();
                }else{
                    tr.show();
                }
                /!*var getRow = table.row( tr );

                if ( getRow.child.isShown() ) {
                    // This row is already open - close it
                    getRow.child.hide();
                    tr.removeClass('shown');
                }
                else {
                    // Open this row
                    getRow.child( format(row.data()) ).show();
                    tr.addClass('shown');
                }*!/
            } );*/
            $(document).ready(function () {

                var max_fields = 3; //maximum input boxes allowed
                var wrapper = $(".phoneNo"); //Fields wrapper
                var add_button = $(".add"); //Add button ID

//			    var x = 1; //initlal text box count
                var x = $('.hotelPhone').length;

                if (x > 1) {
                    $('.removeRow').show();
                } else {
                    $('.removeRow').hide();
                }

                $(add_button).click(function (e) { //on add input button click

                    e.preventDefault();
                    if (x < max_fields) { //max input box allowed

                        x++; //text box increment

                        $('.phone-input').append('<input type="text" class="form-control hotelPhone" placeholder="Phone Number" name="hotelPhNo' + x + '" required>')

                        if (x > 1) {
                            $('.removeRow').show();
                        } else {
                            $('.removeRow').hide();
                        }
                    }
                });

                $(wrapper).on("click", ".removeRow", function (e) { //user click on remove text

                    e.preventDefault();
                    if (x > 1) {
                        $(".hotelPhone").last().remove();
                    }

//                $(this).parent('div').parent('div').remove();
                    x--;
                    if (x > 1) {
                        $('.removeRow').show();
                    } else {
                        $('.removeRow').hide();
                    }

                });


            });

            var areaId = "${hotelDetailMap.addressId}";

           $("#country").change(function(){
                $('#region').find('.appendedRegion').remove();
                $('#area').find('.appendedArea').remove();
                if($(this).val()){
                    $.ajax({
                        method: "POST",
                        url: "getChild",
                        data: { countryId: $(this).val() },

                        dataType: "json",

                        success: function(data){
                            var i =0;
                            var optionList = "";

                            $.each(data, function () {
                                optionList=optionList+'<option value="'+data[i].regionId+'" class="appendedRegion">'+data[i].regionName +'</option>';
                                i++;

                            });
                            $('#region').append(optionList);
                        }
                    });
                }

            });

            $("[id^=address]").each(function () {

               changeFunction($(this));
            });

            function changeFunction(element){
                $(element).change(function(e){
                    e.preventDefault();
                    var elementId = $(this).attr("id");
                    var subId = elementId.substr(elementId.length-1);
                    subId = parseInt(subId)+1;

                    if( typeof $("#address"+subId).attr("id")== 'undefined'){

                        var elementValue = $(this).val();
                        $.ajax({
                            method: "POST",
                            url: "getChild",
                            data: { parentAddressId: elementValue },
                            dataType: "json",
                            success: function(data){
                                console.log(data);
                                console.log("length"+data.length);

                                var i =0;
                                var optionList = "";
                                /*$('#parentAddress').append(' <div class="col-sm-2 addres"><small>'+data[i].type+'</small><select name="areaId" class="form-control m-b" required id="address'+subId+'">'+
                                 '<option value="">Select</option>'+
                                 '  </select></div>');*/
                                if(data.length>0){
                                    $(' <div class="col-sm-2 addres"><small>'+data[i].type+'</small><select class="form-control m-b" required id="address'+subId+'">'+
                                            '<option value="">Select</option>'+
                                            '  </select></div>').insertBefore('#streetAddress');
                                    $.each(data, function () {
                                        optionList=optionList+'<option value="'+data[i].addressId+'" class="appendedField">'+data[i].addressName +'</option>';
                                        i++;

                                    });
                                    /* subId=subId+1;*/

                                    $('#address'+subId).append(optionList);
                                    changeFunction("#address"+subId);
                                }else{
                                    $("[id^=address]").each(function () {
                                        $(this).removeAttr('name');
                                    });
                                    $('#'+elementId).attr('name','addressId');
                                   /* alert($('#'+elementId).val());
                                    codeAddress( $('#'+elementId).val());*/

                                }

                            }
                        });


                    }else{
                        var elementValue = $(this).val();
                        $(this).parent().nextAll('.addres').children('select').find('.appendedField').remove();
//                        $(this).find('#address'+subId).find('.appendedRegion').remove();
                        $.ajax({
                            method: "POST",
                            url: "getChild",
                            data: { parentAddressId: elementValue },
                            dataType: "json",
                            success: function(data){

                                var i =0;
                                var optionList = "";
                                $.each(data, function () {
                                    optionList=optionList+'<option value="'+data[i].addressId+'" class="appendedField">'+data[i].addressName +'</option>';
                                    i++;

                                });
                                /* subId=subId+1;*/

                                $('#address'+subId).append(optionList);
                            }
                        });
                    }


                });

            }

            $("[id^='checkbox']").each(function () {

                $(this).click(function(){
                    var hotelDetailId = $(this).next('.hotelDetailId').val();
                    var active='Y';
                    var elementId = $(this).attr("id");
                   /* if($(this).is(":checked")){
                        active='Y'
                    }*/
                    if($(this).attr('title')=='Active'){
                        active='N';
                    }
                    $.ajax({
                        method: "POST",
                        url: "activate",
                        data: { hotelDetailId: hotelDetailId, active: active},
                        dataType: "json",
                        success: function(data){
                            if(active=='Y'){
                                $("#"+elementId).attr('title','Active');
                                $("#"+elementId).find('i').toggleClass('fa fa-check-square-o fa fa-square-o');
                                $("#"+elementId).parent().prev('td').html('Active');
//                                $("#"+elementId).text('<i class="fa fa-check-square-o" aria-hidden="true"></i>');
//                                $("#"+elementId).text('Active');
                            }else{
                                $("#"+elementId).attr('title','Inactive');
                                $("#"+elementId).find('i').toggleClass('fa fa-check-square-o fa fa-square-o');
                                $("#"+elementId).parent().prev('td').html('Inactive');
//                                $("#"+elementId).text('<i class="fa fa-square-o" aria-hidden="true"></i>');
//                                $("#"+elementId).text('Inactive');
                            }

                            console.log(data);

                        }
                    });
                });

            });



        </script>
    <c:if test="${mode != 'view'}">
        <script>
            $(document).ready(function(){

                $('.summernote').summernote();

              /*  var aHTML = $('.summernote').code();
                alert(aHTML.length);*/

            });
            var markers =[];
            var latitude = Number("${hotelDetailMap.lat}");
            var longitude = Number("${hotelDetailMap.lng}");
            var zoomValue = 13;
            if(latitude==0|| longitude==0){
                $("#latitude").val('28.3949');
                $('#longitude').val('84.1240');
                latitude =28.3949;
                longitude = 84.1240;
                zoomValue = 8;
            }

            function initMap() {

                var mapDiv = document.getElementById('map');
                var map = new google.maps.Map(mapDiv, {
                    center: {lat: latitude, lng: longitude},
                    zoom: zoomValue
                });
//            var latlng = {lat: latitude, lng: longitude};
                var marker = new google.maps.Marker({
                    position: {lat: latitude, lng: longitude},
                    map: map
                });


                markers.push(marker);

                var geocoder = new google.maps.Geocoder;
                map.addListener('click', function(e) {
                    placeMarkerAndPanTo(e.latLng, map);
//                geocodeLatLng(geocoder, map, e.latLng, infowindow);

                });

                document.getElementById('address5').addEventListener('change', function() {
                    var address =$("#address5 option:selected").text();
                    address = address+","+$("#address4 option:selected").text();

                    codeAddress(address,geocoder, map);
                });

                if(map.getZoom()<13){
                    map.setZoom(13);
                }




            }

            function geocodeLatLng(geocoder, map, latlng, infowindow) {
                /*var input = document.getElementById('latlng').value;
                 var latlngStr = input.split(',', 2);
                 var latlng = {lat: parseFloat(latlngStr[0]), lng: parseFloat(latlngStr[1])};*/
                geocoder.geocode({'location': latlng}, function (results, status) {
                    if (status === google.maps.GeocoderStatus.OK) {
                        if (results[1]) {
//                        map.setZoom(11);
                            for (var i = 0; i < markers.length; i++) {
                                markers[i].setMap(null);
                            }

                            var marker = new google.maps.Marker({
                                position: latlng,
                                map: map
                            });
                            markers.push(marker);

                            console.log(results[1]);
                            infowindow.setContent(results[1].formatted_address);
                            infowindow.open(map, marker);
                        } else {
                            console.log('No results found');
                        }
                    } else {
                        console.log('Geocoder failed due to: ' + status);
                    }
                });
            }

            function placeMarkerAndPanTo(latLng, map) {
                /* var marker = new google.maps.Marker();
                 marker.setMap(null);*/


                for (var i = 0; i < markers.length; i++) {
                    markers[i].setMap(null);
                }

                var marker = new google.maps.Marker({
                    position: latLng,
                    map: map
                });
                map.setCenter(latLng);

                markers.push(marker);
                console.log(marker);
                $("#latitude").val(latLng.lat());
                $("#longitude").val(latLng.lng());
//            map.panTo(latLng);
            }

            function codeAddress(address, geocoder, map) {
//    var geocoder = new google.maps.Geocoder;
//    var address = document.getElementById('address').value;
                geocoder.geocode( { 'address': address}, function(results, status) {
                    if (status == google.maps.GeocoderStatus.OK) {
                        console.log(results[0]);
                        /* map.setCenter(results[0].geometry.location);
                         map.setZoom(13);*/
                        for (var i = 0; i < markers.length; i++) {
                            markers[i].setMap(null);
                        }
                        var marker = new google.maps.Marker({
                            map: map,
                            position: results[0].geometry.location
                        });
                        map.setCenter(results[0].geometry.location);
                        $("#latitude").val(results[0].geometry.location.lat());
                        $("#longitude").val(results[0].geometry.location.lng());
                        markers.push(marker);
                    } else {
                        console.log('Geocode was not successful for the following reason: ' + status);
                    }
                });
            }

        </script>
        <script async defer
                src="https://maps.googleapis.com/maps/api/js?key=AIzaSyD8U7vAY3_TcAyfwZ0hzWkK-ZGvV7An-24&callback=initMap">
        </script>
    </c:if>
    <script type="text/javascript">
        $(function () {
            jQuery.validator.addMethod("alphaNumeric", function (value, element) {
                // return true - means the field passed validation
                // return false - means the field failed validation and it triggers the error
                return this.optional(element) || /^([\w\s]+)$/.test(value);
            }, "Only alphanumeric value and underscore is allowed!");


            $('#propertyDetailForm').validate({
                ignore: ':hidden:not("#description")',
                errorPlacement: function( label, element ) {
                    element.parent().append( label );

                },
                rules: {
                    hotelName: {
                        required: true,
                        alphaNumeric: true
                    },
                    starRating:{
                        required: true
                    },
                    hotelType:{
                        required: true
                    },
                    hotelPhNo1:{
                        required: true,
                        maxlength: 15
                    },
                    hotelPhNo2:{
                        required: true,
                        maxlength: 15
                    },
                    hotelPhNo3:{
                        required: true,
                        maxlength: 15
                    },
                    postalCode:{
                        required: true
                    },
                    addressId:{
                        required: true
                    },
                    streeAddress:{
                        required: true
                    },
                    webSite:{
                        required: true
                    },
                    noOfRooms:{
                        required: true,
                        number: true
                    },
                    description:{
                        required: true,
                        minlength:100,
                        maxlength: 8000
                    }

                },
                messages: {
                    description: {
                        required: "This field is required.",
                        minlength: "This field is required."
                    }
                }

                });
        });
    </script>

<!DOCTYPE html>
<html>
<head>
    <title>Geocoding service</title>
    <meta name="viewport" content="initial-scale=1.0, user-scalable=no">
    <meta charset="utf-8">
    <style>
        html, body {
            height: 100%;
            margin: 0;
            padding: 0;
        }
        #map {
            height: 100%;
        }
        #floating-panel {
            position: absolute;
            top: 10px;
            left: 25%;
            z-index: 5;
            background-color: #fff;
            padding: 5px;
            border: 1px solid #999;
            text-align: center;
            font-family: 'Roboto','sans-serif';
            line-height: 30px;
            padding-left: 10px;
        }
    </style>
    <%@include file="/WEB-INF/includes/styling.jsp"%>
</head>
<body>
<%--<div id="floating-panel">
    <input id="address" type="textbox" value="Sydney, NSW">
    <input id="submit" type="button" value="Geocode">
</div>--%>

<div class="col-sm-6">
    <input id="address" type="textbox" value="">
    <input id="submit" type="button" value="Geocode">
    <table id="distance">
        <tr> <th colspan="2">Food</th>
            <th colspan="2">Travel</th>
            <th colspan="2">Food</th></tr>
    </table>

</div>
<div id="map" class="col-sm-6"></div>
<%@include file="/WEB-INF/includes/script.jsp"%>

<script type="text/javascript" src="https://maps.googleapis.com/maps/api/js?key=AIzaSyD8U7vAY3_TcAyfwZ0hzWkK-ZGvV7An-24&libraries=places"></script>
<script>



    function initialize() {
        var pyrmont = new google.maps.LatLng(27.72150, 85.32008);


        var map = new google.maps.Map(document.getElementById('map'), {
            center: pyrmont,
            zoom: 15
//            scrollwheel: false
        });

        var geocoder = new google.maps.Geocoder();

        document.getElementById('submit').addEventListener('click', function() {
            var x = geocodeAddress(geocoder, map);




        });


            // Specify location, radius and place types for your Places API search.


        // Create the PlaceService and send the request.
        // Handle the callback with an anonymous function.

    }

    // Run the initialize function when the window has finished loading.
    google.maps.event.addDomListener(window, 'load', initialize);

    function geocodeAddress(geocoder, resultsMap) {
        var address = document.getElementById('address').value;
        geocoder.geocode({'address': address}, function(results, status) {
            if (status === google.maps.GeocoderStatus.OK) {
                resultsMap.setCenter(results[0].geometry.location);
                var marker = new google.maps.Marker({
                    map: resultsMap,
                    position: results[0].geometry.location
                });
                var loc = results[0].geometry.location;
                nearBySearch(results[0].geometry.location,resultsMap);
            } else {
                alert('Geocode was not successful for the following reason: ' + status);
            }
        });
    }

    function nearBySearch(pyrmont, resultsMap) {
        var type = ['store','food','bus_station','taxi_stand'];
        for(var i=0;i<type.length;i++){
            var request = {
                location: pyrmont,
                radius: '500',
                types: [type[i]]
            };
            var service = new google.maps.places.PlacesService(resultsMap);
            service.nearbySearch(request, function(results, status) {
                if (status == google.maps.places.PlacesServiceStatus.OK) {
                    for (var i = 0; i < results.length; i++) {
                        var place = results[i];
                        // If the request succeeds, draw the place location on
                        // the map as a marker, and register an event to handle a
                        // click on the marker.
                        /* var marker = new google.maps.Marker({
                         map: resultsMap,
                         position: place.geometry.location
                         });*/
//                    alert(place.types.indexOf('food'));
                        var restroName = '';
                        var storeName = '';
                        var transportName = '';
                        if(place.types.indexOf('food') !=-1){
                            restroName = '<td>'+place.name+'</td><td>distance</td>' ;
//                            $( "#food" ).append( name );
                        }
                        if(place.types.indexOf('store') !=-1){
                            storeName = '<td>'+place.name+'</td><td>distance</td>' ;
//                            $( "#market" ).append( name );
                        }
                        if(place.types.indexOf('bus_station') !=-1 || place.types.indexOf('taxi_stand') !=-1){
                            transportName = '<td>'+place.name+'</td><td>distance</td>' ;
//                            $( "#travel" ).append( name );
                        }

                        var appendText = '<tr>'.concat(restroName, storeName, transportName,'</tr>');
                        $( "#distance" ).append( appendText );

                    }
                }
            });
        }

    }


</script>
<%--<script async defer
        src="https://maps.googleapis.com/maps/api/js?key=AIzaSyD8U7vAY3_TcAyfwZ0hzWkK-ZGvV7An-24&callback=initMap">
</script>--%>

</body>
</html>
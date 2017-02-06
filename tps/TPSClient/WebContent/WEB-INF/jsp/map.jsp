<!DOCTYPE html>
<html>
<head>
    <script
            src="http://maps.googleapis.com/maps/api/js">
    </script>

    <script>
        var map;
        var myCenter=new google.maps.LatLng(28.394857,84.124008);

        function initialize()
        {
            var mapProp = {
                center:myCenter,
                zoom:5,
                mapTypeId:google.maps.MapTypeId.ROADMAP
            };

            map = new google.maps.Map(document.getElementById("googleMap"),mapProp);

            google.maps.event.addListener(map, 'click', function(event) {
                document.getElementById('lat').value = event.latLng.lat();
                document.getElementById('lng').value = event.latLng.lng();
                placeMarker(event.latLng);
            });
        }

        function placeMarker(location) {


            var marker = new google.maps.Marker({
                position: location,
                map: map,
            });
            var infowindow = new google.maps.InfoWindow({
                content: 'Latitude: ' + location.lat() + '<br>Longitude: ' + location.lng()
            });
            infowindow.open(map,marker);
        }

        google.maps.event.addDomListener(window, 'load', initialize);
    </script>
</head>

<body>
<div id="googleMap" style="width:500px;height:380px;"></div>
<form method="post" action="hotelDetail/geoCode">
    <input type="hidden" name="lat" id="lat"/>
    <input type="hidden" name="lng" id="lng"/>
    <input type="submit" value="Save">
</form>

</body>
</html>

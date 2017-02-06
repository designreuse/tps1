/**
 * Created by Ganga on 6/10/2016.
 */
    function dropzoneImage(jsonUrl, id, imageBaseUrl, dropzoneContainerId, imageContainerId) {
    var baseUrl = imageBaseUrl.concat(id);

    new Dropzone(
        dropzoneContainerId, //id of drop zone element 1
        {
            url: jsonUrl.saveUrl,
            previewTemplate: document.querySelector('#preview-template').innerHTML,
            //            previewsContainer: '#hotel-previewContainer',
            autoProcessQueue: true,
            uploadMultiple: true,
            maxFilesize: 5, // MB
            parallelUploads: 100,
            maxFiles: 100,
            addRemoveLinks: true,
//                    previewsContainer : ".dropzone-previews",
//                                        acceptedFiles: ".png, .jpg",
//            acceptedFiles: "image/*",
            acceptedFiles: ".jpeg,.jpg,.png",
            /*accept: function(file, done) {

                if (file.width < 530 || file.height < 830) {
                    done("Invalid dimensions!");
                }
                else { done(); }
            },*/
            accept: function(file, done) {
                file.acceptDimensions =function() { done(); };
                file.rejectDimensions = function() { done("Invalid dimension. Min Image dimention is 830 X 530"); };
                // Of course you could also just put the `done` function in the file
                // and call it either with or without error in the `thumbnail` event
                // callback, but I think that this is cleaner.
            },



            // Dropzone settings
            init: function () {
                var myDropzone = this;

                $('#imageSubmit').on("click", function (e) {
                    e.preventDefault();
                    myDropzone.processQueue();
                });

                $.getJSON(jsonUrl.getUrl).done(function (data) {
                    if (data.Data != '') {
                        $.each(data, function (key, value) {
                            //// Create the mock file:
                            var mockFile = {
                                name: value.fileName,
                                size: 12345
                            };

                            // Call the default addedfile event handler
                            myDropzone.emit("addedfile", mockFile);
                            // And optionally show the thumbnail of the file:
                            myDropzone.emit("thumbnail", mockFile, imageBaseUrl + value.imageUrl);

                            var thumbnail1 ='';
                            var caption = '';
                            if(value.thumbnail=='Y'){
                                thumbnail1= 'checked';
                            }
                            if(value.caption!=undefined){
                                caption = value.caption;
                            }
                            var passId = null;
                            if(value.hasOwnProperty('hotelImageId')){
                                passId=value.hotelImageId;
                            }else{
                                passId=value.roomImageId;
                            }

                            $(mockFile.previewTemplate).append('<div class="custom-field"><input type="text" placeholder="caption" class="caption" value="' + caption + '"><br>'+
                                '<input type="radio" name="thumbnail" class="thumbnail"'+thumbnail1+' id="thumbnail'+passId+'" ></div>');
                            $(mockFile.previewTemplate).append('<span class="server_file" style="display: none">' + passId + '</span>');
                            $(mockFile.previewTemplate).children('.dz-details').wrap('<a data-gallery="'+imageContainerId+'" href="'+imageBaseUrl.concat(value.imageUrl)+'" class="image"></a>');
//
                        });
                    }
                    //                    $(file.previewTemplate).append('<span class="server_file" >'+value.imageUrl+'</span>');

                });

                $(dropzoneContainerId).on('focusout', 'input.caption', function() {

                    var caption = $(this).val();
                    var imageId = $(this).parent().parent().find('.server_file').text();

                    $.post(jsonUrl.captionUpdate,{imageId: imageId, caption: caption});
                });

                $(dropzoneContainerId).on('click', 'input.thumbnail', function() {

                    var imageId = $(this).parent().parent().find('.server_file').text();

                    $.post(jsonUrl.thumbnailUpdate,{imageId: imageId, id: id});
                });

                this.on("thumbnail", function(file) {
                    // Do the dimension checks you want to do
                    if(typeof(file.width) !== 'undefined' && typeof(file.height) !== 'undefined'){
                        if (file.width < 230 || file.height < 130) {

                            file.rejectDimensions()
                        }
                        else {
                            file.acceptDimensions();
                        }
                    }

                });

                this.on("successmultiple", function (files, response) {


                    var i = 0;
                    $.each(files, function () {

                        var thumbnail1 ='';
                        var caption = '';
                        if(response[i].thumbnail=='Y'){
                            thumbnail1= 'checked';
                        }
                        if(response[i].caption!=undefined){
                            caption = response[i].ID.caption;
                        }


                        $(files[i].previewTemplate).append('<div class="custom-field"><input type="text" placeholder="caption" class="caption" value="' + caption + '"><br>'+
                            '<input type="radio" name="thumbnail" class="thumbnail"'+thumbnail1+' id="thumbnail'+response[i].ID+'"></div>');
                        $(files[i].previewTemplate).append('<span class="server_file" style="display: none">' + response[i].ID + '</span>');
                        $(files[i].previewTemplate).children('.dz-details').wrap('<a data-gallery="'+imageContainerId+'" href="'+baseUrl+'/'+response[i].file_name+'" ></a>');

//                                    $(files[i].previewTemplate).append('<span class="server_file" style="display: none">' + response[i].ID + '</span>');
                        i++;

                    });

                });
                this.on("errormultiple", function (files, response) {
                     var i = 0;
                  /*  var err = eval("(" + xhr.responseText + ")");
                    alert(err.Message);*/
                   /* var responsetext = JSON.parse(files[0].xhr.responseText);
                    console.log(responsetext.data.name);*/
                    $.each(files, function () {
                        console.log(response);
                        var i=0;
                        $.each(files, function () {
                            if(files[i].xhr != null){


                                console.log(files[i].xhr.statusText);
                                $(files[i].previewElement).find('.dz-error-message').text(files[i].xhr.statusText);
                                console.log(files[i]);
                            }
                            i++;
                        });




                    });
                    console.log(files);
                    console.log(response);
                });
                this.on("success", function (file, response) {
                    console.log(file);
//                            $.each(response, function(key,value) {
//                                $(file.previewTemplate).append('<span class="server_file">'+value.ID+'</span>');
//                            });
                });


                this.on("removedfile", function (file) {

                    var server_file = $(file.previewTemplate).children('.server_file').text();
                    //                    alert(server_file);


                    // Do a post request and pass this path and use server-side language to delete the file
                    $.post(jsonUrl.deleteUrl, {file_to_be_deleted: server_file, id: id}).done(function(response){
                        var thumbnailId = response.thumbnailId;
                        $("#thumbnail"+thumbnailId).prop("checked", true);
                    });


                });

            }
        });
    }


$(document).ready(function () {
    $('#container1').on('click', '.bg-success', function () {
        var id = $(this).attr('i');
        $.ajax({
            url: "like.do",
            data: {id: id},
            type: 'POST',
            success: function (data, textStatus, jqXHR) {
                Snackbar.show({
                    text: 'Shop added to your preffered list',
                    backgroundColor: '#232323',
                    width: 'auto',
                    pos: 'top-center'
                });


            }, error: function (jqXHR, textStatus, errorThrown) {
                Snackbar.show({
                    text: 'Element cannot be added this time',
                    backgroundColor: '#232323',
                    width: 'auto',
                    pos: 'top-center'
                });
            }

        });
    });

    $('#container2').on('click', '.bg-warning', function () {
        if(confirm('Do you really want to remove the shop from your preferred list?')){
        var id = $(this).attr('i');
        $.ajax({
            url: "remove.do",
            data: {id: id},
            type: 'POST',
            success: function (data, textStatus, jqXHR) {
                Snackbar.show({
                    text: 'Shop removed from your preferred list',
                    backgroundColor: '#232323',
                    width: 'auto',
                    pos: 'top-center'
                });
                setTimeout(function() {location.reload()},200)
                //not a very good solution  

            }, error: function (jqXHR, textStatus, errorThrown) {
                Snackbar.show({
                    text: 'Element cannot be removed this time',
                    backgroundColor: '#232323',
                    width: 'auto',
                    pos: 'top-center'
                });
            }

        });
    }
    });


});


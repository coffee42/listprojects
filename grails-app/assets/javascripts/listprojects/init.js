

$(document).ready(function() {

    $('#listproject-table').DataTable({
      ajax: {
        url: '/listprojects/listprojects/ajaxList',
        dataSrc: ""
      },
      columns: [
        {data:"name"},
        {data:"status"},
        {data:"sourceLang"},
        {data:"targetLangs"}
      ],
      "searching" : false,
      "pageLength": 50,
      "lengthChange": false

    });

});



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
      ]

    });

});

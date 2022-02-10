function button_click() {
    var url = document.getElementById('url').value;

    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function () {
      if (xhr.readyState === xhr.DONE) {
        if (xhr.status === 200) {
          var result = JSON.parse(xhr.responseText);
          var data = result['data'];
          console.log(data);

          document.getElementById('content').innerHTML = ""

          var newData = "";
          newData += "<table>";
          for (var key in data){
            var value = data[key];
            newData += "<tr>"
            newData += "<td>" + key + "</td>"
            newData += "<td>"
            newData += value;
            if (key === 'thumbnail_url') {
              newData += "<img src=" + value + ">";
            }
            newData += "</td>";
            newData += "</tr>"
          }
          newData += "</table>";

          document.getElementById('content').innerHTML = newData;
        } else {
          alert('not found');
        }
      }
    };

    xhr.open( "GET", 'http://localhost:8080/preview?url=' + url);
    xhr.send(null);
}
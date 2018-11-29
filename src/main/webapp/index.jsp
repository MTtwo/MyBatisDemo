<html>
<body>
<script>
    $(function () {
        $("#selectId1").bind("change",function () {
            alert("1");
            window.setTimeout(function(){
                alert("2")
                $("#selectId1").find("option[value = '1']").attr("selected","selected");

            },1000);
        })
    })
</script>
<h2>Hello World!</h2>
<select id = "selectId1">
    <option value="0">0</option>
    <option value="1">1</option>
    <option value="2">2</option>
</select>
</body>
</html>

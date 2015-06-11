<html>

<head>

    <script src="http://code.jquery.com/jquery-1.11.1.js"></script>
    <script src="/js/dust-full.js"></script>
    <script>
        $(document).ready(function(){
            dust.isDebug = true;
            var template = $("#userTemplate").html();
            var compiled = dust.compile(template,"user_template");
            dust.loadSource(compiled);
            $("#renderButton").click(function(){
                $.ajax({
                    url : "/test/data",
                    type: "GET",
                    dataType: "json",
                    success: function(data){
                        dust.render("user_template",data,function(err, out) {
                            console.log(out);
                            $(".content").html(out);
                        })
                    }
                });
            });
        });
    </script>
</head>

<body>
<script id="userTemplate" type="text/dust">
    <div>
        <div>Hello dear {firstName} {lastName}!</div>
        <div>Current date: {date}</div>
    </div>
</script>
<h2>Hello World!</h2>
<div class="content"></div>
<input type="button" value="Test" id="renderButton">
</body>
</html>

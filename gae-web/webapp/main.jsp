<%--
  User: hurelhuyag
  Email: hurle0409@gmail.com
  Date: 12/8/12
  Time: 7:35 PM
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title></title>
    <meta charset="UTF-8"/>
    <style>
        .root{width: 1000px; margin: 0 auto;}
        .head{margin: 5px 0; padding: 5px; border: 1px solid #ccc; border-radius: 5px;}
        .left{float: left; width: 680px; padding: 5px;  min-height: 200px; border: 1px solid #ccc; border-radius: 5px;}
        .right{float: right; width: 280px; padding: 5px; min-height: 200px; border: 1px solid #ccc; border-radius: 5px;}
    </style>
    <script src="jquery-1.8.3.min.js"></script>
    <script src="jquery.form.js"></script>
    <script>
        _edit = function(id){
            $.ajax({
                url:'/edit',
                data:'id='+id,
                success:function(data){
                    $('#edit-cont').html(data);
                },
                complete:_list
            });
        };
        _new = function(){
            $.ajax({
                url:'/edit.jsp',
                success:function(data){
                    $('#edit-cont').html(data);
                }
            });
        };
        _list = function(){
            $.ajax({
                url:'/list',
                success:function(data){
                    $('#list-cont').html(data);
                }
            });
        };
        _delete = function(id){
            $.ajax({
                url:'/edit',
                type:'DELETE',
                data:'id='+id,
                success:function(data){
                    $('#message').html(data);
                }
            });
        }
    </script>
</head>
<body>
    <div class="root">
        <div class="head">
            Logged in ${user.nickname}, <a href="${logout}">Log out</a>
        </div>
        <div id="list-cont" class="left">
            <%@include file="list.jsp"%>
        </div>
        <div id="edit-cont" class="right">
            <%@include file="edit.jsp"%>
        </div>
        <div class="foot">
            <a href="https://code.google.com/p/pocket-budget" target="_blank">source code</a>
        </div>
    </div>
</body>
</html>
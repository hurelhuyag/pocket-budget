<%--
  User: hurelhuyag
  Email: hurle0409@gmail.com
  Date: 12/8/12
  Time: 7:30 PM
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<form id="edit-form" method="post" action="/edit">
    <input type="hidden" name="id"/>
    <div>
        <label for="amount">Amount: </label>
        <input id="amount" name="amount"/>
    </div>
    <div>
        <label for="type">Type: </label>
        <select id="type" name="type">
            <option value="INCOME">INCOME</option>
            <option value="OUTCOME">OUTCOME</option>
        </select>
    </div>
    <div>
        <label for="description">Desc: </label>
        <textarea id="description" name="description">

        </textarea>
    </div>
    <div>
        <input type="submit" value="Save"/>
        <input type="reset" value="Reset"/>
        <input type="button" value="New" onclick="_new();"/>
    </div>


</form>

<script>
    $(function(){
        $("#edit-form").ajaxForm({
            target:'#edit-cont',
            success:_list
        })
    })
</script>
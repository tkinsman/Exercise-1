<%--
  Created by IntelliJ IDEA.
  User: toddkinsman
  Date: 9/5/16
  Time: 7:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@include file="head.jsp"%>
<html><body>
<div class="container-fluid">
    <h1>Search For Employee By Last Name</h1>

    <form action="/searchUser" method="GET">
        <label>Enter Search Term:</label><br />
        <input type="text" id="searchTerm" name="searchTerm" />

        <fieldset>
            <legend>Choose Search Method</legend>
            <input type="radio" id="searchType" name="searchType" value="lastName" checked/>Last Name
        </fieldset>


        <input type="submit" name="addEmployee" value="Search" />

    </form>


</div>

</body>
</html>


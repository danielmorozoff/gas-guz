<%@ taglib prefix="c"     uri="http://java.sun.com/jsp/jstl/core" %>

<form action='<c:url value="/admin/logon.html"/>' method="post">
  <table>
    <tr>
      <td><b>User ID</b></td>
      <td><input type="text" name="username"></td>
    </tr>
    <tr>
      <td><b>Password</b></td>
      <td><input type="text" name="password"></td>
    </tr>
    <tr>
      <td colspan=2><input type="submit" value="Submit"></td>
    </tr> 
  </table>  
</form>

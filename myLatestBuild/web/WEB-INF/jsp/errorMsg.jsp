<%@ taglib prefix="bean"  uri="http://struts.apache.org/tags-bean" %>
<%@ taglib prefix="html"  uri="http://struts.apache.org/tags-html" %>

<style type="text/css">
#errorMsg {background-color:#FFFF00;}
#clientValidation, #serverValidation {margin:0;}
#clientValidation li, #serverValidation li {padding:5px;}
</style>

<script type="text/javascript">
function clearErrors(type) {
//  $("#errorMsg").hide('fast');
  if (type == "client" || type == "both") {
    $("#clientValidation ul").empty();
  }
  if (type == "server" || type == "both") {
    $("#serverValidation ul").empty();
  }
}

function addValidationError(msg) {
  $("#clientValidation ul").append('<li>' + msg + '</li>');
  $("html, body").animate({scrollTop: 0}, "slow");
//  $("#errorMsg").show('fast');
}
</script>


<div>
  <div id="errorMsg" class="round-borders">
    <div id="clientValidation"><ul></ul></div>
    <div id="serverValidation">
      <ul>
        <html:messages id="msg">
          <li class="validationerrorxx"><bean:write name="msg" filter="false"/></li>
        </html:messages>
        <html:messages id="msg" message="true">
          <li class="validationerrorxx"><bean:write name="msg" filter="false"/></li>
        </html:messages>
      </ul>
    </div>
  </div>
</div>

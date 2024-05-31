<%@include file="common/header.jspf" %>
<%@include file="common/navigation.jspf" %>

<div class="container">
	<h1>Enter Todo Detais</h1>
	<form:form method="post" modelAttribute="todo">
		<fieldset class="mb-3">
			<form:label path="description">Description</form:label>
			<form:input type="text" path="description" />
			<form:errors cssClass="text-warning" path="description" />
		</fieldset>
		
		<fieldset class="mb-3">
			<form:label path="targetDate">Target Date</form:label>
			<form:input type="text" path="targetDate" />
			<form:errors cssClass="text-warning" path="description" />
		</fieldset>
		
		<form:input type="hidden" path="id" />
		<form:input type="hidden" path="username" />
		<input type="submit" class="btn btn-success" value="submit">
	</form:form>
</div>

<%@include file="common/footer.jspf" %>

<script type="text/javascript">
	$('#targetDate').datepicker({
			format: 'yyyy-mm-dd'
		})
</script>
	
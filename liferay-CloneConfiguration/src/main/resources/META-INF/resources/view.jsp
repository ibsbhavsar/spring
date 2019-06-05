
<%@ include file="init.jsp" %>

<p>
	<b><liferay-ui:message key="clonemodule.caption" /></b>
</p>

<%
	boolean noName = Validator.isNull(name);
	boolean noLink = Validator.isNull(link);
	String[] name_array = portletPreferences.getValues("name", new String[0]);
	String row_index = portletPreferences.getValue("rowIndexes", StringPool.BLANK);
%>

<c:choose>
	<c:when test="<%= noName && noLink %>">
		<p>Please select any value.</p>
	</c:when>
	<c:otherwise>
		<c:set value="<%= name_array %>" var="name_values" />
		<c:set value="<%= row_index %>" var="r_index" />

		<c:forEach items="${name_values}" var="nameVal" varStatus="loop">
			<c:set value="${fn:split(nameVal, '_')}" var="names" />
			<a href="${names[1]}">${names[0]}</a>
			<br>
		</c:forEach>
	</c:otherwise>
</c:choose>
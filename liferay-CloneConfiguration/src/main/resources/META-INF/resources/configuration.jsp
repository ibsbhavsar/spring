<%@ taglib prefix="aui" uri="http://liferay.com/tld/aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ include file="init.jsp"%>


<liferay-portlet:actionURL portletConfiguration="<%=true%>"
	var="configurationActionURL">
	</liferay-portlet:actionURL>

<liferay-portlet:renderURL portletConfiguration="<%=true%>"
	var="configurationRenderURL" />

<%
	String[] name_array = portletPreferences.getValues("name", null);
	String row_index = portletPreferences.getValue("rowIndexes", StringPool.BLANK);
	boolean nameListEmpty = false;

	if (Validator.isNull(name_array)) {
		nameListEmpty = true;
	}
%>
<aui:form action="${configurationActionURL}" method="post" name="fm">
	<div id="member-fields">
		<c:choose>
			<c:when test="<%=nameListEmpty%>">
				<div class="lfr-form-row lfr-form-row-inline">
					<div class="row-fields" style="display: flex;">
						<aui:input fieldParam="name1" id="name1" label="Name" name="name1">
							<aui:validator name="required" />
						</aui:input>

						<br>
						<aui:input fieldParam="link1" id="link1" label="Link" name="link1">
							<aui:validator name="required" />
						</aui:input>

						<br>
					</div>
				</div>
			</c:when>
			<c:otherwise>
				<c:set value="<%=name_array%>" var="name_values" />
				<c:set value="<%=row_index%>" var="r_index" />

				<c:forEach items="${name_values}" var="nameVal" varStatus="loop">
					<div class="lfr-form-row lfr-form-row-inline">
						<div class="row-fields" style="display: flex;">
							<c:set value="${fn:split(nameVal, '_')}" var="names" />
							<c:set value="${loop.index+1}" var="curIndex"></c:set>
							<aui:input fieldParam="name${curIndex}" id="name${curIndex}"
								label="Name" name="name${curIndex}" value="${names[0]}">
								<aui:validator name="required" />
							</aui:input>

							<br>
							<aui:input fieldParam="link${curIndex}" id="link${curIndex}"
								label="Link" name="link${curIndex}" value="${names[1]}">
								<aui:validator name="required" />
							</aui:input>

							<br>
						</div>
					</div>
				</c:forEach>
			</c:otherwise>
		</c:choose>
	</div>

	<aui:button-row>
		<aui:button type="submit"></aui:button>
	</aui:button-row>

</aui:form>
<aui:script>
	AUI().use('liferay-auto-fields', function(A) {
		new Liferay.AutoFields({
			contentBox : '#member-fields',
			fieldIndexes : '<portlet:namespace/>rowIndexes'
		}).render();
	});
</aui:script>
<%@ page import="com.clonemodule.portlet.CloneInterface" %>

<%@ page import="com.liferay.portal.kernel.util.GetterUtil" %>
<%@ page import="com.liferay.portal.kernel.util.StringPool" %><%@
page import="com.liferay.portal.kernel.util.Validator" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<liferay-theme:defineObjects />
<%@ taglib prefix="aui" uri="http://liferay.com/tld/aui" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<portlet:defineObjects />

<%
	CloneInterface cloneInterface = (CloneInterface)GetterUtil
			.getObject(renderRequest.getAttribute(CloneInterface.class.getName()));
	String name = StringPool.BLANK;
	String link = StringPool.BLANK;

	if (Validator.isNotNull(cloneInterface)) {
		name = portletPreferences.getValue("name", cloneInterface.name());
		link = portletPreferences.getValue("link", cloneInterface.link());
	}
%>
<%@page import="com.liferay.portal.kernel.theme.ThemeDisplay"%>
<%@page
	import="com.liferay.journal.service.JournalArticleLocalServiceUtil"%>
<%@page import="com.liferay.journal.model.JournalArticle"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/xml" prefix="x"%>
<%@ include file="init.jsp"%>
<%
	JournalArticle journalArticle = JournalArticleLocalServiceUtil.getLatestArticle(36074);
	request.setAttribute("content", journalArticle.getContent());
%>
<x:parse xml="${content}" var="articleContent" />
<c:set var="title">
	<x:out select="$articleContent//dynamic-element[@name='title']" />
</c:set>
<c:set var="image">
	<x:out select="$articleContent//dynamic-element[@name='image']" />
</c:set>
<strong>Title : ${title}</strong>
<br />
<img alt="Image" src="${image}">




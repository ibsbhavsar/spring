package com.clonemodule.portlet;

import com.clonemodule.constants.CloneModulePortletKeys;

import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import java.io.IOException;

import java.util.Map;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;

/**
 * @author bhavin.bhavsar
 */
@Component(configurationPid = "com.clonemodule.portlet.CloneInterface", immediate = false, property = {
		"com.liferay.portlet.display-category=Auto-Fields",
		"com.liferay.portlet.instanceable=false",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + CloneModulePortletKeys.CloneModule,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"}, service = Portlet.class)
public class CloneModulePortlet extends MVCPortlet {

	@Override
	public void doView(
			RenderRequest renderRequest, RenderResponse renderResponse)
		throws IOException, PortletException {

		renderRequest.setAttribute(
			CloneInterface.class.getName(), cloneInterface);
		super.doView(renderRequest, renderResponse);
	}

	public String getLinks(Map<Object, Object> links) {
		return (String)links.get(cloneInterface.link());
	}

	public String getNames(Map<Object, Object> names) {
		return (String)names.get(cloneInterface.name());
	}

	@Activate
	@Modified
	protected void activate(Map<Object, Object> properties) {
		cloneInterface = ConfigurableUtil.createConfigurable(
			CloneInterface.class, properties);
	}

	private static final Log _log = LogFactoryUtil.getLog(
		CloneModulePortlet.class);

	private volatile CloneInterface cloneInterface;

}
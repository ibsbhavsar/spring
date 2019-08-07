package WebContentDataProgrammatically.portlet;

import WebContentDataProgrammatically.constants.WebContentDataProgrammaticallyPortletKeys;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;

/**
 * @author bhavin.bhavsar
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=WebContentProgramatically",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=WebContentDataProgrammatically",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + WebContentDataProgrammaticallyPortletKeys.WEBCONTENTDATAPROGRAMMATICALLY,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class WebContentDataProgrammaticallyPortlet extends MVCPortlet {
	
	
}
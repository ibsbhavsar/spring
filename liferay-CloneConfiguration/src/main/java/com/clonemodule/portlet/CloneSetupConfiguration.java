package com.clonemodule.portlet;

import com.clonemodule.constants.CloneModulePortletKeys;

import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.ConfigurationAction;
import com.liferay.portal.kernel.portlet.DefaultConfigurationAction;
import com.liferay.portal.kernel.portlet.PortletPreferencesFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;

import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletPreferences;
import javax.portlet.ProcessAction;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ConfigurationPolicy;
import org.osgi.service.component.annotations.Modified;

@Component(configurationPid = "com.clonemodule.portlet.CloneInterface", configurationPolicy = ConfigurationPolicy.OPTIONAL, immediate = true, property = {
		"javax.portlet.name=" + CloneModulePortletKeys.CloneModule, }, service = ConfigurationAction.class
)
public class CloneSetupConfiguration extends DefaultConfigurationAction {

	@ProcessAction(name = "configurationActionURL")
	public void processAction(
			PortletConfig portletConfig, ActionRequest actionRequest,
			ActionResponse actionResponse)
		throws Exception {

		String rowIndexes = actionRequest.getParameter("rowIndexes");

		String[] indexOfRows = rowIndexes.split(",");
		_log.info("row indexes are : " + String.valueOf(rowIndexes.length()));
		String[] nameList = new String[indexOfRows.length];

		for (int i = 0; i < indexOfRows.length; i++) {
			String name1 =
				(actionRequest.getParameter("name" + indexOfRows[i])).trim();
			String link1 =
				(actionRequest.getParameter("link" + indexOfRows[i])).trim();

			nameList[i] = name1 + "_" + link1;
			_log.info("Name : " + name1);
			_log.info("Link : " + link1);
		}

		String portletResource = ParamUtil.getString(
			actionRequest, "portletResource");

		PortletPreferences portletPreferences = PortletPreferencesFactoryUtil.getPortletSetup(actionRequest,
			portletResource);

		portletPreferences.setValues("name", nameList);
		portletPreferences.setValue(
			"rowIndexes", String.valueOf(rowIndexes.length()));
		portletPreferences.store();
		_log.info("Process Action Method Called ");

		super.processAction(portletConfig, actionRequest, actionResponse);
	}

	@Activate
	@Modified
	protected void activate(Map<Object, Object> properties) {
		cloneInterface = ConfigurableUtil.createConfigurable(
			CloneInterface.class, properties);
	}

	private static final Log _log = LogFactoryUtil.getLog(
		CloneSetupConfiguration.class);

	private volatile CloneInterface cloneInterface;

}
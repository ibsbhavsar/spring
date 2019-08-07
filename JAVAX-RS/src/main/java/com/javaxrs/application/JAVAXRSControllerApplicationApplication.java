package com.javaxrs.application;

import java.util.Collections;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.Validator;

/**
 * @author bhavin.bhavsar
 */
@ApplicationPath("/user")
@Component(immediate = true, service = Application.class)
public class JAVAXRSControllerApplicationApplication extends Application {

	public Set<Object> getSingletons() {
		return Collections.<Object>singleton(this);
	}

	@GET
	@Path("/user-info/{userId}")
	@Produces("application/json")
	public String getUserInfo(@PathParam("userId") String userId) {
		JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
		User user = null;
		if (Validator.isNotNull(userId)) {
			try {
				user = UserLocalServiceUtil.getUser(Long.parseLong(userId));
			} catch (NumberFormatException e) {
				jsonObject.put("ERROR", "Pleas pass valid userId");
			} catch (PortalException e) {
				jsonObject.put("ERROR", "No user found !");
			}
		}
		if (Validator.isNotNull(user)) {
			jsonObject.put("emailId", user.getEmailAddress());
			jsonObject.put("Name", user.getFullName());
		}
		return jsonObject.toJSONString();
	}

}
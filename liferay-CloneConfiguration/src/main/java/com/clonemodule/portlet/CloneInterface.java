package com.clonemodule.portlet;

import aQute.bnd.annotation.metatype.Meta;

@Meta.OCD(id = "com.clonemodule.portlet.CloneInterface")
public interface CloneInterface {

	@Meta.AD(deflt = "bhavin", required = true, max = "true")
	public String name();

	@Meta.AD(deflt = "google.com", required = true)
	public String link();

}
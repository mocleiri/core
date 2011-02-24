/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.wicketstuff.dojo.application;

import java.util.Locale;

import org.apache.wicket.Resource;
import org.apache.wicket.ResourceReference;
import org.apache.wicket.request.target.coding.PackageRequestTargetUrlCodingStrategy;
import org.apache.wicket.resource.ContextRelativeResource;
import org.wicketstuff.dojo.resource.DojoJavaScriptResource;

/**
 * @author mocleiri
 * 
 */
public class DojoJavaScriptResourceReference  extends ResourceReference {

	private final String module;
	private final String version;

	/**
	 * Construct.
	 * @param name
	 */
	public DojoJavaScriptResourceReference(String name, String version, String module)
	{
		super(name);
		this.version = version;
		this.module = module;
	}

	/**
	 * @see org.apache.wicket.ResourceReference#newResource()
	 */
	@Override
	protected Resource newResource()
	{
//		return new javascri(version + "/" + module);
		return null;
	}

	
}

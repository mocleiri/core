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
package org.wicketstuff.dojo.resource;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Enumeration;

import org.apache.wicket.markup.html.WebResource;
import org.apache.wicket.protocol.http.WebResponse;
import org.apache.wicket.util.resource.IResourceStream;
import org.apache.wicket.util.resource.WebExternalResourceStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.wicketstuff.dojo.application.InputStreamResourceStream;

/**
 * @author mike
 */
public class DojoJavaScriptResource extends WebResource
{

	private static final Logger log = LoggerFactory.getLogger(DojoJavaScriptResource.class);
	private final String version;
	private final String module;

	/**
	 * Construct.
	 * @param module 
	 */
	public DojoJavaScriptResource(String version, String module)
	{
		this.version = version;
		this.module = module;
	}

	/**
	 * @see org.apache.wicket.Resource#getResourceStream()
	 */
	@Override
	public IResourceStream getResourceStream()
	{
			
			return new InputStreamResourceStream(version +"/" + module, "text/javascript");
	}

}

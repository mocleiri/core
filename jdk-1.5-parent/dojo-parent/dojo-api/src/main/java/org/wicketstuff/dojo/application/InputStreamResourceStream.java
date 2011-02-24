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

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;

import javax.servlet.ServletContext;

import org.apache.wicket.RequestCycle;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.util.resource.AbstractResourceStream;
import org.apache.wicket.util.resource.IResourceStream;
import org.apache.wicket.util.resource.ResourceStreamNotFoundException;
import org.mortbay.log.Log;
import org.mortbay.resource.JarResource;

/**
 * @author mocleiri
 * 
 * 
 * 
 */
public class InputStreamResourceStream extends AbstractResourceStream implements IResourceStream
{

	private InputStream inputStream;
	private final String contentType;
	private final String classPathResource;

	/**
	 * Construct.
	 * @param classPathResource 
	 * @param contentType 
	 */
	public InputStreamResourceStream(String classPathResource, String contentType)
	{
		this.classPathResource = classPathResource;
		this.contentType = contentType;
		
	}

	/**
	 * @see org.apache.wicket.util.resource.IResourceStream#getInputStream()
	 */
	public InputStream getInputStream() throws ResourceStreamNotFoundException
	{
		if (inputStream == null) {
			
			
			getClass().getClassLoader().getResourceAsStream(classPathResource);
			
		}
		
		return inputStream;
	}

	/**
	 * @see org.apache.wicket.util.resource.IResourceStream#close()
	 */
	public void close() throws IOException
	{
		if (this.inputStream != null) {
			this.inputStream.close();
			this.inputStream = null;
		}
	}

	/**
	 * @see org.apache.wicket.util.resource.AbstractResourceStream#getContentType()
	 */
	@Override
	public String getContentType()
	{
		return contentType;
	}
	
	
	
	

}

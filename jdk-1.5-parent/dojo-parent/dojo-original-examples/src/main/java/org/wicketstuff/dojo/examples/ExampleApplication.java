package org.wicketstuff.dojo.examples;

import org.apache.wicket.Request;
import org.apache.wicket.Response;
import org.apache.wicket.Session;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.util.lang.PackageName;
import org.wicketstuff.dojo.examples.inlineedit.DojoInlineEditBoxSample;

/**
 * Runs the ExampleApplication when invoked from command line.
 */
public class ExampleApplication extends WebApplication {

	/**
	 * @see wicket.Application#getHomePage()
	 */
	public Class getHomePage() {
		return Index.class;
	}

	
	/* (non-Javadoc)
	 * @see org.apache.wicket.protocol.http.WebApplication#newSession(org.apache.wicket.Request, org.apache.wicket.Response)
	 */
	@Override
	public Session newSession(Request request, Response response) {
		
		return new ExampleSession(ExampleApplication.this, request, response);
	}
	@Override
	protected void init() {
		mount("/inlineEditBox", PackageName.forClass(DojoInlineEditBoxSample.class));
	}
}

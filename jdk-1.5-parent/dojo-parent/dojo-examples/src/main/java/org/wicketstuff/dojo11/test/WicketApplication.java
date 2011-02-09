package org.wicketstuff.dojo11.test;

import org.apache.wicket.Page;
import org.wicketstuff.dojo11.application.DojoApplication;
import org.wicketstuff.dojo11.push.cometd.CometdService;

/**
 * Application object for your web application. If you want to run this application without deploying, run the Start class.
 * 
 * @see org.wicketstuff.dojo11.test.Start#main(String[])
 */
public class WicketApplication extends DojoApplication
{    	
	private CometdService _svc;

	@Override
	protected void init() {
		super.init();
		_svc = new CometdService(getServletContext());
		
//		getMarkupSettings().setStripWicketTags(true);
		
		mountBookmarkablePage("/dnd", DragAndDropPage.class);
	}

	/**
	 * @see org.apache.wicket.Application#getHomePage()
	 */
	public Class<HomePage> getHomePage()
	{
		return HomePage.class;
	}

	public CometdService getSvc() {
		return _svc;
	}

	public void setSvc(CometdService svc) {
		_svc = svc;
	}

	public String getLayer(Page page) {
		return null;
	}

	
}

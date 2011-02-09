package org.wicketstuff.dojo11.test;

import java.util.Map;

import org.apache.wicket.Application;
import org.apache.wicket.PageParameters;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.behavior.AttributeAppender;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.repeater.RepeatingView;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;
import org.wicketstuff.dojo11.dojofx.FxToggler;
import org.wicketstuff.dojo11.dojofx.ToggleEvents;
import org.wicketstuff.dojo11.dojofx.ToggleAnimations;
import org.wicketstuff.dojo11.markup.html.toaster.DojoToaster;
import org.wicketstuff.dojo11.markup.html.toaster.DojoToaster.ToasterMessageType;
import org.wicketstuff.dojo11.markup.html.toaster.DojoToaster.ToasterPosition;
import org.wicketstuff.dojo11.push.ChannelEvent;
import org.wicketstuff.dojo11.push.IChannelListener;
import org.wicketstuff.dojo11.push.IChannelTarget;
import org.wicketstuff.dojo11.push.cometd.CometdTarget;

/**
 * Homepage
 */
public class HomePage extends WebPage {

	private static final long serialVersionUID = 1L;

	// TODO Add any page properties or variables here

    /**
	 * Constructor that is invoked when page is invoked without a session.
	 * 
	 * @param parameters
	 *            Page parameters
	 */
    public HomePage(final PageParameters parameters) {

        // Add the simplest type of label
        Label trigger;
    	add(trigger = new Label("message", ">> click here <<"));
    	
    	final FxToggler t;
        add(new WebMarkupContainer("mouseOver").add(new FxToggler(ToggleEvents.MOUSE_OVER, ToggleAnimations.FADE_TO_OPACITY, trigger, false)));
        add(new WebMarkupContainer("click").add(t = new FxToggler(ToggleEvents.CLICK, ToggleAnimations.QUART_WIPE, trigger, true)));
        
        final DojoToaster toaster = new DojoToaster("toaster",new Model("Servus"));
        toaster.setPosition(ToasterPosition.BOTTOM_RIGHT_UP);
        
        AjaxLink link = new AjaxLink("toasterLink"){
        	private static final long serialVersionUID = 1L;
			private Integer _counter = 42;

			public void onClick(AjaxRequestTarget target) {
				toaster.setModelObject("Ajax Servus");
        		toaster.publishMessage(target,ToasterMessageType.ERROR);
        		t.show(target);
        		((WicketApplication) Application.get()).getSvc().publish(new ChannelEvent("foo").addData("foo", Integer.toString(_counter++)));
        	}
        };
        
        link.add(new AttributeAppender("onmouseover", true, new PropertyModel(t, "hideScript"), ";"));
        
        add(toaster);
        add(link);
       
        final WebMarkupContainer c = new WebMarkupContainer("c");
        final RepeatingView rv;
        c.add(rv = new RepeatingView("rv"));
        c.setOutputMarkupId(true);
        add(c);
        
        ((WicketApplication) Application.get()).getSvc().addChannelListener(this, "foo", new IChannelListener() {

			private static final long serialVersionUID = 1L;

			@SuppressWarnings("unchecked")
			public void onEvent(String channel, Map datas, IChannelTarget target) {
				toaster.setModelObject("Ajax Servus");
				rv.add(new Label(rv.newChildId(), (String)datas.get("foo")));
        		((CometdTarget)target).addComponent(c);		
			}
        	
        });
    }
}

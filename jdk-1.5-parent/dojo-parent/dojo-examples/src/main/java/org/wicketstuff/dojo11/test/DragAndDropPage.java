package org.wicketstuff.dojo11.test;

import org.apache.wicket.Component;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.behavior.HeaderContributor;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.wicketstuff.dojo.dojodnd.DojoDragAndDropContainer;
import org.wicketstuff.dojo.dojodnd.DojoDragContainer;
import org.wicketstuff.dojo.dojodnd.DojoDraggableBehavior;
import org.wicketstuff.dojo.dojodnd.DojoDropContainer;

public class DragAndDropPage extends WebPage {

	public DragAndDropPage() {
		add(HeaderContributor.forCss(DragAndDropPage.class, DragAndDropPage.class.getSimpleName()+".css"));
		
		DojoDropContainer dropContainer = new DojoDragAndDropContainer("dropContainer") {

			private static final long serialVersionUID = 1L;

			@Override
			public void onDrop(AjaxRequestTarget target, Component component, int position) {
				System.out.println("position = " + position);
				System.out.println("DojoDragContainer: " + component.getId());
			}
		};
		add(dropContainer);
		
		DojoDragContainer c;
		add(c = new DojoDragAndDropContainer("dragContainer") {
			private static final long serialVersionUID = 1L;

			@Override
			public void onDrop(AjaxRequestTarget target, Component component, int position) {
				System.out.println("position = " + position);
				System.out.println("DojoDragContainer: " + component.getId());
			}
		});
		c.add(new Label("dragItem1", "foo1").add(new DojoDraggableBehavior()));
		c.add(new Label("dragItem2", "foo2").add(new DojoDraggableBehavior()));
		c.add(new Label("dragItem3", "foo3").add(new DojoDraggableBehavior()));
		c.add(new Label("dragItem4", "foo4").add(new DojoDraggableBehavior()));		
	}
}

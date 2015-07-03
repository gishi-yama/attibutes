package com.mycompany;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.link.ExternalLink;

public class HomePage extends WebPage {
	private static final long serialVersionUID = 1L;

	public HomePage() {

		this.add(new BookmarkablePageLink<>("toAttributePage", AttributePage.class));
		this.add(new ExternalLink("toAttributeServlet", "./AttributeServlet"));

	}
}

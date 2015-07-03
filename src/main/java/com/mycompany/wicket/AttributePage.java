package com.mycompany.wicket;

import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.request.cycle.RequestCycle;
import org.apache.wicket.request.handler.TextRequestHandler;

public class AttributePage extends WebPage {
	private static final long serialVersionUID = 8528885172051051245L;

	private String SEPARATOR_FORMAT = "%s:%s";

	public AttributePage() {
		HttpServletRequest req = (HttpServletRequest) getRequest().getContainerRequest();
		// Example
		req.setAttribute("example", "I'm Wicket.");

		String params = Collections.list(req.getAttributeNames())
				.stream()
				.map(name -> String.format(SEPARATOR_FORMAT, name, req.getAttribute(name)))
				.collect(Collectors.joining(" , "));

		RequestCycle.get().scheduleRequestHandlerAfterCurrent(
				new TextRequestHandler("text/plain", StandardCharsets.UTF_8.toString(), params));
	}
}

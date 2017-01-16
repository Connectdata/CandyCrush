package view;


import javax.servlet.jsp.JspException;


public class TemplateModelAndView extends ModelView{
	private String bodyEvents;
	public TemplateModelAndView(String content,String title) throws JspException{
		super("template",content,title);
	}
	public String getBodyEvents() {
		return bodyEvents;
	}
	public void setBodyEvents(String bodyEvents) {
		this.bodyEvents = bodyEvents;
		addObject("bodyEvents",bodyEvents);
	}

	
}
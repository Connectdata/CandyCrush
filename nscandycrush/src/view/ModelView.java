package view;

import javax.servlet.jsp.JspException;

import org.springframework.web.servlet.ModelAndView;


public class ModelView extends ModelAndView{
	private String _content;
	private String _title;
	
	public ModelView(String template,String content,String title) throws JspException{
		super(template);
		setContent(content);
		setTitle(title);
		addWording();
	}
	public ModelView(String content){
		super(content);
		addWording();
	}
	public String getContent() {
		return _content;
	}
	public void setContent(String content) throws JspException {
		if(content==null)throw new JspException("Model content cannot be null");
		this._content = content+".jsp";
		this.addObject("content",getContent());
	}
	public String getTitle() {
		return _title;
	}
	public void setTitle(String title) throws JspException {
		if(title==null)throw new JspException("Model title cannot be null");
		this._title = title;
		this.addObject("title",title);
	}
	private void addWording(){
		//TODO: Implement wording
//		Locale locale=PokerConfiguration.getDefaultWording();
//		ResourceBundle wording=ResourceBundle.getBundle("com.nellistudio.operator.general.domaine.properties.langue", locale);
//		addObject("wording",wording);
	}
}

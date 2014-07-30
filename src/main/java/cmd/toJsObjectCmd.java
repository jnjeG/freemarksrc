package cmd;

import java.io.IOException;
import java.io.Writer;
import java.util.Map;


import freemarker.core.Environment;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateDirectiveModel;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;

public class toJsObjectCmd implements TemplateDirectiveModel {
	private Integer counter =0;

	public void execute(Environment env, Map params, TemplateModel[] loopVars,
			TemplateDirectiveBody body) throws TemplateException, IOException {
		//真正执行的部分
		Writer out = env.getOut();
//		synchronized(counter){
			out.write(counter+"");
			counter++;
//		}
		body.render(env.getOut());
	}
}

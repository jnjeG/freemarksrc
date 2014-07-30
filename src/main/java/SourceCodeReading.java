

import freemarker.core.Environment;
import freemarker.ext.servlet.HttpRequestHashModel;
import freemarker.template.SimpleCollection;
import freemarker.template.SimpleSequence;
import freemarker.template.Template;
import freemarker.template.TemplateBooleanModel;
import freemarker.template.TemplateCollectionModel;
import freemarker.template.TemplateDirectiveModel;
import freemarker.template.TemplateMethodModel;
import freemarker.template.TemplateSequenceModel;

public class SourceCodeReading {
	public static void main(String[] args) {
		HttpRequestHashModel hrhm = null;
//		SimpleScalar ss =null;
		TemplateBooleanModel tbm = null;
//		TemplateDateModel tdm = null;
		TemplateSequenceModel tsm = null;
		SimpleSequence ss = null;
		TemplateCollectionModel tcm =null;
		SimpleCollection sm =null;
		
		Environment.getCurrentEnvironment();
		
		TemplateMethodModel tmm = null;
		TemplateDirectiveModel tdm = null;
		freemarker.template.Configuration c =null;
		Template t =null;
		
		freemarker.cache.TemplateLoader tl = null;
		
		freemarker.cache.URLTemplateLoader utl = null;
		
	}
}

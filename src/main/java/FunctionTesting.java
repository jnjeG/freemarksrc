import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import cmd.toJsObjectCmd;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;


public class FunctionTesting {
	private static Configuration cfg = new Configuration();
	private static Map<String,Object> model = new HashMap<String,Object>();
	
	static{
		try {
			cfg.setDirectoryForTemplateLoading(new File("/home/chenjunjie/workspaces/3g/freemarksrc/src/main/webapp/fmt"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static Map<String,Object> putAndGet(String key,Object value){
		model.put(key, value);
		return model;
	}
	
	private static void logic() {
		putAndGet("name","chenjunjie");
		putAndGet("cmd", new toJsObjectCmd());
	}
	
	public static void main(String[] args) throws IOException, TemplateException {
		logic();
		Writer out = new FileWriter(new File("/home/chenjunjie/workspaces/3g/freemarksrc/src/main/webapp/output/output.html"));
		Template t = cfg.getTemplate("main.ftl","utf-8");
		t.process(model, out);
	}

	/**
	 * 
	 */
	public static void testMultipleThread() {
		try {
			putAndGet("doc", freemarker.ext.dom.NodeModel.parse(new File("the/path/of/the.xml")));
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
		
		
		for(int i =0; i < 20; i++){
			new Thread(){

				@Override
				public void run() {
					PrintWriter out = new PrintWriter(System.out);
					Template t;
					try {
						t = cfg.getTemplate("main.ftl","utf-8");
						t.process(model, out);
					} catch (IOException e) {
						e.printStackTrace();
					} catch (TemplateException e) {
						e.printStackTrace();
					}
				}
			}.start();
			
		}
	}
}

package velocity.XML;

import java.io.*;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;

import org.jdom.Document;
import org.jdom.input.SAXBuilder;

public class XMLHandling {

  public static void main(String args[]) {
  try {
  Velocity.init();

  SAXBuilder builder;
  Document root = null;
  try {
  builder = 
new SAXBuilder("org.apache.xerces.parsers.SAXParser");
 root = builder.build("./src/velocity/XML/handling.xml");
  } catch (Exception e) {
  System.out.println(e);
  }

  VelocityContext context = new VelocityContext();
  context.put("root", root);

  Template template = 
Velocity.getTemplate("./src/velocity/XML/handling.vm");

      StringWriter writer = new StringWriter();
  template.merge(context, writer);

  System.out.println(writer);
  } catch (Exception e) {
  System.out.println(e);
  }

  }
}

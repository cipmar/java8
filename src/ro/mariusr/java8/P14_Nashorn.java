package ro.mariusr.java8;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * Created by mariusrop on 13.11.2015.
 * <p>
 * Nashorn - JavaScript engine - running dynamic javascript code natively on the JVM!!!
 * It is similar to Google V8 (used in Chrome and Node.js)
 * http://winterbe.com/posts/2014/04/05/java8-nashorn-tutorial/
 */
public class P14_Nashorn {
    public static void main(String[] args) throws FileNotFoundException, ScriptException, NoSuchMethodException {
        ScriptEngineManager engineManager = new ScriptEngineManager();
        ScriptEngine engine = engineManager.getEngineByName("nashorn");
        engine.eval(new FileReader("src/ro/mariusr/java8/mustache.js"));

        Invocable invocable = (Invocable) engine;

        String contactJson = "{\"contact\": {\"name\": \"Mr A\", \"emails\": [\"contact@some.tld\", \"sales@some.tld\"]}}";
        String template = "Email addresses of {{contact.name}}:\n {{#contact.emails}}\n- {{.}}\n{{/contact.emails}}";

        Object json = engine.eval("JSON");
        Object data = invocable.invokeMethod(json, "parse", contactJson);
        Object mustache = engine.eval("Mustache");
        System.out.println(invocable.invokeMethod(mustache, "render", template, data));
    }
}

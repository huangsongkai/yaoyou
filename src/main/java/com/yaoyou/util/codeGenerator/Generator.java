package com.yaoyou.util.codeGenerator;

import com.yaoyou.model.dataObject.User;
import com.yaoyou.util.StringUtil;
import com.yaoyou.util.TimeUtil;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.app.VelocityEngine;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * Created by song on 16/8/30.
 */
public class Generator {
    VelocityEngine ve = new VelocityEngine();
    Properties properties = new Properties();
    String basePath = "src/main/java/com/yaoyou/util/codeGenerator";//这里需要这样写路径！！！
    // 设置模板的路径
    String JAVA_PATH = "src/main/java/com/yaoyou";

    public Generator(){
        properties.setProperty(Velocity.FILE_RESOURCE_LOADER_PATH, basePath);
        properties.setProperty(Velocity.INPUT_ENCODING, "UTF-8");
        ve.init(properties);
    }

    void generate(String entityClassName){
    }

    String generatorTemplate(String moduleName, String entityClassName){
        VelocityContext context = new VelocityContext();
        context.put("class", entityClassName);
        context.put("object", StringUtil.getObjName(entityClassName));
        return generatorTemplate(moduleName, context);
    }

    String generatorTemplate(String moduleName, VelocityContext context){
        StringWriter writer = new StringWriter();
        Template t = ve.getTemplate("velocity/"+moduleName+".vm");
        t.merge(context, writer);
        System.out.println(writer.toString());
        return writer.toString();
    }

    class ValuePair{
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        String name;
        String value;
    }

    void generateFile(String fileName, String content){
        File file = new File(fileName);
        int index = 1;
        while (file.exists()){
            file = new File(fileName+(index++));
        }
        try {
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(content);
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

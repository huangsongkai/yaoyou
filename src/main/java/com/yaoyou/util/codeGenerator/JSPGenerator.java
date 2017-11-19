package com.yaoyou.util.codeGenerator;

import com.yaoyou.util.StringUtil;
import com.yaoyou.util.TimeUtil;
import org.apache.velocity.VelocityContext;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by song on 16/9/1.
 */
public class JSPGenerator extends Generator{
    String WEB_PATH = "WebRoot/WEB-INF/pages";
    @Override
    void generate(String entityClassName){
        VelocityContext context = new VelocityContext();
        List<ValuePair> fieldList = new ArrayList<ValuePair>();
        Class E = null;
        try {
            E = Class.forName("com.yaoyou.model.dataObject."+entityClassName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return;
        }
        Field[] declaredFields = E.getDeclaredFields();
        for(Field field : declaredFields){
            if(field.getName().equals("createTime"))
                continue;
            ValuePair valuePair = new ValuePair();
            valuePair.setName(field.getName());
            if(field.getName().toLowerCase().contains("time"))
                valuePair.setValue(TimeUtil.now());
            else
                valuePair.setValue(field.getName());
            fieldList.add(valuePair);
        }
        context.put("fieldList", fieldList);
        context.put("object", E.getSimpleName().toLowerCase());
        String filePath = WEB_PATH + "/" + StringUtil.getObjName(entityClassName);
        generateFile(filePath+"/add.jsp", generatorTemplate("add_jsp", context));
        generateFile(filePath+"/edit.jsp", generatorTemplate("edit_jsp", context));
    }
}

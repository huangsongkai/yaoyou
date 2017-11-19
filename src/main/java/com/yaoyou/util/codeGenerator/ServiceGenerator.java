package com.yaoyou.util.codeGenerator;


/**
 * Created by song on 16/9/1.
 */
public class ServiceGenerator extends Generator {
    String SERVICE_PATH = JAVA_PATH+"/service";
    @Override
    void generate(String entityClassName){
        generateFile(SERVICE_PATH+"/"+entityClassName+"Service.java", generatorTemplate("service", entityClassName));
    }
}

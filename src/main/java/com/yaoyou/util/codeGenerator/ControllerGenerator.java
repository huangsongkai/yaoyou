package com.yaoyou.util.codeGenerator;

/**
 * Created by song on 16/9/1.
 */
public class ControllerGenerator extends Generator {
    String CONTROLLER_PATH = JAVA_PATH+"/interfaces/controller";
    @Override
    void generate(String entityClassName){
        generateFile(CONTROLLER_PATH+"/"+entityClassName+"Controller.java", generatorTemplate("controller", entityClassName));
    }
}

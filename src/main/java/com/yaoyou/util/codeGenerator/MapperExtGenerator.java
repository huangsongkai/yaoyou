package com.yaoyou.util.codeGenerator;

/**
 * Created by song on 16/9/2.
 */
public class MapperExtGenerator extends Generator {
    String MAPPER_PATH = JAVA_PATH+"/dao";
    @Override
    void generate(String entityClassName){
        generateFile(MAPPER_PATH+"/"+entityClassName+"MapperExt.java", generatorTemplate("mapperExt", entityClassName));
    }

}

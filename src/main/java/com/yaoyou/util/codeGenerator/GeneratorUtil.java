package com.yaoyou.util.codeGenerator;

/**
 * Created by song on 16/9/1.
 */
public class GeneratorUtil {
    public static void generateJsp(String classSimpleName){
        new JSPGenerator().generate(classSimpleName);
    }

    public static void generateController(String classSimpleName){
        new ControllerGenerator().generate(classSimpleName);
    }

    public static void generateService(String classSimpleName){
        new ServiceGenerator().generate(classSimpleName);
    }
    public static void generateMapperExt(String classSimpleName){
        new MapperExtGenerator().generate(classSimpleName);
    }

    public static void generateAll(String classSimpleName){
        generateJsp(classSimpleName);
        generateController(classSimpleName);
        generateService(classSimpleName);
        generateMapperExt(classSimpleName);
    }

    public static void main(String args[]){
        GeneratorUtil.generateAll("User");
//        GeneratorUtil.generateMapperExt("User");
    }
}

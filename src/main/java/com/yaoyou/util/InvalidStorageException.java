package com.yaoyou.util;

/**
 * Created by song on 16/8/6.
 */
public class InvalidStorageException extends RuntimeException {
    public InvalidStorageException(){
        super("Storage not enough");
    }
    @Override
    public String toString(){
        return "Storage not enough";
    }
}


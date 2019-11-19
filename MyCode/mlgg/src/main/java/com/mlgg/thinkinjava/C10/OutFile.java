package com.mlgg.thinkinjava.C10;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * <Description> <br>
 *
 * @author zhang.yifei4<br>
 * @Date 11:01 2019/11/1
 * @see com.mlgg.thinkinjava.C10
 */
public class OutFile extends DataOutputStream {

    public OutFile(String filename) throws IOException {
        super(new BufferedOutputStream(new FileOutputStream(filename)));
    }

    public OutFile(File file) throws IOException {
        this(file.getPath());
    }
}

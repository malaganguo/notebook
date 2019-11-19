package com.mlgg.thinkinjava.C10;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

/**
 * <Description> <br>
 *
 * @author zhang.yifei4<br>
 * @Date 14:35 2019/11/1
 * @see com.mlgg.thinkinjava.C10
 */
public class Redirecting {
    public static void main(String[] args) {
        String redirectingPath = "E:\\mlgg\\src\\main\\java\\com\\mlgg\\thinkinjava\\C10\\Redirecting.java";
        try {
            BufferedInputStream in = new BufferedInputStream(new FileInputStream(redirectingPath));
            // Produces deprecation message:
            PrintStream out = new PrintStream(new BufferedOutputStream(new FileOutputStream("E:\\mlgg\\src\\main\\java\\com\\mlgg\\thinkinjava\\C10\\test.out")));
            System.setIn(in);
            System.setOut(out);
            System.setErr(out);
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String s;
            while ((s = br.readLine()) != null)
                System.out.println(s);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

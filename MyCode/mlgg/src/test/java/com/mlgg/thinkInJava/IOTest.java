package com.mlgg.thinkInJava;

import com.mlgg.thinkinjava.C10.OutFile;
import org.junit.Test;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.zip.GZIPInputStream;

/**
 * <Description> <br>
 *
 * @author zhang.yifei4<br>
 * @Date 14:04 2019/10/31
 * @see com.mlgg.thinkInJava
 */
public class IOTest {

    private final static String SANZIJING_PATH = "E:\\mlgg\\src\\main\\resources\\file\\三字经.txt";
    private final static String MANANDCAT_PATH = "E:\\mlgg\\src\\main\\resources\\file\\The Old Man and the Old Cat.txt";
    private final static String NUMBER_PATH = "E:\\mlgg\\src\\main\\resources\\file\\number.txt";
    private final static String FILE_PATH = "E:\\mlgg\\src\\main\\resources\\file";
    private final static String TOMCAT_GZ_PATH = "E:\\mlgg\\src\\main\\resources\\file\\apache-tomcat-7.0.96.tar.gz";

    @Test
    public void test1() {
        DataInputStream dataInputStream = null;
        DataOutputStream dataOutputStream = null;
        try {
            String path = "E:\\mlgg\\src\\main\\resources\\file\\The Old Man and the Old Cat.txt";
            String outPath = "E:\\mlgg\\src\\test\\java\\com\\mlgg\\thinkInJava\\The Old Man and the Old Cat(Copy).txt";
            dataInputStream = new DataInputStream(new FileInputStream(new File(path)));
            byte[] bytes = new byte[1024];
            int length = 0;
            dataOutputStream = new DataOutputStream(new FileOutputStream(new File(outPath)));
            while ((length = dataInputStream.read(bytes)) != -1) {
//                dataOutputStream.write(bytes,0,1024);
                System.out.println(new String(bytes,0, length));
                dataOutputStream.write(bytes, 0, length);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(dataOutputStream != null) {
                try {
                    dataOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(dataInputStream != null) {
                try {
                    dataInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void test2() throws IOException {
        DataInputStream dataInputStream = new DataInputStream(new FileInputStream(new File(NUMBER_PATH)));
        int i = dataInputStream.readInt();
        System.out.println(i);
    }

    @Test
    public void test3() {
        File file = new File(SANZIJING_PATH);
        System.out.println(file);

        System.out.println();

        File files = new File(FILE_PATH);
        String[] list = files.list();
        for (String name: list) {
            System.out.println(name);
        }
    }

    @Test
    //目录过滤器
    public void test4() {
        File file = new File(FILE_PATH);
        //回调
        String[] list = file.list(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                String f = new File(name).getName();
                System.out.println(f);
                return true;
            }
        });
        for (String s : list) {
            System.out.println(s);
        }
    }

    //缓冲流
    @Test
    public void test5() {
        DataInputStream in = null;
        DataOutputStream out = null;
        try{
            in = new DataInputStream(new BufferedInputStream(new FileInputStream(MANANDCAT_PATH)));
            out = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("E:\\mlgg\\src\\test\\java\\com\\mlgg\\thinkInJava\\TOMATOCtest5.txt")));
            while ((in.available()) != 0) {
                System.out.print((char) in.readByte());
            }
            System.out.println("\n--------------------");
            while ((in.available()) != 0) {
                System.out.print( in.readChar());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //封装
    @Test
    public void test6() {
        try (OutFile outFile = new OutFile("三字经Copy.txt")) {
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //BufferedReader
    @Test
    public void Test7() {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(SANZIJING_PATH));
            String s, s2 = null;
            while ((s = reader.readLine()) != null) {
                s2 += s + "\n";
            }
            reader.close();
            System.out.println(s2);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //gz压缩读取   存在大量的乱码
    @Test
    public void test8() {
        BufferedInputStream in = null;
        try {
            in = new BufferedInputStream(new GZIPInputStream(new FileInputStream(TOMCAT_GZ_PATH)));
            System.out.println("read file");
            byte[] b = new byte[1024];
            int length;

            while ((length = in.read(b)) != -1) {
                System.out.println(new String(b,0, length));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //gz压缩文件读取（字符流）  太慢了，也无法验证对不对
    @Test
    public void test9() {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(new GZIPInputStream(new FileInputStream(TOMCAT_GZ_PATH))));
            String s,ss=null;
            while((s = reader.readLine()) != null) {
                ss += s +"\n";
            }
            System.out.println(ss);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

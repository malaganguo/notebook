package com.mlgg.thinkinjava.C10;

import java.io.File;
import java.io.FilenameFilter;

/**
 * <Description> <br>
 *
 * @author zhang.yifei4<br>
 * @Date 15:52 2019/10/31
 * @see com.mlgg.thinkinjava.C10
 */
public class DirList {
    public static void main(String[] args) {
        try {
            File path = new File(".");
            String[] list;
            if(args.length == 0)
                list = path.list();
            else
//                list = path.list(new DirFilter(args[0]));
                list = path.list(new FilenameFilter() {
                    @Override
                    public boolean accept(File dir, String name) {
                        String f = new File(name).getName();
                        return f.indexOf(args[0]) != -1;
                    }
                });
            for(int i = 0; i < list.length; i++)
                System.out.println(list[i]);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

}
class DirFilter implements FilenameFilter {
    String afn;
    DirFilter(String afn) { this.afn = afn; }
    public boolean accept(File dir, String name) {
// Strip path information:
        String f = new File(name).getName();
        return f.indexOf(afn) != -1;
    }
}
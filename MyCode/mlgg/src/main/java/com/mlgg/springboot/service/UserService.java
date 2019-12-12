package com.mlgg.springboot.service;

import com.google.common.base.Strings;
import com.mlgg.springboot.req.UserRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.net.URL;

/**
 * <Description> <br>
 *
 * @author zhang.yifei4<br>
 * @Date 17:56 2019/12/12
 * @see com.mlgg.springboot.service
 */
@Service
@Slf4j
public class UserService {
    private static String USER_FILE_NAME = "file/user.txt";

    public Integer AddUser(UserRequest userRequest) throws Exception {
        if(!Strings.isNullOrEmpty(userRequest.getUsername())) {
            try(BufferedWriter br = new BufferedWriter(new FileWriter(getFile(USER_FILE_NAME),true))) {
                br.write(userRequest.toString());
                br.newLine();
                br.flush();
                return 1;
            } catch (Exception e) {
                e.printStackTrace();
                return 0;
            }
        } else {
            throw new Exception("username is empty!");
        }

    }


    /**
     * 获取目的文件url
     * @param fileName
     * @return
     */
    private File getFile(String fileName) {
        ClassLoader classLoader = getClass().getClassLoader();
        URL url = classLoader.getResource(fileName);
        log.info("output url is {}",url);
        return new File(url.getFile());
    }
}

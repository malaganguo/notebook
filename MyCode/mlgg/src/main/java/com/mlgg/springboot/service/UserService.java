package com.mlgg.springboot.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import com.mlgg.springboot.req.UserRequest;
import com.mlgg.springboot.res.UserResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

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

    public Integer addUser(UserRequest userRequest) throws Exception {
        if(!Strings.isNullOrEmpty(userRequest.getUsername())) {
            try(BufferedWriter br = new BufferedWriter(new FileWriter(getFile(USER_FILE_NAME),true))) {
                br.write(userRequest.toJsonString());
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

    public List<UserResponse> getAllUserFromFile() throws Exception {
        if(getFile(USER_FILE_NAME).exists() && getFile(USER_FILE_NAME).length() != 0) {
            try(
                    BufferedReader br = new BufferedReader(new FileReader(getFile(USER_FILE_NAME)));
                    ){
                String str = "";
                List<UserResponse> allUserJsonList = Lists.newArrayList();
                while ((str = br.readLine()) != null) {
                    allUserJsonList.add((UserResponse) JSON.parseObject(str).toJavaObject(UserResponse.class));
                }
                return allUserJsonList;
            }catch (Exception e) {
                /*log.error("get all user error,reason is {}", e.getMessage());
                throw new Exception("get all user error");*/
                e.printStackTrace();
            }
        }
        return null;
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

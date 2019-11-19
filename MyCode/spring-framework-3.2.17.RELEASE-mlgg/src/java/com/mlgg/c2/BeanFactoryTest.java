package com.mlgg.c2;

import com.mlgg.c2.bean.MyTestBean;
import com.mlgg.c2.bean.Phone;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.io.InputStream;

/**
 * <Description> <br>
 *
 * @author zhang.yifei4<br>
 * @Date 17:19 2019/10/28
 * @see com.mlgg.c2
 */
@SuppressWarnings("deprecation")
public class BeanFactoryTest {

    @Test
    public void testSimpleLoad() {
        BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("beanFactoryTest.xml"));
        MyTestBean myTestBean = (MyTestBean) beanFactory.getBean("myTestBean");
        System.out.println(myTestBean.getTestStr());
    }

    @Test
    public void testReadSource() throws IOException {
        Resource resource = new ClassPathResource("beanFactoryTest.xml");
        InputStream inputStream = resource.getInputStream();

        int by = 0 ;//必须要给by初始化为0，否则输出会缺少
        while((by=inputStream.read()) != -1) {
            System.out.print((char)by);
        }
        inputStream.close();
    }

    @Test
    public void testIgnoreDependencyInterface() {
        BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("beanFactoryTest.xml"));
        Phone phone = (Phone) beanFactory.getBean("phone");
        System.out.println(phone);
        System.out.println(new Phone());
    }

}

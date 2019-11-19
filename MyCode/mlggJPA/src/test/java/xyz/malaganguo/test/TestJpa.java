package xyz.malaganguo.test;

import org.junit.Test;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

/**
 * <Description> <br>
 *
 * @author zhang.yifei4<br>
 * @Date 19:28 2019/11/12
 * @see xyz.malaganguo.test
 */
public class TestJpa {

    @Test
    public void test1() {
        XmlBeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("classpath:applicationContext.xml"));
    }
}

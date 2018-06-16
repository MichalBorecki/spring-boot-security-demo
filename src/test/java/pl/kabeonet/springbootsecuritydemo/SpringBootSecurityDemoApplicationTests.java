package pl.kabeonet.springbootsecuritydemo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBootSecurityDemoApplication.class)
@WebAppConfiguration
public class SpringBootSecurityDemoApplicationTests {

    @Test
    public void contextLoads() {
    }

}

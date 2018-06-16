package pl.kabeonet.springbootsecuritydemo.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import pl.kabeonet.springbootsecuritydemo.SpringBootSecurityDemoApplication;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBootSecurityDemoApplication.class)
@WebAppConfiguration
public class CarRepositoryTest {

    @Test
    public void contextLoads() {
    }
}
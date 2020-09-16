package br.com.hoffmann.brasilprev.config;

import java.io.IOException;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AbstractRefreshableWebApplicationContext;

@ContextConfiguration(classes = {TestConfiguration.class, MockServletContext.class,
    MainConfiguration.class})
@WebAppConfiguration
public abstract class ConfigTest extends AbstractTestNGSpringContextTests {

}
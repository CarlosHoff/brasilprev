package br.com.hoffmann.brasilprev.config;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;

@ContextConfiguration(classes = {TestConfiguration.class, MockServletContext.class,
    MainConfiguration.class})
@WebAppConfiguration
public abstract class ConfigTest extends AbstractTestNGSpringContextTests {

}
package br.com.hoffmann.brasilprev;

import br.com.hoffmann.brasilprev.config.MainConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;

@SpringBootTest
@ContextConfiguration(classes = {TestConfiguration.class, MockServletContext.class,
    MainConfiguration.class})
@WebAppConfiguration
class BrasilprevApplicationTests extends BrasilprevApplication {

}

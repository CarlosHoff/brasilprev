package br.com.hoffmann.brasilprev.config;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

import javax.servlet.http.HttpServletRequest;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

public abstract class ControllerConfigTest extends AbstractTestNGSpringContextTests {

  public static final String CUSTOMER_TOKEN;

  @Autowired
  protected Environment environment;

  @Mock
  protected HttpServletRequest req;

  static {
    CUSTOMER_TOKEN = "eyAgICJhbGciOiAiSFMyNTYiIH0.ew0KICAic3ViIjogIk5leHRfYmFuayIsDQogICJ1c2VyRGF0YSI6eyJob3N0TmFtZSI6IjEwLjE5NS4xODIuMTIwIiwiYWdlbnRJZCI6Ikk5MDEwMDEiLCJ0aWNrZXQiOiI5QTREOTUzMjI3NDI3ODA3IiwiY2xhaW1zIjp7InN5c21nbXQiOnRydWV9LCJzZXNzaW9uSWQiOiIwMDFENjM1RTlEMjNDRkNYMDJBOTBFNDM3MzRENEU5NSIsImRldmljZUlkIjoiT3B0aW9uYWwuZW1wdHkifSwNCiAgImp0aSI6IjAwMUQ2MzVFOUQyM0NGQ1gwMkE5MEU0MzczNEQ0RTk1Ig0KfQ.CzvMmpBYhkNo24dY1vdJj0b3p2X4i6Ew9y61a4Sl-rQ";
  }

  protected MockMvc mvc;
  protected HttpHeaders httpHeaders;

  protected void setUp(Object controller, Object restExceptionHandler) {
    mvc = standaloneSetup(controller)
        .setControllerAdvice(restExceptionHandler).build();

    httpHeaders = new HttpHeaders();
    httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
    httpHeaders.set("X-Next-AuthToken", CUSTOMER_TOKEN);

  }

  protected ResultActions performPutAndCheckIsNotFound(String url) throws Exception {
    return mvc.perform(put(url).headers(httpHeaders)
        .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isNotFound());
  }

  protected ResultActions performPutAndCheckIsBadRequest(String url) throws Exception {
    return mvc.perform(put(url).headers(httpHeaders)
        .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isBadRequest());
  }

  protected ResultActions performPutAndCheckIsNoContent(String url) throws Exception {
    return mvc.perform(put(url).headers(httpHeaders)
        .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isNoContent());
  }


  protected ResultActions performPutWithContentAndCheckIsNoContent(String url, String content)
      throws Exception {
    return mvc.perform(put(url).headers(httpHeaders)
        .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)
        .content(content))
        .andExpect(status().isNoContent());
  }

  protected ResultActions performPutWithContentListOfStatus(String url) throws Exception {
    return mvc.perform(put(url).headers(httpHeaders)
        .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON));
  }

  protected ResultActions performPutWithContentAndCheckIsNotFound(String url, String content)
      throws Exception {
    return mvc.perform(put(url).headers(httpHeaders)
        .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)
        .content(content))
        .andExpect(status().isNotFound());
  }

  protected ResultActions performGet(String url) throws Exception {
    return mvc.perform(get(url).headers(httpHeaders)
        .contentType(MediaType.APPLICATION_JSON)
        .accept(MediaType.APPLICATION_JSON));
  }

  protected ResultActions performGetAndCheckIsOK(String url)
      throws Exception {
    return mvc.perform(get(url).headers(httpHeaders)
        .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk());
  }

  protected ResultActions performPutWithContentAndCheckIsOK(String url, String content)
      throws Exception {
    return mvc.perform(put(url).headers(httpHeaders)
        .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)
        .content(content))
        .andExpect(status().isOk());
  }

  protected ResultActions performPutWithContentAndCheckIsCreated(String url, String content)
      throws Exception {
    return mvc.perform(put(url).headers(httpHeaders)
        .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)
        .content(content))
        .andExpect(status().isCreated());
  }

  protected ResultActions performGetAndCheckIsNotFound(String url)
      throws Exception {
    return mvc.perform(get(url).headers(httpHeaders)
        .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isNotFound());
  }

  protected ResultActions performGetWithContentAndCheckIsOK(String url, String content)
      throws Exception {
    return mvc.perform(get(url).headers(httpHeaders)
        .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)
        .content(content))
        .andExpect(status().isOk());
  }

  protected ResultActions performPostWithContentAndCheckIsCreated(String url, String content)
      throws Exception {
    return mvc.perform(post(url).headers(httpHeaders)
        .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)
        .content(content))
        .andExpect(status().isCreated());
  }

  protected ResultActions performPostWithContentAndCheckIsAccepted(String url, String content)
      throws Exception {
    return mvc.perform(post(url).headers(httpHeaders)
        .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)
        .content(content))
        .andExpect(status().isAccepted());
  }

  protected ResultActions performGetWithContentAndCheckIsNotFound(String url, String content)
      throws Exception {
    return mvc.perform(get(url).headers(httpHeaders)
        .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)
        .content(content))
        .andExpect(status().isNotFound());
  }

  protected ResultActions performPostWithContentAndCheckIsBadRequest(String url, String content)
      throws Exception {
    return mvc.perform(post(url).headers(httpHeaders)
        .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)
        .content(content))
        .andExpect(status().isBadRequest());
  }

  protected ResultActions performPostWithContent(String url, String content)
      throws Exception {
    return mvc.perform(post(url).headers(httpHeaders)
        .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)
        .content(content));
  }


  protected ResultActions performDeleteWithId(String url)
      throws Exception {
    return mvc.perform(delete(url).headers(httpHeaders).contentType(MediaType.APPLICATION_JSON)
        .accept(MediaType.APPLICATION_JSON))
        .andDo(print());
  }

  protected ResultActions performGetWithContentAndIsEmpty(String url, String content)
      throws Exception {
    return mvc.perform(get(url).headers(httpHeaders)
        .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)
        .content(content))
        .andExpect(status().isOk());
  }
}
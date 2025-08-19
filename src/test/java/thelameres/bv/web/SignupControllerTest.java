package thelameres.bv.web;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import thelameres.bv.BvApplicationTests;
import thelameres.bv.dto.SignupDto;

@AutoConfigureMockMvc
class SignupControllerTest extends BvApplicationTests {

  private final MockMvc mockMvc;
  private final ObjectMapper objectMapper;

  @Autowired
  public SignupControllerTest(MockMvc mockMvc, ObjectMapper objectMapper) {
    this.mockMvc = mockMvc;
    this.objectMapper = objectMapper;
  }

  @Test
  void signup() throws Exception {

    var signupDto = new SignupDto("Alexey", "+79999999999", "89991234567");

    mockMvc.perform(
        post("/v1/signup")
            .contentType(MediaType.APPLICATION_JSON_VALUE)
            .content(objectMapper.writeValueAsString(signupDto))
            .accept(MediaType.APPLICATION_JSON_VALUE)
    )
        .andDo(print())
        .andExpect(status().is2xxSuccessful());
  }

  @Test
  void signup_whenMobilePhoneIsNull() throws Exception {
    var signupDto = new SignupDto("Alexey", "+79999999999", null);

    mockMvc.perform(
            post("/v1/signup")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(objectMapper.writeValueAsString(signupDto))
                .accept(MediaType.APPLICATION_JSON_VALUE)
        )
        .andDo(print())
        .andExpect(status().is4xxClientError());
  }

  @Test
  void signup_whenNameAndPhoneIsNull() throws Exception {
    var signupDto = new SignupDto(null, null, null);

    mockMvc.perform(
            post("/v1/signup")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(objectMapper.writeValueAsString(signupDto))
                .accept(MediaType.APPLICATION_JSON_VALUE)
        )
        .andDo(print())
        .andExpect(status().is4xxClientError());
  }

  @Test
  void signup_whenPhonesIsInvalid() throws Exception {
    var signupDto = new SignupDto("Alexey", "+7", "+7");

    mockMvc.perform(
            post("/v1/signup")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(objectMapper.writeValueAsString(signupDto))
                .accept(MediaType.APPLICATION_JSON_VALUE)
        )
        .andDo(print())
        .andExpect(status().is4xxClientError());
  }
}
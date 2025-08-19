package thelameres.bv.web;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import thelameres.bv.dto.SignupDto;

@RestController
@RequestMapping("/v1/signup")
public class SignupController {

  @PostMapping
  public ResponseEntity<Void> signup(@RequestBody @Validated SignupDto signupDto) {
    return ResponseEntity.ok().build();
  }

}


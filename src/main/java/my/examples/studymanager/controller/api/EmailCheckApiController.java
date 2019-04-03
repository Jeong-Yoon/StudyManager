package my.examples.studymanager.controller.api;

import lombok.RequiredArgsConstructor;
import my.examples.studymanager.dto.EmailCheckDto;
import my.examples.studymanager.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/emailCheck")
@RequiredArgsConstructor
public class EmailCheckApiController {
    private final UserService userService;

    @PostMapping
    public int emailCheck(@RequestBody EmailCheckDto emailCheckDto){
        int emailChk = userService.emailChk(emailCheckDto.getEmail());
        return emailChk;
    }
}

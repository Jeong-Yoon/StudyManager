package my.examples.studymanager.controller.api;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import my.examples.studymanager.domain.User;
import my.examples.studymanager.dto.EmailCheckDto;
import my.examples.studymanager.dto.JoinFormDto;
import my.examples.studymanager.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
@Slf4j
public class UserApiController {
    private final UserService userService;

    @PostMapping("/emailCheck")
    public ResponseEntity<Integer> emailCheck(@RequestBody EmailCheckDto emailCheckDto){
        int emailChk = userService.emailChk(emailCheckDto.getEmail());
        return new ResponseEntity<>(emailChk, HttpStatus.OK);
    }

    @PostMapping("/join")
    public ResponseEntity<User> join(@Valid @RequestBody JoinFormDto joinFormDto, BindingResult bindingResult){
        System.out.println("==========="+joinFormDto.getPasswd1());
        // join form을 완성시키지 못함
        if(bindingResult.hasErrors()){
//            throw new IllegalArgumentException(bindingResult.toString());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        //비밀번호와 비밀번호 확인 불일치
        if(!joinFormDto.getPasswd1().equals(joinFormDto.getPasswd2())){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//            throw new IllegalArgumentException("비밀번호가 일치하지 않아요!!");
        }
        // email 중복
        if(userService.emailChk(joinFormDto.getEmail()) == 1){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }

        User user = new User();
        user.setName(joinFormDto.getName());
        user.setEmail(joinFormDto.getEmail());
        user.setPhone(joinFormDto.getPhone());

        // 비밀번호 암호화
        PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        user.setPasswd(passwordEncoder.encode(joinFormDto.getPasswd1()));
        User result = userService.addUser(user);

        // 저장된 유저 리턴 (201: CREATED)
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public String login(){
        return"/study/list";
    }
}

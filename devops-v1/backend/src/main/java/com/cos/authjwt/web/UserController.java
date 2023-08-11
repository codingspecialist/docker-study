package com.cos.authjwt.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cos.authjwt.config.auth.LoginUser;
import com.cos.authjwt.domain.user.User;
import com.cos.authjwt.service.UserService;
import com.cos.authjwt.web.dto.CMRespDto;

import lombok.RequiredArgsConstructor;

@RequestMapping("/api")
@RequiredArgsConstructor
@RestController // 데이터만 리턴한다.
public class UserController {

	private final UserService userService;

	// Post : /login (Json) - 이건 JwtAutenticationFilter 에서!!

	@PostMapping("/join")
	public CMRespDto<?> join(@RequestBody User user) {
		System.out.println("나실행됨 ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		User userEntity = userService.회원가입(user);
		userEntity.setPassword(null); // password는 돌려주지 않는다. (컨트롤러에서 변경했기 때문에 dirty checking 안됨)
		return new CMRespDto<>(1, "회원가입완료", userEntity);
	}

	// @LoginUser로 세션정보 접근 가능!!
	@GetMapping("/user/{id}")
	public CMRespDto<?> userinfo(@PathVariable Integer id, @LoginUser User principal) {

		if (principal.getId() == id) {
			User userEntity = userService.회원정보보기(id);
			return new CMRespDto<>(1, "회원정보확인완료", userEntity);
		} else {
			return new CMRespDto<>(-1, "권한이 없습니다.", null);
		}

	}

	// Test 용 (실제 앱에서 사용안함)
	@PutMapping("/user/{id}")
	public CMRespDto<?> userUpdate(@PathVariable Integer id, @RequestBody User user, @LoginUser User principal) {

		if (principal.getId() == id) {
			return new CMRespDto<>(1, "회원정보수정완료", userService.회원수정(id, user));
		} else {
			return new CMRespDto<>(-1, "권한이 없습니다.", null);
		}

	}

	@GetMapping("/init/user")
	public CMRespDto<?> initUser() {
		return new CMRespDto<>(1, "목록보기완료", userService.회원목록보기());
	}

}

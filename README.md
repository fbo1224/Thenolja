# THE NOLJA — 숙박 예약 플랫폼

> 사용자 취향에 맞는 숙소 정보를 제공하고 직관적인 흐름으로 예약까지 이어지는 숙박 서비스

![Java](https://img.shields.io/badge/Java-007396?style=flat&logo=java&logoColor=white)
![Spring](https://img.shields.io/badge/Spring-6DB33F?style=flat&logo=spring&logoColor=white)
![JavaScript](https://img.shields.io/badge/JavaScript-F7DF1E?style=flat&logo=javascript&logoColor=black)
![Oracle](https://img.shields.io/badge/Oracle-F80000?style=flat&logo=oracle&logoColor=white)

<br>

## 기술 스택

| 분류 | 기술 |
|---|---|
| 백엔드 | Java · Spring Framework |
| 프론트엔드 | JavaScript · jQuery · Ajax · JSTL |
| 데이터베이스 | Oracle DB · MyBatis |
| 보안 | BCryptPasswordEncoder |
| 인프라 | AWS |

<br>

## 아키텍처

```
Client (JSP)
    ↕ Ajax
Spring Controller
    ↕
Service → MyBatis Mapper → Oracle DB
```

<br>

## 핵심 코드

### 닉네임 중복 확인 — 실시간 Ajax

입력값 2글자 이상일 때 서버에 중복 여부를 요청하고 반환값으로 결과를 표시한다.

```javascript
$nickname.keyup(() => {
  if ($nickname.val().length >= 2) {
    $.ajax({
      url: 'nickNameCheck.do',
      data: { checkNickname: $nickname.val() },
      success: result => {
        if (result.substr(4) === 'N') {
          $checkResult.show().css('color', 'orangered').text('중복되는 닉네임입니다.');
        } else {
          $checkResult.show().css('color', 'green').text('사용가능한 닉네임입니다.');
        }
      }
    });
  } else {
    $checkResult.hide();
  }
});
```

### 비밀번호 재설정 — BCrypt 암호화

기존 비밀번호를 노출하지 않고 새 비밀번호를 입력받아 BCrypt 암호화 후 저장한다.

```java
@PostMapping("resetPwd")
public ModelAndView resetPwd(ModelAndView mv, HttpSession session,
                             String memId, String memPwd) {
  String newPwd = bcryptPasswordEncoder.encode(memPwd);
  Member member = new Member();
  member.setMemId(memId);
  member.setMemPwd(newPwd);
  if (memberService.resetPwd(member) > 0) {
    session.setAttribute("alertMsg", "비밀번호 변경에 성공하였습니다.");
    mv.setViewName("redirect:/");
  } else {
    mv.addObject("errorMsg", "비밀번호 변경에 실패하였습니다.")
      .setViewName("common/errorPage");
  }
  return mv;
}
```

### 프로필 사진 — INSERT / UPDATE 분기

이전 이력이 있으면 UPDATE, 없으면 INSERT. 파일명은 랜덤 숫자를 붙여 중복을 방지한다.

```java
@PostMapping("insertProfile")
public String insertProfile(Profile profile, MultipartFile upfile, HttpSession session) {
  profile.setProfilePath(saveFile(upfile, session));
  if (mypageService.updateProfile(profile) == 0) {
    mypageService.insertProfile(profile);
  }
  session.setAttribute("alertMsg", "사진변경 성공!");
  return "redirect:/myPage";
}
```

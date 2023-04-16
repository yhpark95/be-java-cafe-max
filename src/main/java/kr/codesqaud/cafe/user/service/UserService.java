package kr.codesqaud.cafe.user.service;

import kr.codesqaud.cafe.user.domain.User;
import kr.codesqaud.cafe.user.dto.UserFormDto;
import kr.codesqaud.cafe.user.dto.UserPreviewDto;
import kr.codesqaud.cafe.user.dto.UserProfileDto;
import kr.codesqaud.cafe.user.mapper.UserDtoMapper;
import kr.codesqaud.cafe.user.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {


    private final UserRepository userRepository;


    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //ID 중복 확인 후 회원가입
    public String join(UserFormDto userFormDto) {
        User user = UserDtoMapper.INSTANCE.toUser(userFormDto);
        validateDuplicateMember(user); //중복 회원 검증
        userRepository.save(user);
        return user.getUserId();
    }

    //중복 확인(중복이 들어오면 에러 페이지로 감)
    private void validateDuplicateMember(User user) {
        userRepository.findById(user.getUserId())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }


    //회원목록 조회(+DTO로 필터)
    public List<UserPreviewDto> getUserList() {
        List<User> users = userRepository.findAll();
        List<UserPreviewDto> userPreviewDtos = new ArrayList<>();
        for (User user : users) {
            userPreviewDtos.add(UserDtoMapper.INSTANCE.toPreviewDto(user));
        }
        return userPreviewDtos;
    }


    //특정 회원 조회(+DTO 필터)
    public UserProfileDto getUserProfile(String userId) {
        User user = userRepository.findById(userId).orElse(null);
        return UserDtoMapper.INSTANCE.toProfileDto(user);
    }

    public User findAndAuthenticate(String userId, String password) {
        User user = userRepository.findById(userId).orElse(null);
        if(user != null){
            return user.getPassword().equals(password) ? user : null;
        }
        return null;
    }
}

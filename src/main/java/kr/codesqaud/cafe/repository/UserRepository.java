package kr.codesqaud.cafe.repository;
import kr.codesqaud.cafe.domain.User;

import java.util.*;

public interface UserRepository {
    public String save(User user);

    public List<User> findAll();

    public Optional<User> findByID(String userID);

}

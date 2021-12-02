package CC1.domain;

import java.util.List;

public interface UserRepository {
    void save(User user);

    User byId(UserId userId);

    UserId nextIdentity();

    List<User> findAll();

    boolean isValidUser(UserId userId);

    boolean UserExist(UserId userId);
}

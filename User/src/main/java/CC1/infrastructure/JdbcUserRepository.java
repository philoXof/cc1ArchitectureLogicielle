package CC1.infrastructure;


import CC1.domain.User;
import CC1.domain.UserId;
import CC1.domain.UserRepository;

import java.util.List;

public final class JdbcUserRepository implements UserRepository {

    @Override
    public void save(User user) {
        throw new UnsupportedOperationException("Not yet implemented.");
    }

    @Override
    public User byId(UserId userId) {
        throw new UnsupportedOperationException("Not yet implemented.");
    }

    @Override
    public UserId nextIdentity() {
        throw new UnsupportedOperationException("Not yet implemented.");
    }

    @Override
    public List<User> findAll() {
        throw new UnsupportedOperationException("Not yet implemented.");
    }

    @Override
    public boolean isValidUser(UserId userId) {
        throw new UnsupportedOperationException("Not yet implemented.");
    }

    @Override
    public boolean UserExist(UserId userId) {
        throw new UnsupportedOperationException("Not yet implemented.");
    }
}

package CC1.infrastructure;


import CC1.domain.User;
import CC1.domain.UserId;
import CC1.domain.UserRepository;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public final class InMemoryUserRepository implements UserRepository {

    private final AtomicInteger counter = new AtomicInteger(0);
    private final Map<UserId, User> data = new ConcurrentHashMap<>();

    @Override
    public void save(User user) {
        data.put(user.getUserId(), user);
    }

    @Override
    public User byId(UserId userId) {
        final User user = data.get(userId);
        if (user == null) {
            throw new RuntimeException("No user for " + userId.getValue());
        }
        return user;
    }

    @Override
    public UserId nextIdentity() {
        return UserId.of(counter.incrementAndGet());
    }

    @Override
    public List<User> findAll() {
        return data.values().stream().collect(Collectors.toList());
    }

    @Override
    public boolean isValidUser(UserId userId) {
        final User user = data.get(userId);
        return user.IsValid();
    }

    @Override
    public boolean UserExist(UserId userId) {
        return data.get(userId) != null;

    }



}

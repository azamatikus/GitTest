package hw03.server.auth;

import hw03.server.User;

public interface AuthService {

    boolean authUser(User user);
}

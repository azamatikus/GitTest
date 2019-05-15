package hw02.server.auth;

import hw02.server.User;

public interface AuthService {

    boolean authUser(User user);
}

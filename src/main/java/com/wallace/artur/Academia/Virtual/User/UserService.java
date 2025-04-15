package com.wallace.artur.Academia.Virtual.User;

import com.wallace.artur.Academia.Virtual.AcessToken;

public interface UserService {
    User getByEmail(String email);
    AcessToken authenticate(String email, String password);
    User save(User user);

}

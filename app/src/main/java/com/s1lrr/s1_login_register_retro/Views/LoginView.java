package com.s1lrr.s1_login_register_retro.Views;

import com.s1lrr.s1_login_register_retro.Models.User;

/**
 * Created by Mada on 6/30/2018.
 */

public interface LoginView {
    void OpenMain(User user);
    void ErrorMessage();
}

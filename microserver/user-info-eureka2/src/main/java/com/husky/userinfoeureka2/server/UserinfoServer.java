package com.husky.userinfoeureka2.server;



import com.husky.userinfoeureka2.entity.UserInfo;

import java.util.List;

public interface UserinfoServer {
    List<UserInfo> getAll();
}

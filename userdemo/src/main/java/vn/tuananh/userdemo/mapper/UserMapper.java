package vn.tuananh.userdemo.mapper;

import vn.tuananh.userdemo.dto.UserRecord;
import vn.tuananh.userdemo.entity.User;

public class UserMapper {
    public static UserRecord toUserRecord(User user){
        return  new UserRecord(user.getId(), user.getName(), user.getEmail(),user.getPhone(), user.getAddress(), user.getAvatar());
    }
}

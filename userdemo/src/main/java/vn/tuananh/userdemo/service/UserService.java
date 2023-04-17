package vn.tuananh.userdemo.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import vn.tuananh.userdemo.dto.UserRecord;
import vn.tuananh.userdemo.entity.User;
import vn.tuananh.userdemo.request.CreateUser;
import vn.tuananh.userdemo.request.UpdateUser;

import java.util.List;

@Service
public interface UserService {
    public List<UserRecord> getListUser();

    public UserRecord getUser(int id);

    public List<UserRecord> search(String name);
    public UserRecord createUser(CreateUser createUser);

    public UserRecord updatUser(UpdateUser user, int id);

    public void deleteUser(int id);
}



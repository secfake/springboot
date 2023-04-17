package vn.tuananh.userdemo.service;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Component;
import vn.tuananh.userdemo.dto.UserRecord;
import vn.tuananh.userdemo.entity.User;
import vn.tuananh.userdemo.exception.DuplicateRecordException;
import vn.tuananh.userdemo.exception.NotFoundUser;
import vn.tuananh.userdemo.mapper.UserMapper;
import vn.tuananh.userdemo.request.CreateUser;
import vn.tuananh.userdemo.request.UpdateUser;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserServiceImpl implements UserService {
    private static ArrayList<User> users = new ArrayList<User>();
    static int index = 5;

    static {
        users.add(new User(1, "Nguyễn Thị Mộng Mơ", "mongmo@gmail.com", "0987654321", "", "avatar.img", "123"));
        users.add(new User(2, "Bùi Như Lạc", "laclac@gmail.com", "0123456789", "", "avatar1.img", "123"));
        users.add(new User(3, "Phan Thị Lỏng Lẻo", "longleo@gmail.com", "0987564664", "", "avatar3.img", "123"));
        users.add(new User(4, "Bành Thị Tèo", "teo@gmail.com", "0874845455", "", "avatar9.img", "123"));
    }

    @Override
    public List<UserRecord> getListUser() {
        ArrayList<UserRecord> result = new ArrayList<>();

        // Convert users -> result
        for (User user : users) {
            result.add(UserMapper.toUserRecord(user));
        }

        return result;
    }

    @Override
    public UserRecord getUser(int id) {
        for (User user : users) {
            if (user.getId() == id)
                return UserMapper.toUserRecord(user);
        }
        throw new NotFoundUser("Not found user");
    }

    @Override
    public List<UserRecord> search(String name) {
        ArrayList<UserRecord> nameList = new ArrayList<>();
        for (User user : users) {
            if (user.getName().toLowerCase().contains(name.toLowerCase()))
                nameList.add(UserMapper.toUserRecord(user));
        }
        return nameList;
    }

    @Override
    public UserRecord createUser(CreateUser createUser) {
        User user = new User();
        for (User user1 : users) {
            if (user1.getEmail().equals(createUser.getEmail())) {
                throw new DuplicateRecordException("New email already exists in the system");
            }
        }
        user.setId(index++);
        user.setEmail(createUser.getEmail());
        user.setName(createUser.getName());
        user.setPassword(BCrypt.hashpw(createUser.getPassword(), BCrypt.gensalt(12)));
        user.setPhone(createUser.getPhone());
        user.setAddress(createUser.getAddress());
        users.add(user);
        return UserMapper.toUserRecord(user);
    }

    @Override
    public UserRecord updatUser(UpdateUser user1, int id) {

        for (User user : users) {
            if (user.getId() == id) {

                user.setName(user1.getName());
                user.setPhone(user1.getPhone());
                user.setAddress(user1.getAddress());
                users.add(user);
                return UserMapper.toUserRecord(user);
            }
        }
        throw new NotFoundUser("Not found user");
    }

    @Override
    public void deleteUser(int id) {
        for (User user : users) {
            if (user.getId() == id) {
                users.remove(user);
                return;
            }
        }
        throw new NotFoundUser("Not found user");
    }
}

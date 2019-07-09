package qingdao.dazhi.house.service;

import com.github.pagehelper.PageInfo;
import qingdao.dazhi.house.entity.Users;
import qingdao.dazhi.house.util.Pagee;
import qingdao.dazhi.house.util.UserUtil;

public interface UserService {
    PageInfo<Users> getuserinfo(Pagee pagee, UserUtil userUtil);
    public int cheakUserName(String name);
    int add(Users users);
    Users getUser(String name,String password);
}

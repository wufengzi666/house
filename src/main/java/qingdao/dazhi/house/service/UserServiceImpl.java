package qingdao.dazhi.house.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import qingdao.dazhi.house.entity.Users;
import qingdao.dazhi.house.entity.UsersExample;
import qingdao.dazhi.house.mapper.UsersMapper;
import qingdao.dazhi.house.util.MD5Utils;
import qingdao.dazhi.house.util.Pagee;
import qingdao.dazhi.house.util.UserUtil;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UsersMapper usersMapper;
    @Override
    public PageInfo<Users> getuserinfo(Pagee pagee, UserUtil userUtil) {
        UsersExample example=new UsersExample();
        UsersExample.Criteria criteria = example.createCriteria();
        criteria.andIsadminEqualTo(1);
        if(userUtil.getName()!=null){
            criteria.andNameLike("%"+userUtil.getName()+"%");
        }
        if(userUtil.getTelephone()!=null){
            criteria.andTelephoneLike("%"+userUtil.getTelephone()+"%");
        }
        if(userUtil.getMinid()!=null){
            criteria.andIdGreaterThanOrEqualTo(userUtil.getMinid());
        }
        if(userUtil.getMaxid()!=null){
            criteria.andIdLessThanOrEqualTo(userUtil.getMaxid());
        }
        PageHelper.startPage(pagee.getPage(),pagee.getRows());
        List<Users> list=usersMapper.selectByExample(example);
        PageInfo<Users> info=new PageInfo<>(list);
        return  info;
    }

    @Override
    public int cheakUserName(String name) {
        UsersExample example = new UsersExample();
        UsersExample.Criteria criteria = example.createCriteria();
        criteria.andNameEqualTo(name);
        criteria.andIsadminEqualTo(0);
        List<Users> list = usersMapper.selectByExample(example);
        return list.size();
    }

    @Override
    public int add(Users users) {
        users.setIsadmin(0);//设置默认的isadmin值
        //给密码加密
        String pw=MD5Utils.md5Encrypt(users.getPassword());
        users.setPassword(pw);
        return usersMapper.insertSelective(users);
    }

    @Override
    public Users getUser(String name, String password) {
        UsersExample example=new UsersExample();
        UsersExample.Criteria criteria = example.createCriteria();
        criteria.andNameEqualTo(name);
        criteria.andPasswordEqualTo(MD5Utils.md5Encrypt(password));
        List<Users> list=usersMapper.selectByExample(example);
        if(list.size()==0){
            return null;
        }else {
            return list.get(0);
        }
    }
}

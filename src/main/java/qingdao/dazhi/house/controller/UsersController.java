package qingdao.dazhi.house.controller;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import qingdao.dazhi.house.entity.Users;
import qingdao.dazhi.house.service.UserService;
import qingdao.dazhi.house.util.Pagee;
import qingdao.dazhi.house.util.UserUtil;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/admin/")
public class UsersController {
    @Autowired
    UserService userService;
    @RequestMapping("getuserpage")
    @ResponseBody
    public Map getuserpage(Pagee pagee, UserUtil userUtil){
        PageInfo<Users> info=userService.getuserinfo(pagee,userUtil);
        Map<String,Object> map=new HashMap<>();
        map.put("total",info.getTotal());
        map.put("rows",info.getList());
        return map;
    }


}

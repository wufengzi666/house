package qingdao.dazhi.house.protal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import qingdao.dazhi.house.entity.Users;
import qingdao.dazhi.house.service.UserService;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/page/")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("cheakname")
    @ResponseBody
    public String cheakname(String name){
      int  temp= userService.cheakUserName(name);
      return "{\"result\":"+temp+"}";
    }

    @RequestMapping("reg")
    public String add(Users users){
        int  temp= userService.add(users);
        if(temp>0){
            return "login";
        }else {
            return "regs";
        }
    }

    @RequestMapping("log")
    public String log(String name, String password, Model model, HttpSession session){
        Users user = userService.getUser(name, password);
        if(user==null){
            model.addAttribute("info","用户名或密码不正确");
            return "login";
        }else {
            session.setAttribute("logininfo",user);
            session.setMaxInactiveInterval(600);//设置sessiond的有效时间为600秒
            return "redirect:goguanli";
        }
    }
}

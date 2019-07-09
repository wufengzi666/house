package qingdao.dazhi.house.controller;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import qingdao.dazhi.house.entity.Type;
import qingdao.dazhi.house.service.TypeService;
import qingdao.dazhi.house.util.Pagee;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/admin/")
public class TypeController {
    @Autowired
    TypeService typeService;
    @RequestMapping("gettypepage")
    @ResponseBody
    public Map<String,Object>gettypepage(Pagee pagee){
        PageInfo<Type> info=typeService.gettypeinfo(pagee);
        Map<String,Object> map=new HashMap<>();
        map.put("total",info.getTotal());
        map.put("rows",info.getList());
        return map;
    }

    @RequestMapping("addtype")
    @ResponseBody
    public String addtype(Type type){
        int temp=typeService.addtype(type);
        return "{\"resout\":"+temp+"}";
    }

    @RequestMapping("deletetype")
    @ResponseBody
    public String deletetype(Integer id){
        int temp=typeService.deletetype(id);
        return "{\"resout\":"+temp+"}";
    }
}

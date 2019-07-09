package qingdao.dazhi.house.controller;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import qingdao.dazhi.house.entity.House;
import qingdao.dazhi.house.service.HouseService;
import qingdao.dazhi.house.util.Pagee;

import java.util.HashMap;
import java.util.Map;

@Controller(value ="houseController2" )

@RequestMapping("/admin/")
public class HouseController {
    @Autowired
    private HouseService houseService;
    @RequestMapping("gethouseinfo")
    @ResponseBody
    public Map<String,Object> gethouseinfo(Pagee pagee){
        PageInfo<House> info=houseService.getHouseInfo(pagee,0);
        Map<String,Object> map=new HashMap<>();
        map.put("total",info.getTotal());
        map.put("rows",info.getList());
        return map;
    }

    @RequestMapping("pass")
    @ResponseBody
    public String pass(String id){
        int temp=houseService.updatehouse(id);
        return "{result:"+temp+"}";
    }

    @RequestMapping("gethouseinfo1")
    @ResponseBody
    public Map<String,Object> gethouseinfo1(Pagee pagee){
        PageInfo<House> info=houseService.getHouseInfo(pagee,1);
        Map<String,Object> map=new HashMap<>();
        map.put("total",info.getTotal());
        map.put("rows",info.getList());
        return map;
    }
}

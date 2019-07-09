package qingdao.dazhi.house.controller;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import qingdao.dazhi.house.entity.District;
import qingdao.dazhi.house.service.DistrictService;
import qingdao.dazhi.house.util.Pagee;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin/")
public class DisController {
    @Autowired
    private DistrictService districtService;
    @RequestMapping("getDistrict")
    @ResponseBody
    public Map<String,Object> getDistrict(Pagee pagee){
        PageInfo<District> info=districtService.getInfo(pagee);
        Map<String,Object> map=new HashMap<>();
        map.put("total",info.getTotal());
        map.put("rows",info.getList());
        return map;
    }


    @RequestMapping("getadd")
    @ResponseBody
   public String getadd(District district){
        int temp=districtService.add(district);

        return "{\"result\":"+temp+"}";

    }

    @RequestMapping("getupdate")
    @ResponseBody
    public District getadd(Integer id){
     return districtService.getDistrict(id);
    }

    @RequestMapping("update")
    @ResponseBody
    public String update(District district){
        int temp=districtService.update(district);
        /*return "{'resout':"+temp+"}";*/
        return "{\"result\":"+temp+"}";
    }

    @RequestMapping("delete")
    @ResponseBody
    public String delete(Integer id){
        int temp=districtService.delete(id);
        /*return "{'resout':"+temp+"}";*/
        return "{\"result\":"+temp+"}";
    }

    @RequestMapping("deleteMore")
    @ResponseBody
    public String deleteMore(String id){
        String[] arr=id.split(",");
        List<Integer> list=new ArrayList<>();
        for(int i=0;i<arr.length;i++){
            list.add(Integer.parseInt(arr[i]));
        }
        int temp=districtService.deleteMore(list);
        /*return "{'resout':"+temp+"}";*/
        return "{\"result\":"+temp+"}";
    }

}

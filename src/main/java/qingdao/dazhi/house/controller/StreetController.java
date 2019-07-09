package qingdao.dazhi.house.controller;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import qingdao.dazhi.house.entity.Street;
import qingdao.dazhi.house.service.StreetService;
import qingdao.dazhi.house.util.Pagee;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/admin/")
public class StreetController {
    @Autowired
    StreetService streetService;
    @RequestMapping("getstreetpage")
    @ResponseBody
    public Map<String,Object> getstreetpage(Pagee pagee,Integer id){
        PageInfo<Street> info=streetService.getStreetInfo(id,pagee);
        Map<String,Object> map=new HashMap<>();
        map.put("total",info.getTotal());
        map.put("rows",info.getList());
        return map;
    }
}

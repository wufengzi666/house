package qingdao.dazhi.house.protal.controller;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import qingdao.dazhi.house.entity.*;
import qingdao.dazhi.house.service.DistrictService;
import qingdao.dazhi.house.service.HouseService;
import qingdao.dazhi.house.service.StreetService;
import qingdao.dazhi.house.service.TypeService;
import qingdao.dazhi.house.util.Pagee;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.List;

@Controller
@RequestMapping("/page/")
public class HouseController {
    @Autowired
    private TypeService typeService;
    @Autowired
    private DistrictService districtService;
    @Autowired
    private StreetService streetService;
    @Autowired
    private HouseService houseService;
    @RequestMapping("gofabu")
    public String gofabu(Model model){
        List<Type> typeList=typeService.getTypeList();
        List<District> districtList=districtService.getDistrictList();
        model.addAttribute("typeList",typeList);
        model.addAttribute("districtList",districtList);
        return "fabu";
    }

    @RequestMapping("getstreetbydid")
    @ResponseBody
    public List<Street> getstreetbydid(Integer did){
        List<Street> streetList=streetService.getStreetListbudid(did);
        return streetList;
    }

    @RequestMapping("addhouse")
    public String addhouse(HttpSession session, House house,
                           @RequestParam(name = "pfile",required = false)
                                   CommonsMultipartFile pfile,Model model) throws Exception{
        //1.实现图片上传：图片在图片服务器 c:/images
        String filename=pfile.getOriginalFilename();  //1.jpg  上传文件名称
        if(filename!=null&&filename!=""){
            String expname=filename.substring(filename.lastIndexOf("."));  //上传文件的扩展名
            String saveFileName=System.currentTimeMillis()+expname;  //保存文件名称
            String path="c:/images/"+saveFileName;  //保存路径
            File saveFile=new File(path);
            pfile.transferTo(saveFile);  //上传文件

            //2.将输入的数据保存到数据库中
            house.setId(System.currentTimeMillis()+"");  //设置编号
            //设置用户id
            Users user=(Users)session.getAttribute("logininfo");
            house.setUserId(user.getId());
            //设置图片
            house.setPath(saveFileName);

            house.setIsdel(0);  //如果数据有默认值可不设
            house.setIspass(0);  //如果数据有默认值可不设
            //调用业务
            int temp=houseService.addhouse(house);
            if(temp>0){
                return "redirect:goguanli";
            }else{
                saveFile.delete();  //删除文件
            }
            return "redirect:goguanli";
        }else{
            String s="图片等信息填写不完整";
            model.addAttribute("erro",s);
            return "fabu";
        }
    }

    @RequestMapping("goguanli")
    public String goguanli(Pagee pagee,HttpSession session,Model model) {
        Users user = (Users) session.getAttribute("logininfo");
        PageInfo<House> info = houseService.getinfo(pagee, user.getId());
        model.addAttribute("houseinfo",info);
        return "guanli";
    }

    @RequestMapping("goupdate")
    public String goupdate(String id,Model model) {
        List<Type> typeList = typeService.getTypeList();
        List<District> districtList = districtService.getDistrictList();
        model.addAttribute(typeList);
        model.addAttribute(districtList);
        House house = houseService.getHouseByID(id);
        model.addAttribute("house",house);
        return "update";
    }

    @RequestMapping("updatehouse")
    public String updatehouse( House house,String oldpath,String id,
                           @RequestParam(name = "pfile",required = false)
                                   CommonsMultipartFile pfile) throws Exception{
        //1.实现图片上传：图片在图片服务器 c:/images
        String filename=pfile.getOriginalFilename();  //1.jpg  上传文件名称
        if(filename!=null&&filename!=""){
            String expname=filename.substring(filename.lastIndexOf("."));  //上传文件的扩展名
            String saveFileName=System.currentTimeMillis()+expname;  //保存文件名称
            String path="c:/images/"+saveFileName;  //保存路径
            File saveFile=new File(path);
            pfile.transferTo(saveFile);  //上传文件

            //删除原有的图片
            new File("c//images//"+oldpath).delete();

            house.setPath(saveFileName);
        }
            //调用业务
            houseService.updatehouse(house);
           return "redirect:goguanli";
        }

        //实现逻辑删除
        @RequestMapping("deletehouse")
        public String delete(String id,Integer isdel) {
            houseService.deleteHouse(id, 1);
            return "redirect:goguanli";
        }
//浏览所有出租房
    @RequestMapping("lookhouse")
    public String lookhouse(Pagee pagee,Integer isdel,Model model) {
        PageInfo<House> housePageInfo = houseService.lookhouse(pagee, 1);
        model.addAttribute("housePageInfo",housePageInfo);
        return "list";
    }
}

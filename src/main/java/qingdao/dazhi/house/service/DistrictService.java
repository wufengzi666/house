package qingdao.dazhi.house.service;

import com.github.pagehelper.PageInfo;
import qingdao.dazhi.house.entity.District;
import qingdao.dazhi.house.util.Pagee;

import java.util.List;

public interface DistrictService {
    public PageInfo<District> getInfo(Pagee pagee);
    public int add(District district);
    public District getDistrict(Integer id);
    int update(District district);
    int delete(Integer id);
    int deleteMore(List<Integer> ids);
    List<District> getDistrictList();
}

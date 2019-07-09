package qingdao.dazhi.house.service;

import com.github.pagehelper.PageInfo;
import qingdao.dazhi.house.entity.Street;
import qingdao.dazhi.house.util.Pagee;

import java.util.List;

public interface StreetService {
    public PageInfo<Street> getStreetInfo(Integer id, Pagee pagee);
    public List<Street> getStreetListbudid(Integer did);
}

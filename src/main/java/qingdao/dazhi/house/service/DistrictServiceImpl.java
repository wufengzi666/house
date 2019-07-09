package qingdao.dazhi.house.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import qingdao.dazhi.house.entity.District;
import qingdao.dazhi.house.entity.DistrictExample;
import qingdao.dazhi.house.mapper.DistrictMapper;
import qingdao.dazhi.house.util.Pagee;

import java.util.List;

@Service
public class DistrictServiceImpl implements DistrictService {
    @Autowired
    DistrictMapper districtMapper;
    @Override
    public PageInfo<District> getInfo(Pagee pagee) {
        DistrictExample example=new DistrictExample();
        PageHelper.startPage(pagee.getPage(),pagee.getRows());
        List<District> list=districtMapper.selectByExample(example);
        PageInfo<District> info=new PageInfo<>(list);
        return info;
    }

    @Override
    public int add(District district) {
        return districtMapper.insertSelective(district);
    }

    @Override
    public District getDistrict(Integer id) {
        return districtMapper.selectByPrimaryKey(id);
    }

    @Override
    public int update(District district) {
        return districtMapper.updateByPrimaryKey(district);
    }

    @Override
    public int delete(Integer id) {
        return  districtMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int deleteMore(List<Integer> ids) {
        return districtMapper.deleteMore(ids);
    }

    @Override
    public List<District> getDistrictList() {
        return districtMapper.selectByExample(null);
    }
}

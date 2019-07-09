package qingdao.dazhi.house.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import qingdao.dazhi.house.entity.Street;
import qingdao.dazhi.house.entity.StreetExample;
import qingdao.dazhi.house.mapper.StreetMapper;
import qingdao.dazhi.house.util.Pagee;

import java.util.List;

@Service
public class StreetServiceImpl implements StreetService {
    @Autowired
    StreetMapper streetMapper;
    @Override
    public PageInfo<Street> getStreetInfo(Integer id, Pagee pagee) {
        StreetExample example=new StreetExample();
        StreetExample.Criteria criteria = example.createCriteria();
        criteria.andDistrictIdEqualTo(id);
        PageHelper.startPage(pagee.getPage(),pagee.getRows());
        List<Street> list=streetMapper.selectByExample(example);
        PageInfo<Street> info=new PageInfo<>(list);
        return info;
    }

    @Override
    public List<Street> getStreetListbudid(Integer did) {
        StreetExample example=new StreetExample();
        StreetExample.Criteria criteria = example.createCriteria();
        criteria.andDistrictIdEqualTo(did);
        return streetMapper.selectByExample(example);
    }
}

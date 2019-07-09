package qingdao.dazhi.house.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import qingdao.dazhi.house.entity.House;
import qingdao.dazhi.house.entity.HouseExample;
import qingdao.dazhi.house.mapper.HouseMapper;
import qingdao.dazhi.house.util.Pagee;

import java.util.ArrayList;
import java.util.List;

@Service
public class HouseServiceImpl implements HouseService {
    @Autowired
    private HouseMapper houseMapper;
    @Override
    public int addhouse(House house) {
        return houseMapper.insertSelective(house);
    }

    @Override
    public PageInfo<House> getinfo(Pagee pagee, Integer uid) {
        PageHelper.startPage(pagee.getPage(),pagee.getRows());
        List<House> list=houseMapper.getHouseByUserId(uid);
        return new PageInfo<House>(list);
    }

    @Override
    public House getHouseByID(String id) {
        House house = houseMapper.getHouseById(id);
        return house;
    }

    @Override
    public int updatehouse(House house) {
        return houseMapper.updateByPrimaryKeySelective(house);
    }

    @Override
    public PageInfo<House> getHouseInfo(Pagee pagee,Integer ispass) {
        HouseExample example=new HouseExample();
        HouseExample.Criteria criteria = example.createCriteria();
        criteria.andIspassEqualTo(ispass);
        PageHelper.startPage(pagee.getPage(),pagee.getRows());
        List<House> list = houseMapper.selectByExample(example);
        PageInfo<House> info=new PageInfo<>(list);
        return info;
    }

    @Override
    public int updatehouse(String id) {
        House house=houseMapper.selectByPrimaryKey(id);
        house.setIspass(1);
        return houseMapper.updateByPrimaryKeySelective(house);
    }

    @Override
    public int deleteHouse(String id,Integer isdel) {
        House house=new House();
        house.setId(id);
        house.setIsdel(isdel);
       return houseMapper.updateByPrimaryKeySelective(house);
    }

    @Override
    public PageInfo<House> lookhouse(Pagee pagee, Integer isdel) {

        PageHelper.startPage(pagee.getPage(),pagee.getRows());
        List<House> list=houseMapper.lookhouse();
        return new PageInfo<>(list);
    }
}

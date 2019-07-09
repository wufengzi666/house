package qingdao.dazhi.house.service;

import com.github.pagehelper.PageInfo;
import qingdao.dazhi.house.entity.House;
import qingdao.dazhi.house.util.Pagee;

import java.util.List;

public interface HouseService {
int addhouse(House house);
PageInfo<House> getinfo(Pagee pagee,Integer uid);
House getHouseByID(String id);
int updatehouse(House house);
PageInfo<House> getHouseInfo(Pagee pagee,Integer ispass);
    int updatehouse(String id);
    int deleteHouse(String id,Integer isdel);
    PageInfo<House> lookhouse(Pagee pagee,Integer isdel);
}

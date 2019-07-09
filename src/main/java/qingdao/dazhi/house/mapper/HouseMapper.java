package qingdao.dazhi.house.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import qingdao.dazhi.house.entity.House;
import qingdao.dazhi.house.entity.HouseExample;

public interface HouseMapper {
    int countByExample(HouseExample example);

    int deleteByExample(HouseExample example);

    int deleteByPrimaryKey(String id);

    int insert(House record);

    int insertSelective(House record);

    List<House> selectByExample(HouseExample example);

    House selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") House record, @Param("example") HouseExample example);

    int updateByExample(@Param("record") House record, @Param("example") HouseExample example);

    int updateByPrimaryKeySelective(House record);

    int updateByPrimaryKey(House record);

    List<House> getHouseByUserId(Integer id);

    House getHouseById(String id);

    List<House> lookhouse();
}
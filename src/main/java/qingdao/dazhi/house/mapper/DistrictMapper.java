package qingdao.dazhi.house.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import qingdao.dazhi.house.entity.District;
import qingdao.dazhi.house.entity.DistrictExample;

public interface DistrictMapper {
    int countByExample(DistrictExample example);

    int deleteByExample(DistrictExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(District record);

    int insertSelective(District record);

    List<District> selectByExample(DistrictExample example);

    District selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") District record, @Param("example") DistrictExample example);

    int updateByExample(@Param("record") District record, @Param("example") DistrictExample example);

    int updateByPrimaryKeySelective(District record);

    int updateByPrimaryKey(District record);

    int deleteMore(List<Integer> ids);
}
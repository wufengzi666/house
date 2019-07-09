package qingdao.dazhi.house.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import qingdao.dazhi.house.entity.Type;
import qingdao.dazhi.house.entity.TypeExample;

public interface TypeMapper {
    int countByExample(TypeExample example);

    int deleteByExample(TypeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Type record);

    int insertSelective(Type record);

    List<Type> selectByExample(TypeExample example);

    Type selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Type record, @Param("example") TypeExample example);

    int updateByExample(@Param("record") Type record, @Param("example") TypeExample example);

    int updateByPrimaryKeySelective(Type record);

    int updateByPrimaryKey(Type record);

    int deleteMore(List<Integer> ids);
}
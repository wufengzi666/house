package qingdao.dazhi.house.service;

import com.github.pagehelper.PageInfo;
import qingdao.dazhi.house.entity.Type;
import qingdao.dazhi.house.util.Pagee;

import java.util.List;

public interface TypeService {
    PageInfo<Type> gettypeinfo(Pagee pagee);
    int addtype(Type type);
    int deletetype(Integer id);
    List<Type> getTypeList();
}

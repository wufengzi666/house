package qingdao.dazhi.house.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import qingdao.dazhi.house.entity.Type;
import qingdao.dazhi.house.entity.TypeExample;
import qingdao.dazhi.house.mapper.TypeMapper;
import qingdao.dazhi.house.util.Pagee;

import java.util.List;

@Service
public class TypeServiceImpl implements TypeService {
    @Autowired
    TypeMapper typeMapper;
    @Override
    public PageInfo<Type> gettypeinfo(Pagee pagee) {
        TypeExample example=new TypeExample();
        PageHelper.startPage(pagee.getPage(),pagee.getRows());
        List<Type> list=typeMapper.selectByExample(example);
        return new PageInfo<Type>(list);
    }

    @Override
    public int addtype(Type type) {
       return typeMapper.insertSelective(type);
    }

    @Override
    public int deletetype(Integer id) {
        return typeMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<Type> getTypeList() {
        return typeMapper.selectByExample(null);
    }
}

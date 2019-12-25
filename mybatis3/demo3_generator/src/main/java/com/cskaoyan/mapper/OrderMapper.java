package com.cskaoyan.mapper;

import com.cskaoyan.bean.Order;
import com.cskaoyan.bean.OrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface OrderMapper {
    long countByExample(OrderExample example);

    int deleteByExample(OrderExample example);

    @Delete({
        "delete from user_order",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into user_order (id, order_name, ",
        "uid)",
        "values (#{id,jdbcType=INTEGER}, #{orderName,jdbcType=VARCHAR}, ",
        "#{uid,jdbcType=INTEGER})"
    })
    int insert(Order record);

    int insertSelective(Order record);

    List<Order> selectByExample(OrderExample example);

    @Select({
        "select",
        "id, order_name, uid",
        "from user_order",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @ResultMap("com.cskaoyan.mapper.OrderMapper.BaseResultMap")
    Order selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Order record, @Param("example") OrderExample example);

    int updateByExample(@Param("record") Order record, @Param("example") OrderExample example);

    int updateByPrimaryKeySelective(Order record);

    @Update({
        "update user_order",
        "set order_name = #{orderName,jdbcType=VARCHAR},",
          "uid = #{uid,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Order record);
}
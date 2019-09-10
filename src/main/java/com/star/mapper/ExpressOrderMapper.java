package com.star.mapper;

import com.star.vo.ExpressOrder;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface ExpressOrderMapper {
    @Select("select * from express_order where is_delete=0")
    List<ExpressOrder> findAll();
    @Select("select * from express_order where id=#{id}")
    ExpressOrder getExpressOrderById(@Param("id") Integer id);
    @Insert("insert into express_order(phone,user_name,create_time,door_adress,door_time,status,is_delete,content) values(#{phone},#{userName},#{createTime},#{doorAdress},#{doorTime},#{status},#{isDelete},#{content})")
    Integer saveExpressOrder(ExpressOrder expressOrder);
    @Update("update express_order set id=#{id},phone=#{phone},user_name=#{userName},create_time=#{createTime},door_adress=#{doorAdress},door_time=#{doorTime},status=#{status},is_delete=#{isDelete},content=#{content} where id=#{id}")
    Integer updateExpressOrder(ExpressOrder expressOrder);
}

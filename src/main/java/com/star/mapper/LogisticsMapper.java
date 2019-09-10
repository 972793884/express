package com.star.mapper;

import com.star.vo.Logistics;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface LogisticsMapper {
    @Select("select * from logistics where is_delete=0")
    List<Logistics> findAll();
    @Select("select * from logistics where id=#{id}")
    Logistics getLogisticsById(@Param("id") Integer id);
    @Insert("insert into logistics(express_id,create_time,current_adress,next_adress,create_user,arrive_time,is_delete,company_id) values(#{expressId},#{createTime},#{currentAdress},#{nextAdress},#{createUser},#{arriveTime},#{isDelete},#{companyId})")
    Integer saveLogistics(Logistics logistics);
    @Update("update logistics set id=#{id},express_id=#{expressId},create_time=#{createTime},current_adress=#{currentAdress},next_adress=#{nextAdress},create_user=#{createUser},arrive_time=#{arriveTime},is_delete=#{isDelete},company_id=#{companyId} where id=#{id}")
    Integer updateLogistics(Logistics logistics);
    @Select("select l.*,c.name as company_name from logistics l left join company c on l.company_id=c.id where l.express_id=#{id}")
    List<Logistics> getMyLogisticsList(@Param("id") Integer id);
}

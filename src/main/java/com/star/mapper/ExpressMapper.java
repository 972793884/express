package com.star.mapper;

import com.star.vo.Express;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface ExpressMapper {
    @Select("select * from express where is_delete=0")
    List<Express> findAll();
    @Select("select * from express where id=#{id}")
    Express getExpressById(@Param("id") Integer id);
    @Insert("insert into express(code,user_name_send,user_name_recive,phone_send,phone_recive,adress_send,adress_recive,content,price,weight,create_user,create_time,update_time,status,is_delete,overtime,overtime_time,company_id,express_order_id) values(#{code},#{userNameSend},#{userNameRecive},#{phoneSend},#{phoneRecive},#{adressSend},#{adressRecive},#{content},#{price},#{weight},#{createUser},#{createTime},#{updateTime},#{status},#{isDelete},#{overtime},#{overtimeTime},#{companyId},#{expressOrderId})")
    Integer saveExpress(Express express);
    @Update("update express set id=#{id},code=#{code},user_name_send=#{userNameSend},user_name_recive=#{userNameRecive},phone_send=#{phoneSend},phone_recive=#{phoneRecive},adress_send=#{adressSend},adress_recive=#{adressRecive},content=#{content},price=#{price},weight=#{weight},create_user=#{createUser},create_time=#{createTime},update_time=#{updateTime},status=#{status},is_delete=#{isDelete},overtime=#{overtime},overtime_time=#{overtimeTime},company_id=#{companyId},express_order_id=#{expressOrderId} where id=#{id}")
    Integer updateExpress(Express express);
    @Select("select id from express where express_order_id=#{id}")
    Integer findExpressIdByExpressOrderId(@Param("id") Integer expressOrderId);
    @Select("SELECT COUNT(*) FROM express WHERE DATE_FORMAT(create_time,'%Y-%m-%d') = DATE_FORMAT(now(),'%Y-%m-%d')")
    Integer getNum();
    @Select("select * from express where latest_pickup_time is not null and overtime_time is null and status=2")
    List<Express> getAllNotPickupExpress();
    @Select("<script> select * from express where <if test=\"code!=null and code!=''\"> code=#{code} or</if>  <if test=\"phoneRecive!=null and phoneRecive!=''\"> phone_recive=#{phoneRecive} or</if> 1=1 </script>")
    List<Express> getMyExpressList(@Param("code") String code, @Param("phoneRecive") String phoneRecive);
}

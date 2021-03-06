package cn.aberic.fabric.dao.mapper;

import cn.aberic.fabric.dao.Peer;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 作者：Aberic on 2018/6/9 13:53
 * 邮箱：abericyang@gmail.com
 */
@Mapper
public interface PeerMapper {

    @Insert("insert into peer (name,event_hub_name,location,event_hub_location,event_listener,org_id,date) " +
            "values (#{p.name},#{p.eventHubName},#{p.location},#{p.eventHubLocation},#{p.eventListener},#{p.orgId},#{p.date})")
    int add(@Param("p") Peer peer);

    @Update("update peer set name=#{p.name}, event_hub_name=#{p.eventHubName}, location=#{p.location}" +
            ", event_hub_location=#{p.eventHubLocation}, event_listener=#{p.eventListener} where rowid=#{p.id}")
    int update(@Param("p") Peer peer);

    @Select("select count(name) from peer where org_id=#{id}")
    int count(@Param("id") int id);

    @Select("select count(name) from peer")
    int countAll();

    @Select("select rowid,name,event_hub_name,location,event_hub_location,event_listener,org_id,date from peer where rowid=#{id}")
    @Results({
            @Result(property = "id", column = "rowid"),
            @Result(property = "name", column = "name"),
            @Result(property = "eventHubName", column = "event_hub_name"),
            @Result(property = "location", column = "location"),
            @Result(property = "eventHubLocation", column = "event_hub_location"),
            @Result(property = "eventListener", column = "event_listener"),
            @Result(property = "orgId", column = "org_id"),
            @Result(property = "date", column = "date")
    })
    Peer get(@Param("id") int id);

    @Select("select rowid,name,event_hub_name,location,event_hub_location,event_listener,org_id,date from peer where org_id=#{id}")
    @Results({
            @Result(property = "id", column = "rowid"),
            @Result(property = "name", column = "name"),
            @Result(property = "eventHubName", column = "event_hub_name"),
            @Result(property = "location", column = "location"),
            @Result(property = "eventHubLocation", column = "event_hub_location"),
            @Result(property = "eventListener", column = "event_listener"),
            @Result(property = "orgId", column = "org_id"),
            @Result(property = "date", column = "date")
    })
    List<Peer> list(@Param("id") int id);

    @Select("select rowid,name,event_hub_name,location,event_hub_location,event_listener,org_id,date from peer")
    @Results({
            @Result(property = "id", column = "rowid"),
            @Result(property = "name", column = "name"),
            @Result(property = "eventHubName", column = "event_hub_name"),
            @Result(property = "location", column = "location"),
            @Result(property = "eventHubLocation", column = "event_hub_location"),
            @Result(property = "eventListener", column = "event_listener"),
            @Result(property = "orgId", column = "org_id"),
            @Result(property = "date", column = "date")
    })
    List<Peer> listAll();

}

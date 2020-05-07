package io.dropwizard.jdbi;

import io.dropwizard.api.*;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.Define;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;
import org.skife.jdbi.v2.sqlobject.stringtemplate.UseStringTemplate3StatementLocator;

import java.util.Date;
import java.util.List;


@UseStringTemplate3StatementLocator
public interface numberplateDAO {

    public static final String studentTable="anpr";

    @SqlUpdate("insert into "+studentTable+" values (:id,:name,:mobile,:toll,:license,:type);")
    void insert(@BindBean final numberplate np);



    @SqlUpdate(" create table tollrecord ( code character varying, type1 integer, type2 integer, type3 integer, type4 integer, type5 integer, type6 integer);")
    void createtollrecordtable();



//    @SqlUpdate("Alter table anpr add type int default (1) ;")
//    void alter();

    @SqlUpdate(" drop table <tablename>;")
    void dropcartables(@Define("tablename") String tablename);

    @SqlUpdate(" create table tolldata ( code character varying , exceptions character varying);")
    void createtabletolldata();

    @SqlUpdate("insert into tolldata values(:code,:exception);")
    void inserttolldata(@Bind("code") String code,@Bind("exception") String exception);

    @SqlUpdate("delete from tolldata where  code=:code and exception:exception;")
    void deletetolldata(@Bind("code") String code,@Bind("exception") String exception);


    @RegisterMapper(tolldataMapper.class)
    @SqlQuery("Select * from tolldata where code=:code and exceptions=:exception;")
    List<tolldata> gettolldata(@Bind("code") String code,@Bind("exception") String exception);

    @SqlUpdate(" create table <tablename> (tollamount integer, date date, tollcode character varying); ")
    void createTables(@Define("tablename") String tablename);

    @SqlUpdate("insert into <tablename> values (:tollamount,:date,:tollcode);")
    void insertcarrecord(@Define("tablename") String tablename, @Bind("tollamount") int amount, @Bind("date") java.util.Date d,@Bind("tollcode") String tollcode);

    @SqlUpdate("update "+studentTable+" set license=:license, mobile=:mobile,name=:name,toll=:toll, type=:type where id=:id;")
    void update(@BindBean final numberplate np);

    @RegisterMapper(carrecordMapper.class)
    @SqlQuery("select * from <tablename>;")
    List<carrecord> getallcardata(@Define("tablename") String tablename);

    @RegisterMapper(tolldataMapper.class)
    @SqlQuery("select * from tolldata;")
    List<tolldata> getalltolldata();

    @RegisterMapper(tolldataMapper.class)
    @SqlQuery("select * from tolldata where code=:code;")
    List<tolldata> getalltolldatacode(@Bind("code") String code);




    @RegisterMapper(tollrecordMapper.class)
    @SqlQuery("select * from tollrecord;")
    List<tollrecord> getalltollrecorddata();




    @RegisterMapper(numberplateMapper.class)
    @SqlQuery("select * from "+studentTable+" ;")
    List<numberplate> findAllNumberPlate();

    @RegisterMapper(numberplateMapper.class)
    @SqlQuery("select * from "+studentTable+" where id=:id;")
    numberplate findNByNumberPlate(@Bind("id") String id);

    @SqlUpdate("update "+studentTable+" set toll= toll + :toll where id=:id;")
    void updateToll(@Bind("id") String id,@Bind("toll") int toll);

    @SqlUpdate("delete from "+studentTable+" where id=:id;")
    void deletedata(@Bind("id") String id);

    @SqlUpdate(" insert into session values (:accessToken,:username,:created,:type);")
    void insertSession(@Bind("accessToken") String accessToken,@Bind("username") String username,@Bind("created") java.util.Date created,@Bind("type") int type);

    @RegisterMapper(sessionMapper.class)
    @SqlQuery("select * from session where username=:username and created=:created and type=:type;")
    List<session> getSession(@Bind("username") String username,@Bind("created") java.util.Date created,@Bind("type") int type);

    @RegisterMapper(carrecordMapper.class)
    @SqlQuery("select * from <tablename> where date =:date and tollcode=:tollcode;")
    List<carrecord> getcarrecord(@Define("tablename") String tablename,@Bind("date") java.util.Date d,@Bind("tollcode") String tollcode);

    @RegisterMapper(loginMapper.class)
    @SqlQuery("select * from login where username=:uname and password=:password and type=:type;")
    List<login> getlogin(@BindBean final login lo);



    @RegisterMapper(tollrecordMapper.class)
    @SqlQuery("Select * from tollrecord where code=:code;")
    tollrecord getTollrecords(@Bind("code") String code);

    @RegisterMapper(loginMapper.class)
    @SqlQuery("select * from login ;")
    List<login> getalllogin();

    @SqlUpdate(" insert into login values (:uname,:password,:type);")
    void insertlogin(@BindBean final login lo);

    @SqlUpdate("delete from tollrecord where code=:code;")
    void deletetollrecord(@Bind("code") String code);

    @SqlUpdate("insert into tollrecord values(:code,:type1,:type2,:type3,:type4,:type5,:type6);")
    void inserttollrecord(@BindBean final tollrecord t);

    @SqlUpdate("update tollrecord set type1=:type1, type2=:type2, type3=:type3, type4=:type4, type5=:type5, type6=:type6 where code=:code;")
    void updatetoollrecord(@BindBean final tollrecord t);

}

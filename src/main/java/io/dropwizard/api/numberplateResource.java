package io.dropwizard.api;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.awt.*;
import java.util.List;

@Path("/anpr")
@Produces(MediaType.APPLICATION_JSON)
public interface numberplateResource {

    @GET
    @Path("/get/{numberplate}")
    public numberplate getNumberPlateByNumber(@PathParam("numberplate") final String numberplate);

    @GET
    @Path("/getall")
    public List<numberplate> getNumberPlateData();
    @GET
    @Path("insert/{numberplate}/{license}/{mobile}/{name}/{toll}/{type}")
    public List<numberplate> insertNumberData(@PathParam("numberplate") String numberplate,@PathParam("license") String license,@PathParam("mobile") int mobile,@PathParam("name") String name,@PathParam("toll") int toll,@PathParam("type") int type);

    @GET
    @Path("update/{numberplate}/{license}/{mobile}/{name}/{toll}/{type}")
    public List<numberplate> updateNumberData(@PathParam("numberplate") String numberplate,@PathParam("license") String license,@PathParam("mobile") int mobile,@PathParam("name") String name,@PathParam("toll") int toll,@PathParam("type") int type);

    @GET
    @Path("insertuser/{numberplate}/{license}/{mobile}/{name}/{toll}/{type}")
    public List<numberplate> insertNumberDataUser(@PathParam("numberplate") String numberplate,@PathParam("license") String license,@PathParam("mobile") int mobile,@PathParam("name") String name,@PathParam("toll") int toll,@PathParam("type") int type);

    @GET
    @Path("updateuser/{numberplate}/{license}/{mobile}/{name}/{toll}/{type}")
    public List<numberplate> updateNumberDataUser(@PathParam("numberplate") String numberplate,@PathParam("license") String license,@PathParam("mobile") int mobile,@PathParam("name") String name,@PathParam("toll") int toll,@PathParam("type") int type);


    @GET
    @Path("deleteuser/{numberplate}/{name}")
    public List<numberplate> deleteNumberDataUser(@PathParam("numberplate") String numberplate,@PathParam("name") String name);


    @GET
    @Path("addtoll/{numberplate}/{toll}")
    public List<numberplate>  addToll(@PathParam("numberplate") String numberplate,@PathParam("toll") int toll);

    @GET
    @Path("removetoll/{numberplate}/{toll}/{name}")
    public List<numberplate>  removeToll(@PathParam("numberplate") String numberplate,@PathParam("toll") int toll,@PathParam("name") String name);


    @GET
    @Path("delete/{numberplate}")
    public List<numberplate> deleteNumberData(@PathParam("numberplate") String numberplate);

    @GET
    @Path("getallbyname/{name}")
    public List<numberplate> getallNameData(@PathParam("name") String name);


    @GET
    @Path("getalllogin/")
    public List<login> getalllogindata();

    @GET
    @Path("altertable/")
    public void alterTable();

    @GET
    @Path("createtable/")
    public void createtable();

    @GET
    @Path("inserttolldata/{code}/{exception}")
    public void inserttolldata(@PathParam("code") String code,@PathParam("exception") String exemp);

    @GET
    @Path("deletetolldata/{code}/{exception}")
    public void deletetolldata(@PathParam("code") String code,@PathParam("exception") String exemp);


    @GET
    @Path("gettolldata/{code}/{exception}")
    public List<tolldata> gettolldata(@PathParam("code") String code,@PathParam("exception") String exemp);

    @GET
    @Path("addtollrecord/{code}/{type1}/{type2}/{type3}/{type4}/{type5}/{type6}/{typer1}/{typer2}/{typer3}/{typer4}/{typer5}/{typer6}")
    public void addtollrecord(@PathParam("code") String code,
                              @PathParam("type1") int type1,@PathParam("type2") int type2,@PathParam("type3")int type3,
                              @PathParam("type4") int type4,@PathParam("type5") int type5,@PathParam("type6") int type6,

                              @PathParam("typer1") int typer1,@PathParam("typer2") int typer2,@PathParam("typer3")int typer3,
                              @PathParam("typer4") int typer4,@PathParam("typer5") int typer5,@PathParam("typer6") int typer6
                              );
    @GET
    @Path("getalltolldata/")
    public List<tolldata> getalltolldata();

    @GET
    @Path("getalltollrecorddata/")
    public List<tollrecord> getalltollrecorddata();

    @GET
    @Path("gettolldatabycode/{code}")
    public List<tolldata> gettolldatabycode(@PathParam("code") String code);

    @GET
    @Path("getallcardata/{numberplate}")
    public List<carrecord> getallcarrecorddata(@PathParam("numberplate") String numberplate);
    //    @GET
//    @Path("login/uname/password")

    @GET
    @Path("updatetollrecord/{code}/{type1}/{type2}/{type3}/{type4}/{type5}/{type6}")
    public List<tollrecord> updatetollrecord(@PathParam("code") String code,
                              @PathParam("type1") int type1,@PathParam("type2") int type2,@PathParam("type3")int type3,
                              @PathParam("type4") int type4,@PathParam("type5") int type5,@PathParam("type6") int type6
    );

    @GET
    @Path("deletetollrecord/{code}")
    public List<tollrecord> deletetollrecord(@PathParam("code") String code);

    @PUT
    @Path("insertlogin/{username}/{password}/{type}")
    public void insertlogin(@PathParam("username") String username,@PathParam("password") String password,@PathParam("type") int type);



    @PUT
    @Path("session/{username}/{password}/{type}")
    public session getSession(@PathParam("username") String username,@PathParam("password") String password,@PathParam("type") int type);


}

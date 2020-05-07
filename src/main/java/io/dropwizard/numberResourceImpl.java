package io.dropwizard;

import io.dropwizard.api.*;
import io.dropwizard.jdbi.numberplateDAO;
import org.skife.jdbi.v2.sqlobject.Bind;

import java.util.ArrayList;
import java.util.List;

public class numberResourceImpl implements numberplateResource {

    public final numberplateDAO numberPlateDAO;

    public numberResourceImpl(numberplateDAO numberPlateDAO) {
        this.numberPlateDAO = numberPlateDAO;
    }

    @Override
    public numberplate getNumberPlateByNumber(String numberplate) {
        System.out.println("get numberplate by number");
        return this.numberPlateDAO.findNByNumberPlate(numberplate);
    }
    @Override
    public List<numberplate> getNumberPlateData() {
        System.out.println("get all number plate");
        List<numberplate> n=this.numberPlateDAO.findAllNumberPlate();

        return n;
    }
    @Override
    public List<numberplate> insertNumberData(String numberplate, String license, int mobile, String name, int toll,int type) {
        numberplate np=new numberplate(numberplate,license,mobile,name,toll,type);
        System.out.println("insert data");
        this.numberPlateDAO.insert(np);
        System.out.println("get all number plate");
        this.numberPlateDAO.createTables("t"+numberplate);
        List<numberplate> n=this.numberPlateDAO.findAllNumberPlate();

        return n;
    }
    @Override
    public List<numberplate> updateNumberData(String numberplate, String license, int mobile, String name, int toll, int type) {
        numberplate np=new numberplate(numberplate,license,mobile,name,toll, type);
        System.out.println("update data");
        this.numberPlateDAO.update(np);
        System.out.println("get all number plate");
        List<numberplate> n=this.numberPlateDAO.findAllNumberPlate();

        return n;

    }

    @Override
    public List<numberplate> insertNumberDataUser(String numberplate, String license, int mobile, String name, int toll,int type) {
        numberplate np=new numberplate(numberplate,license,mobile,name,toll, type);
        System.out.println("insert data");
        this.numberPlateDAO.insert(np);
        System.out.println("get all number plate");
        List<numberplate> n=this.getallNameData(name);

        return n;
    }

    @Override
    public List<numberplate> updateNumberDataUser(String numberplate, String license, int mobile, String name, int toll,int type) {
        numberplate np=new numberplate(numberplate,license,mobile,name,toll,type);
        System.out.println("update data");
        this.numberPlateDAO.update(np);
        System.out.println("get all number plate");
        List<numberplate> n=this.getallNameData(name);

        return n;
    }

    @Override
    public List<numberplate> deleteNumberDataUser(String numberplate,String name) {
        this.numberPlateDAO.deletedata(numberplate);

        List<numberplate> n=this.getallNameData(name);

        return n;
    }

    @Override
    public List<numberplate> deleteNumberData(String numberplate) {

        this.numberPlateDAO.deletedata(numberplate);
        this.numberPlateDAO.dropcartables("t"+numberplate);
        List<numberplate> n=this.numberPlateDAO.findAllNumberPlate();

        return n;
    }

    @Override
    public List<login> getalllogindata() {
        List<login> tlogin=this.numberPlateDAO.getalllogin();
        for(int i=0;i<tlogin.size();i++)
        {
            login as=tlogin.get(i);
            as.setPassword("xxxx");
            tlogin.set(i,as);
        }
        return tlogin;
    }

    @Override
    public void alterTable() {
//        this.numberPlateDAO.alter();
    }

    @Override
    public void createtable() {

//        this.numberPlateDAO.alter();
//        List<numberplate> tlogin=this.numberPlateDAO.findAllNumberPlate();
//        for(int i=0;i<tlogin.size();i++)
//        {
//            numberplate as=tlogin.get(i);
//            this.numberPlateDAO.dropcartables("t"+as.getId());
//            this.numberPlateDAO.createTables("t"+as.getId());
//
//        }

//        this.numberPlateDAO.createtollrecordtable();
        this.numberPlateDAO.createtabletolldata();
    }

    @Override
    public void inserttolldata(String code, String exemp) {
        this.numberPlateDAO.inserttolldata(code,exemp.toUpperCase());
    }

    @Override
    public void deletetolldata(String code, String exemp) {
        this.numberPlateDAO.deletetolldata(code,exemp.toUpperCase());
    }

    @Override
    public List<tolldata> gettolldata(String code, String exemp) {
        return this.numberPlateDAO.gettolldata(code,exemp);
    }

    @Override
    public void addtollrecord(String code, int type1, int type2, int type3, int type4, int type5, int type6, int typer1, int typer2, int typer3, int typer4, int typer5, int typer6) {
        tollrecord oneside=new tollrecord(code,type1,type2,type3,type4,type5,type6);
        tollrecord roundtrip=new tollrecord("ret"+code,typer1,typer2,typer3,typer4,typer5,typer6);

        this.numberPlateDAO.deletetollrecord(oneside.getCode());
        this.numberPlateDAO.deletetollrecord(roundtrip.getCode());
        this.numberPlateDAO.inserttollrecord(oneside);
        this.numberPlateDAO.inserttollrecord(roundtrip);
    }

    @Override
    public List<tolldata> getalltolldata() {
        return this.numberPlateDAO.getalltolldata();
    }

    @Override
    public List<tollrecord> getalltollrecorddata() {
        return this.numberPlateDAO.getalltollrecorddata();
    }

    @Override
    public List<tolldata> gettolldatabycode(String code) {
        return this.numberPlateDAO.getalltolldatacode(code);
    }

    @Override
    public List<carrecord> getallcarrecorddata(String numberplate) {
        return this.numberPlateDAO.getallcardata("t"+numberplate);
    }

    @Override
    public List<tollrecord> updatetollrecord(String code, int type1, int type2, int type3, int type4, int type5, int type6) {
        tollrecord t=new tollrecord(code,type1,type2,type3,type4,type5,type6);
        this.numberPlateDAO.updatetoollrecord(t);
        return this.numberPlateDAO.getalltollrecorddata();
    }

    @Override
    public List<tollrecord> deletetollrecord(String code) {
        this.numberPlateDAO.deletetollrecord(code);
        this.numberPlateDAO.deletetollrecord("ret"+code);
        return this.numberPlateDAO.getalltollrecorddata();
    }


    @Override
    public List<numberplate> getallNameData(String name) {
        List<numberplate> tlogin=this.numberPlateDAO.findAllNumberPlate();
        for(int i=0;i<tlogin.size();i++)
        {
            numberplate as=tlogin.get(i);
            System.out.println(as.getName());

        }
        List<numberplate> newlist = new ArrayList<numberplate>();
        for(int i=0;i<tlogin.size();i++)
        {
            numberplate as=tlogin.get(i);
            if(as.getName().equals(name))
            {
                newlist.add(tlogin.get(i));
            }

        }
        return newlist;
    }

    public int gettoll(tollrecord t, int v)
    {
        if(v==1)
            return t.getType1();
        if(v==2)
            return t.getType2();
        if(v==3)
            return t.getType3();
        if(v==4)
            return t.getType4();
        if(v==5)
            return t.getType5();
            return t.getType6();
    }

    @Override
    public List<numberplate> addToll(String numberplate, int code) {
    System.out.println("incrementing data");
    String co=""+code;
    List<carrecord> cr=this.numberPlateDAO.getcarrecord("t"+numberplate,new java.util.Date(),co);
    int toll=0;
    numberplate nu=this.numberPlateDAO.findNByNumberPlate(numberplate);
    int typeval=nu.getType();



    if(cr.size()>0)
    {
        tollrecord tr=this.numberPlateDAO.getTollrecords("ret"+co);
        tollrecord tr2=this.numberPlateDAO.getTollrecords(co);
        toll=gettoll(tr,typeval)-gettoll(tr2,typeval);
    }
    else
    {
        tollrecord tr2=this.numberPlateDAO.getTollrecords(co);
        toll=gettoll(tr2,typeval);
    }

    String numberplateco=numberplate.substring(0,Math.min(numberplate.length(),4));
    System.out.println(numberplateco);
    List<tolldata> td=this.numberPlateDAO.gettolldata(co,numberplateco);
            if(td.size()>0)
                toll=0;
    this.numberPlateDAO.updateToll(numberplate,toll);
        System.out.println("get all number plate");
        this.numberPlateDAO.insertcarrecord("t"+numberplate,toll,new java.util.Date(),co);
        List<numberplate> tlogin=this.numberPlateDAO.findAllNumberPlate();


        return tlogin;
    }

    @Override
    public List<numberplate> removeToll(String numberplate, int toll, String name) {
        System.out.println("decrementing data");

        int ntoll=0-toll;
        this.numberPlateDAO.updateToll(numberplate,ntoll);
        System.out.println("get some number plate");
        List<numberplate> tlogin=this.numberPlateDAO.findAllNumberPlate();

        List<numberplate> newlist = new ArrayList<numberplate>();
        for(int i=0;i<tlogin.size();i++)
        {
            numberplate as=tlogin.get(i);
            if(as.getName().equals(name))
            {
                newlist.add(tlogin.get(i));
            }

        }
        return newlist;

    }

    @Override
    public void insertlogin(String username, String password, int type) {
        System.out.println("inserting login");
        login lo=new login(username,password,type);
        System.out.println(lo.getPassword());
        lo.setuplogin(username,password,type);
        System.out.println(lo.getPassword());
        numberPlateDAO.insertlogin(lo);
    }

    @Override
    public session getSession(String username, String password, int type) {
        login lo=new login(username,password,type);
        lo.setuplogin(username,password,type);
        List<login> l=this.numberPlateDAO.getlogin(lo);

        if(l.size()>0) {
            List<session> ses=this.numberPlateDAO.getSession(username, new java.util.Date(),type);
            if(ses.size()==0)
            {session newSession = new session(username);
                this.numberPlateDAO.insertSession(newSession.getAccessToken(), newSession.getId(), new java.util.Date(),type);
                return newSession;
            }
            else
                {
                return ses.get(0);
            }
        }
        session newSession = new session("&&invalid&&");
        return newSession;
    }


}

package io.dropwizard.api;

import java.math.BigInteger;
import java.security.MessageDigest;

public class login {
    String uname;
    String password;
    int type;

    public login(String uname,String password,int type)
    {
        this.uname=uname;
        this.password=password;
        this.type=type;
    }

    public static String getMd5(String input)
    {
        try {

            MessageDigest md = MessageDigest.getInstance("MD5");


            byte[] messageDigest = md.digest(input.getBytes());
            BigInteger no = new BigInteger(1, messageDigest);
            String hashtext = no.toString(16);
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        }

        // For specifying wrong message digest algorithms
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    public void setuplogin(String uname,String password,int type)
    {
        this.uname=uname;
        this.password=getMd5(password);
        this.type=type;

    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}

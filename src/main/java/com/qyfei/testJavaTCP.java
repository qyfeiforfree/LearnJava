package com.qyfei;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class testJavaTCP {
    public  static void main (String [] args)throws UnknownHostException {

        InetAddress address = InetAddress.getLocalHost();
        System.out.println(address.getHostName());
        System.out.println(address.getHostAddress());
        String  bytes= address.getHostAddress();
        System.out.println(bytes);
        InetAddress address2 = InetAddress.getByName("DESKTOP-0Q1JM2C");
        System.out.println(address2.getHostName());
        System.out.println(address2.getHostAddress());
        String  bytes2= address2.getHostAddress();
        System.out.println(bytes);

    }
}

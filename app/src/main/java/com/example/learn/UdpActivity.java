package com.example.learn;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UdpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_udp);

        try {
            DatagramSocket ds=new DatagramSocket(10086);

            byte[] bytes=new byte[1024];
            DatagramPacket dp=new DatagramPacket(bytes,bytes.length);
            ds.receive(dp);

            String str=new String(bytes,0,dp.getLength());
            Log.d("UDPTEST",str);

            ds.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
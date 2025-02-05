package com.server.web;

import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;

import java.io.*;
import java.util.Arrays;
import java.util.List;

public class ProxyMachine {
    private List<String> servers;
    File  configFile;
    List<String> ips = Arrays.asList("103.13.209.144","199.19.75.138");
    String user= "borisfa";
    String password= "Yoni2006!";
    final int PORT =22;
    public ProxyMachine() throws JSchException {
       for ( String ip : ips ){
           sendSsh(ip);
       }
    }

    private void sendSsh(String ip)  {
        JSch jsch = new JSch();
        Session session = null;
        try {
            session = jsch.getSession(user, ip, PORT);
            session.setPassword(password);
            session.setConfig("StrictHostKeyChecking", "no"); // Disable host key checking

            // Connect to the server
            session.connect();
            // Create a channel
            ChannelExec channel = (ChannelExec) session.openChannel("exec");

            // Set the command to be executed
            String command = "ls -l"; // Example command
            channel.setCommand(command);

            // Get the input and output streams
            InputStream in = channel.getInputStream();
            //OutputStream out = channel.getOutputStream();

            // Connect the channel
            channel.connect();

            // Read the output
            byte[] buffer = new byte[1024];
            StringBuilder output = new StringBuilder();

           try( BufferedReader reader = new BufferedReader(new InputStreamReader(in))){

               String line;
               while ((line = reader.readLine()) != null) {
                   output.append(line).append("\n");
               }
           };

            while (true) {
                while (in.available() > 0) {
                    int bytesRead = in.read(buffer, 0, 1024);
                    if (bytesRead < 0) break;
                    output.append(new String(buffer, 0, bytesRead));
                }
                if (channel.isClosed()) {
                    if (in.available() > 0) continue;
                    System.out.println("Exit status: " + channel.getExitStatus());
                    break;
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ignored) {
                }
            }

            // Print the output
            System.out.println(output.toString());

            // Disconnect from the server
            channel.disconnect();
            session.disconnect();
        } catch (JSchException | java.io.IOException e) {
            e.printStackTrace();
        }
    }
}

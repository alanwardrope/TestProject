package acme.expedia.framework.common;

import java.io.IOException;
import java.io.InputStream;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

/**
 * Created by wardropea on 18/10/2017.
 */
public class SshConnector {

    private String host;
    private String username;
    private String password;
    private String command1;

    /* This constructor initializes the database variables that requires
        to connect to the database
      */
    public SshConnector(String sshhost, String sshusername,
                             String sshpassword, String sshcommand1 ) throws IOException {
        host = sshhost;
        username = sshusername;
        password = sshpassword;
        command1 = sshcommand1;

    }

    /**
     * JSch Example Tutorial
     * Java SSH Connection Program
     */
    //public void main(String[] args) {
    public void openSshConnection() {
        try{

            java.util.Properties config = new java.util.Properties();
            config.put("StrictHostKeyChecking", "no");
            JSch jsch = new JSch();
            Session session=jsch.getSession(username, host, 22);
            session.setPassword(password);
            session.setConfig(config);
            session.connect(0);
            System.out.println("username: " + username + "\tpassword: " + password + "\thost: " + host +"\tcommand1 " + command1);
            System.out.println("Connected");

            Channel channel=session.openChannel("exec");
            ((ChannelExec)channel).setCommand(command1);
            channel.setInputStream(null);
            ((ChannelExec)channel).setErrStream(System.err);

            System.out.println("1. I am here");
            InputStream in=channel.getInputStream();
            channel.connect();
            byte[] tmp=new byte[10000];
            while(true){
                while(in.available()>0){
                    int i=in.read(tmp, 0, 10000);
                    if(i<0)break;
                    System.out.print(new String(tmp, 0, i));
                }
                if(channel.isClosed()){
                    System.out.println("exit-status: "+channel.getExitStatus());
                    break;
                }
                try{Thread.sleep(1000);}catch(Exception ee){}
            }
            System.out.println("2. I am here");

            channel.disconnect();
            session.disconnect();
            System.out.println("DONE");

        }catch(Exception e){
            e.printStackTrace();
        }

    }


}

import java.io.*;
import java.net.*;
class Node extends Thread
{
private Socket sock=null;	
private int port=3015;
private String ip="127.0.0.1";	
private String input,output="",str="";               
private BufferedReader keyRead;
private OutputStream outputstream;
private PrintWriter pwrite;
private InputStream inputstream;
private BufferedReader getfromserver;
public void setIp(String ip){
this.ip=ip;
}
public String getIp(){
return ip;
}
public void setPort(int port){
this.port=port;
}
public int getPort(){
return port;
}

public void start(){ 
try{
	sock = new Socket(ip,port);	
	keyRead = new BufferedReader(new InputStreamReader(System.in));
	outputstream = sock.getOutputStream(); 
	pwrite = new PrintWriter(outputstream, true);
	inputstream = sock.getInputStream();
	getfromserver = new BufferedReader(new InputStreamReader(inputstream));	
     	pwrite.println("ID ashish");         
     	str = getfromserver.readLine();
        System.out.println(str);
        if(str.contains("authintication done")){
	System.out.println("started");
	run();
	
	}else{
		throw new Exception();		
	}	
	}
	catch(Exception e){
	System.out.println("catch ");
	e.printStackTrace();		
	}  

}

public void run(){
System.out.println("Starting Node");
try{    
while(true)
     {                    
        input=keyRead.readLine();
        pwrite.println(input);
	if(input.equals("exit")){
		throw new Exception();		
	}
         pwrite.flush();  
      }
}catch(Exception e){
//sock.close();
}
}
  public static void main(String[] args) throws Exception
  {  
	Node n=new Node();
	n.start();           
}                    
}  

import java.io.*;
import java.net.*;
import java.util.*;
class BasicServer extends Thread
{
ServerSocket sersock;
boolean bool=true;
int port=3015;
int id=0;
ArrayList<helper> activeNode=new ArrayList<helper>();
String input,output;

public BasicServer(){
System.out.println("hello");
			try{
				sersock = new ServerSocket(port);
				System.out.println("Server started at port number:"+port);
				run();				
			}
			catch(Exception e){
				e.printStackTrace();				
				
			}
		
}

public void run(){
try{
loop:while(bool){ 

	  Socket sock = sersock.accept();                                         
	  helper helpr ;	
      	  BufferedReader keyRead = new BufferedReader(new InputStreamReader(System.in));
      	  OutputStream outputstream = sock.getOutputStream(); 
      	  PrintWriter pwrite = new PrintWriter(outputstream, true);
      	  InputStream inputstream = sock.getInputStream();
      	  BufferedReader getbackoutput = new BufferedReader(new InputStreamReader(inputstream));
 	  output=getbackoutput.readLine();
	  if(output.equals("ID ashish")){
	  id++;
	  String sip=sock.getRemoteSocketAddress().toString();
	  System.out.println("ip="+sip);
  	  helpr = new helper(sock,id,sip);
          helpr.start();
	  activeNode.add(helpr);
	  ActiveNode();
	  pwrite.println("authintication done"+helpr.id);
	  }else{
	  pwrite.println("authintication failed"+id);
	   }
        
	System.out.println(output);
		if(output.equals("exit")){break loop;}
			
		}

	}catch(Exception e){}
}
public void ActiveNode(){
Iterator<helper> itr=activeNode.iterator();
	while(itr.hasNext()){
		helper h=itr.next();
		if(h.status)
		System.out.println(h.id+" ip:"+h.ip);
		else
	}
}

public void ExitServer(){
try{
sersock.close();
}
catch(Exception e){e.printStackTrace();}               
}
  public static void main(String[] args) throws Exception
  {
	BasicServer bs=new BasicServer();
  }
}

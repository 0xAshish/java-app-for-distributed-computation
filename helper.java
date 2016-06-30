import java.io.*;
import java.net.*;
import java.util.*;
class helper extends Thread{

 Socket socket = null;
int id;
String ip;
boolean status;
 helper(Socket socket,int id,String ip) {

        super("helper"+id);
        this.socket = socket;
	this.id=id;
	this.ip=ip;	
	status=true;
    }

    public void run(){
	try{            //input and process
	InputStream inputstream = socket.getInputStream();
        BufferedReader getbackoutput = new BufferedReader(new InputStreamReader(inputstream));

while(status)
      {
String output="";
        if((output=getbackoutput.readLine()) != null)  
        {
           System.out.println(id+"->>"+output);
		if(output.equals("exit")){
			System.out.println("helper node number "+id+"disconected");
					
		status=false;}         
           
        }         
      }


}
catch(Exception e){
System.out.println(e);

}
}
}    



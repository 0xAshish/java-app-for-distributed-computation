import java.io.*;
import java.net.*;
class Node
{
  public static void main(String[] args) throws Exception
  {
     Socket sock = new Socket("127.0.0.1", 3002);
     BufferedReader keyRead = new BufferedReader(new InputStreamReader(System.in));
     OutputStream outputstream = sock.getOutputStream(); 
     PrintWriter pwrite = new PrintWriter(outputstream, true);
     InputStream inputstream = sock.getInputStream();
     BufferedReader getfromserver = new BufferedReader(new InputStreamReader(inputstream));
 
     System.out.println("Starting Node");
 
     String input="",output="",str="";               
     while(true)
     {                    
        if((str = getfromserver.readLine()) != null)
        {
           input+=str;
        }
        
        pwrite.println(input);//we need to add that compilation and execution mechanism here
        System.out.println(input);
        pwrite.flush();   // flush the data      
      }               
    }                    
}  

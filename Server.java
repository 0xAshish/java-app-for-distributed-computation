import java.io.*;
import java.net.*;
class BasicServer
{
  public static void main(String[] args) throws Exception
  {
      ServerSocket sersock = new ServerSocket(3002);
      System.out.println("Server for computation");
      Socket sock = sersock.accept( );                          
                         
      BufferedReader keyRead = new BufferedReader(new InputStreamReader(System.in));
      OutputStream outputstream = sock.getOutputStream(); 
      PrintWriter pwrite = new PrintWriter(outputstream, true);
      InputStream inputstream = sock.getInputStream();
      BufferedReader getbackoutput = new BufferedReader(new InputStreamReader(inputstream));
      String input,output;
      while(true)
      {
      input= keyRead.readLine();
        pwrite.println(input);
        if((output=getbackoutput.readLine()) != null)  
        {
           System.out.println(output);
                    
        }         
         
       output="";
      }               
    }                    
//todo list
/*
1.list for active conected nodes
2.maintain a queue for request from client
3.give input(program source code and take output whatever is asked like compil or run)
4.class for database conectivity to store all correct /succesfully compiled programs
5.and list goes on








*/
} 

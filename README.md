# rackspacedemo
Demo Project for Rackspace Coding Interview

1. Download project and build it to download all required jars
2. Open DemoApplication.java class, right click on it and click on run application  
    Application will start and embedded tomcat will be listening on port 8000.

3. Open Postman App and give following url.
   postman URL : http://localhost:8000/randomnumbers  
4. Select Get http method form the drop down.

5. Provide values as below : 
   Header :SESSIONID  : enter any text
   Request Param - limit :- enter integer value

6. Click on the send button to execute the API.

Note : We can also execute the operation using swagger-ui.  localhost:8000/swagger-ui.html

I have considered both the numbers 1 & limit (input). 
In case limit value has not provided output can give any value from 1 to 6.



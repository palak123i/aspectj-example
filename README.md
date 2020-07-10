# aspectj-example

To run the example, run `mvn clean package exec:java`

Sample output from the program.
```
The method: void com.mycompany.HelloWorld.sayHello(String) is getting called from: class com.mycompany.Main
The method: void java.io.PrintStream.println(String) is getting called from: class com.mycompany.HelloWorld
Hello World!
The method: boolean org.apache.commons.lang3.StringUtils.isEmpty(CharSequence) is getting called from: class com.mycompany.HelloWorld
!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! WARNING !!!!!!!!!!!!!!!!!!!!!!!!!!!
Your code has unapproved usage.... You wont be allowed to proceeed...

Process finished with exit code 0
```

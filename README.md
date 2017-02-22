# JettySSLDemo
```
keytool -genkey -alias tomcat -keypass 123456 -keyalg RSA -keysize 1024 -validity 365 -keystore D:/MyProjects/IdeaProjects/JettySSLDemo/tomcat.keystore -storepass 123456
```
```
keytool -genkey -alias client1 -keypass 123456 -keyalg RSA -keysize 1024 -validity 365 -storetype PKCS12 -keystore D:/MyProjects/IdeaProjects/JettySSLDemo/client1.p12 -storepass 123456
```
```
keytool -export -alias client1 -keystore D:/MyProjects/IdeaProjects/JettySSLDemo/client1.p12 -storetype PKCS12 -keypass 123456 -file D:/MyProjects/IdeaProjects/JettySSLDemo/client.cer
```
```
keytool -import -v -file D:/MyProjects/IdeaProjects/JettySSLDemo/client.cer -keystore D:/MyProjects/IdeaProjects/JettySSLDemo/tomcat.keystore -storepass 123456
```
```
keytool -list -v -keystore D:/MyProjects/IdeaProjects/JettySSLDemo/tomcat.keystore
```
```
keytool -keystore D:/MyProjects/IdeaProjects/JettySSLDemo/tomcat.keystore -export -alias tomcat -file D:/MyProjects/IdeaProjects/JettySSLDemo/server.cer
```







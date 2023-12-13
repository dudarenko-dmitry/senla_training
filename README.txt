Task 15 (difficulty 3)
1.	Install Apache Tomcat 8+.
2.	Create a Servlet-based-webapp branch. The branch must be from the first commit of the master branch.
3.	Make HelloWorld a web application consisting of a single servlet.
The application must accept a GET request to the URI /hello and return the string “Hello world” in response.
4.	This application should be assembled in war (specified in pom.xml <packaging>war</packaging>)
and deployed on Apache Tomcat.

Optional, but highly recommended: Add a tomcat plugin to the HelloWorld project,
with which to perform deploy/undeploy on/from Tomcat.

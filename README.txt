How to Install

Prerequisists
    1. Payara Glassfish Server
    2. Netbeans IDE
    3. MySQL
    4. JDBC Driver

1. Creating the Database
    1.1 Log into MySQL
    1.2 Create the Database, named dogsdb

2. Configuring Payara Glassfish and JDBC Connections
    2.1 Unzip the payara41.zip
    2.2 Go to the Services tab of Netbeans
    2.3 Right-click "Servers" and select "Add Server..."
    2.4 Choose Glassfish and click Next
    2.5 Select the folder that was unzipped from payara41.zip
    2.6 Click Next then click Finish
    2.7 Right-click the newly created Glassfish server and click "View Domain Admin Console"
    2.8 Create a new JDBC connection pool under Resources
    2.9 Name the pool dogsPool and select javax.sql.DataSource as the resource type
    2.10 Click next and copy type com.mysql.jdbc.jdbc2.optional.MysqlDataSource as the Datasource Classname and click finish
    2.11 Create a new JDBC resource named jdbc/dogsdb, select the dogspool pool and click next
    2.12

3. Deploying the project into Payara Glassfish Server
    3.1 Import the Java project into Netbeans
    3.2 Right-click the project and select deploy
    3.3 Run the UserDB.sql script and select the connection created in step 2
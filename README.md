# rgi-challenge

Requirements:
- Java 8
- Postgresql
- Tomcat

Default settings in Application.properties and pom.xml

data.sql contains fake data for test (recreated on spring startup)

Endpoints available:

1. GET ${server}:${port}/task/${task_id} - return task details
2. GET ${server}:${port}/task/user/${user_id} - returns open tasks for given user
3. POST ${server}:${port}/task/createTask + body - create new task
4. PUT ${server}:${port}/task/closeTask${task_id} - close the task (set the status as closed)

There are 2 available tests:
1. closeTaskTest
2. createTaskTest

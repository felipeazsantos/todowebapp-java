mysql:
	docker run -d -e MYSQL_ROOT_PASSWORD=dummy -e MYSQL_USER=todos-user -e MYSQL_PASSWORD=dummy --name mysql_todo -p 3316:3306 mysql:8-oracle
	
.PHONY: mysql
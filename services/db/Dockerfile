FROM mysql:latest

ENV MYSQL_ROOT_PASSWORD 'yes'

ARG DB_NAME
ARG DB_USER
ARG DB_PASSWORD

COPY provisionning/01-databases.sql /docker-entrypoint-initdb.d/01-databases.sql

RUN sed -i 's/DB_NAME/'$DB_NAME'/g' /docker-entrypoint-initdb.d/01-databases.sql
RUN sed -i 's/DB_USER/'$DB_USER'/g' /docker-entrypoint-initdb.d/01-databases.sql
RUN sed -i 's/DB_PASSWORD/'$DB_PASSWORD'/g' /docker-entrypoint-initdb.d/01-databases.sql


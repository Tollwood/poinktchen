## Playground Angular4 + Spring Boot + Postgres (cloud)

### install build tools (npm + gradle)
[more details](https://changelog.com/posts/install-node-js-with-homebrew-on-os-x)
1. Run `/usr/bin/ruby -e "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/master/install)"` to install homebrew 
2. Run `brew update` to make sure homebrew is up to date
3. Run `brew install node` to install node including npm
4. Run `brew install gradle`to install gradle on your mac

### install postgres local
1. [download](https://postgresapp.com/de/) and run app
2. Run `export PATH=$PATH:/Applications/Postgres.app/Contents/Versions/latest/bin/` to add psql commandline tool to youre path
3. Run `psql --version` to verify its in the path

### install 
1. install lombok Plugin
2. Enable Annotation Processing in settings

## Build and Run the application

1. Run `npm install --prefix ./frontend` to install front-end dependencies.
2. Run `npm run build --prefix ./frontend` to build angular application.
3. Run `./init_db` to create database, dbuser and dump default schema.
4. Run `gradle -p ./backend build` to build a spring boot application.
5. Run `gradle -p ./backend bootRun` or `java -jar backend/build/libs/app-name-[version].jar` to start spring boot application on embedded server. By default server will be running on port `8080`.

> `npm start --prefix ./frontend` to start front-end server for development.

> By default server will be running on port `4200`

## Testing

- `npm test --prefix ./frontend` - to run front-end unit tests.
- `npm run e2e --prefix ./frontend` - to run end to end tests.
- `gradle -p ./backend test` - to run server tests.


# Spring Boot + Angular 4 Boilerplate

[![Code Climate](https://codeclimate.com/github/Saka7/spring-boot-angular4-boilerplate/badges/gpa.svg)](https://codeclimate.com/github/Saka7/spring-boot-angular4-boilerplate)
[![Issue Count](https://codeclimate.com/github/Saka7/spring-boot-angular4-boilerplate/badges/issue_count.svg)](https://codeclimate.com/github/Saka7/spring-boot-angular4-boilerplate)

Quick start for Spring Boot + Angular 4 projects with JWT auth

## Includes:

Front-end:

- angular-cli boilerplate files
- Authentication service

Back-end:

- Embedded tomcat server
- Gradle build file
- Boilerplate files
- JWT authentication

## Technologies used

- [spring-boot 1.5.3](https://projects.spring.io/spring-boot/)
- [spring-mvc 4.3.6](https://docs.spring.io/spring/docs/current/spring-framework-reference/html/mvc.html)
- [spring-data-jpa 1.11.0](http://projects.spring.io/spring-data-jpa/)
- [spring-security 4.2.1](https://projects.spring.io/spring-security/)
- [jjwt 0.7.0](https://github.com/jwtk/jjwt)
- [lombok 1.16.12](https://projectlombok.org/)
- [junit 4.11](http://junit.org/junit4/)
- [gradle 3.3](https://gradle.org/)
- [postgresql 9.5](https://www.postgresql.org/)
- [h2 1.4](http://www.h2database.com/html/main.html)
- [angular-cli 1.1.1](https://cli.angular.io/)
- [angular 4.2.2](https://angular.io/)
- [rxjs 5](http://reactivex.io/rxjs/)
- [jasmine 2.5](https://jasmine.github.io/)
- [karma 1.0](https://karma-runner.github.io/1.0/index.html)
- [protractor 4](http://www.protractortest.org/#/)

## initial Setup 

You can use `setup.sh` script to change name and version of the app and database connection properties.
Just run `sh setup.sh` and follow the instructions.

### setup database

Database settings can be configured in `./backend/src/main/resources/application.properties`.

> By default application is using PostgreSQL database(name: `test`, user: `test`, password: `test`).

Also you need to configure JWT secret in file listed above.

#### Thanks to Saka7
Thank you for your [base repo](https://github.com/Saka7/spring-boot-angular4-boilerplate) which I based my playground on


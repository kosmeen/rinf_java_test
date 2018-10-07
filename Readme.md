# Run locally
1. Clone this repo
2. cd into the directory
3. mvn package
4. java -jar target/webapp/webapp-runner-7.0.22.jar  target/rinf.war
5. See api specification in swagger ui .Open the url in browser at http://localhost:8080/swagger-ui/. Replace the json url with /api/openapi.json
6. Test one api run : curl http://localhost:8080/api/customers/hello/test

#Deploy in Heroku

1. heroku create --stack cedar
2. git push heroku master
3. curl http://[appname].herokuapp.com/api/customers/hello/test



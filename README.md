# Install MongoDB
on MacOS with HomeBrew:

`
$ brew tap mongodb/brew
`
`
$ brew install mongodb-community@4.2
`

on Windows, just follow the instruction:

https://docs.mongodb.com/manual/tutorial/install-mongodb-on-windows/

# Start and Shut Down MongoDB
on MacOS with HomeBrew:
Start:

`
$ brew services start mongodb-community@4.2
`

Shut down:

`
$ brew services stop mongodb-community@4.2
`

on Windows:
Start:

`
"C:\Program Files\MongoDB\Server\4.2\bin\mongo.exe"
`

Shut down:
From the services console, locate the MongoDB service and right-click on the MongoDB service and click Stop (or Pause).

# Start the application in gradle
at root dirctory of this project(/accessing-data-mongodb), use this cmd:

`
$ ./gradlew bootRun
`

# API Documents
Following information is provided when you run and test this application locally and use default configurations.

Get all customers:

`
HTTP Method: GET
URL: http://localhost:8080/customer
`

POST a customer

`
HTTP Method: POST
URL: http://localhost:8080/customer/{firstName}/{lastName}
`

# References

https://docs.mongodb.com/manual/tutorial/install-mongodb-on-os-x/

https://spring.io/guides/gs/accessing-data-mongodb/


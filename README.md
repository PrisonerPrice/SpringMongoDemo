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

## Customer Controller

Get all customers:

`
HTTP Method: GET
`
`
URL: http://localhost:8080/customer
`

Get all groups a customer joins by email address:

`
HTTP Method: GET
`
`
URL: http://localhost:8080/customer/{emailAddress}
`

Add a customer:

`
HTTP Method: POST
`
`
URL: http://localhost:8080/customer/
`
`
Request Body Template:
{
	"firstName": "firstName",
	"lastName": "lastName",
	"emailAddress": "f.l@example.com",
	"groupIds": [
		"123456789abc",
		"234567890bcd"
	]
}
`

## Group Controller

Get all groups:

`
HTTP Method: GET
`
`
URL: http://localhost:8080/group
`

Get customers belong to a group by the group name:

`
HTTP Method: GET
`
`
URL: http://localhost:8080/group/{groupName}
`

Add a group:

`
HTTP Method: POST
`
`
URL: http://localhost:8080/group/
`
`
Request Body Template:
{
	"groupName": "groupName",
	"customerIds": [
		"customerID1",
		"customerID2"
	]
}
`

# CORS test

Run application on other port rather than 8080
`
./gradlew bootRun -Pport=9000
`

in browser, open localhost:8080 to test whether the CORS settings are effective.

# References

https://docs.mongodb.com/manual/tutorial/install-mongodb-on-os-x/

https://spring.io/guides/gs/accessing-data-mongodb/


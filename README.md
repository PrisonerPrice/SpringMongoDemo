# Install MongoDB
on MacOS with HomeBrew:

`
$ brew tap mongodb/brew
$ brew install mongodb-community@4.2
`

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

# Start the application in gradle
at root dirctory of this project(/accessing-data-mongodb), use this cmd:

`
$ ./gradlew bootRun
`


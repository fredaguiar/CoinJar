Project description: 
Implementation of a coin jar of 32 fluid ounce where only US coinage are accepted.
------------------------------------------------------------------------------------

Instructions:
- dowload the application from target/coinjar-0.1.0.jar
- Start the application: java -jar coinjar-0.1.0.jar
- In Firefox, install the RestClient plugin.
- Method = PUT
- For adding coins:
	URL: http://localhost:8080/coinjar/add/US_DOLLAR_PRESIDENT
	All the options for US coinage are: US_DOLLAR_PENNY, US_DOLLAR_NICKEL, US_DOLLAR_DIME, US_DOLLAR_25, US_DOLLAR_50, US_DOLLAR_PRESIDENT, US_DOLLAR_NATIVE
- For resetting: 
	URL http://localhost:8080/coinjar/reset
- RESTful responses:
	header: 200 OK or 400 Bad Request
	body: total or error info
------------------------------------------------------------------------------------

Environment and frameworks: 
Eclipse IDE, Java 7, JEE, Maven, Spring framework, RESTful Web Services.
------------------------------------------------------------------------------------

Code design:
JEE project built with Maven and Spring framework to support RESTful Web Services and Error Handling.
Application class: this class implements Spring technology to search recursively for RESTful controllers, and provide Spring MVC configuration, so no web.xml is needed.
Cache: it is a singleton that keeps the metadata in memory. The most ideal would be to load the cache from a metadata DB table, however it would be an over killing solution. The metadata keeps info about every coin, such as denomination, amount, volume, etc.
CoinJarRestController: it is the RESTful controller class managed by Spring, which the client consumes. It is responsible for the business logic and error handling. For the RESTful responses, Spring uses the Jackson JSON lib to automatically marshal the CoinJarRestResponse object into JSON.

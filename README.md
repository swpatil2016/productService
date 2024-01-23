
Our API generally aggregator between a frontend and fake store.


-> add File server.port=8080 in application.properties
run application local host. 

->@Qualifier in constructor use when there are more than
one class implementing interface. In case of single 
class spring will automatically inject the object But 
when more than one class come spring confused.

->@RequestBody take JSON from input and convert it into 
java object.

->RestTemple do some work for us in creating the object.
 1}Hit the fake store API using url
 2}Convert java object in JSON
 3}Convert fake store response(JSON) in java object.


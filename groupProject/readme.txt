
In order to get the project working you will need to download the database thingy 
from http://www.objectdb.com/object/db/database/download
once you have it downloaded, extract it somewhere and then go to netbeans. Right click the project & go to properties
then Libraries. Click Add JAR/FOLDER and locate the extracted objectdb file. once there go to bin/objectdb.jar and add it
You might want to remove the broken link from my while there.

To access the database:
From the java class we want to access from, create an EntityManagerFactory
and a EntityManager. In the constructor initialise the EMF with
--- emf = Persistance.createEntityManagerFactory("$objectdb/db/person.odb");
then the EM with
--- em = emf.createEntityManager();

then you can simply add things to the database with em.persist(thing to add)

and retrive things with em.createQuery(query here);


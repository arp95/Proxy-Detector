# Proxy_Detector
Proxy detector is an android app aimed to detect the number of persons identified by their branch , roll number , year in a particular area that is the classroom for this app as specified by the professor.
It contains three tables in the SQLite Database one being " admin " which is used by the proffessors , " user4 " used by the students , " master1 " which has the record of the students once queried by the professor .
The professor logs into the system and gets his details displayed such as name , username , location ( latitude and longitude ). He is asked to enter the branch , the year he is teaching right now and the roll number range present in the class and once he clicks the " apply " button he gets the students at the location where the professor is present belonging to branch , year , roll number as specified by the professor .
To ensure that the multi - user login from the same android device doesnt happen , each device is mapped in the " user4 " database table so that only one student registration is done per device .
A good app for ensuring no proxy takes place.

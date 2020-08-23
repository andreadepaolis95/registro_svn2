CREATE DATABASE IF NOT EXISTS registro4;
USE registro4;
CREATE TABLE users(
    username VARCHAR(255),
    password VARCHAR(255),
    id VARCHAR(255),
    PRIMARY KEY(id)
);
CREATE TABLE students(
    name VARCHAR(255),
  last VARCHAR(255),
  id VARCHAR(255),
  course VARCHAR(255),
  PRIMARY KEY(id)
);

CREATE TABLE professors(
    name VARCHAR(255),
  last VARCHAR(255),
  id VARCHAR(255),
  PRIMARY KEY(id)
);
CREATE TABLE matchcourse(
      userid VARCHAR(255),
      course VARCHAR(255),
      matter VARCHAR(255),
      PRIMARY KEY(userid,course,matter)
);


CREATE TABLE homework(

	  id int NOT NULL AUTO_INCREMENT,
      matter VARCHAR(255),
      course VARCHAR(255),
      expire Date,
      description VARCHAR(255),
     PRIMARY KEY (id)
);

CREATE TABLE arguments(

      id int NOT NULL AUTO_INCREMENT,
      matter VARCHAR(255),
      course VARCHAR(255),
      title VARCHAR(255),
      created Date,
      description VARCHAR(255),
      PRIMARY KEY (id)

);

CREATE TABLE schedule(
      pid VARCHAR(255),
      course VARCHAR(255),
      matter VARCHAR(255),
      day int(8),
      hour int(8),
      PRIMARY KEY(pid,day,hour)
);


CREATE TABLE grades(

      id int NOT NULL AUTO_INCREMENT,
   	  studentid VARCHAR(255),
      matter VARCHAR(255),
      value int,
      type VARCHAR(255),
      day Date,
      PRIMARY KEY (id)
);

CREATE TABLE absences(

      id int NOT NULL AUTO_INCREMENT,
   	  studentid VARCHAR(255),
      value VARCHAR(255),
      day Date,
      justified int,
      PRIMARY KEY (id)
);


CREATE TABLE pin(

      studentid VARCHAR(255),
      pin VARCHAR(255),
      PRIMARY KEY (studentid)
);


INSERT INTO users (username,password,id) VALUES ("alberto","123","1");
INSERT INTO users(username,password,id) VALUES ("fab","123","20");

INSERT INTO students (name,last,id,course) VALUES ("Alberto","Bianchi","1","1B");
INSERT INTO students (name,last,id,course) VALUES ("Mario","Rossi","3","1B");
INSERT INTO students (name,last,id,course) VALUES ("Gian Marco","Colagrossi","4","1B");
INSERT INTO students (name,last,id,course) VALUES ("Riccardo","Carpinella","5","1B");
INSERT INTO students (name,last,id,course) VALUES ("Andrea","De Paolis","6","1B");
INSERT INTO students (name,last,id,course) VALUES ("Roberto","D' Angelo","7","3B");
INSERT INTO students (name,last,id,course) VALUES ("Patrizio","Amicomio","8","3B");
INSERT INTO students (name,last,id,course) VALUES ("Federica","Riccardi","9","1B");
INSERT INTO students (name,last,id,course) VALUES ("Chiara","Proietti","10","1B");
INSERT INTO students (name,last,id,course) VALUES ("Flavia","Verona","12","1B");
INSERT INTO students (name,last,id,course) VALUES ("Donatella","Verdi","14","1B");
INSERT INTO students (name,last,id,course) VALUES ("Alberto","Amicomio","13","1B");
INSERT INTO students (name,last,id,course) VALUES ("Elisabetta","Proietti","15","3B");
INSERT INTO students (name,last,id,course) VALUES ("Davide","Conti","16","3B");
INSERT INTO students (name,last,id,course) VALUES ("Alessia","Rossi","17","3B");


INSERT INTO professors(name,last,id) VALUES ("Fabrizio","Cola","20");
INSERT INTO professors(name,last,id) VALUES ("Maurizio","Tomei","19");

INSERT INTO professors(name,last,id) VALUES ("Salvatore","Tucci","18");

INSERT INTO professors(name,last,id) VALUES ("Salvatore","Romero","21");


INSERT INTO matchcourse(userid,course,matter) VALUES ("20","1B","Matematica");
INSERT INTO matchcourse(userid,course,matter) VALUES ("20","1B","Fisica");
INSERT INTO matchcourse(userid,course,matter) VALUES ("20","3B","Matematica");
INSERT INTO matchcourse(userid,course,matter) VALUES ("19","1B","Storia");
INSERT INTO matchcourse(userid,course,matter) VALUES ("19","1B","Geografia");
INSERT INTO matchcourse(userid,course,matter) VALUES ("19","1B","Scienze");
INSERT INTO matchcourse(userid,course,matter) VALUES ("19","1B","Italiano");
INSERT INTO matchcourse(userid,course,matter) VALUES ("18","1B","Inglese");
INSERT INTO matchcourse(userid,course,matter) VALUES ("18","1B","Francese");

INSERT INTO matchcourse(userid,course,matter) VALUES ("21","3B","Storia");
INSERT INTO matchcourse(userid,course,matter) VALUES ("21","3B","Geografia");
INSERT INTO matchcourse(userid,course,matter) VALUES ("21","3B","Scienze");
INSERT INTO matchcourse(userid,course,matter) VALUES ("18","3B","Inglese");





INSERT INTO schedule(pid,course,matter,day,hour) VALUES("20","1B","Matematica",0,9);
INSERT INTO schedule(pid,course,matter,day,hour) VALUES("20","1B","Matematica",0,10);
INSERT INTO schedule(pid,course,matter,day,hour) VALUES("20","1B","Fisica",2,9);
INSERT INTO schedule(pid,course,matter,day,hour) VALUES("20","1B","Fisica",2,10);
INSERT INTO schedule(pid,course,matter,day,hour) VALUES("20","1B","Matematica",4,11);
INSERT INTO schedule(pid,course,matter,day,hour) VALUES("20","1B","Matematica",4,12);
INSERT INTO schedule(pid,course,matter,day,hour) VALUES("20","3B","Matematica",1,9);
INSERT INTO schedule(pid,course,matter,day,hour) VALUES("20","3B","Matematica",1,10);
INSERT INTO schedule(pid,course,matter,day,hour) VALUES("20","3B","Matematica",3,9);
INSERT INTO schedule(pid,course,matter,day,hour) VALUES("20","3B","Matematica",3,10);

INSERT INTO absences(studentid,value,day,justified) VALUES("1","absence","2020-05-22",0);
INSERT INTO absences(studentid,value,day,justified) VALUES("3","absence","2020-05-22",0);
INSERT INTO absences(studentid,value,day,justified) VALUES("8","absence","2020-05-8",0);

INSERT INTO absences(studentid,value,day,justified) VALUES("4","ritardo","2020-05-25",0);

INSERT INTO grades(studentid,matter,value,day,type) VALUES("1","Matematica",8,"2020-06-6","written");
INSERT INTO grades(studentid,matter,value,day,type) VALUES("1","Matematica",6,"2020-06-7","oral");
INSERT INTO grades(studentid,matter,value,day,type) VALUES("4","Matematica",6,"2020-06-10","oral");
INSERT INTO grades(studentid,matter,value,day,type) VALUES("1","Matematica",5,"2020-06-13","lab");
INSERT INTO grades(studentid,matter,value,day,type) VALUES("8","Matematica",6,"2020-06-14","oral");
INSERT INTO grades(studentid,matter,value,day,type) VALUES("3","Matematica",6,"2020-06-16","oral");

INSERT INTO grades(studentid,matter,value,day,type) VALUES("7","Matematica",3,"2020-06-3","written");

INSERT INTO grades(studentid,matter,value,day,type) VALUES("5","Matematica",5,"2020-06-4","oral");
INSERT INTO grades(studentid,matter,value,day,type) VALUES("5","Matematica",5,"2020-06-6","oral");
INSERT INTO grades(studentid,matter,value,day,type) VALUES("5","Matematica",5,"2020-06-20","oral");

INSERT INTO grades(studentid,matter,value,day,type) VALUES("9","Matematica",9,"2020-06-5","written");
INSERT INTO grades(studentid,matter,value,day,type) VALUES("3","Matematica",9,"2020-06-6","oral");
INSERT INTO grades(studentid,matter,value,day,type) VALUES("4","Matematica",3,"2020-06-7","oral");
INSERT INTO grades(studentid,matter,value,day,type) VALUES("9","Matematica",7,"2020-06-8","lab");
INSERT INTO grades(studentid,matter,value,day,type) VALUES("3","Matematica",6,"2020-06-9","lab");

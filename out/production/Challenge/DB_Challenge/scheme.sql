create database if not exists challenge;

use challenge;

Create table if not exists provinces(
province_id INT NOT NULL AUTO_INCREMENT,
name varchar(30) NOT NULL,
CONSTRAINT pk_province PRIMARY KEY (province_id)
);

Create table if not exists cities(
city_id INT NOT NULL AUTO_INCREMENT,
name varchar(30) NOT NULL,
province_id INT NOT NULL,
CONSTRAINT pk_city PRIMARY KEY (city_id),
CONSTRAINT fk_province FOREIGN KEY (province_id) REFERENCES provinces(province_id)
);

Create table if not exists universities(
university_id INT NOT NULL AUTO_INCREMENT,
name varchar(50) NOT NULL,
city_id INT NOT NULL,
CONSTRAINT pk_university PRIMARY KEY (university_id),
CONSTRAINT fk_city FOREIGN KEY (city_id) REFERENCES cities(city_id)
);

Create table if not exists students(
student_id INT NOT NULL AUTO_INCREMENT,
firstName varchar(30) NOT NULL,
lastName varchar(30) NOT NULL,
phone varchar(20) NOT NULL,
email varchar(40) NOT NULL,
university_id INT NOT NULL,
CONSTRAINT pk_student PRIMARY KEY (student_id),
CONSTRAINT fk_university FOREIGN KEY (university_id) REFERENCES universities(university_id)
);

Create table if not exists subjects(
subject_id INT NOT NULL AUTO_INCREMENT,
name varchar(30) NOT NULL,
CONSTRAINT pk_subject PRIMARY KEY (subject_id)
);

#Uso un ManyToMany entre students y subjects
create table if not exists grades(
student_id INT NOT NULL,
subject_id INT NOT NULL,
qualification INT NOT NULL,
CONSTRAINT fk_student FOREIGN KEY (student_id) REFERENCES students(student_id),
CONSTRAINT fk_subject FOREIGN KEY (subject_id) REFERENCES subjects(subject_id),
CONSTRAINT check_qualification CHECK (qualification BETWEEN 0 AND 10) #Condición para que las calificación sean entre 0 y 10
);



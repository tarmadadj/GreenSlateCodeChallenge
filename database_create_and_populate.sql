DROP DATABASE IF EXISTS `userprojects`;

CREATE DATABASE `userprojects` /*!40100 DEFAULT CHARACTER SET utf8 */;


CREATE TABLE `userprojects`.`project` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `start_date` datetime NOT NULL,
  `end_date` datetime NOT NULL,
  `credits` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE `userprojects`.`user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(50) NOT NULL,
  `last_name` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE `userprojects`.`user_project` (
  `user_id` int(11) NOT NULL,
  `project_id` int(11) NOT NULL,
  `is_active` bit(1) NOT NULL,
  `assigned_date` datetime NOT NULL,
  KEY `fk_user_id` (`user_id`),
  KEY `fk_project_id` (`project_id`),
  CONSTRAINT `fk_project_id` FOREIGN KEY (`project_id`) REFERENCES `project` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

Insert into  `userprojects`.`user`  (first_name, last_name)
values ("Tommy","Wiseau");

Insert into  `userprojects`.`user`  (first_name, last_name)
values ("Hari","Seldon");

Insert into  `userprojects`.`user`  (first_name, last_name)
values ("Molly","Millions");

Insert into  `userprojects`.`project`  (start_date, end_date, credits)
values (20180607,20190606, 12);
Insert into  `userprojects`.`project`  (start_date, end_date, credits)
values (20180902,20181212, 2);
Insert into  `userprojects`.`project`  (start_date, end_date, credits)
values (20181112,20190105, 1);
Insert into  `userprojects`.`project`  (start_date, end_date, credits)
values (20190110,20190406, 3);
Insert into  `userprojects`.`project`  (start_date, end_date, credits)
values (20190201,20191201, 9);
Insert into  `userprojects`.`project`  (start_date, end_date, credits)
values (20190310,20190416, 4);
Insert into  `userprojects`.`project`  (start_date, end_date, credits)
values (20190610,20200416, 10);

Insert into `userprojects`.`user_project` (user_id, project_id, is_active, assigned_date)
values (3,2,false,20191111);
Insert into `userprojects`.`user_project` (user_id, project_id, is_active, assigned_date)
values (3,3,false,20190104);
Insert into `userprojects`.`user_project` (user_id, project_id, is_active, assigned_date)
values (3,5,true,20190204);
Insert into `userprojects`.`user_project` (user_id, project_id, is_active, assigned_date)
values (3,6,false,20190301);
Insert into `userprojects`.`user_project` (user_id, project_id, is_active, assigned_date)
values (3,7,false,20190307);


Insert into `userprojects`.`user_project` (user_id, project_id, is_active, assigned_date)
values (2,1,true,20190206);
Insert into `userprojects`.`user_project` (user_id, project_id, is_active, assigned_date)
values (2,2,false,20181004);
Insert into `userprojects`.`user_project` (user_id, project_id, is_active, assigned_date)
values (2,3,false,20191224);
Insert into `userprojects`.`user_project` (user_id, project_id, is_active, assigned_date)
values (2,4,true,20190213);
Insert into `userprojects`.`user_project` (user_id, project_id, is_active, assigned_date)
values (2,6,false,20190228);


Insert into `userprojects`.`user_project` (user_id, project_id, is_active, assigned_date)
values (1,1,true,20190206);
Insert into `userprojects`.`user_project` (user_id, project_id, is_active, assigned_date)
values (1,2,false,20181106);
Insert into `userprojects`.`user_project` (user_id, project_id, is_active, assigned_date)
values (1,3,false,20191216);
Insert into `userprojects`.`user_project` (user_id, project_id, is_active, assigned_date)
values (1,4,true,20190115);
Insert into `userprojects`.`user_project` (user_id, project_id, is_active, assigned_date)
values (1,5,false,20190214);

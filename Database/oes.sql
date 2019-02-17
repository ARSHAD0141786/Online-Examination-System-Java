-- Adminer 4.2.5 MySQL dump

SET NAMES utf8;
SET time_zone = '+00:00';
SET foreign_key_checks = 0;
SET sql_mode = 'NO_AUTO_VALUE_ON_ZERO';

CREATE DATABASE `oes` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `oes`;


DROP TABLE IF EXISTS `userdetails`;
CREATE TABLE `userdetails` (
  `Username` varchar(15) NOT NULL,
  `Password` varchar(15) NOT NULL DEFAULT '12345',
  `FirstName` varchar(10) NOT NULL,
  `MiddleName` varchar(10) DEFAULT '',
  `LastName` varchar(10) DEFAULT '',
  `Gender` char(1) NOT NULL,
  `E-mail` varchar(30) NOT NULL,
  `Mobile` char(10) NOT NULL,
  `DOB` date NOT NULL,
  `RegNo` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `RegDate` timestamp NOT NULL ON UPDATE CURRENT_TIMESTAMP,
  `Address` longtext NOT NULL,
  `College` varchar(60) NOT NULL,
  `Verify` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`RegNo`),
  UNIQUE KEY `Username` (`Username`),
  UNIQUE KEY `E-mail` (`E-mail`),
  UNIQUE KEY `Mobile` (`Mobile`)
) ENGINE=InnoDB AUTO_INCREMENT=52 DEFAULT CHARSET=latin1;


DROP TABLE IF EXISTS `course_details`;
CREATE TABLE `course_details` (
  `course_name` varchar(20) NOT NULL,
  `time` time NOT NULL,
  `course_no` int(4) unsigned NOT NULL AUTO_INCREMENT,
  `date_of_creation` timestamp NOT NULL ON UPDATE CURRENT_TIMESTAMP,
  `hide` smallint(6) unsigned NOT NULL DEFAULT '0',
  `total_question` int(5) unsigned NOT NULL DEFAULT '0',
  `question_mark` int(5) unsigned NOT NULL DEFAULT '4',
  PRIMARY KEY (`course_name`),
  UNIQUE KEY `course_no` (`course_no`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=latin1;

INSERT INTO `course_details` (`course_name`, `time`, `course_no`, `date_of_creation`, `hide`, `total_question`, `question_mark`) VALUES
('APPTITUDE',	'00:30:00',	33,	'2018-03-23 06:05:02',	0,	9,	2),
('COMPUTER',	'00:00:45',	34,	'2018-03-22 17:18:03',	0,	6,	0),
('MATHS',	'00:00:30',	32,	'2018-01-30 14:25:19',	1,	8,	4);

DROP TABLE IF EXISTS `questions`;
CREATE TABLE `questions` (
  `q_id` varchar(5) NOT NULL,
  `q_statement` longtext NOT NULL,
  `option_1` varchar(150) NOT NULL,
  `option_2` varchar(150) NOT NULL,
  `option_3` varchar(150) NOT NULL,
  `option_4` varchar(150) NOT NULL,
  `correct_option` int(1) NOT NULL,
  `course_name` varchar(20) NOT NULL,
  PRIMARY KEY (`q_id`),
  KEY `course_name` (`course_name`),
  CONSTRAINT `questions_ibfk_1` FOREIGN KEY (`course_name`) REFERENCES `course_details` (`course_name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `questions` (`q_id`, `q_statement`, `option_1`, `option_2`, `option_3`, `option_4`, `correct_option`, `course_name`) VALUES
('Ap1',	'what 3% of 5% is?',	'60%',	'30%',	'15%',	'45%',	2,	'APPTITUDE'),
('AP2',	'In how many ways the letter ‘SOLVING’ can be\nrearranged to make 7 letter words such that none\nof the letters repeat?',	'49',	'5040',	'7670',	'None of the above',	2,	'APPTITUDE'),
('AP3',	'What is the missing letter in this series?\n  b e h k n ? t',	'q',	'r',	's',	'u',	2,	'APPTITUDE'),
('AP4',	'The average age of a group of 5 students was 10.The \naverage age increased by 4 years when 2 new \nstudents joined the group.What is the average age of \nthe two new students who joined the group?',	'15',	'20',	'22',	'24',	4,	'APPTITUDE'),
('AP5',	'If you unscramble the letters YKANE, you will get the \nname of a:',	'Mountain Pass',	'Warrior',	'Flower',	'Country',	4,	'APPTITUDE'),
('AP6',	'3 is 80% of what number?',	'2.50',	'3.00',	'3.75',	'3.50',	3,	'APPTITUDE'),
('AP7',	'In an equation, (96)^(1/2) ÷ (k)^(1/2) = 2*(6)^(1/2);\nwhat value of k will satisfy the equation?',	'2',	'4',	'6',	'8',	2,	'APPTITUDE'),
('AP8',	'To the correct number of significant figures, \n(5.0 x 10^-5) ÷ (2.00 x 10^-2) is?',	'2.5X10^-7',	'2.5X10^-3',	'2.50X10^-3',	'None of the above',	2,	'APPTITUDE'),
('AP9',	'The product of 3×2 matrix and 2×3 matrix will result \nin what order matrix?',	'3x2',	'2x2',	'2x3',	'3x3',	4,	'APPTITUDE'),
('CM1',	'Who is the father of personal computer?',	'IBM',	'APPLE',	'MS',	'NONE OF THESE',	1,	'COMPUTER'),
('CM2',	'Which is the first electronic digital computer? ',	'ENIAC',	'MARK1 ',	'Z3',	'iCOM',	1,	'COMPUTER'),
('CM3',	'IC chips used in computer are usually made of?		',	'Lead',	'Silicon',	'Gold',	'Silver',	2,	'COMPUTER'),
('CM4',	'INDIA\'s first supercomputer PARAM 8000 was installed in ??',	'1990',	'1991',	'1992',	'1993',	1,	'COMPUTER'),
('CM5',	'The CPU\'s ALU contains:',	'RAM Spaces',	'Registers',	'Byte Spaces',	'Secondary Storage spaces',	2,	'COMPUTER'),
('CM6',	'Which is example of recursion : ',	'void func(){return func();}',	'String func(){return \"func()\";}',	'int func(){return 1;}',	'None',	1,	'COMPUTER'),
('MQ1',	'What is the unit digit in the product \nof (3547)^153 * (251)^72  ?',	'1',	'3',	'7',	'5',	3,	'MATHS'),
('MQ2',	'What is the remainder when 2^31 is divided by 5 ?',	'1',	'2',	'3',	'4',	3,	'MATHS'),
('MQ3',	'The H.C.F of 1.75 , 5.6 , 7 is :  ',	'0.07',	'0.7',	'3.5',	'0.35',	4,	'MATHS'),
('MQ4',	'Three numbers are in ratio 1:2:3 and their HCF is 12.\nThe numbers are : ',	'4,8,12',	'5,10,15',	'10,20,30',	'12,24,36',	4,	'MATHS'),
('MQ5',	'Two pipes A and B can fill a tank in 36 hours and 45 hours\nrespectively.If both the pipes are opened simultaneously,\nhow much time will be taken to fill the tank ? ',	'20 hours',	'25 hours',	'18 hours',	'22 hours',	1,	'MATHS'),
('MQ6',	'A train running at a certain speed crosses a stationary\nengine in 20 seconds.To find out the speed of the train,\nwhich of the following information is necessary ?',	'Only the length of the train',	'Only the length of the engine',	'Either the length of the train or the length of the engine',	'Both the length of the train and the length of the engine',	4,	'MATHS'),
('MQ7',	'If sin x + cosec x = 2,then find the value of\n(sin x)^7 + (cosec x)^7 ?',	'1',	'2',	'0',	'2^7',	3,	'MATHS'),
('MQ8',	'On which of the point will the graph of x=3 and y=8 intersect\neach other ',	'(0,0)',	'(3,8)',	'(8,3)',	'(-3,-8)',	2,	'MATHS');

DROP TABLE IF EXISTS `result`;
CREATE TABLE `result` (
  `Username` varchar(15) NOT NULL,
  `course_name` varchar(20) NOT NULL,
  `time_taken` time NOT NULL DEFAULT '00:00:00',
  `total_questions` int(3) NOT NULL,
  `wrong_question` int(3) NOT NULL,
  `attempted_question` int(3) NOT NULL,
  `obtained_marks` int(5) NOT NULL,
  `total_marks` int(5) NOT NULL,
  `percentage` float NOT NULL,
  `test_date` timestamp NOT NULL ON UPDATE CURRENT_TIMESTAMP,
  KEY `Username` (`Username`),
  KEY `course_name` (`course_name`),
  CONSTRAINT `result_ibfk_1` FOREIGN KEY (`Username`) REFERENCES `userdetails` (`Username`),
  CONSTRAINT `result_ibfk_2` FOREIGN KEY (`course_name`) REFERENCES `course_details` (`course_name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- 2018-03-23 11:03:35

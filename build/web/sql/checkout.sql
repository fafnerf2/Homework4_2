 CREATE TABLE UserTest (
  UserID INT NOT NULL AUTO_INCREMENT, 
  FirstName VARCHAR(50), 
  LastName VARCHAR(50), 
  EmailAddress VARCHAR(50), 
BookTitle VARCHAR(50),
DueDate date, 
  PRIMARY KEY (UserID)
)

SELECT 
	UserID AS 'ID',
    FirstName AS 'First Name',
    LastName AS 'Last Name',
    EmailAddress AS 'Email Address',
    BookTitle AS 'Book Title',
    date_add(DueDate, INTERVAL 14 Day) AS 'Due Date'
FROM
    elon.usertest
    ;


INSERT INTO UserTest 
    (FirstName, LastName, EmailAddress, BookTitle, DueDate)
VALUES 
    ('John', 'Smith', 'jsmith@gmail.com', '50 Shades of Black', '2015-11-19'), 
    ('Andrea', 'Steelman', 'andrea@murach.com', 'Betseys Life Adventures', '2015-12-01'), 
    ('Joel', 'Murach', 'joelmurach@yahoo.com', '50 shades of blacker', '1995-09-16');

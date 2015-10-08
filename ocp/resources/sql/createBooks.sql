CREATE TABLE Buch (
  ISBN varchar(20) not null primary key, 
  TITEL varchar(40) not null, 
  AUTOR varchar(40) not null, 
  PREIS decimal(8,2) not null
)

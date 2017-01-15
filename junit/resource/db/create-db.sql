--DROP TABLE cities IF EXISTS;

CREATE TABLE country (
  countryId        INTEGER auto_increment  PRIMARY KEY,
  countryName VARCHAR(30)
);
CREATE TABLE attraction (
  attractionId        INTEGER auto_increment  PRIMARY KEY,
  attractionName VARCHAR(30)
  
);
CREATE TABLE city (
  cityId        INTEGER auto_increment  PRIMARY KEY,
  cityName VARCHAR(30),
  visited BOOLEAN ,
  countryId  INTEGER 
  
);

-- manyToOne
alter table city add constraint fk_country foreign key (countryId) references country(countryId);

CREATE TABLE attraction_city (
  cityId INTEGER ,
  attractionId        INTEGER,
  constraint pk_attraction_city primary key(cityId,attractionId) 
);
alter table attraction_city add constraint fk_attraction_city_city foreign key (cityId) references city(cityId);
alter table attraction_city add constraint fk_attraction_city_attraction foreign key (attractionId) references attraction(attractionId);




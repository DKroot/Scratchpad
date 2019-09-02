/*
REM   Script: Pivot and unpivot examples using Olympic data
REM   Examples of pivoting and unpivoting data. Uses a subset of the results from the Rio Olympics as a data source.

For further explanation of the scripts, read the following blog post:

https://blogs.oracle.com/sql/entry/how_to_convert_rows_to
*/

CREATE TABLE olympic_medal_winners (
  olympic_year INT,
  sport        VARCHAR2(30),
  gender       VARCHAR2(1),
  event        VARCHAR2(128),
  medal        VARCHAR2(10),
  noc          VARCHAR2(3),
  athlete      VARCHAR2(128)
);

INSERT INTO olympic_medal_winners(olympic_year, sport, gender, event, medal, noc, athlete)
VALUES (2016, 'Archery', 'M', 'Men''s Individual', 'Gold', 'KOR', 'KU Bonchan');

INSERT INTO olympic_medal_winners(olympic_year, sport, gender, event, medal, noc, athlete)
VALUES (2016, 'Archery', 'M', 'Men''s Individual', 'Silver', 'FRA', 'VALLADONT Jean-Charles');

INSERT INTO olympic_medal_winners(olympic_year, sport, gender, event, medal, noc, athlete)
VALUES (2016, 'Archery', 'M', 'Men''s Individual', 'Bronze', 'USA', 'ELLISON Brady');

INSERT INTO olympic_medal_winners(olympic_year, sport, gender, event, medal, noc, athlete)
VALUES (2016, 'Archery', 'M', 'Men''s Team', 'Gold', 'KOR', 'Republic of Korea');

INSERT INTO olympic_medal_winners(olympic_year, sport, gender, event, medal, noc, athlete)
VALUES (2016, 'Archery', 'M', 'Men''s Team', 'Bronze', 'AUS', 'Australia');

INSERT INTO olympic_medal_winners(olympic_year, sport, gender, event, medal, noc, athlete)
VALUES (2016, 'Archery', 'M', 'Men''s Team', 'Silver', 'USA', 'United States');

INSERT INTO olympic_medal_winners(olympic_year, sport, gender, event, medal, noc, athlete)
VALUES (2016, 'Artistic Gymnastics', 'M', 'Men''s Floor Exercise', 'Gold', 'GBR', 'WHITLOCK Max');

INSERT INTO olympic_medal_winners(olympic_year, sport, gender, event, medal, noc, athlete)
VALUES (2016, 'Artistic Gymnastics', 'M', 'Men''s Floor Exercise', 'Bronze', 'BRA', 'MARIANO Arthur');

INSERT INTO olympic_medal_winners(olympic_year, sport, gender, event, medal, noc, athlete)
VALUES (2016, 'Artistic Gymnastics', 'M', 'Men''s Floor Exercise', 'Silver', 'BRA', 'HYPOLITO Diego');

INSERT INTO olympic_medal_winners(olympic_year, sport, gender, event, medal, noc, athlete)
VALUES (2016, 'Artistic Gymnastics', 'M', 'Men''s Horizontal Bar', 'Gold', 'GER', 'HAMBUECHEN Fabian');

INSERT INTO olympic_medal_winners(olympic_year, sport, gender, event, medal, noc, athlete)
VALUES (2016, 'Artistic Gymnastics', 'M', 'Men''s Horizontal Bar', 'Bronze', 'GBR', 'WILSON Nile');

INSERT INTO olympic_medal_winners(olympic_year, sport, gender, event, medal, noc, athlete)
VALUES (2016, 'Artistic Gymnastics', 'M', 'Men''s Horizontal Bar', 'Silver', 'USA', 'LEYVA Danell');

INSERT INTO olympic_medal_winners(olympic_year, sport, gender, event, medal, noc, athlete)
VALUES (2016, 'Athletics', 'M', 'Men''s 10,000m', 'Gold', 'GBR', 'FARAH Mohamed');

INSERT INTO olympic_medal_winners(olympic_year, sport, gender, event, medal, noc, athlete)
VALUES (2016, 'Athletics', 'M', 'Men''s 10,000m', 'Bronze', 'ETH', 'TOLA Tamirat');

INSERT INTO olympic_medal_winners(olympic_year, sport, gender, event, medal, noc, athlete)
VALUES (2016, 'Athletics', 'M', 'Men''s 10,000m', 'Silver', 'KEN', 'TANUI Paul Kipngetich');

INSERT INTO olympic_medal_winners(olympic_year, sport, gender, event, medal, noc, athlete)
VALUES (2016, 'Athletics', 'M', 'Men''s 100m', 'Gold', 'JAM', 'BOLT Usain');

INSERT INTO olympic_medal_winners(olympic_year, sport, gender, event, medal, noc, athlete)
VALUES (2016, 'Athletics', 'M', 'Men''s 100m', 'Silver', 'USA', 'GATLIN Justin');

INSERT INTO olympic_medal_winners(olympic_year, sport, gender, event, medal, noc, athlete)
VALUES (2016, 'Athletics', 'M', 'Men''s 100m', 'Bronze', 'CAN', 'DE GRASSE Andre');

INSERT INTO olympic_medal_winners(olympic_year, sport, gender, event, medal, noc, athlete)
VALUES (2016, 'Badminton', 'M', 'Men''s Doubles', 'Gold', 'CHN', 'Zhang');

INSERT INTO olympic_medal_winners(olympic_year, sport, gender, event, medal, noc, athlete)
VALUES (2016, 'Badminton', 'M', 'Men''s Doubles', 'Bronze', 'GBR', 'Langridge');

INSERT INTO olympic_medal_winners(olympic_year, sport, gender, event, medal, noc, athlete)
VALUES (2016, 'Badminton', 'M', 'Men''s Doubles', 'Bronze', 'GBR', 'Ellis');

INSERT INTO olympic_medal_winners(olympic_year, sport, gender, event, medal, noc, athlete)
VALUES (2016, 'Badminton', 'M', 'Men''s Doubles', 'Silver', 'MAS', 'Tan');

INSERT INTO olympic_medal_winners(olympic_year, sport, gender, event, medal, noc, athlete)
VALUES (2016, 'Badminton', 'M', 'Men''s Doubles', 'Silver', 'MAS', 'Goh');

INSERT INTO olympic_medal_winners(olympic_year, sport, gender, event, medal, noc, athlete)
VALUES (2016, 'Badminton', 'M', 'Men''s Doubles', 'Gold', 'CHN', 'Fu');

INSERT INTO olympic_medal_winners(olympic_year, sport, gender, event, medal, noc, athlete)
VALUES (2016, 'Beach Volleyball', 'M', 'Men', 'Gold', 'BRA', 'Cerutti');

INSERT INTO olympic_medal_winners(olympic_year, sport, gender, event, medal, noc, athlete)
VALUES (2016, 'Beach Volleyball', 'M', 'Men', 'Gold', 'BRA', 'Oscar Schmidt');

INSERT INTO olympic_medal_winners(olympic_year, sport, gender, event, medal, noc, athlete)
VALUES (2016, 'Beach Volleyball', 'M', 'Men', 'Silver', 'ITA', 'Nicolai');

INSERT INTO olympic_medal_winners(olympic_year, sport, gender, event, medal, noc, athlete)
VALUES (2016, 'Beach Volleyball', 'M', 'Men', 'Silver', 'ITA', 'Lupo');

INSERT INTO olympic_medal_winners(olympic_year, sport, gender, event, medal, noc, athlete)
VALUES (2016, 'Beach Volleyball', 'M', 'Men', 'Bronze', 'NED', 'Meeuwsen');

INSERT INTO olympic_medal_winners(olympic_year, sport, gender, event, medal, noc, athlete)
VALUES (2016, 'Beach Volleyball', 'M', 'Men', 'Bronze', 'NED', 'Brouwer');

INSERT INTO olympic_medal_winners(olympic_year, sport, gender, event, medal, noc, athlete)
VALUES (2016, 'Boxing', 'M', 'Men''s Bantam (56kg)', 'Gold', 'CUB', 'RAMIREZ Robeisy');

INSERT INTO olympic_medal_winners(olympic_year, sport, gender, event, medal, noc, athlete)
VALUES (2016, 'Boxing', 'M', 'Men''s Bantam (56kg)', 'Bronze', 'UZB', 'AKHMADALIEV Murodjon');

INSERT INTO olympic_medal_winners(olympic_year, sport, gender, event, medal, noc, athlete)
VALUES (2016, 'Boxing', 'M', 'Men''s Bantam (56kg)', 'Bronze', 'RUS', 'NIKITIN Vladimir');

INSERT INTO olympic_medal_winners(olympic_year, sport, gender, event, medal, noc, athlete)
VALUES (2016, 'Boxing', 'M', 'Men''s Bantam (56kg)', 'Silver', 'USA', 'STEVENSON Shakur');

INSERT INTO olympic_medal_winners(olympic_year, sport, gender, event, medal, noc, athlete)
VALUES (2016, 'Boxing', 'M', 'Men''s Fly (52kg)', 'Gold', 'UZB', 'ZOIROV Shakhobidin');

INSERT INTO olympic_medal_winners(olympic_year, sport, gender, event, medal, noc, athlete)
VALUES (2016, 'Boxing', 'M', 'Men''s Fly (52kg)', 'Bronze', 'CHN', 'HU Jianguan');

INSERT INTO olympic_medal_winners(olympic_year, sport, gender, event, medal, noc, athlete)
VALUES (2016, 'Canoe Slalom', 'M', 'Canoe Double (C2) Men', 'Gold', 'SVK', 'PETER Skantar');

INSERT INTO olympic_medal_winners(olympic_year, sport, gender, event, medal, noc, athlete)
VALUES (2016, 'Canoe Slalom', 'M', 'Canoe Double (C2) Men', 'Bronze', 'FRA', 'GAUTHIER Klauss');

INSERT INTO olympic_medal_winners(olympic_year, sport, gender, event, medal, noc, athlete)
VALUES (2016, 'Canoe Slalom', 'M', 'Canoe Double (C2) Men', 'Bronze', 'FRA', 'MATTHIEU Peche');

INSERT INTO olympic_medal_winners(olympic_year, sport, gender, event, medal, noc, athlete)
VALUES (2016, 'Canoe Slalom', 'M', 'Canoe Double (C2) Men', 'Silver', 'GBR', 'RICHARD Hounslow');

INSERT INTO olympic_medal_winners(olympic_year, sport, gender, event, medal, noc, athlete)
VALUES (2016, 'Canoe Slalom', 'M', 'Canoe Double (C2) Men', 'Silver', 'GBR', 'DAVID Florence');

INSERT INTO olympic_medal_winners(olympic_year, sport, gender, event, medal, noc, athlete)
VALUES (2016, 'Canoe Slalom', 'M', 'Canoe Double (C2) Men', 'Gold', 'SVK', 'LADISLAV Skantar');

INSERT INTO olympic_medal_winners(olympic_year, sport, gender, event, medal, noc, athlete)
VALUES (2016, 'Canoe Sprint', 'M', 'Men''s Canoe Double 1000m', 'Gold', 'GER', 'Brendel');

INSERT INTO olympic_medal_winners(olympic_year, sport, gender, event, medal, noc, athlete)
VALUES (2016, 'Canoe Sprint', 'M', 'Men''s Canoe Double 1000m', 'Bronze', 'UKR', 'Mishchuk');

INSERT INTO olympic_medal_winners(olympic_year, sport, gender, event, medal, noc, athlete)
VALUES (2016, 'Canoe Sprint', 'M', 'Men''s Canoe Double 1000m', 'Bronze', 'UKR', 'Ianchuk');

INSERT INTO olympic_medal_winners(olympic_year, sport, gender, event, medal, noc, athlete)
VALUES (2016, 'Canoe Sprint', 'M', 'Men''s Canoe Double 1000m', 'Silver', 'BRA', 'Queiroz dos Santos');

INSERT INTO olympic_medal_winners(olympic_year, sport, gender, event, medal, noc, athlete)
VALUES (2016, 'Canoe Sprint', 'M', 'Men''s Canoe Double 1000m', 'Silver', 'BRA', 'de Souza Silva');

INSERT INTO olympic_medal_winners(olympic_year, sport, gender, event, medal, noc, athlete)
VALUES (2016, 'Canoe Sprint', 'M', 'Men''s Canoe Double 1000m', 'Gold', 'GER', 'Vandrey');

INSERT INTO olympic_medal_winners(olympic_year, sport, gender, event, medal, noc, athlete)
VALUES (2016, 'Cycling Road', 'M', 'Men''s Individual Time Trial', 'Gold', 'SUI', 'CANCELLARA Fabian');

INSERT INTO olympic_medal_winners(olympic_year, sport, gender, event, medal, noc, athlete)
VALUES (2016, 'Cycling Road', 'M', 'Men''s Individual Time Trial', 'Bronze', 'GBR', 'FROOME Christopher');

INSERT INTO olympic_medal_winners(olympic_year, sport, gender, event, medal, noc, athlete)
VALUES (2016, 'Cycling Road', 'M', 'Men''s Individual Time Trial', 'Silver', 'NED', 'DUMOULIN Tom');

INSERT INTO olympic_medal_winners(olympic_year, sport, gender, event, medal, noc, athlete)
VALUES (2016, 'Cycling Road', 'M', 'Men''s Road Race', 'Gold', 'BEL', 'VAN AVERMAET Greg');

INSERT INTO olympic_medal_winners(olympic_year, sport, gender, event, medal, noc, athlete)
VALUES (2016, 'Cycling Road', 'M', 'Men''s Road Race', 'Silver', 'DEN', 'FUGLSANG Jakob');

INSERT INTO olympic_medal_winners(olympic_year, sport, gender, event, medal, noc, athlete)
VALUES (2016, 'Cycling Road', 'M', 'Men''s Road Race', 'Bronze', 'POL', 'MAJKA Rafal');

INSERT INTO olympic_medal_winners(olympic_year, sport, gender, event, medal, noc, athlete)
VALUES (2016, 'Cycling Track', 'M', 'Men''s Keirin', 'Gold', 'GBR', 'KENNY Jason');

INSERT INTO olympic_medal_winners(olympic_year, sport, gender, event, medal, noc, athlete)
VALUES (2016, 'Cycling Track', 'M', 'Men''s Keirin', 'Bronze', 'MAS', 'AWANG Azizulhasni');

INSERT INTO olympic_medal_winners(olympic_year, sport, gender, event, medal, noc, athlete)
VALUES (2016, 'Cycling Track', 'M', 'Men''s Keirin', 'Silver', 'NED', 'BUCHLI Matthijs');

INSERT INTO olympic_medal_winners(olympic_year, sport, gender, event, medal, noc, athlete)
VALUES (2016, 'Cycling Track', 'M', 'Men''s Omnium', 'Gold', 'ITA', 'VIVIANI Elia');

INSERT INTO olympic_medal_winners(olympic_year, sport, gender, event, medal, noc, athlete)
VALUES (2016, 'Cycling Track', 'M', 'Men''s Omnium', 'Bronze', 'DEN', 'HANSEN Lasse Norman');

INSERT INTO olympic_medal_winners(olympic_year, sport, gender, event, medal, noc, athlete)
VALUES (2016, 'Cycling Track', 'M', 'Men''s Omnium', 'Silver', 'GBR', 'CAVENDISH Mark');

INSERT INTO olympic_medal_winners(olympic_year, sport, gender, event, medal, noc, athlete)
VALUES (2016, 'Diving', 'M', 'Men''s 10m Platform', 'Gold', 'CHN', 'CHEN Aisen');

INSERT INTO olympic_medal_winners(olympic_year, sport, gender, event, medal, noc, athlete)
VALUES (2016, 'Diving', 'M', 'Men''s 10m Platform', 'Bronze', 'USA', 'BOUDIA David');

INSERT INTO olympic_medal_winners(olympic_year, sport, gender, event, medal, noc, athlete)
VALUES (2016, 'Diving', 'M', 'Men''s 10m Platform', 'Silver', 'MEX', 'SANCHEZ German');

INSERT INTO olympic_medal_winners(olympic_year, sport, gender, event, medal, noc, athlete)
VALUES (2016, 'Diving', 'M', 'Men''s 3m Springboard', 'Gold', 'CHN', 'CAO Yuan');

INSERT INTO olympic_medal_winners(olympic_year, sport, gender, event, medal, noc, athlete)
VALUES (2016, 'Diving', 'M', 'Men''s 3m Springboard', 'Silver', 'GBR', 'LAUGHER Jack');

INSERT INTO olympic_medal_winners(olympic_year, sport, gender, event, medal, noc, athlete)
VALUES (2016, 'Diving', 'M', 'Men''s 3m Springboard', 'Bronze', 'GER', 'HAUSDING Patrick');

INSERT INTO olympic_medal_winners(olympic_year, sport, gender, event, medal, noc, athlete)
VALUES (2016, 'Equestrian', 'X', 'Dressage Individual', 'Gold', 'GBR', 'DUJARDIN Charlotte');

INSERT INTO olympic_medal_winners(olympic_year, sport, gender, event, medal, noc, athlete)
VALUES (2016, 'Equestrian', 'X', 'Dressage Individual', 'Bronze', 'GER', 'BRORING-SPREHE Kristina');

INSERT INTO olympic_medal_winners(olympic_year, sport, gender, event, medal, noc, athlete)
VALUES (2016, 'Equestrian', 'X', 'Dressage Individual', 'Silver', 'GER', 'WERTH Isabell');

INSERT INTO olympic_medal_winners(olympic_year, sport, gender, event, medal, noc, athlete)
VALUES (2016, 'Equestrian', 'X', 'Dressage Team', 'Gold', 'GER', 'Germany');

INSERT INTO olympic_medal_winners(olympic_year, sport, gender, event, medal, noc, athlete)
VALUES (2016, 'Equestrian', 'X', 'Dressage Team', 'Bronze', 'USA', 'United States');

INSERT INTO olympic_medal_winners(olympic_year, sport, gender, event, medal, noc, athlete)
VALUES (2016, 'Equestrian', 'X', 'Dressage Team', 'Silver', 'GBR', 'Great Britain');

INSERT INTO olympic_medal_winners(olympic_year, sport, gender, event, medal, noc, athlete)
VALUES (2016, 'Fencing', 'M', 'Men''s Foil Individual', 'Gold', 'ITA', 'GAROZZO Daniele');

INSERT INTO olympic_medal_winners(olympic_year, sport, gender, event, medal, noc, athlete)
VALUES (2016, 'Fencing', 'M', 'Men''s Foil Individual', 'Silver', 'USA', 'MASSIALAS Alexander');

INSERT INTO olympic_medal_winners(olympic_year, sport, gender, event, medal, noc, athlete)
VALUES (2016, 'Fencing', 'M', 'Men''s Foil Individual', 'Bronze', 'RUS', 'SAFIN Timur');

INSERT INTO olympic_medal_winners(olympic_year, sport, gender, event, medal, noc, athlete)
VALUES (2016, 'Fencing', 'M', 'Men''s Foil Team', 'Gold', 'RUS', 'Russian Federation');

INSERT INTO olympic_medal_winners(olympic_year, sport, gender, event, medal, noc, athlete)
VALUES (2016, 'Fencing', 'M', 'Men''s Foil Team', 'Bronze', 'USA', 'United States');

INSERT INTO olympic_medal_winners(olympic_year, sport, gender, event, medal, noc, athlete)
VALUES (2016, 'Fencing', 'M', 'Men''s Foil Team', 'Silver', 'FRA', 'France');

INSERT INTO olympic_medal_winners(olympic_year, sport, gender, event, medal, noc, athlete)
VALUES (2016, 'Handball', 'M', 'Men', 'Gold', 'DEN', 'Denmark');

INSERT INTO olympic_medal_winners(olympic_year, sport, gender, event, medal, noc, athlete)
VALUES (2016, 'Handball', 'M', 'Men', 'Silver', 'FRA', 'France');

INSERT INTO olympic_medal_winners(olympic_year, sport, gender, event, medal, noc, athlete)
VALUES (2016, 'Handball', 'M', 'Men', 'Bronze', 'GER', 'Germany');

INSERT INTO olympic_medal_winners(olympic_year, sport, gender, event, medal, noc, athlete)
VALUES (2016, 'Handball', 'W', 'Women', 'Gold', 'RUS', 'Russian Federation');

INSERT INTO olympic_medal_winners(olympic_year, sport, gender, event, medal, noc, athlete)
VALUES (2016, 'Handball', 'W', 'Women', 'Silver', 'FRA', 'France');

INSERT INTO olympic_medal_winners(olympic_year, sport, gender, event, medal, noc, athlete)
VALUES (2016, 'Handball', 'W', 'Women', 'Bronze', 'NOR', 'Norway');

INSERT INTO olympic_medal_winners(olympic_year, sport, gender, event, medal, noc, athlete)
VALUES (2016, 'Hockey', 'M', 'Men', 'Gold', 'ARG', 'Argentina');

INSERT INTO olympic_medal_winners(olympic_year, sport, gender, event, medal, noc, athlete)
VALUES (2016, 'Hockey', 'M', 'Men', 'Silver', 'BEL', 'Belgium');

INSERT INTO olympic_medal_winners(olympic_year, sport, gender, event, medal, noc, athlete)
VALUES (2016, 'Hockey', 'M', 'Men', 'Bronze', 'GER', 'Germany');

INSERT INTO olympic_medal_winners(olympic_year, sport, gender, event, medal, noc, athlete)
VALUES (2016, 'Hockey', 'W', 'Women', 'Gold', 'GBR', 'Great Britain');

INSERT INTO olympic_medal_winners(olympic_year, sport, gender, event, medal, noc, athlete)
VALUES (2016, 'Hockey', 'W', 'Women', 'Silver', 'NED', 'Netherlands');

INSERT INTO olympic_medal_winners(olympic_year, sport, gender, event, medal, noc, athlete)
VALUES (2016, 'Hockey', 'W', 'Women', 'Bronze', 'GER', 'Germany');

INSERT INTO olympic_medal_winners(olympic_year, sport, gender, event, medal, noc, athlete)
VALUES (2016, 'Judo', 'M', 'Men +100 kg', 'Gold', 'FRA', 'RINER Teddy');

INSERT INTO olympic_medal_winners(olympic_year, sport, gender, event, medal, noc, athlete)
VALUES (2016, 'Judo', 'M', 'Men +100 kg', 'Bronze', 'BRA', 'SILVA Rafael');

INSERT INTO olympic_medal_winners(olympic_year, sport, gender, event, medal, noc, athlete)
VALUES (2016, 'Judo', 'M', 'Men +100 kg', 'Bronze', 'ISR', 'SASSON Or');

INSERT INTO olympic_medal_winners(olympic_year, sport, gender, event, medal, noc, athlete)
VALUES (2016, 'Judo', 'M', 'Men +100 kg', 'Silver', 'JPN', 'HARASAWA Hisayoshi');

INSERT INTO olympic_medal_winners(olympic_year, sport, gender, event, medal, noc, athlete)
VALUES (2016, 'Judo', 'M', 'Men -100 kg', 'Gold', 'CZE', 'KRPALEK Lukas');

INSERT INTO olympic_medal_winners(olympic_year, sport, gender, event, medal, noc, athlete)
VALUES (2016, 'Judo', 'M', 'Men -100 kg', 'Bronze', 'FRA', 'MARET Cyrille');

INSERT INTO olympic_medal_winners(olympic_year, sport, gender, event, medal, noc, athlete)
VALUES (2016, 'Modern Pentathlon', 'M', 'Men''s Individual', 'Gold', 'RUS', 'LESUN Alexander');

INSERT INTO olympic_medal_winners(olympic_year, sport, gender, event, medal, noc, athlete)
VALUES (2016, 'Modern Pentathlon', 'M', 'Men''s Individual', 'Silver', 'UKR', 'TYMOSHCHENKO Pavlo');

INSERT INTO olympic_medal_winners(olympic_year, sport, gender, event, medal, noc, athlete)
VALUES (2016, 'Modern Pentathlon', 'M', 'Men''s Individual', 'Bronze', 'MEX', 'HERNANDEZ USCANGA Ismael Marcelo');

INSERT INTO olympic_medal_winners(olympic_year, sport, gender, event, medal, noc, athlete)
VALUES (2016, 'Modern Pentathlon', 'W', 'Women''s Individual', 'Gold', 'AUS', 'ESPOSITO Chloe');

INSERT INTO olympic_medal_winners(olympic_year, sport, gender, event, medal, noc, athlete)
VALUES (2016, 'Modern Pentathlon', 'W', 'Women''s Individual', 'Silver', 'FRA', 'CLOUVEL Elodie');

INSERT INTO olympic_medal_winners(olympic_year, sport, gender, event, medal, noc, athlete)
VALUES (2016, 'Modern Pentathlon', 'W', 'Women''s Individual', 'Bronze', 'POL', 'NOWACKA Oktawia');

INSERT INTO olympic_medal_winners(olympic_year, sport, gender, event, medal, noc, athlete)
VALUES (2016, 'Rhythmic Gymnastics', 'W', 'Group All-Around', 'Gold', 'RUS', 'Russian Federation');

INSERT INTO olympic_medal_winners(olympic_year, sport, gender, event, medal, noc, athlete)
VALUES (2016, 'Rhythmic Gymnastics', 'W', 'Group All-Around', 'Bronze', 'BUL', 'Bulgaria');

INSERT INTO olympic_medal_winners(olympic_year, sport, gender, event, medal, noc, athlete)
VALUES (2016, 'Rhythmic Gymnastics', 'W', 'Group All-Around', 'Silver', 'ESP', 'Spain');

INSERT INTO olympic_medal_winners(olympic_year, sport, gender, event, medal, noc, athlete)
VALUES (2016, 'Rhythmic Gymnastics', 'W', 'Individual All-Around', 'Gold', 'RUS', 'MAMUN Margarita');

INSERT INTO olympic_medal_winners(olympic_year, sport, gender, event, medal, noc, athlete)
VALUES (2016, 'Rhythmic Gymnastics', 'W', 'Individual All-Around', 'Silver', 'RUS', 'KUDRYAVTSEVA Yana');

INSERT INTO olympic_medal_winners(olympic_year, sport, gender, event, medal, noc, athlete)
VALUES (2016, 'Rhythmic Gymnastics', 'W', 'Individual All-Around', 'Bronze', 'UKR', 'RIZATDINOVA Ganna');

INSERT INTO olympic_medal_winners(olympic_year, sport, gender, event, medal, noc, athlete)
VALUES (2016, 'Rowing', 'M', 'Lightweight Men''s Double Sculls', 'Gold', 'FRA', 'Azou');

INSERT INTO olympic_medal_winners(olympic_year, sport, gender, event, medal, noc, athlete)
VALUES (2016, 'Rowing', 'M', 'Lightweight Men''s Double Sculls', 'Bronze', 'NOR', 'Brun');

INSERT INTO olympic_medal_winners(olympic_year, sport, gender, event, medal, noc, athlete)
VALUES (2016, 'Rowing', 'M', 'Lightweight Men''s Double Sculls', 'Bronze', 'NOR', 'Strandli');

INSERT INTO olympic_medal_winners(olympic_year, sport, gender, event, medal, noc, athlete)
VALUES (2016, 'Rowing', 'M', 'Lightweight Men''s Double Sculls', 'Silver', 'IRL', 'O''Donovan');

INSERT INTO olympic_medal_winners(olympic_year, sport, gender, event, medal, noc, athlete)
VALUES (2016, 'Rowing', 'M', 'Lightweight Men''s Double Sculls', 'Silver', 'IRL', 'O''Donovan');

INSERT INTO olympic_medal_winners(olympic_year, sport, gender, event, medal, noc, athlete)
VALUES (2016, 'Rowing', 'M', 'Lightweight Men''s Double Sculls', 'Gold', 'FRA', 'Houin');

INSERT INTO olympic_medal_winners(olympic_year, sport, gender, event, medal, noc, athlete)
VALUES (2016, 'Sailing', 'M', '470 Men', 'Gold', 'CRO', 'Fantela');

INSERT INTO olympic_medal_winners(olympic_year, sport, gender, event, medal, noc, athlete)
VALUES (2016, 'Sailing', 'M', '470 Men', 'Bronze', 'GRE', 'Kagialis');

INSERT INTO olympic_medal_winners(olympic_year, sport, gender, event, medal, noc, athlete)
VALUES (2016, 'Sailing', 'M', '470 Men', 'Bronze', 'GRE', 'Mantis');

INSERT INTO olympic_medal_winners(olympic_year, sport, gender, event, medal, noc, athlete)
VALUES (2016, 'Sailing', 'M', '470 Men', 'Silver', 'AUS', 'Ryan');

INSERT INTO olympic_medal_winners(olympic_year, sport, gender, event, medal, noc, athlete)
VALUES (2016, 'Sailing', 'M', '470 Men', 'Silver', 'AUS', 'Belcher');

INSERT INTO olympic_medal_winners(olympic_year, sport, gender, event, medal, noc, athlete)
VALUES (2016, 'Sailing', 'M', '470 Men', 'Gold', 'CRO', 'Marenic');

INSERT INTO olympic_medal_winners(olympic_year, sport, gender, event, medal, noc, athlete)
VALUES (2016, 'Swimming', 'M', 'Men''s 100m Backstroke', 'Gold', 'USA', 'MURPHY Ryan');

INSERT INTO olympic_medal_winners(olympic_year, sport, gender, event, medal, noc, athlete)
VALUES (2016, 'Swimming', 'M', 'Men''s 100m Backstroke', 'Bronze', 'USA', 'PLUMMER David');

INSERT INTO olympic_medal_winners(olympic_year, sport, gender, event, medal, noc, athlete)
VALUES (2016, 'Swimming', 'M', 'Men''s 100m Backstroke', 'Silver', 'CHN', 'XU Jiayu');

INSERT INTO olympic_medal_winners(olympic_year, sport, gender, event, medal, noc, athlete)
VALUES (2016, 'Swimming', 'M', 'Men''s 100m Breaststroke', 'Gold', 'GBR', 'PEATY Adam');

INSERT INTO olympic_medal_winners(olympic_year, sport, gender, event, medal, noc, athlete)
VALUES (2016, 'Swimming', 'M', 'Men''s 100m Breaststroke', 'Bronze', 'USA', 'MILLER Cody');

INSERT INTO olympic_medal_winners(olympic_year, sport, gender, event, medal, noc, athlete)
VALUES (2016, 'Swimming', 'M', 'Men''s 100m Breaststroke', 'Silver', 'RSA', 'VAN DER BURGH Cameron');

INSERT INTO olympic_medal_winners(olympic_year, sport, gender, event, medal, noc, athlete)
VALUES (2016, 'Table Tennis', 'M', 'Men''s Singles', 'Gold', 'CHN', 'MA Long');

INSERT INTO olympic_medal_winners(olympic_year, sport, gender, event, medal, noc, athlete)
VALUES (2016, 'Table Tennis', 'M', 'Men''s Singles', 'Bronze', 'JPN', 'MIZUTANI Jun');

INSERT INTO olympic_medal_winners(olympic_year, sport, gender, event, medal, noc, athlete)
VALUES (2016, 'Table Tennis', 'M', 'Men''s Singles', 'Silver', 'CHN', 'ZHANG Jike');

INSERT INTO olympic_medal_winners(olympic_year, sport, gender, event, medal, noc, athlete)
VALUES (2016, 'Table Tennis', 'M', 'Men''s Team', 'Gold', 'CHN', 'China');

INSERT INTO olympic_medal_winners(olympic_year, sport, gender, event, medal, noc, athlete)
VALUES (2016, 'Table Tennis', 'M', 'Men''s Team', 'Bronze', 'GER', 'Germany');

INSERT INTO olympic_medal_winners(olympic_year, sport, gender, event, medal, noc, athlete)
VALUES (2016, 'Table Tennis', 'M', 'Men''s Team', 'Silver', 'JPN', 'Japan');

INSERT INTO olympic_medal_winners(olympic_year, sport, gender, event, medal, noc, athlete)
VALUES (2016, 'Taekwondo', 'M', 'Men +80kg', 'Gold', 'AZE', 'ISAEV Radik');

INSERT INTO olympic_medal_winners(olympic_year, sport, gender, event, medal, noc, athlete)
VALUES (2016, 'Taekwondo', 'M', 'Men +80kg', 'Bronze', 'KOR', 'CHA Dongmin');

INSERT INTO olympic_medal_winners(olympic_year, sport, gender, event, medal, noc, athlete)
VALUES (2016, 'Taekwondo', 'M', 'Men +80kg', 'Bronze', 'BRA', 'SIQUEIRA Maicon');

INSERT INTO olympic_medal_winners(olympic_year, sport, gender, event, medal, noc, athlete)
VALUES (2016, 'Taekwondo', 'M', 'Men +80kg', 'Silver', 'NIG', 'ISSOUFOU ALFAGA Abdoulrazak');

INSERT INTO olympic_medal_winners(olympic_year, sport, gender, event, medal, noc, athlete)
VALUES (2016, 'Taekwondo', 'M', 'Men -58kg', 'Gold', 'CHN', 'ZHAO Shuai');

INSERT INTO olympic_medal_winners(olympic_year, sport, gender, event, medal, noc, athlete)
VALUES (2016, 'Taekwondo', 'M', 'Men -58kg', 'Silver', 'THA', 'HANPRAB Tawin');

INSERT INTO olympic_medal_winners(olympic_year, sport, gender, event, medal, noc, athlete)
VALUES (2016, 'Tennis', 'M', 'Men''s Doubles', 'Gold', 'ESP', 'Lopez');

INSERT INTO olympic_medal_winners(olympic_year, sport, gender, event, medal, noc, athlete)
VALUES (2016, 'Tennis', 'M', 'Men''s Doubles', 'Bronze', 'USA', 'Johnson');

INSERT INTO olympic_medal_winners(olympic_year, sport, gender, event, medal, noc, athlete)
VALUES (2016, 'Tennis', 'M', 'Men''s Doubles', 'Bronze', 'USA', 'Sock');

INSERT INTO olympic_medal_winners(olympic_year, sport, gender, event, medal, noc, athlete)
VALUES (2016, 'Tennis', 'M', 'Men''s Doubles', 'Silver', 'ROU', 'Tecau');

INSERT INTO olympic_medal_winners(olympic_year, sport, gender, event, medal, noc, athlete)
VALUES (2016, 'Tennis', 'M', 'Men''s Doubles', 'Silver', 'ROU', 'Mergea');

INSERT INTO olympic_medal_winners(olympic_year, sport, gender, event, medal, noc, athlete)
VALUES (2016, 'Tennis', 'M', 'Men''s Doubles', 'Gold', 'ESP', 'Nadal');

INSERT INTO olympic_medal_winners(olympic_year, sport, gender, event, medal, noc, athlete)
VALUES (2016, 'Trampoline Gymnastics', 'M', 'Men', 'Gold', 'BLR', 'HANCHAROU Uladzislau');

INSERT INTO olympic_medal_winners(olympic_year, sport, gender, event, medal, noc, athlete)
VALUES (2016, 'Trampoline Gymnastics', 'M', 'Men', 'Silver', 'CHN', 'DONG Dong');

INSERT INTO olympic_medal_winners(olympic_year, sport, gender, event, medal, noc, athlete)
VALUES (2016, 'Trampoline Gymnastics', 'M', 'Men', 'Bronze', 'CHN', 'GAO Lei');

INSERT INTO olympic_medal_winners(olympic_year, sport, gender, event, medal, noc, athlete)
VALUES (2016, 'Trampoline Gymnastics', 'W', 'Women', 'Gold', 'CAN', 'MACLENNAN Rosannagh');

INSERT INTO olympic_medal_winners(olympic_year, sport, gender, event, medal, noc, athlete)
VALUES (2016, 'Trampoline Gymnastics', 'W', 'Women', 'Silver', 'GBR', 'PAGE Bryony');

INSERT INTO olympic_medal_winners(olympic_year, sport, gender, event, medal, noc, athlete)
VALUES (2016, 'Trampoline Gymnastics', 'W', 'Women', 'Bronze', 'CHN', 'LI Dan');

INSERT INTO olympic_medal_winners(olympic_year, sport, gender, event, medal, noc, athlete)
VALUES (2016, 'Triathlon', 'M', 'Men', 'Gold', 'GBR', 'BROWNLEE Alistair');

INSERT INTO olympic_medal_winners(olympic_year, sport, gender, event, medal, noc, athlete)
VALUES (2016, 'Triathlon', 'M', 'Men', 'Silver', 'GBR', 'BROWNLEE Jonathan');

INSERT INTO olympic_medal_winners(olympic_year, sport, gender, event, medal, noc, athlete)
VALUES (2016, 'Triathlon', 'M', 'Men', 'Bronze', 'RSA', 'SCHOEMAN Henri');

INSERT INTO olympic_medal_winners(olympic_year, sport, gender, event, medal, noc, athlete)
VALUES (2016, 'Triathlon', 'W', 'Women', 'Gold', 'USA', 'JORGENSEN Gwen');

INSERT INTO olympic_medal_winners(olympic_year, sport, gender, event, medal, noc, athlete)
VALUES (2016, 'Triathlon', 'W', 'Women', 'Silver', 'SUI', 'SPIRIG HUG Nicola');

INSERT INTO olympic_medal_winners(olympic_year, sport, gender, event, medal, noc, athlete)
VALUES (2016, 'Triathlon', 'W', 'Women', 'Bronze', 'GBR', 'HOLLAND Vicky');

INSERT INTO olympic_medal_winners(olympic_year, sport, gender, event, medal, noc, athlete)
VALUES (2016, 'Volleyball', 'M', 'Men', 'Gold', 'BRA', 'Brazil');

INSERT INTO olympic_medal_winners(olympic_year, sport, gender, event, medal, noc, athlete)
VALUES (2016, 'Volleyball', 'M', 'Men', 'Silver', 'ITA', 'Italy');

INSERT INTO olympic_medal_winners(olympic_year, sport, gender, event, medal, noc, athlete)
VALUES (2016, 'Volleyball', 'M', 'Men', 'Bronze', 'USA', 'United States');

INSERT INTO olympic_medal_winners(olympic_year, sport, gender, event, medal, noc, athlete)
VALUES (2016, 'Volleyball', 'W', 'Women', 'Gold', 'CHN', 'China');

INSERT INTO olympic_medal_winners(olympic_year, sport, gender, event, medal, noc, athlete)
VALUES (2016, 'Volleyball', 'W', 'Women', 'Silver', 'SRB', 'Serbia');

INSERT INTO olympic_medal_winners(olympic_year, sport, gender, event, medal, noc, athlete)
VALUES (2016, 'Volleyball', 'W', 'Women', 'Bronze', 'USA', 'United States');

INSERT INTO olympic_medal_winners(olympic_year, sport, gender, event, medal, noc, athlete)
VALUES (2016, 'Water Polo', 'M', 'Men', 'Gold', 'SRB', 'Serbia');

INSERT INTO olympic_medal_winners(olympic_year, sport, gender, event, medal, noc, athlete)
VALUES (2016, 'Water Polo', 'M', 'Men', 'Silver', 'CRO', 'Croatia');

INSERT INTO olympic_medal_winners(olympic_year, sport, gender, event, medal, noc, athlete)
VALUES (2016, 'Water Polo', 'M', 'Men', 'Bronze', 'ITA', 'Italy');

INSERT INTO olympic_medal_winners(olympic_year, sport, gender, event, medal, noc, athlete)
VALUES (2016, 'Water Polo', 'W', 'Women', 'Gold', 'USA', 'United States');

INSERT INTO olympic_medal_winners(olympic_year, sport, gender, event, medal, noc, athlete)
VALUES (2016, 'Water Polo', 'W', 'Women', 'Silver', 'ITA', 'Italy');

INSERT INTO olympic_medal_winners(olympic_year, sport, gender, event, medal, noc, athlete)
VALUES (2016, 'Water Polo', 'W', 'Women', 'Bronze', 'RUS', 'Russian Federation');

INSERT INTO olympic_medal_winners(olympic_year, sport, gender, event, medal, noc, athlete)
VALUES (2016, 'Weightlifting', 'M', 'Men''s +105kg', 'Gold', 'GEO', 'TALAKHADZE Lasha');

INSERT INTO olympic_medal_winners(olympic_year, sport, gender, event, medal, noc, athlete)
VALUES (2016, 'Weightlifting', 'M', 'Men''s +105kg', 'Bronze', 'GEO', 'TURMANIDZE Irakli');

INSERT INTO olympic_medal_winners(olympic_year, sport, gender, event, medal, noc, athlete)
VALUES (2016, 'Weightlifting', 'M', 'Men''s +105kg', 'Silver', 'ARM', 'MINASYAN Gor');

INSERT INTO olympic_medal_winners(olympic_year, sport, gender, event, medal, noc, athlete)
VALUES (2016, 'Weightlifting', 'M', 'Men''s 105kg', 'Gold', 'UZB', 'NURUDINOV Ruslan');

INSERT INTO olympic_medal_winners(olympic_year, sport, gender, event, medal, noc, athlete)
VALUES (2016, 'Weightlifting', 'M', 'Men''s 105kg', 'Bronze', 'KAZ', 'ZAICHIKOV Alexandr');

INSERT INTO olympic_medal_winners(olympic_year, sport, gender, event, medal, noc, athlete)
VALUES (2016, 'Weightlifting', 'M', 'Men''s 105kg', 'Silver', 'ARM', 'MARTIROSYAN Simon');

INSERT INTO olympic_medal_winners(olympic_year, sport, gender, event, medal, noc, athlete)
VALUES (2016, 'Wrestling', 'M', 'Men''s Freestyle 125 kg', 'Gold', 'TUR', 'AKGUL Taha');

INSERT INTO olympic_medal_winners(olympic_year, sport, gender, event, medal, noc, athlete)
VALUES (2016, 'Wrestling', 'M', 'Men''s Freestyle 125 kg', 'Bronze', 'BLR', 'SAIDAU Ibrahim');

INSERT INTO olympic_medal_winners(olympic_year, sport, gender, event, medal, noc, athlete)
VALUES (2016, 'Wrestling', 'M', 'Men''s Freestyle 125 kg', 'Bronze', 'GEO', 'PETRIASHVILI Geno');

INSERT INTO olympic_medal_winners(olympic_year, sport, gender, event, medal, noc, athlete)
VALUES (2016, 'Wrestling', 'M', 'Men''s Freestyle 125 kg', 'Silver', 'IRI', 'GHASEMI Komeil Nemat');

INSERT INTO olympic_medal_winners(olympic_year, sport, gender, event, medal, noc, athlete)
VALUES (2016, 'Wrestling', 'M', 'Men''s Freestyle 57 kg', 'Gold', 'GEO', 'KHINCHEGASHVILI Vladimer');

INSERT INTO olympic_medal_winners(olympic_year, sport, gender, event, medal, noc, athlete)
VALUES (2016, 'Wrestling', 'M', 'Men''s Freestyle 57 kg', 'Bronze', 'AZE', 'ALIYEV Haji');

-- This pivots the results by medal. But the columns not listed in the pivot form an implicit group by.
-- So this gives the medal total per athlete per event.
SELECT *
FROM olympic_medal_winners --
  PIVOT (count(*) FOR medal IN ('Gold' gold, 'Silver' silver, 'Bronze' bronze))
ORDER BY noc
FETCH FIRST 6 ROWS ONLY;

-- To overcome the problem in the previous statement, this selects just the columns you need in the subquery. 
-- But SOME EVENTS have multiple people who win THE same medal - e.g.doubles tennis.This PIVOT counts ROWS IN THE TABLE, NOT individual EVENTS.
SELECT *
FROM
  (SELECT noc, medal
   FROM olympic_medal_winners) --
    PIVOT (count(*) FOR medal IN ('Gold' gold, 'Silver' silver, 'Bronze' bronze))
ORDER BY 2 DESC, 3 DESC, 4 DESC
FETCH FIRST 5 ROWS ONLY;

-- This solves the over counting problem in the previous statement. It does this by finding the distinct values for sport, event and gender then counting the results.
SELECT *
FROM
  (SELECT noc, medal, sport, event, gender
   FROM olympic_medal_winners) --
    PIVOT (count(DISTINCT
                 sport || '#' || event || '#' || gender) FOR medal IN ('Gold' gold, 'Silver' silver, 'Bronze' bronze))
ORDER BY 2 DESC, 3 DESC, 4 DESC
FETCH FIRST 5 ROWS ONLY;

-- A base query for the `gold` column
SELECT count(DISTINCT sport || '#' || event || '#' || gender) AS gold
FROM olympic_medal_winners
WHERE medal = 'Gold'
GROUP BY noc
ORDER BY gold DESC
FETCH FIRST 5 ROWS ONLY;

-- You can have many functions in the pivot. Oracle generates a column for each function per value in the in clause.
-- This finds THE gold medal winning countries.FOR EACH it shows:
-- THE NUMBER OF different EVENTS these were won IN - THE NUMBER OF different sports thy were won IN -
-- THE names OF THE athlete OR team who won EACH medal
-- Finally it filters TO ONLY SHOW those countries that won AT least two gold medals.
SELECT *
FROM
  (SELECT noc, medal, sport, event, gender, athlete
   FROM olympic_medal_winners) --
    PIVOT (--
      count(DISTINCT sport || '#' || event || '#' || gender) medals, --
    count(DISTINCT sport) sports, --
    listagg(athlete, ',')
    WITHIN GROUP (ORDER BY athlete) athletes --
    FOR medal IN ('Gold' gold))
WHERE gold_medals > 1
ORDER BY gold_medals, gold_sports, noc
FETCH FIRST 5 ROWS ONLY;

-- This is similar to the previous query. But it finds those countries whose IOC code starts with D.
SELECT *
FROM
  (SELECT noc, medal, sport, event, gender, athlete
   FROM olympic_medal_winners) --
    PIVOT (--
      count(DISTINCT sport || '#' || event || '#' || gender) medals, --
    count(DISTINCT sport) sports, --
    listagg(athlete, ',')
    WITHIN GROUP (ORDER BY athlete) athletes
    FOR medal IN ('Gold' gold))
WHERE noc LIKE 'D%'
ORDER BY gold_medals;

-- This produces a matrix, sports across the top countries down the side.
-- There's an X for each sport that country has a row in the table for.
SELECT *
FROM
  (SELECT noc, sport
   FROM olympic_medal_winners) --
    PIVOT (--
      min('X') --
    FOR sport IN ('Archery' AS arc, 'Athletics' AS ath, 'Hockey' AS hoc, 'Judo' AS jud, 'Sailing' AS sai, 'Wrestling' AS wre))
ORDER BY noc
FETCH FIRST 7 ROWS ONLY;

-- This is the old school, pre Oracle Database 11g method for pivoting data.
SELECT
  noc,
  count(CASE WHEN medal = 'Gold' THEN 1 END) AS gold_medals,
  count(CASE WHEN medal = 'Silver' THEN 1 END) AS silver_medals,
  count(CASE WHEN medal = 'Bronze' THEN 1 END) AS bronze_medals
FROM olympic_medal_winners
GROUP BY noc
ORDER BY 2 DESC, 3 DESC, 4 DESC
FETCH FIRST 5 ROWS ONLY;

-- An example of how to build the pivot clause values dynamically. 
-- Note that WHEN you do this THE NUMBER OF COLUMNS can CHANGE between runs.
-- So the execute and fetch routine will be far more complex in a real world scenario!
DECLARE sql_stmt CLOB;
  pivot_clause CLOB;
BEGIN SELECT listagg('''' || sport || ''' as "' || sport || '"', ',') WITHIN GROUP (ORDER BY sport)
  INTO pivot_clause
      FROM
        (SELECT DISTINCT sport
         FROM olympic_medal_winners);

  sql_stmt := 'select * from (select noc, sport from olympic_medal_winners)   
pivot (count(*) for sport in (' || pivot_clause || '))';

  dbms_output.put_line(sql_stmt);

  EXECUTE IMMEDIATE sql_stmt;
END;
/

-- The XML keyword dynamically builds the list of values to pivot.
-- But you get the results in XML! Each "column" is an element in this document.
/*
-- NoClassDefFoundError: oracle/xdb/XMLType

SELECT *
FROM
  (SELECT noc, sport
   FROM olympic_medal_winners) --
    PIVOT XML (count(*) medal_winners FOR sport IN (SELECT sport
                                                    FROM olympic_medal_winners
                                                    WHERE sport LIKE 'A%'))
WHERE rownum = 1;

-- This previous example gave every country at least one medal in every sport! To avoid this, you need to count a column which will be null if the country didn't win in a particular event. 
SELECT *
FROM
  (SELECT noc, sport, athlete
   FROM olympic_medal_winners) PIVOT XML (count(athlete) medal_winners FOR sport IN (SELECT sport
                                                                                     FROM olympic_medal_winners
                                                                                     WHERE sport LIKE 'A%'))
WHERE rownum = 1;
*/

-- This creates the final medal table for the unpivot example below.
CREATE TABLE olympic_medal_tables AS
  SELECT *
  FROM
    (SELECT noc, medal, sport, event, gender
     FROM olympic_medal_winners) --
      PIVOT (--
        count(DISTINCT sport || '#' || event || '#' || gender) --
      FOR medal IN ('Gold' gold_medals, 'Silver' silver_medals, 'Bronze' bronze_medals))
  ORDER BY 2 DESC, 3 DESC, 4 DESC;

-- Unpivot takes the columns and converts them back to rows. 
SELECT *
FROM olympic_medal_tables --
  UNPIVOT (medal_count FOR medal_colour IN (--
  gold_medals AS 'GOLD', --
  silver_medals AS 'SILVER', --
  bronze_medals AS 'BRONZE'))
ORDER BY noc
FETCH FIRST 6 ROWS ONLY;

DROP TABLE olympic_medal_tables PURGE;

CREATE TABLE olympic_medal_tables AS
  SELECT *
  FROM
    (SELECT noc, medal, sport, event, gender
     FROM olympic_medal_winners) --
      PIVOT (count(DISTINCT sport || '#' || event || '#' || gender) medals, count(DISTINCT sport) sports
      FOR medal IN ('Gold' gold, 'Silver' silver, 'Bronze' bronze))
  ORDER BY 2 DESC, 4 DESC, 6 DESC;

-- You can unpivot two or more columns to a single row. To do this, provide a list of the columns you want to combine. You then get a column for each in the results.
SELECT *
FROM olympic_medal_tables--
  UNPIVOT ((medal_count, sport_count) FOR medal_colour IN ((gold_medals, gold_sports) AS 'GOLD', (silver_medals, silver_sports) AS 'SILVER', (bronze_medals, bronze_sports) AS 'BRONZE'))
FETCH FIRST 9 ROWS ONLY;

DROP TABLE olympic_medal_tables PURGE

CREATE TABLE olympic_medal_tables AS
  SELECT *
  FROM
    (SELECT noc, medal, sport, event, gender, athlete
     FROM olympic_medal_winners) PIVOT (count(DISTINCT sport || '#' || event || '#' || gender) medals, listagg(athlete,
                                                                                                               ',')
                                                                                                       WITHIN GROUP (ORDER BY athlete) athletes
      FOR medal IN ('Gold' gold, 'Silver' silver, 'Bronze' bronze))
  ORDER BY 2 DESC, 4 DESC, 6 DESC;

-- Another example of unpivoting multiple columns. This time with a list of athletes.
SELECT *
FROM olympic_medal_tables UNPIVOT ((medal_count, athletes) FOR medal_colour IN ((gold_medals, gold_athletes) AS 'GOLD', (silver_medals, silver_athletes) AS 'SILVER', (bronze_medals, bronze_athletes) AS 'BRONZE'))
WHERE medal_colour = 'GOLD' AND medal_count = 2
ORDER BY noc
FETCH FIRST 3 ROWS ONLY;

-- This first unpivots the results to get the list of athletes won two gold medals. It then uses XML tokenization to split the list into a row per person.
WITH rws AS (SELECT *
             FROM olympic_medal_tables UNPIVOT ((medal_count, athletes) FOR medal_colour IN ((gold_medals, gold_athletes) AS 'GOLD', (silver_medals, silver_athletes) AS 'SILVER', (bronze_medals, bronze_athletes) AS 'BRONZE'))
             WHERE medal_colour = 'GOLD' AND medal_count = 2)
SELECT noc, athlete
FROM rws,
  xmltable('if (contains($X,",")) then ora:tokenize($X,"\,") else $X' PASSING athletes AS x
           COLUMNS athlete VARCHAR2(4000) PATH '.')
ORDER BY 1, 2
FETCH FIRST 6 ROWS ONLY


-- This creates the table of medals won by each country per sport for use in the examples below.
CREATE TABLE olympic_country_sport_medals AS
  SELECT *
  FROM
    (SELECT noc, sport
     FROM olympic_medal_winners) PIVOT (count(
      sport) FOR sport IN ('Athletics' AS ath, 'Artistic Gymnastics' AS gym, 'Cycling Track' AS cyc, 'Boxing' AS box, 'Sailing' AS sai))
  ORDER BY 1;

-- This switches the rows and columns over aka a transpose. It does so by chaining a pivot followed by an unpivot.
SELECT *
FROM olympic_country_sport_medals PIVOT (sum(ath) ath, sum(box) box, sum(gym) gym, sum(sai) sai, sum(cyc) cyc
  FOR noc IN ('BRA' bra, 'CHN' chn, 'DEN' den, 'ESP' esp, 'ETH' eth, 'GRE' gre)) UNPIVOT ((bra, chn, den, esp, eth, gre) FOR sport IN ((bra_ath, chn_ath, den_ath, esp_ath, eth_ath, gre_ath) AS 'Athletics', (bra_gym, chn_gym, den_gym, esp_gym, eth_gym, gre_gym) AS 'Artistic Gym', (bra_box, chn_box, den_box, esp_box, eth_box, gre_box) AS 'Boxing', (bra_sai, chn_sai, den_sai, esp_sai, eth_sai, gre_sai) AS 'Sailing', (bra_cyc, chn_cyc, den_cyc, esp_cyc, eth_cyc, gre_cyc) AS 'Track Cycling'));

-- Tranposing data using unpivot and pivot. Much easier to write than the other way around!
SELECT *
FROM olympic_country_sport_medals UNPIVOT ((medals) FOR sport IN (ath, box, gym, sai, cyc)) PIVOT (sum(
  medals) FOR noc IN ('BRA' bra, 'CHN' chn, 'DEN' den, 'ESP' esp, 'ETH' eth, 'GRE' gre));


create table T_HUMAN_RESOURCE(
	ID_HUMAN_RESOURCE int identity(1,1),
	ID_TITLE int not null,
	ID_COUNTRY int not null,
	FIRSTNAME varchar(50) not null,
	LASTNAME varchar(50) not null
)

create table REF_TITLE(
	ID_TITLE int identity(1,1),
	NAME varchar(50)
)

create table REF_COUNTRY(
	ID_COUNTRY int identity(1,1),
	NAME varchar(50)
)

create table T_EMPLOYEE(
	ID_EMPLOYEE int not null,
	ID_CONTRACT int not null,
	LOGIN varchar(50),
	START_DATE datetime not null, 
	END_DATE datetime
)

create table T_CANDIDATE(
	ID_CANDIDATE int not null,
	ID_CANDIDATE_STATUS int not null,
	ID_MANAGER int not null
)

create table REF_CONTRACT(
	ID_CONTRACT int identity(1,1),
	NAME varchar(50) not null
)

create table REF_CANDIDATE_STATUS(
	ID_CANDIDATE_STATUS int identity(1,1),
	NAME varchar(50) not null
)

create table REF_SKILL_LEVEL(
	ID_SKILL_LEVEL int identity(1,1),
	NAME varchar(50) not null
)

create table REF_TECHNICAL_DOMAIN(
	ID_TECHNICAL_DOMAIN int identity(1,1),
	ID_TECHNICAL_DOMAIN_PARENT int null,
	NAME varchar(50) not null,
	POSITION int
)

create table REF_BUSINESS_DOMAIN(
	ID_BUSINESS_DOMAIN int identity(1,1),
	ID_BUSINESS_DOMAIN_PARENT int null,
	NAME varchar(50) not null,
	POSITION int
)

create table LINK_RESOURCE_BUSINESS_DOMAIN(
	ID_HUMAN_RESOURCE int not null,
	ID_BUSINESS_DOMAIN int not null,
	ID_SKILL_LEVEL int not null
)

create table LINK_RESOURCE_TECHNICAL_DOMAIN(
	ID_HUMAN_RESOURCE int not null,
	ID_TECHNICAL_DOMAIN int not null,
	ID_SKILL_LEVEL int not null
)

insert into REF_TITLE(NAME) values('Mr')
insert into REF_TITLE(NAME) values('Mme')

insert into REF_COUNTRY(NAME) values('Afghanistan')
insert into REF_COUNTRY(NAME) values('Afrique du Sud')
insert into REF_COUNTRY(NAME) values('Albanie')
insert into REF_COUNTRY(NAME) values('Algérie')
insert into REF_COUNTRY(NAME) values('Allemagne')
insert into REF_COUNTRY(NAME) values('Andorre')
insert into REF_COUNTRY(NAME) values('Angola')
insert into REF_COUNTRY(NAME) values('Anguilla')
insert into REF_COUNTRY(NAME) values('Antarctique, Base Mawson')
insert into REF_COUNTRY(NAME) values('Antarctique, Base Scott')
insert into REF_COUNTRY(NAME) values('Antigua-et-Barbuda')
insert into REF_COUNTRY(NAME) values('Antilles Françaises (Saint Martin)')
insert into REF_COUNTRY(NAME) values('Antilles Néerlandaises (Saint Martin)')
insert into REF_COUNTRY(NAME) values('Arabie saoudite')
insert into REF_COUNTRY(NAME) values('Argentine')
insert into REF_COUNTRY(NAME) values('Arménie')
insert into REF_COUNTRY(NAME) values('Aruba')
insert into REF_COUNTRY(NAME) values('Australie')
insert into REF_COUNTRY(NAME) values('Autriche')
insert into REF_COUNTRY(NAME) values('Azerbaïdjan')
insert into REF_COUNTRY(NAME) values('Bahamas')
insert into REF_COUNTRY(NAME) values('Bahreïn')
insert into REF_COUNTRY(NAME) values('Bangladesh')
insert into REF_COUNTRY(NAME) values('Barbade')
insert into REF_COUNTRY(NAME) values('Belgique')
insert into REF_COUNTRY(NAME) values('Belize')
insert into REF_COUNTRY(NAME) values('Bénin')
insert into REF_COUNTRY(NAME) values('Bermudes')
insert into REF_COUNTRY(NAME) values('Bhoutan')
insert into REF_COUNTRY(NAME) values('Bielorussie')
insert into REF_COUNTRY(NAME) values('Birmanie (Myanmar)')
insert into REF_COUNTRY(NAME) values('Bolivie')
insert into REF_COUNTRY(NAME) values('Bosnie-Herzégovine')
insert into REF_COUNTRY(NAME) values('Botswana')
insert into REF_COUNTRY(NAME) values('Brésil')
insert into REF_COUNTRY(NAME) values('Brunei')
insert into REF_COUNTRY(NAME) values('Bulgarie')
insert into REF_COUNTRY(NAME) values('Burkina Faso')
insert into REF_COUNTRY(NAME) values('Burundi')
insert into REF_COUNTRY(NAME) values('Cambodge')
insert into REF_COUNTRY(NAME) values('Cameroun')
insert into REF_COUNTRY(NAME) values('Canada')
insert into REF_COUNTRY(NAME) values('Cap-Vert')
insert into REF_COUNTRY(NAME) values('Chili')
insert into REF_COUNTRY(NAME) values('Chine')
insert into REF_COUNTRY(NAME) values('Chypre')
insert into REF_COUNTRY(NAME) values('Colombie')
insert into REF_COUNTRY(NAME) values('Comores')
insert into REF_COUNTRY(NAME) values('Congo')
insert into REF_COUNTRY(NAME) values('Corée du Nord')
insert into REF_COUNTRY(NAME) values('Corée du Sud')
insert into REF_COUNTRY(NAME) values('Costa Rica')
insert into REF_COUNTRY(NAME) values('Côte d''Ivoire')
insert into REF_COUNTRY(NAME) values('Croatie')
insert into REF_COUNTRY(NAME) values('Cuba')
insert into REF_COUNTRY(NAME) values('Danemark')
insert into REF_COUNTRY(NAME) values('Djibouti')
insert into REF_COUNTRY(NAME) values('Dominique')
insert into REF_COUNTRY(NAME) values('Égypte')
insert into REF_COUNTRY(NAME) values('Émirats arabes unis')
insert into REF_COUNTRY(NAME) values('Équateur')
insert into REF_COUNTRY(NAME) values('Érythrée')
insert into REF_COUNTRY(NAME) values('Espagne')
insert into REF_COUNTRY(NAME) values('Estonie')
insert into REF_COUNTRY(NAME) values('États-Unis')
insert into REF_COUNTRY(NAME) values('Éthiopie')
insert into REF_COUNTRY(NAME) values('Fidji')
insert into REF_COUNTRY(NAME) values('Finlande')
insert into REF_COUNTRY(NAME) values('France')
insert into REF_COUNTRY(NAME) values('Gabon')
insert into REF_COUNTRY(NAME) values('Gambie')
insert into REF_COUNTRY(NAME) values('Géorgie')
insert into REF_COUNTRY(NAME) values('Ghana')
insert into REF_COUNTRY(NAME) values('Gibraltar')
insert into REF_COUNTRY(NAME) values('Grèce')
insert into REF_COUNTRY(NAME) values('Grenade')
insert into REF_COUNTRY(NAME) values('Groënland')
insert into REF_COUNTRY(NAME) values('Guadeloupe')
insert into REF_COUNTRY(NAME) values('Guam')
insert into REF_COUNTRY(NAME) values('Guantanamo')
insert into REF_COUNTRY(NAME) values('Guatemala')
insert into REF_COUNTRY(NAME) values('Guinée')
insert into REF_COUNTRY(NAME) values('Guinée équatoriale')
insert into REF_COUNTRY(NAME) values('Guinée-Bissao')
insert into REF_COUNTRY(NAME) values('Guyana')
insert into REF_COUNTRY(NAME) values('Guyane Française')
insert into REF_COUNTRY(NAME) values('Haïti')
insert into REF_COUNTRY(NAME) values('Honduras')
insert into REF_COUNTRY(NAME) values('Hong Kong')
insert into REF_COUNTRY(NAME) values('Hongrie')
insert into REF_COUNTRY(NAME) values('Iles Ascension')
insert into REF_COUNTRY(NAME) values('Iles Cayman')
insert into REF_COUNTRY(NAME) values('Ile Chatham')
insert into REF_COUNTRY(NAME) values('Ile Christmas')
insert into REF_COUNTRY(NAME) values('Iles Cocos')
insert into REF_COUNTRY(NAME) values('Iles Cook')
insert into REF_COUNTRY(NAME) values('Ile de la Réunion')
insert into REF_COUNTRY(NAME) values('Iles de Paques')
insert into REF_COUNTRY(NAME) values('Iles Falkland')
insert into REF_COUNTRY(NAME) values('Iles Faroe')
insert into REF_COUNTRY(NAME) values('Iles Marshall')
insert into REF_COUNTRY(NAME) values('Ile Mariana')
insert into REF_COUNTRY(NAME) values('Ile Maurice')
insert into REF_COUNTRY(NAME) values('Iles Midway')
insert into REF_COUNTRY(NAME) values('Ile de Montserrat')
insert into REF_COUNTRY(NAME) values('Ile Norfolk')
insert into REF_COUNTRY(NAME) values('Iles Salomon')
insert into REF_COUNTRY(NAME) values('Iles Turks et Caicos')
insert into REF_COUNTRY(NAME) values('Iles Vierges Britaniques')
insert into REF_COUNTRY(NAME) values('Iles Vierges US')
insert into REF_COUNTRY(NAME) values('Ile Wake')
insert into REF_COUNTRY(NAME) values('Iles Wallis et Futuna')
insert into REF_COUNTRY(NAME) values('Inde')
insert into REF_COUNTRY(NAME) values('Indonésie')
insert into REF_COUNTRY(NAME) values('Iran')
insert into REF_COUNTRY(NAME) values('Iraq')
insert into REF_COUNTRY(NAME) values('Irlande')
insert into REF_COUNTRY(NAME) values('Islande')
insert into REF_COUNTRY(NAME) values('Israël')
insert into REF_COUNTRY(NAME) values('Italie')
insert into REF_COUNTRY(NAME) values('Jamaïque')
insert into REF_COUNTRY(NAME) values('Japon')
insert into REF_COUNTRY(NAME) values('Jérusalem')
insert into REF_COUNTRY(NAME) values('Jordanie')
insert into REF_COUNTRY(NAME) values('Kazakhstan')
insert into REF_COUNTRY(NAME) values('Kenya')
insert into REF_COUNTRY(NAME) values('Kirghizistan')
insert into REF_COUNTRY(NAME) values('Kiribati')
insert into REF_COUNTRY(NAME) values('Koweït')
insert into REF_COUNTRY(NAME) values('Laos')
insert into REF_COUNTRY(NAME) values('Lesotho')
insert into REF_COUNTRY(NAME) values('Lettonie')
insert into REF_COUNTRY(NAME) values('Liban')
insert into REF_COUNTRY(NAME) values('Liberia')
insert into REF_COUNTRY(NAME) values('Libye')
insert into REF_COUNTRY(NAME) values('Liechtenstein')
insert into REF_COUNTRY(NAME) values('Lituanie')
insert into REF_COUNTRY(NAME) values('Luxembourg')
insert into REF_COUNTRY(NAME) values('Macao')
insert into REF_COUNTRY(NAME) values('Macédoine')
insert into REF_COUNTRY(NAME) values('Madagascar')
insert into REF_COUNTRY(NAME) values('Malaisie')
insert into REF_COUNTRY(NAME) values('Malawi')
insert into REF_COUNTRY(NAME) values('Maldives')
insert into REF_COUNTRY(NAME) values('Mali')
insert into REF_COUNTRY(NAME) values('Malte')
insert into REF_COUNTRY(NAME) values('Maroc')
insert into REF_COUNTRY(NAME) values('Martinique')
insert into REF_COUNTRY(NAME) values('Mauritanie')
insert into REF_COUNTRY(NAME) values('Mayotte')
insert into REF_COUNTRY(NAME) values('Mexique')
insert into REF_COUNTRY(NAME) values('Micronésie')
insert into REF_COUNTRY(NAME) values('Moldavie')
insert into REF_COUNTRY(NAME) values('Monaco (Monte Carlo)')
insert into REF_COUNTRY(NAME) values('Mongolie')
insert into REF_COUNTRY(NAME) values('Montenegro')
insert into REF_COUNTRY(NAME) values('Mozambique')
insert into REF_COUNTRY(NAME) values('Namibie')
insert into REF_COUNTRY(NAME) values('Nauru')
insert into REF_COUNTRY(NAME) values('Népal')
insert into REF_COUNTRY(NAME) values('Nicaragua')
insert into REF_COUNTRY(NAME) values('Niger')
insert into REF_COUNTRY(NAME) values('Nigeria')
insert into REF_COUNTRY(NAME) values('Niue')
insert into REF_COUNTRY(NAME) values('Norvège')
insert into REF_COUNTRY(NAME) values('Nouvelle Calédonie')
insert into REF_COUNTRY(NAME) values('Nouvelle-Zélande')
insert into REF_COUNTRY(NAME) values('Ouganda')
insert into REF_COUNTRY(NAME) values('Ouzbékistan')
insert into REF_COUNTRY(NAME) values('Pakistan')
insert into REF_COUNTRY(NAME) values('Palau (Palaos)')
insert into REF_COUNTRY(NAME) values('Panama')
insert into REF_COUNTRY(NAME) values('Papouasie - Nouvelle Guinée')
insert into REF_COUNTRY(NAME) values('Paraguay')
insert into REF_COUNTRY(NAME) values('Pays-Bas (Hollande)')
insert into REF_COUNTRY(NAME) values('Pérou')
insert into REF_COUNTRY(NAME) values('Philippines')
insert into REF_COUNTRY(NAME) values('Pologne')
insert into REF_COUNTRY(NAME) values('Polynésie Française (Archipel des Tuamotu)')
insert into REF_COUNTRY(NAME) values('Porto Rico (Puerto Rico)')
insert into REF_COUNTRY(NAME) values('Portugal')
insert into REF_COUNTRY(NAME) values('Qatar')
insert into REF_COUNTRY(NAME) values('République centrafricaine')
insert into REF_COUNTRY(NAME) values('République démocratique du Congo')
insert into REF_COUNTRY(NAME) values('République dominicaine')
insert into REF_COUNTRY(NAME) values('République Tchèque (Tchéquie)')
insert into REF_COUNTRY(NAME) values('Roumanie')
insert into REF_COUNTRY(NAME) values('Royaume-Uni')
insert into REF_COUNTRY(NAME) values('Russie (Fédération de)')
insert into REF_COUNTRY(NAME) values('Rwanda')
insert into REF_COUNTRY(NAME) values('Saint-Christophe-et-Niévès (St Kitts et Nevis)')
insert into REF_COUNTRY(NAME) values('Sainte Hélène')
insert into REF_COUNTRY(NAME) values('Sainte-Lucie')
insert into REF_COUNTRY(NAME) values('Saint-Marin')
insert into REF_COUNTRY(NAME) values('Saint Pierre et Miquelon')
insert into REF_COUNTRY(NAME) values('Saint-Vincent-et-les Grenadines')
insert into REF_COUNTRY(NAME) values('Salvador')
insert into REF_COUNTRY(NAME) values('Samoa Américaine')
insert into REF_COUNTRY(NAME) values('Samoa Occidentale')
insert into REF_COUNTRY(NAME) values('Sao Tomé-et-Principe')
insert into REF_COUNTRY(NAME) values('Sénégal')
insert into REF_COUNTRY(NAME) values('Serbie')
insert into REF_COUNTRY(NAME) values('Seychelles')
insert into REF_COUNTRY(NAME) values('Sierra Leone')
insert into REF_COUNTRY(NAME) values('Singapour')
insert into REF_COUNTRY(NAME) values('Slovaquie')
insert into REF_COUNTRY(NAME) values('Slovénie')
insert into REF_COUNTRY(NAME) values('Somalie')
insert into REF_COUNTRY(NAME) values('Soudan')
insert into REF_COUNTRY(NAME) values('Sri Lanka')
insert into REF_COUNTRY(NAME) values('Suède')
insert into REF_COUNTRY(NAME) values('Suisse')
insert into REF_COUNTRY(NAME) values('Suriname')
insert into REF_COUNTRY(NAME) values('Swaziland')
insert into REF_COUNTRY(NAME) values('Syrie')
insert into REF_COUNTRY(NAME) values('Tadjikistan')
insert into REF_COUNTRY(NAME) values('Taïwan')
insert into REF_COUNTRY(NAME) values('Tanzanie')
insert into REF_COUNTRY(NAME) values('Tchad')
insert into REF_COUNTRY(NAME) values('Territoires Palestiniens')
insert into REF_COUNTRY(NAME) values('Thaïlande')
insert into REF_COUNTRY(NAME) values('Togo')
insert into REF_COUNTRY(NAME) values('Tokelau')
insert into REF_COUNTRY(NAME) values('Tonga')
insert into REF_COUNTRY(NAME) values('Trinité-et-Tobago')
insert into REF_COUNTRY(NAME) values('Tunisie')
insert into REF_COUNTRY(NAME) values('Turkménistan')
insert into REF_COUNTRY(NAME) values('Turquie')
insert into REF_COUNTRY(NAME) values('Tuvalu')
insert into REF_COUNTRY(NAME) values('Ukraine')
insert into REF_COUNTRY(NAME) values('Uruguay')
insert into REF_COUNTRY(NAME) values('Vanuatu')
insert into REF_COUNTRY(NAME) values('Vatican')
insert into REF_COUNTRY(NAME) values('Venezuela')
insert into REF_COUNTRY(NAME) values('Viêt Nam')
insert into REF_COUNTRY(NAME) values('Yémen')
insert into REF_COUNTRY(NAME) values('Yougoslavie')
insert into REF_COUNTRY(NAME) values('Zaïre voir Congo (la Rép. dém. du)')
insert into REF_COUNTRY(NAME) values('Zambie')
insert into REF_COUNTRY(NAME) values('Zanzibar')
insert into REF_COUNTRY(NAME) values('Zimbabwe')
insert into REF_COUNTRY(NAME) values('Crète')
insert into REF_COUNTRY(NAME) values('Iles des Canaries')

insert into REF_CONTRACT(NAME) values('Stage')
insert into REF_CONTRACT(NAME) values('CDD')
insert into REF_CONTRACT(NAME) values('CDI')

insert into REF_CANDIDATE_STATUS(NAME) values('En cours')
insert into REF_CANDIDATE_STATUS(NAME) values('Abandon')
insert into REF_CANDIDATE_STATUS(NAME) values('Ok')

insert into REF_SKILL_LEVEL(NAME) values('Vernis technique')
insert into REF_SKILL_LEVEL(NAME) values('Débutant')
insert into REF_SKILL_LEVEL(NAME) values('Opérationel')
insert into REF_SKILL_LEVEL(NAME) values('Expert')

insert into REF_TECHNICAL_DOMAIN(NAME) values('Langages')
insert into REF_TECHNICAL_DOMAIN(NAME, ID_TECHNICAL_DOMAIN_PARENT) values('Java', 1)
insert into REF_TECHNICAL_DOMAIN(NAME, ID_TECHNICAL_DOMAIN_PARENT) values('.NET', 1)
insert into REF_TECHNICAL_DOMAIN(NAME) values('DB')
insert into REF_TECHNICAL_DOMAIN(NAME, ID_TECHNICAL_DOMAIN_PARENT) values('Oracle', 4)
insert into REF_TECHNICAL_DOMAIN(NAME, ID_TECHNICAL_DOMAIN_PARENT) values('SQL Server', 4)
insert into REF_TECHNICAL_DOMAIN(NAME) values('OS')
insert into REF_TECHNICAL_DOMAIN(NAME, ID_TECHNICAL_DOMAIN_PARENT) values('Windows', 7)
insert into REF_TECHNICAL_DOMAIN(NAME, ID_TECHNICAL_DOMAIN_PARENT) values('Unix', 7)
insert into REF_TECHNICAL_DOMAIN(NAME, ID_TECHNICAL_DOMAIN_PARENT) values('Linux', 7)

insert into REF_BUSINESS_DOMAIN(NAME) values('Finance')
insert into REF_BUSINESS_DOMAIN(NAME, ID_BUSINESS_DOMAIN_PARENT) values('Banque', 1)
insert into REF_BUSINESS_DOMAIN(NAME, ID_BUSINESS_DOMAIN_PARENT) values('Salle de marché', 1)
insert into REF_BUSINESS_DOMAIN(NAME) values('Assurance')
insert into REF_BUSINESS_DOMAIN(NAME) values('Energie')
insert into REF_BUSINESS_DOMAIN(NAME, ID_BUSINESS_DOMAIN_PARENT) values('Transport', 5)
insert into REF_BUSINESS_DOMAIN(NAME, ID_BUSINESS_DOMAIN_PARENT) values('Train', 5)
insert into REF_BUSINESS_DOMAIN(NAME, ID_BUSINESS_DOMAIN_PARENT) values('Aéronautique', 5)
insert into REF_BUSINESS_DOMAIN(NAME, ID_BUSINESS_DOMAIN_PARENT) values('Marine', 5)

alter table T_HUMAN_RESOURCE
	alter column ID_COUNTRY int null
GO

INSERT INTO T_HUMAN_RESOURCE(FIRSTNAME, LASTNAME, ID_TITLE)  VALUES('Aria', 'Cruz', 2)
INSERT INTO T_HUMAN_RESOURCE(FIRSTNAME, LASTNAME, ID_TITLE)  VALUES('Ann', 'Devon', 2)
INSERT INTO T_HUMAN_RESOURCE(FIRSTNAME, LASTNAME, ID_TITLE)  VALUES('Annette', 'Roulet', 2)
INSERT INTO T_HUMAN_RESOURCE(FIRSTNAME, LASTNAME, ID_TITLE)  VALUES('Anabela', 'Domingues', 2)
INSERT INTO T_HUMAN_RESOURCE(FIRSTNAME, LASTNAME, ID_TITLE)  VALUES('Carlos', 'Hernadez', 1)
INSERT INTO T_HUMAN_RESOURCE(FIRSTNAME, LASTNAME, ID_TITLE)  VALUES('Carine', 'Schmitt', 2)
INSERT INTO T_HUMAN_RESOURCE(FIRSTNAME, LASTNAME, ID_TITLE)  VALUES('Daniel', 'Tonini', 1)
INSERT INTO T_HUMAN_RESOURCE(FIRSTNAME, LASTNAME, ID_TITLE)  VALUES('Diego', 'Roel', 1)
INSERT INTO T_HUMAN_RESOURCE(FIRSTNAME, LASTNAME, ID_TITLE)  VALUES('Elizabeth', 'Lincoln', 2)
INSERT INTO T_HUMAN_RESOURCE(FIRSTNAME, LASTNAME, ID_TITLE)  VALUES('Francisco', 'Chang', 1)
INSERT INTO T_HUMAN_RESOURCE(FIRSTNAME, LASTNAME, ID_TITLE)  VALUES('Gary', 'Thomas', 1)
INSERT INTO T_HUMAN_RESOURCE(FIRSTNAME, LASTNAME, ID_TITLE)  VALUES('Helvetius', 'Nagy', 1)
INSERT INTO T_HUMAN_RESOURCE(FIRSTNAME, LASTNAME, ID_TITLE)  VALUES('Howard', 'Snyder', 1)
INSERT INTO T_HUMAN_RESOURCE(FIRSTNAME, LASTNAME, ID_TITLE)  VALUES('Helen', 'Bennett', 2)
INSERT INTO T_HUMAN_RESOURCE(FIRSTNAME, LASTNAME, ID_TITLE)  VALUES('Janine', 'Labrune', 2)
INSERT INTO T_HUMAN_RESOURCE(FIRSTNAME, LASTNAME, ID_TITLE)  VALUES('Karin', 'Josephs', 2)
INSERT INTO T_HUMAN_RESOURCE(FIRSTNAME, LASTNAME, ID_TITLE)  VALUES('Karla', 'Jablonski', 2)
INSERT INTO T_HUMAN_RESOURCE(FIRSTNAME, LASTNAME, ID_TITLE)  VALUES('Laurence', 'Lebihan', 2)
INSERT INTO T_HUMAN_RESOURCE(FIRSTNAME, LASTNAME, ID_TITLE)  VALUES('Lesley', 'Brown', 1)
INSERT INTO T_HUMAN_RESOURCE(FIRSTNAME, LASTNAME, ID_TITLE)  VALUES('Miguel', 'Paolino', 1)
INSERT INTO T_HUMAN_RESOURCE(FIRSTNAME, LASTNAME, ID_TITLE)  VALUES('Margaret', 'Smith', 2)
INSERT INTO T_HUMAN_RESOURCE(FIRSTNAME, LASTNAME, ID_TITLE)  VALUES('Martin', 'Sommer', 1)
INSERT INTO T_HUMAN_RESOURCE(FIRSTNAME, LASTNAME, ID_TITLE)  VALUES('Matti', 'Karttunen', 1)
INSERT INTO T_HUMAN_RESOURCE(FIRSTNAME, LASTNAME, ID_TITLE)  VALUES('Maria', 'Pontes', 2)
INSERT INTO T_HUMAN_RESOURCE(FIRSTNAME, LASTNAME, ID_TITLE)  VALUES('Maria', 'Larsson', 2)
INSERT INTO T_HUMAN_RESOURCE(FIRSTNAME, LASTNAME, ID_TITLE)  VALUES('Mary', 'Saveley', 2)
INSERT INTO T_HUMAN_RESOURCE(FIRSTNAME, LASTNAME, ID_TITLE)  VALUES('Manuel', 'Pereira', 1)
INSERT INTO T_HUMAN_RESOURCE(FIRSTNAME, LASTNAME, ID_TITLE)  VALUES('Martine', 'Rance', 2)
INSERT INTO T_HUMAN_RESOURCE(FIRSTNAME, LASTNAME, ID_TITLE)  VALUES('Patricia', 'McKenna', 2)
INSERT INTO T_HUMAN_RESOURCE(FIRSTNAME, LASTNAME, ID_TITLE)  VALUES('Palle', 'Ibsen', 1)
INSERT INTO T_HUMAN_RESOURCE(FIRSTNAME, LASTNAME, ID_TITLE)  VALUES('Peter', 'Franken', 1)
INSERT INTO T_HUMAN_RESOURCE(FIRSTNAME, LASTNAME, ID_TITLE)  VALUES('Paolo', 'Accorti', 1)
INSERT INTO T_HUMAN_RESOURCE(FIRSTNAME, LASTNAME, ID_TITLE)  VALUES('Pirkko', 'Koskitalo', 1)
INSERT INTO T_HUMAN_RESOURCE(FIRSTNAME, LASTNAME, ID_TITLE)  VALUES('Pedro', 'Afonso', 1)
INSERT INTO T_HUMAN_RESOURCE(FIRSTNAME, LASTNAME, ID_TITLE)  VALUES('Paula', 'Parente', 2)
INSERT INTO T_HUMAN_RESOURCE(FIRSTNAME, LASTNAME, ID_TITLE)  VALUES('Philip', 'Cramer', 1)
INSERT INTO T_HUMAN_RESOURCE(FIRSTNAME, LASTNAME, ID_TITLE)  VALUES('Paul', 'Henriot', 1)
INSERT INTO T_HUMAN_RESOURCE(FIRSTNAME, LASTNAME, ID_TITLE)  VALUES('Rita', 'Muller', 2)
INSERT INTO T_HUMAN_RESOURCE(FIRSTNAME, LASTNAME, ID_TITLE)  VALUES('Roland', 'Mendel', 1)
INSERT INTO T_HUMAN_RESOURCE(FIRSTNAME, LASTNAME, ID_TITLE)  VALUES('Sven', 'Ottlieb', 1)
INSERT INTO T_HUMAN_RESOURCE(FIRSTNAME, LASTNAME, ID_TITLE)  VALUES('Timothy', 'O''Rourke', 1)
INSERT INTO T_HUMAN_RESOURCE(FIRSTNAME, LASTNAME, ID_TITLE)  VALUES('Victoria', 'Ashworth', 2)
INSERT INTO T_HUMAN_RESOURCE(FIRSTNAME, LASTNAME, ID_TITLE)  VALUES('Yoshi', 'Latimer', 2)

update T_HUMAN_RESOURCE set ID_COUNTRY=ID_HUMAN_RESOURCE

alter table T_HUMAN_RESOURCE
alter column ID_COUNTRY int not null
GO

alter table T_EMPLOYEE
	alter column LOGIN varchar(50) null
GO
alter table T_EMPLOYEE
	alter column START_DATE datetime null
GO
insert into T_EMPLOYEE(ID_EMPLOYEE, ID_CONTRACT) 
select ID_HUMAN_RESOURCE, 1+ID_HUMAN_RESOURCE%3 from T_HUMAN_RESOURCE where ID_HUMAN_RESOURCE %3=0

update e 
set 
	e.start_date=GETDATE(),
	end_date=
		case 
			when c.name='cdi' then null 
			else DATEADD(y, 1, getdate()) 
			
		end,
	e.LOGIN=LOWER(left(r.firstname, 1)+r.lastname)
from 
	t_employee e 
	inner join ref_contract c on e.id_contract=c.id_contract
	inner join t_human_resource r on e.id_employee=r.id_human_resource

alter table T_EMPLOYEE
	alter column LOGIN varchar(50) not null
GO
alter table T_EMPLOYEE
	alter column START_DATE datetime not null 
GO


insert into T_CANDIDATE(ID_CANDIDATE, ID_CANDIDATE_STATUS, ID_MANAGER) 
select ID_HUMAN_RESOURCE, 1+ID_HUMAN_RESOURCE%3, 0 from T_HUMAN_RESOURCE where ID_HUMAN_RESOURCE %3<>0

while((select COUNT(*) from t_candidate where id_manager=0)>0)
begin
	update c 
	set c.id_manager=xyz.id_employee
	from 
		t_candidate c inner join 
		(
		select id_candidate, id_employee from 
			(select id_candidate, row_number() over(order by id_candidate) as r1 from t_candidate where id_manager=0) c
			inner join
			(select id_employee, row_number() over(order by id_employee) as r2 from t_employee) e 
			on c.r1=e.r2
		) xyz on c.id_candidate=xyz.id_candidate
end
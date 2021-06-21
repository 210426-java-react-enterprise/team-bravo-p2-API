create table project_two.accounts (
	acct_id serial primary key,
	email varchar(255) unique not null,
	username varchar(50) unique not null,
	password varchar(50) not null
)

create table project_two.users (
	user_id int primary key references project_two.accounts,
	first_name varchar(50) not null,
	last_name varchar(50) not null,
	age int not null
)

create table project_two.collection_types (
	coll_type_id serial primary key,
	medium_type varchar(50) unique not null
)

create table project_two.movies (
	movie_id serial primary key,
	title varchar not null,
	year int not null,
	mpaa_rating varchar not null,
	length_min int not null,
	genre varchar not null,
	descrip varchar not null,
	prod_company varchar not null
)

create table project_two.directors (
	director_id serial primary key,
	first_name varchar(50) not null,
	last_name varchar(50) not null
)

create table project_two.actors (
	actor_id serial primary key,
	first_name varchar(50) not null,
	last_name varchar(50) not null
)

create table project_two.movie_actors (
	ma_key serial primary key,
	movie int not null,
	actor int not null,
	constraint fk_movie
		foreign key(movie)
			references project_two.movies(movie_id)
			on delete cascade,
	constraint fk_actor
		foreign key(actor)
			references project_two.actors(actor_id)
			on delete cascade
)

create table project_two.movie_directors (
	md_key serial primary key,
	movie int not null,
	director int not null,
	constraint fk_movie
		foreign key(movie)
			references project_two.movies(movie_id)
			on delete cascade,
	constraint fk_director
		foreign key(director)
			references project_two.directors(director_id)
			on delete cascade
)

create table project_two.collection_info (
	collection_info_id serial primary key,
	acct_id int not null,
	type_id int not null,
	coll_name varchar(75) not null,
	description varchar(255),
	constraint fk_account
		foreign key(acct_id)
			references project_two.accounts(acct_id)
			on delete cascade,
	constraint fk_coll_type
		foreign key(type_id)
			references project_two.collection_types(coll_type_id)
			on delete cascade
)

create table project_two.movie_collections (
	collection_id serial primary key,
	collection_info_id int not null,
	movie_id int not null,
	owned int not null,
	watched int not null,
	user_rating int,
	user_comment varchar(255),
	tradeable int,
	constraint fk_coll_info
		foreign key(collection_info_id)
			references project_two.collection_info(collection_info_id)
			on delete cascade,
	constraint fk_movie
		foreign key(movie_id)
			references project_two.movies(movie_id)
			on delete cascade
)









CREATE SCHEMA `springb_movieslibrary` DEFAULT CHARACTER SET utf8 ;

create table hibernate_sequence (next_val bigint) engine=MyISAM
insert into hibernate_sequence values ( 1 )
create table movie (id bigint not null, 
					box_office varchar(255), 
					director varchar(255), 
					genre varchar(255),
					imdb_id varchar(255),
					imdb_rating varchar(255),
					plot varchar(255),
					poster varchar(255),
					production varchar(255),
					release_date date, 
					response varchar(255),
					runtime varchar(255),
					title varchar(255),
					website varchar(255),
					is_movie_seen bit not null,
					primary key (id))
			engine=MyISAM

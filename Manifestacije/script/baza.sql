create database manifestacije;
use manifestacije;

drop table if exists grad;
drop table if exists manifestacija;

create table grad (
	ptt integer,
    naziv varchar(30) not null,
    primary key (ptt)
);

create table manifestacija (
	id integer auto_increment,
    nazivman varchar(50) not null,
    brpos integer,
    grad_ptt integer,
    primary key (id),
    foreign key (grad_ptt) references grad (ptt)
);

use ÆÚ¿¯Ô¤¶©ÏµÍ³
GO
create table Mgz_cont_Inf
(
Mgz_ID nvarchar(50),
Mgz_Name nvarchar(50) not null,
Yeartime int not null,
Reel_number nvarchar(50),
Mgz_Number nvarchar(50) not null,
Title_of_article nvarchar(50) not null,
Author_name nvarchar(50) not null,
Keywords nvarchar(50) not null,
Page_number nvarchar(50) not null,
primary key(Mgz_ID,Page_number),
foreign key(Mgz_ID) references Mgz_log_Inf(Mgz_ID)
);
GO

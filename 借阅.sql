use 期刊管理系统
GO
create table Mag_bor_Inf
(
UserID Nvarchar(50) ,
Mgz_ID Nvarchar(50)not null,
Mgz_name Nvarchar(50) not null,
Yeartime Int not null,
Reel_number Nvarchar(50),
Mgz_number Nvarchar(50) not null,
Borrowdate Datetime not null,
Returneddate Datetime,
Borrowstate  Nvarchar(50) CHECK(Borrowstate in('归还','借出')),
primary key(UserID,Mgz_ID),
foreign key(UserID) references User_Inf(UserID),
foreign key(Mgz_ID) references Mgz_log_Inf(Mgz_ID)
);
GO



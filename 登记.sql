use 期刊管理系统
GO
create table Mgz_log_Inf
(
Mgz_ID nvarchar(50) primary key,
Mgz_Name nvarchar(50) not null,
Yeartime int not null,
Reel_number nvarchar(50),
Mgz_Number nvarchar(50) not null,
RecordData nvarchar(50) not null,
Mgz_state nvarchar(50) CHECK(Mgz_state in('在馆','借出'))
);
GO
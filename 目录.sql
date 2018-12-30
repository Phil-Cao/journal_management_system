use 期刊管理系统
GO
create table Mgz_dir_Inf
(
Mgz_Name nvarchar(50) primary key,
CN_Number nvarchar(50) not null,
Yeartime int not null,
Mgz_Number nvarchar(50) not null,
ISSN_Number nvarchar(50) not null,
Mgz_PostNumber nvarchar(50) not null,
Mgz_Period nvarchar(50) not null,
Mgz_PublishingCity nvarchar(50) not null,
Host_unit nvarchar(50) not null,
M_count int not null
);
GO

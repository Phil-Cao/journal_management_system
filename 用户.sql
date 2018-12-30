use ÆÚ¿¯Ô¤¶©ÏµÍ³
GO
create table User_Inf
(
UserID nvarchar(50) primary key,
UserName nvarchar(50) not null,
User_Password nvarchar(50) not null,
User_number nvarchar(50) CHECK(User_number between 13000000000 and 18999999999),
User_mailbox nvarchar(50) not null,
Use_Borrownum int CHECK(Use_Borrownum<=5)
);
GO

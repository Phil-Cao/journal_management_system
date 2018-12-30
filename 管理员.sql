use ÆÚ¿¯Ô¤¶©ÏµÍ³
GO
create table M_inf
(
m_ID nvarchar(50) primary key,
m_Password nvarchar(50) not null,
m_number nvarchar(50) CHECK(m_number between 13000000000 and 18999999999),
m_mailbox nvarchar(50) not null,
);
GO
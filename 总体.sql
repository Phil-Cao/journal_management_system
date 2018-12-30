create database 期刊预订系统
on primary
(
name='期刊预订系统_data',
filename='I:\data\期刊预订系统.mdf',
size=10MB,
filegrowth=10%
)
log on
(name='期刊预订系统_log',
filename='I:\data\期刊预订系统.ldf',
size=10MB,
maxsize=100MB,
filegrowth=10%
)


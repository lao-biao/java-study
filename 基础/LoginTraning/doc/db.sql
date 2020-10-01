# 创建用户表
create table tb_training_user(
                                 username varchar(32) not null,
                                 password varchar(64) not null,
                                 primary key(username)
);

# 添加测试数据
insert into tb_training_user values("zhangsan","123");
insert into tb_training_user values("lisi","456");

# 查询数据
select * from tb_training_user;
create table oauth2.account_info
(
    id               int auto_increment comment '自增编号'
        primary key,
    username         varchar(16)                         not null comment '账户用户名',
    password         varchar(64)                         not null comment '账户密码',
    enabled          int(1)    default 1                 not null comment '账户是否启用',
    insert_time      timestamp default CURRENT_TIMESTAMP not null comment '入库时间',
    last_update_time timestamp default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '最近更新时间',
    constraint username_u_index
        unique (username)
)
    comment '客户端接入信息表';

INSERT INTO oauth2.account_info (id, username, password, enabled, insert_time, last_update_time)
VALUES (3, 'admin', '$2a$10$7iNTVQ.zbPmZqHgAQQcwv.z1t7NDkRBqZhq3Uyrcnawpe/UrD/la6', 1, '2019-10-17 06:12:18',
        '2019-10-17 07:31:39');
INSERT INTO oauth2.account_info (id, username, password, enabled, insert_time, last_update_time)
VALUES (4, 'test', '$2a$10$WevW/9CKtwSgZEuCB0UFleAjEllMZtpI9JfwQI8DNzx2Z7.2EbI2u', 1, '2019-10-17 06:12:18',
        '2019-10-17 07:31:39');
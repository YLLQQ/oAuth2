create table oauth2.account_info
(
    id                      int auto_increment comment '自增编号'
        primary key,
    username                varchar(16)                         not null comment '账户用户名',
    password                varchar(64)                         not null comment '账户密码',
    enabled                 int(1)    default 1                 not null comment '账户是否启用',
    account_non_expired     int(1)    default 1                 not null comment '账户是否过期',
    account_non_locked      int(1)    default 1                 not null comment '账户是否上锁',
    credentials_non_expired int(1)    default 1                 not null comment '凭证是否无有效期',
    insert_time             timestamp default CURRENT_TIMESTAMP not null comment '入库时间',
    last_update_time        timestamp default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '最近更新时间',
    constraint username_u_index
        unique (username)
)
    comment '账户接入信息表';

INSERT INTO oauth2.account_info (username, password)
VALUES ('admin', '$2a$10$7iNTVQ.zbPmZqHgAQQcwv.z1t7NDkRBqZhq3Uyrcnawpe/UrD/la6');
INSERT INTO oauth2.account_info (username, password)
VALUES ('test', '$2a$10$WevW/9CKtwSgZEuCB0UFleAjEllMZtpI9JfwQI8DNzx2Z7.2EbI2u');

create table oauth2.client_info
(
    id                             int auto_increment comment '自增编号'
        primary key,
    client_id                      varchar(16)                         not null comment '用于唯一标识每一个客户端(client)',
    client_secret                  varchar(64)                         not null comment '客户端密码',
    secret_required                int(1)    default 1                 not null comment '是否需要密码',
    scoped                         int(1)    default 1                 not null comment '是否限制范围',
    auto_approve                   int(1)    default 0                 not null comment '默认false,适用于authorization_code模式,设置用户是否自动approval操作,设置true跳过用户确认授权操作页面，直接跳到redirect_uri',
    access_token_validity_seconds  int       default 43200             not null comment '设置access_token的有效时间(秒),默认(60*60*12,12小时)',
    refresh_token_Validity_seconds int       default 2592000           not null comment '设置refresh_token有效期(秒)，默认(60*60*24*30, 30天)',
    resource_ids_unit              varchar(256)                        not null comment '不能为空，用逗号分隔。客户端能访问的资源id集合，注册客户端时，根据实际需要可选择资源id',
    scope_unit                     varchar(256)                        not null comment '不能为空，用逗号分隔。指定client的权限范围，比如读写权限，比如移动端还是web端权限',
    authorized_grant_types_unit    varchar(128)                        not null comment '不能为空，用逗号分隔。可选值 授权码模式:authorization_code,密码模式:password,刷新token: refresh_token, 隐式模式: implicit: 客户端模式: client_credentials。',
    registered_redirect_uri_unit   varchar(256)                        not null comment '客户端重定向uri，authorization_code和implicit需要该值进行校验，注册时填写',
    insert_time                    timestamp default CURRENT_TIMESTAMP not null comment '入库时间',
    last_update_time               timestamp default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '最近更新时间',
    constraint client_id_u_index
        unique (client_id)
)
    comment '客户端接入信息表';

INSERT INTO oauth2.client_info (client_id, client_secret, resource_ids_unit,
                                scope_unit, authorized_grant_types_unit, registered_redirect_uri_unit)
VALUES ('client', '$2a$10$AEoG8SZeVsx1lsP0UdEKv.yv7oAetYXDPXze3r5jxtn5SEGlGyaDm', 'oauth2-resource', 'All',
        'authorization_code,refresh_token', 'http://localhost:9999/login');
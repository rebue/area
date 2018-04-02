/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2018/4/2 14:55:41                            */
/*==============================================================*/


drop table if exists ARE_AREA;

/*==============================================================*/
/* Table: ARE_AREA                                              */
/*==============================================================*/
create table ARE_AREA
(
   ID                   bigint not null comment '区域ID',
   AREA_CODE            varchar(80) not null comment '区域编码',
   AREA_NAME            varchar(300) not null comment '区域名称',
   IS_DIS               bool not null default false comment '是否禁用',
   primary key (ID),
   unique key AK_AREA_CODE (AREA_CODE)
);

alter table ARE_AREA comment '区域信息';


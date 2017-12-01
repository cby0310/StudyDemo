# 新人指引
版本 | 修订时间 | 修订人 | 备注
------|------|------|------
@v1.0.0 | 2017-08-29 | 李映 |

##### WIFI
- Heyzhima-*
- 不带Guest的密码为：`Heyzhima666#@!`  带Guest的密码为：`Heyzhima8888`

##### 环境
- 服务器

    环境 | host |
    ------|------|
    开发(dev) | http://service.zhuolipu.com/V3 |
    测试(testing) | https://t-service.heyzhima.com/V3 | 
    预发布(release) | http://r-service.heyzhima.com/V3 |
    正式(online) | https://service.heyzhima.com/V3 |


##### 项目管理
- [gitlab](http://gitlab.zhuolipu.com/)
- [jira](http://jira.zhuolipu.com/)
- [开发文档](http://gitlab.zhuolipu.com/php/doc/tree/master)
- 产品原型 (\\fileshare\部门文件\产品)
- 测试用例 (\\fileshare\部门文件\技术部\测试用例)

##### 开发流程规范
- [gitlab管理流程](http://gitlab.zhuolipu.com/php/doc/blob/master/%E7%89%88%E6%9C%AC%E5%8F%91%E5%B8%83%E6%B5%81%E7%A8%8B%E8%A7%84%E8%8C%83.md)
- [ios开发规范](http://gitlab.zhuolipu.com/php/doc/blob/master/android/Android%E5%BC%80%E5%8F%91%E8%A7%84%E8%8C%83.md)
- [文档规范](http://gitlab.zhuolipu.com/php/doc/blob/master/%E6%96%87%E6%A1%A3%E8%A7%84%E8%8C%83.md)

##### 相关开发文档(接口使用swagger提供文档) [swagger-php](http://gitlab.zhuolipu.com/php/doc/tree/master/php/swagger)
- [数据字典](http://gitlab.zhuolipu.com/php/api.heyzhima.com/blob/master/Doc/.DB.md)
- [App API](http://doc.zhuolipu.com/php/swagger/dist/?url=http://doc.zhuolipu.com/php/api.v3.json)
- [设备 API](http://doc.zhuolipu.com/php/swagger/dist/?url=http://doc.zhuolipu.com/php/device.json)
- [租房 API](http://doc.zhuolipu.com/php/swagger/dist/?url=http://doc.zhuolipu.com/php/house.json)

##### Android相关项目简介

    项目名称 | 项目地址 
    -----|-----
    手机端APP
    嘿芝麻社区 | http://gitlab.zhuolipu.com/PhoneApp/HeyzhimaReconstruct
    嘿芝麻运维助手 | http://gitlab.zhuolipu.com/PhoneApp/heyzhimaYWZS 
    嘿芝麻物管后台 | http://gitlab.zhuolipu.com/PhoneApp/heyzhimaPM 
    嘿芝麻智警 | http://gitlab.zhuolipu.com/PhoneApp/heyzhimaPC
    门禁端
    V3F7 | http://gitlab.zhuolipu.com/AndroidDoorDevice/V3F7Reconstruct
    V4F7 | http://gitlab.zhuolipu.com/AndroidDoorDevice/heyzhimaV4F7
    V4F14 | http://gitlab.zhuolipu.com/AndroidDoorDevice/heyzhimaV4F14
    

##### 团队协作
- 明确目标： 
    1. 有相应的jira，需求明确;
    2. 开发资源到位(如需要设计资源的必须有设计稿才进入开发)
    3. 对接过程中相应的改动都必须备注（需求方）到jira上;
- 确认好Deadline
    1. 需求评估以上线时间为准，避免单纯评估开发时间忽略调试测试时间导致需求延期
- 评估风险
    1. 可能出现风险点及时提出及时沟通寻找解决方案
    2. 提测前先按照测试用例逐条验证，自测通过后再提测
    3. 在jira上备注好本次改动会涉及的影响范围，提醒测试重点测试点
- 信息沟通(讨论组+面对面+邮件周知)
    1. 需求开发沟通先拉讨论组(相关人员+PM)
    2. 紧急的需求面对面沟通，再把沟通结果发讨论组
    3. 重要事项确认后需发邮件周知

##### Android新人注意事项(逐步完善中)
- 项目统一使用 `Java` 开发,以模块化、组件化的方式开发
- 评估需求时间以实际上线时间为准，严格把控好上线时间，按时上线
- 需求按照jira排期，原则上无需求不开发。进入开发、开发提测都要及时修改相应状态
- 提测前必须先自测通过，提测后测试发现有明显功能不完整的直接打回开发，第二天重提测
- 版本发布前把release跟master合并的diff发到小组群里进行code revciew，组内成员审核过才可以打Tag发布
- 新功能/接口开发写文档 [文档规范](http://gitlab.zhuolipu.com/php/doc/blob/master/%E6%96%87%E6%A1%A3%E8%A7%84%E8%8C%83.md)

##### 其他
- 晨会：每天10点大会议室晨会，主要沟通昨天开发进度及遇到的问题
- 请假：请假流程走钉钉，请假前先发邮件周知@技术部@产品部，并备注好工作交接
- 调休：由于项目紧急周末加班可申请调休，平时晚上加班超过10点半下班第二天可以早上10点半到
- 绩效：每季度考核绩效，绩效跟公司调薪制度挂钩 [绩效考核](http://gitlab.zhuolipu.com/php/doc/blob/master/%E7%A0%94%E5%8F%91%E7%BB%A9%E6%95%88%E8%80%83%E6%A0%B8.md)
- 电脑账号相关问题找@李平处理，服务器相关问题找@谭群处理


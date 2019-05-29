# Spring Cloud Calculator

### 逻辑架构

* Server
  * cserver
* Service Provider
  * ccalculator
  * login
* Service Consumer
  * consumer



### 业务逻辑

1. Server搭建Eureka服务在http://localhost:5000
2. Service Provider 和 Service Consumer作为Eureka Client注册到http://localhost:5000, 端口号分别为5010和5020（但这不重要，只要和5000不一样就行）
3. Postman访问Consumer的controller，consumer通过DiscoveryClient（服务发现）从Server寻找到login和ccalculate服务并调用，然后返回给Postman

> > 怎么一个项目启动多个实例？请看[这里](<https://blog.csdn.net/ht_love_wy/article/details/78834823>)


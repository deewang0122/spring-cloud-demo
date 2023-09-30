# spring-cloud-demo

### 技术架构
~~~
SpringCloud2022.0.4 + SpringBoot3.1.3 + WebFlux + Gateway + Nacos + Redis + Mysql + Jdk17 + Maven + Docker
~~~

### 业务架构
~~~
 目的：完成基本业务架构设计：登录、基础权限管理、新服务接入基础功能开发
 目标：业务拿来即用的效果
~~~

### 本地环境预制

#### 安装Docker
~~~
1. 下载安装：https://www.docker.com/
2. 配置镜像：  
    "registry-mirrors": [
        "http://hub-mirror.c.163.com",
        "https://docker.mirrors.ustc.edu.cn",
        "https://registry.docker-cn.com"
    ]
~~~
#### 安装Mysql
~~~
1. 下载镜像：docker pull mysql
2. 安装运行：docker run -p 3306:3306 --name mysql -v G:/docker_data/mysql/conf/etc/mysql/conf.d -v G:/docker_data/mysql/logs/logs -v G:/docker_data/mysql/data/var/lib/mysql -e MYSQL_ROOT_PASSWORD=123456 -d mysql:latest --character-set-server=utf8mb4 --collation-server=utf8mb4_unicode_ci
~~~

#### 安装Redis
~~~
1. 下载镜像：docker pull redis
2. 安装运行：docker run -p 6379:6379 --name redis -v G:/docker_data/redis/redis.conf:/etc/redis/redis.conf -v G:/docker_data/redis/data:/data -d redis:latest redis-server /etc/redis/redis.conf --appendonly yes
~~~

#### 安装Nacos Server
~~~
1. 下载镜像：docker pull nacos/nacos-server
2. 安装运行：docker run -d --name nacos --env PREFER_HOST_MODE=hostname --env MODE=standalone -p 8848:8848 -p 9848:9848 -p 9849:9849 nacos/nacos-server:latest
~~~

#### Gateway
~~~
1. 通过gateway网关访问子应用
2. Gateway完成登录认证鉴权
~~~

#### Learning
~~~
1. Httpexchange异步方式调用其它服务-未完成
~~~

#### System
~~~
1. Nacos配置动态修改获取
2. Jpa自动填充创建人、修改人
3. Webflux模式下获取当前登录用户会话信息
4. 一次Http请求完成之后，ThreadLocal销毁当前会话信息-未完成
~~~

#### base-kit
~~~
1. 封装过滤器：Gateway、Filter
2. 封装Redis
3. 封装Context
4. 封装Jpa
5. 封装Login
6. 封装Mvc
7. 公共工具类
~~~
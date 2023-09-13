# spring-cloud-demo

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
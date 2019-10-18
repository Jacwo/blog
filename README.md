# blog
## 实现一个的博客后台服务开发
#### 技术栈
- spring
- dubbo
- mybatis
- docker
- zookeeper
- mysql 
- maven 
- redis
---------------------------
#### 实现功能：
- 注册登录
- 打赏功能
- 留言功能
- 项目功能
- 点赞功能
- 评论功能
- 写博客功能
- 浏览博客
---------------------------
#### 项目构建
* 安装docker环境 
* 在docker中获取zookeeper镜像、redis镜像、mysql镜像
* 启动zookeeper ```docker run --name zookeeper -it -p 2181:2181 -d zookeeper```
* 启动redis ```docker run -p 6379:6379 -d redis:latest redis-server```
* 启动mysql ```docker run -p 3306:3306 --name mysql -e MYSQL_ROOT_PASSWORD=123456 -d mysql```
* 下载后台项目 ```git clone https://github.com/Jacwo/blog.git``` 
* 启动 blog-service 
* 启动 controller 
* 下载前端项目 ```git clone https://github.com/Jacwo/blog-react.git```
* 启动前端项目 ```npm start```


#### 项目在线预览 http://118.31.9.84:3001



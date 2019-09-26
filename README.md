# spring boot 集成dubbo、nacos

## 编译
```
    mvn clean install
```
## nacos安装
```
    git clone https://github.com/alibaba/nacos.git
    cd nacos/
    mvn -Prelease-nacos clean install -U  
    ls -al distribution/target/
    
    // change the $version to your actual path
    cd distribution/target/nacos-server-$version/nacos/bin
    
    // 开启
    sh startup.sh -m standalone
    
    // 关闭
    sh shutdown.sh
```
## spring boot provider 启动

## spring boot consumer 启动

登录 http://localhost:8848/nacos/index.html  

初始账号、密码: nacos nacos

可以在服务列表中看到刚注册的服务

## 测试
### http测试
curl http://localhost:8081/user/http?name=yase
### dubbo测试 
curl http://localhost:8081/user/dubbo?name=yase
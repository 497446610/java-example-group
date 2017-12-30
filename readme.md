##项目说明
* panda-2c-business：商家管理后台项目，放有展示层静态页面、样式和js代码以及Java逻辑层代码。
* panda-2c-pbps：底层业务逻辑处理，本可由熊猫联采开发团队启动项目注册到zk，然后直接调用；但由于不在一起，因此采用模拟的方式。也即此处为了项目能跑起来并展现数据，所以需要实现里面的方法，并写死模拟数据。
* panda-2c-domain、panda-2c-generic：由熊猫联采开发团队提供mave依赖包，到时候配置在pom文件即可。


##项目部署

* 安装
    *  JDK1.8；
    *  Nginx（1.10以上）;
    *  zookeeper（3.3以上）；
*  Nginx配置：

```javascript
    # 修改conf目录下的nginx.cnf，在http内部增加对外部独立配置文件的引用：
    include nginx-test.conf;
```

```javascript
# 新建nginx-test.conf文件，贴一下内容：
server {
    ssi on;
    ssi_silent_errors on;
	listen       80;
	server_name  b.xiongmao1718.com;
	# 此处为静态文件配置地址
	location ~ .*\.(gif|jpg|jpeg|png|bmp|swf|css|js|html|eot|svg|ttf|woff|woff2|htm)$ {
		# 配置为静态文件存放地址，自行修改
		root D:/workspace/code/Java/panda/business/panda-2c-business/src/main/webapp/WEB-INF/html/panda;
		expires      30d;
	}

	# 此处为后台数据访问的配置地址，注意是以.data为结尾
	location ~ .*\.(data)$ {
		proxy_pass http://127.0.0.1:8080;
	}
}
```
* zookeeper直接使用默认配置即可
* 修改HOSTS配置，windows直接找到hosts文件（路径：C:\Windows\System32\drivers\etc\HOSTS），增加配置：

```javascript
    127.0.0.1 b.xiongmao1718.com
```

##运行
* 启动Nginx；
* 启动zookeeper;
* 启动panda-2c-pbps项目；
* 启动panda-2c-business项目；
* 访问：http://b.xiongmao1718.com/web/test/test.html
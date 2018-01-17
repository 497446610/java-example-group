工程说明：
	1、example-api：接口工程
	2、example-dao: dao工程，domain/mapper相关
	3、example-provider：业务服务工程
	4、example-consumer: web工程
依赖服务：
	1、mysql服务器
	2、zookeeper
	3、redis服务
配置方式：（使用中心化配置文件方式，mysql、redis等等相关配置信息全部存储在zookeeper中）
	1、在bootstrap.properties配置zookeeper相关的信息:
		#ZooKeeper的连接字符串，如果是集群，逗号分隔节点，格式：ip:port[,ip2:port2,.....]
		spring.cloud.zookeeper.connect-string=127.0.0.1:2181
		#指定zookeeper目录的根目录
		spring.cloud.zookeeper.config.root=config
		#启用zk的配置
		spring.cloud.zookeeper.config.enabled=true
		#定义了你的项目的名称，zk会在你指定的
		#根目录下寻找以这个项目名命名的目录下的配置
		spring.application.name=example
	2、在zookeeper中配置系统启动参数：
		在你指定zookeeper下的根目录，zk会在这个根目录下寻找跟你项目名称相同的文件夹，然后找到其下面的所有配置。
		例如指定的根目录config（即/config），项目名称叫example,（即/config/example），
		以配置数据库连接如下：		
		/config/example/spring/datasource/type这个key,type的值是com.alibaba.druid.pool.DruidDataSource
		参考：zookeeper配置文件.png
	
集成elasticsearch时，要注意spring boot和elasticsearch版本的兼容性，低版本的spring boot可能和高版本的elasticsearch不兼容。
spring boot 1.5.7 建议安装elasticsearch2.4.0版本的

1.项目结构

2.应用约定
	a.controller层规范：
		1.返回的对象为response或CommonRes
		2.在controller层做数据check
		3.
	b.service层定义接口方法规范：
		1.插入操作统一为add+类名
		2.更新操作统一为edit+类名或字段名
		3.查询操作统一为get+，如果是条件查询则为getBycondition,如果是根据某一字段查询则getBy字段（字段可以有多个）
		4.删除操作统一为deleteBy+id或条件
	c.dao层定义接口方法规范：
		1.插入操作统一为insert+类型
		2.更新操作统一为update+类名或字段名
		3.更新操作统一为find+，如果是条件查询则为findBycondition,如果是根据某一字段查询则findBy字段（字段可以有多个）
		4.删除操作统一为deleteBy+id或条件
		
3.数据库约定	
	a.主键名称为id
	b.使用其他表主键做外键时，名称为：f_类名+id
	c.表名：tb_类型

4.git
	a.做到每日一提

5.  

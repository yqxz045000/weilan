package com.cfyj.weilan.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cfyj.weilan.dao.UserAccountDao;
import com.cfyj.weilan.domain.CodeDict;
import com.cfyj.weilan.domain.CommonRes;
import com.cfyj.weilan.domain.UserView;
import com.cfyj.weilan.entity.User;
import com.cfyj.weilan.entity.UserInfoSummary;
import com.cfyj.weilan.service.UserAccountService;
import com.cfyj.weilan.service.UserInfoService;
import com.cfyj.weilan.service.UserInfoSummaryService;
import com.cfyj.weilan.utils.BaseLogUtil;
import com.cfyj.weilan.utils.MD5Util;
import com.cfyj.weilan.utils.UserIdUtils;

@Service
public class UserAccountServiceImpl extends BaseLogUtil implements UserAccountService {
	
	@Autowired
	private UserAccountDao userAccountDao;
	
	@Autowired
	private UserInfoService userInfoService;
	
	@Autowired
	private UserInfoSummaryService userInfoSummaryService;

	private int generatorId_num = 5;

	@Override
	@Transactional
	public CommonRes<User> addUserAccount(User account) {
		CommonRes<User> res  = new CommonRes<User>(CodeDict.FAIL);
		//生成id的算法
		int num ;
		int id = 0 ;
		if(getByAccount(account.getUserAccount())!=null) {
			res.setMsg("账户名已存在");
			return res;
		}
		
		for(int i=0;i<generatorId_num;i++) {
			id = UserIdUtils.generatorUserId();
			if(userAccountDao.findNumById(id)==0) {
				break;
			}
		}
		log.info("为注册用户["+account.getUserAccount()+"]生成随机id["+id+"]");
		account.setId(id);
		String passwd = MD5Util.MD5(account.getPasswd());
		account.setPasswd(passwd);
		account.setOldPasswd(passwd);
//		account.setLevel(UserConstant.USERLEVEL_1);
		
		try {
			num = userAccountDao.insertUserAccount(account);	
			
			UserInfoSummary summary = new UserInfoSummary();
			summary.setUserId(id);
			userInfoSummaryService.addUserInfoSummary(summary);
		} catch (DuplicateKeyException e) {
			id = new Integer(UserIdUtils.generatorUserId()+"1");
			log.error("账户["+account.getUserAccount()+"]生成的id["+account.getId()+"]已存在,重新生成id["+id+"]");
			account.setId(id);
			num = userAccountDao.insertUserAccount(account);	
		}
		if(num>0) {
			if(!userInfoService.addUser(account)) {
				throw new RuntimeException("生成用户信息失败，账户："+account);	
			}
		}	
		res.setCodeDict(CodeDict.SUCCESS);
		res.setData(account);
		return res;
	}


	@Override
	public boolean checkPasswd(String password,String passwordDB) {		
		return passwordDB.equalsIgnoreCase(MD5Util.MD5(password));
	}


	@Override
	public User Login(User user) {
		User dbUser = null;
		if(user!=null && StringUtils.isNotBlank(user.getUserAccount()) &&  StringUtils.isNotBlank(user.getPasswd())) {	
			dbUser = getByAccount(user.getUserAccount());
			boolean flag = dbUser!=null?checkPasswd(user.getPasswd(),dbUser.getPasswd()) : false;
			if(flag) {
				//成功
				dbUser.setPasswd("");
				dbUser.setOldPasswd("");
				return dbUser;
			}
		}		
		return dbUser;
	}

	/**
	 * 获取user所有信息
	 */
	@Override
	public User getByAccount(String account) {
		return userAccountDao.findByAccount(account);
	}


	@Override
	public User getByUserId(int id) {	
		return userAccountDao.findByUserId(id);
	}


	@Override
	public UserView initUser(User user) {
		/**
		 * 登录成功进行帐号的数据初始化
		 */
		return null;
	}


}

package com.cfyj.weilan.task;

import java.sql.Timestamp;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.cfyj.weilan.dao.UserAccountDao;
import com.cfyj.weilan.service.UserInfoSummaryService;
import com.cfyj.weilan.utils.DateUtil;

/**
 * 
 * 按用户最后的登录时间对其进行分段统计
 * 
 * 
 * @author cfyj
 *2017年12月23日 下午3:06:07
 *
 */
@Component
public class UserInfoSummaryTask {
	
	private Logger log = LoggerFactory.getLogger(UserInfoSummaryTask.class);
	
	@Autowired
	private UserInfoSummaryService userInfoSummaryService;
	
	@Autowired
	private UserAccountDao userAccountDao;
	
	@Scheduled(cron = "40 * * * * ?")//0 0 3 * * ?
	public void  summary() {
		long yesterdayTime = DateUtil.yesterdayTime();
		/**
		 * 先查一下前一天的登录用户数量，如果大于分段初始值，则进行分段统计  :放弃，在sql层面无法实现
		 * select count(*) from tb_userAccount where lastLoginTime between #{lasttime} and now()
			select uc.id,
				(select sum(userId) from tb_longmessage where userId = uc.id) as longnum,
				(select sum(userId) from tb_shortmessage where userId = uc.id) as shortnum,
				(select sum(userId) from tb_category where userId = uc.id) as categorynum,
				(select sum(userId) from tb_feedback where userId = uc.id) as feedbacknum,
				(select sum(userId) from tb_annoyancewall where userId = uc.id) as wallnum
				
				from tb_useraccount  uc  where lastLoginTime between #{lasttime} and now() limit #{begin},#{end}
		 */
		
		log.info("执行定时任务：汇总用户信息");
		List<Integer> userIds= userAccountDao.findByLasttime(new Timestamp(yesterdayTime));
		for(Integer userId:userIds) {
			userInfoSummaryService.sumUserInfoSummary(userId);
			
		}
		
	}
	

	
}

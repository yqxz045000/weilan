package com.cfyj.weilan.task;

import java.sql.Timestamp;

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
	
	@Autowired
	private UserInfoSummaryService userInfoSummaryService;
	
	@Autowired
	private UserAccountDao userAccountDao;
	
	private final int ONE_THOUSAND = 1000;
	private final int TWO_THOUSAND = 2000;
	private final int FIVE_THOUSAND = 5000;
	private final int SEVEN_THOUSAND = 7000;
	private final int TEN_THOUSAND = 10000;
	
	

	@Scheduled(cron = "0 0 3 * * ? ")
	public void  summary() {
		long yesterdayTime = DateUtil.yesterdayTime();
		/**
		 * 先查一下前一天的登录用户数量，如果大于分段初始值，则进行分段统计
		 * select uc.id,sum(short.userId) from tb_useraccount  uc  left join tb_shortmessage short on short.userId = uc.id   where uc.id = 1;
select uc.id,sum(l.userId) from tb_useraccount  uc  left join tb_longmessage l on l.userId = uc.id   where uc.id = 1
		 */
		
		
		int num = userAccountDao.findByLasttime(new Timestamp(yesterdayTime));
		if(num<TWO_THOUSAND) {
			
		}else if(num<FIVE_THOUSAND) {
			
		}else if(num<SEVEN_THOUSAND) {
			
		}else if(num<TEN_THOUSAND) {
			
		}
		
		
		
		
		
		
		
		
		
	}
}

package com.cfyj.weilan.config;

import java.io.IOException;
import java.util.Iterator;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import com.alibaba.fastjson.JSON;
import com.cfyj.weilan.constant.URLConstant;
import com.cfyj.weilan.domain.CodeDict;
import com.cfyj.weilan.domain.Response;
import com.cfyj.weilan.utils.IPUtils;

/**
 * 
 * 对ip进行拦截：对于限定操作进行ip限时操作
 * 
 * @author cfyj 2017年12月13日 下午5:57:15
 *
 */
// @WebFilter
// @Order(2)
public class IpFilter implements Filter {

	private Logger log = LoggerFactory.getLogger(IpFilter.class);

	@Autowired
	private IpCacheClient ipCacheClient;

	// TODO这个值没设置，从DB取或者从配置文件中取，最好做到能动态设置
	@Value("restrictionNum")
	private int restrictionNum = 10;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

		log.info("IpFilter启动----------------");
	}

	@SuppressWarnings("finally")
	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		// TODO
		/**
		 * 判断请求是否为限时访问接口，是则从缓存中取出对应ip的操作次数，如果次数小于某个值则允许访问，并加次数加1，如果不存在则存入缓存中并
		 * 设置一个过期时间，如果操作次数大于限定值，则直接返回。
		 */
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		String requestURI = request.getRequestURI();

		if (isRestriction(requestURI)) {
			String ip = IPUtils.getIpAddr(request);
			// 查缓存，判断，存缓存，然后放行或限制访问.
			int num = ipCacheClient.getIpCache(ip);
			if (restrictionNum < num) {
				ServletOutputStream outputStream = null;
				try {
					// ip限时，直接返回错误码
					outputStream = response.getOutputStream();
					Response resp = new Response(CodeDict.OperationRes);
					outputStream.write(JSON.toJSONString(resp).getBytes());
					outputStream.flush();
				} catch (Exception e) {
					log.error("未通过ip过滤，返回异常", e);
				} finally {
					if (outputStream != null) {
						outputStream.close();
					}
					return;
				}
			}
			log.info("IpFilter--访问路径:{},用户ip:{},当前访问次数：{}",requestURI,ip,num);
		}
		// 不是限时访问接口，直接访问
		chain.doFilter(request, response);

	}

	public boolean isRestriction(String requestURI) {
		Iterator<String> iterator = URLConstant.Restriction_filter_userUrl.iterator();
		boolean flag = false;
		while (iterator.hasNext()) {
			flag = iterator.next().equals(requestURI);
			if (flag) {
				return true;
			}
		}

		return flag;
	}

	@Override
	public void destroy() {
		log.info("IpFilter销毁----------------");

	}

}

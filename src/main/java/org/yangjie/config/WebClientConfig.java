package org.yangjie.config;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.yangjie.service.UserService;

/**
 * cxf客户端配置
 * @author YangJie [2017年2月14日 下午5:35:05]
 */
@Configuration
public class WebClientConfig {

	// 创建客户端代理类
	private JaxWsProxyFactoryBean clientFactory = new JaxWsProxyFactoryBean();
	
	@SuppressWarnings("unchecked")
	private final <T> T buildClient(Class<T> clazz, String address) {
		clientFactory.setServiceClass(clazz);
		clientFactory.setAddress(address);
		return (T) clientFactory.create();
	}
	
	
	@Bean // 创建soap接口服务
	public UserService userService(){
		return buildClient(UserService.class, "http://localhost:8080/ws/userService");
	}

}

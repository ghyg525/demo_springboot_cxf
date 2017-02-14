package org.yangjie.config;

import javax.xml.ws.Endpoint;

import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.yangjie.service.UserService;

/**
 * cxf服务端配置
 * @author YangJie [2017年2月14日 下午5:35:13]
 */
@Configuration
public class WebServiceConfig {

	@Bean // 初始化cxf的servlet
	public ServletRegistrationBean servletRegistrationBean() {
		return new ServletRegistrationBean(new CXFServlet(), "/ws/*");
	}

	@Bean(name = Bus.DEFAULT_BUS_ID)
	public SpringBus springBus() {
		return new SpringBus();
	}

	@Bean // 发布soap接口
	public Endpoint userServiceEndpoint(UserService userService) {
		return Endpoint.publish("/userService", userService);
	}

}

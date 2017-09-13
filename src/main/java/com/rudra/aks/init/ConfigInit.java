package com.rudra.aks.init;

import org.springframework.session.web.context.AbstractHttpSessionApplicationInitializer;

public class ConfigInit extends AbstractHttpSessionApplicationInitializer {
	
	public ConfigInit() {
		super(DBConfig.class);
	}
}

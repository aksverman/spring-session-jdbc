/*
 * Copyright 2014-2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.rudra.aks.init;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.h2.server.web.WebServlet;
import org.springframework.web.WebApplicationInitializer;

public class H2ConsoleInitializer implements WebApplicationInitializer {

	public void onStartup(ServletContext servletContext) throws ServletException {
		servletContext.addServlet("h2Console", new WebServlet()).addMapping("/h2-console/*");
	}

}

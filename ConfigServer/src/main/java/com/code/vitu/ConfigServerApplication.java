package com.code.vitu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@EnableConfigServer
public class ConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigServerApplication.class, args);
	}

	/*@Author Vithal
	 * for implementing externalization configuration we need config server 1:create
	 * one spring boot project as name config server. 2:add config server dependancy
	 * and eureka client 3:in main application add two
	 * annotation @EnableEurekaClient
	 * 
	 * @EnableConfigServer 4:add some properties in apllication.yml file spring:
	 * cloud: config: server: git: uri:
	 * https://github.com/vithaln/microservice-config clone-on-start: true
	 * 
	 * 5:go to the client services like user-service add one property like
	 * spring.config.import: optional.configserver.http://localhost:8085 (config
	 * server url) and comment common thing that need to be update in github
	 * repository
	 * 
	 */
}

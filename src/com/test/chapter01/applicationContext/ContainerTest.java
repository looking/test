package com.test.chapter01.applicationContext;

import java.io.File;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
/**
 * IOC容器的实现
 * */
public class ContainerTest {
	/**
	 * beanfactory实现，从文件系统中获取资源
	 */
	@Test
	public void beanFactoryBaseonFileSystem(){
		//从文件系统中获取配置文件，默认为相对路径，也可以取绝对路径
		File file=new File("bin/resource/chapter01.xml");
		Resource resource=new FileSystemResource(file);
		//初始化容器
		BeanFactory bean=new XmlBeanFactory(resource);
		//从容器中获取bean
		GreetServiceImp service=bean.getBean("greetservice", GreetServiceImp.class);
		//执行操作
		service.sayGreeting();
	}
	/**
	 * beanfactory实现，从classpath获取资源
	 */
	@Test
	public void beanFactoryBaseOnClassPath(){
		//准备配置文件，从当前类加载路径中获取配置文件
		Resource resource=new ClassPathResource("resource/chapter01.xml");
		//初始化容器
		BeanFactory bean=new XmlBeanFactory(resource);
		//从容器中获取bean
		GreetServiceImp service=bean.getBean("greetservice", GreetServiceImp.class);
		//执行操作
		service.sayGreeting();
	}
	/**
	 * ApplicationContext实现，从文件系统中获取资源
	 */
	@Test
	public void applicationContextBaseOnFileSystem(){
		//准备配置文件，从文件系统中获取配置文件，默认为相当路径，也可以写绝对路径
		BeanFactory bean=new FileSystemXmlApplicationContext("bin/resource/chapter01.xml");
		//从容器中获取bean
		GreetServiceImp service=bean.getBean("greetservice", GreetServiceImp.class);
		//执行操作
		service.sayGreeting();
	}
	
	/**
	 * ApplicationContext实现，从ClassPath中获取资源
	 */
	@Test
	public void applicationContextBaseOnClassPath(){
		//准备配置文件，从当前类加载路径中获取配置文件
		BeanFactory bean=new ClassPathXmlApplicationContext("resource/chapter01.xml");
		//从容器中获取bean
		GreetServiceImp service=bean.getBean("greetservice",GreetServiceImp.class);
		//执行操作
		service.sayGreeting();
	}
}

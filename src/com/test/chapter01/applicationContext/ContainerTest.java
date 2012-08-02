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
 * IOC������ʵ��
 * */
public class ContainerTest {
	/**
	 * beanfactoryʵ�֣����ļ�ϵͳ�л�ȡ��Դ
	 */
	@Test
	public void beanFactoryBaseonFileSystem(){
		//���ļ�ϵͳ�л�ȡ�����ļ���Ĭ��Ϊ���·����Ҳ����ȡ����·��
		File file=new File("bin/resource/chapter01.xml");
		Resource resource=new FileSystemResource(file);
		//��ʼ������
		BeanFactory bean=new XmlBeanFactory(resource);
		//�������л�ȡbean
		GreetServiceImp service=bean.getBean("greetservice", GreetServiceImp.class);
		//ִ�в���
		service.sayGreeting();
	}
	/**
	 * beanfactoryʵ�֣���classpath��ȡ��Դ
	 */
	@Test
	public void beanFactoryBaseOnClassPath(){
		//׼�������ļ����ӵ�ǰ�����·���л�ȡ�����ļ�
		Resource resource=new ClassPathResource("resource/chapter01.xml");
		//��ʼ������
		BeanFactory bean=new XmlBeanFactory(resource);
		//�������л�ȡbean
		GreetServiceImp service=bean.getBean("greetservice", GreetServiceImp.class);
		//ִ�в���
		service.sayGreeting();
	}
	/**
	 * ApplicationContextʵ�֣����ļ�ϵͳ�л�ȡ��Դ
	 */ 
	@Test
	public void applicationContextBaseOnFileSystem(){
		//׼�������ļ������ļ�ϵͳ�л�ȡ�����ļ���Ĭ��Ϊ�൱·����Ҳ����д����·��
		BeanFactory bean=new FileSystemXmlApplicationContext("bin/resource/chapter01.xml");
		//�������л�ȡbean
		GreetServiceImp service=bean.getBean("greetservice", GreetServiceImp.class);
		//ִ�в���
		service.sayGreeting();
	}
	
	/**
	 * ApplicationContextʵ�֣���ClassPath�л�ȡ��Դ
	 */
	@Test
	public void applicationContextBaseOnClassPath(){
		//׼�������ļ����ӵ�ǰ�����·���л�ȡ�����ļ�
		BeanFactory bean=new ClassPathXmlApplicationContext("resource/chapter01.xml");
		//�������л�ȡbean
		GreetServiceImp service=bean.getBean("greetservice",GreetServiceImp.class);
		//ִ�в���
		service.sayGreeting();
	}
}

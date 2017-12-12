/**   
* @Title: SpringContextUtil.java 
* @Package com.xaxb.utils 
* @Description: TODO(用一句话描述该文件做什么) 
* @author enqiu.jia  
* @date 2017年9月25日 下午5:43:38 
* @version V1.0   
*/
package com.web.emailOS.util;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;

/** 
* @ClassName: SpringContextUtil 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author jiaenqiu 
* @date 2017年9月25日 下午5:43:38 
*  
*/

public class Springfactory implements BeanFactoryAware {

	private static BeanFactory beanFactory;

	// private static ApplicationContext context;

	@SuppressWarnings("static-access")
	public void setBeanFactory(BeanFactory factory) throws BeansException {
		this.beanFactory = factory;
	}

	/**
	 * 根据beanName名字取得bean
	 * 
	 * @param beanName
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> T getBean(String beanName) {
		if (null != beanFactory) {
			return (T) beanFactory.getBean(beanName);
		}
		return null;
	}

}
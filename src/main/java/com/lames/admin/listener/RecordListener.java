package com.lames.admin.listener;

import com.lames.admin.dao.IMerchantDetailDAO;
import com.lames.admin.dao.impl.MerchantDetailDAOimpl;
import com.lames.admin.model.MerchantDetail;
import com.lames.admin.util.JMSUtil;
import com.lames.admin.util.JsonUtil;

import javax.jms.*;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class RecordListener implements ServletContextListener {

	private IMerchantDetailDAO dao = new MerchantDetailDAOimpl();
   
	public void contextDestroyed(ServletContextEvent sce) {
		
	}

	public void contextInitialized(ServletContextEvent sce) {
		 try {
	            System.out.println("init login record");
	            MessageConsumer consumer = JMSUtil.getConsumer();
	            consumer.setMessageListener(new MessageListener() {
					public void onMessage(Message message) {
							try {
		                        System.out.println(((TextMessage)message).getText());
		                        dao.insert((MerchantDetail)JsonUtil.jsonToObject(((TextMessage)message).getText(), MerchantDetail.class));
		                    } catch (JMSException e) {
		                        e.printStackTrace();
		                    }
			            }
					});
	        } catch (JMSException e) {
	            e.printStackTrace();
	        }
		
	}
	
}

//package com.lames.admin.listener;
//
//import com.lames.admin.dao.IMerchantDetailDAO;
//import com.lames.admin.dao.impl.MerchantDetailDAOimpl;
//import com.lames.admin.model.MerchantDetail;
//import com.lames.admin.service.IMerchantDetailService;
//import com.lames.admin.service.impl.MerchantDetailServiceimpl;
//import com.lames.admin.util.JMSUtil;
//import com.lames.admin.util.JsonUtil;
//
//import javax.jms.*;
//import javax.servlet.ServletContextEvent;
//import javax.servlet.ServletContextListener;
//import javax.servlet.annotation.WebListener;
//
//@WebListener
//public class MerchantDetailListener implements ServletContextListener {
//
//	private IMerchantDetailService service = new MerchantDetailServiceimpl();
//   
//	public void contextDestroyed(ServletContextEvent sce) {
//		JMSUtil.close();
//	}
//
//	public void contextInitialized(ServletContextEvent sce) {
//		 try {
//			 	final Session session = JMSUtil.getSession();
//			 	Queue queue = session.createQueue("merchantDetail");
//	            MessageConsumer consumer = session.createConsumer(queue);
//	            consumer.setMessageListener(new MessageListener() {
//					public void onMessage(Message message) {
//							try {
//		                        System.out.println(((TextMessage)message).getText());
//		                        service.insert((MerchantDetail)JsonUtil.jsonToObject(((TextMessage)message).getText(), MerchantDetail.class));
//		                        session.commit();
//		                    } catch (JMSException e) {
//		                        e.printStackTrace();
//		                    }
//			            }
//					});
//	        } catch (JMSException e) {
//	            e.printStackTrace();
//	        }
//		
//	}
//	
//}

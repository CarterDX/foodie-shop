package net.seehope.foodie.controller.async;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class QueueListener implements ApplicationListener<ContextRefreshedEvent> {

	private static final Logger log = LoggerFactory.getLogger(QueueListener.class);

	@Autowired
	private MockQueue queue;

	@Autowired
	private DeferredResultHolder holder;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		new Thread(() -> {
			while (true) {
				if (StringUtils.isNotEmpty(queue.getCompleteOrder())) {
					String orderId = queue.getCompleteOrder();
					log.info("监听器获取到队列中的返回结果，订单号为{}--", orderId);
					holder.getMap().get(orderId).setResult(orderId);
					queue.setCompleteOrder(null);
				} else {
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

			}
		}).start();

	}

}

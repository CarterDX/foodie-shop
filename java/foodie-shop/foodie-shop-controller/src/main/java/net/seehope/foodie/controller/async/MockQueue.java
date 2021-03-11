package net.seehope.foodie.controller.async;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 伪造的队列
 * 
 * @author Monty
 *
 */
@Component
public class MockQueue {

	private static final Logger log = LoggerFactory.getLogger(MockQueue.class);

	/**
	 * 存放订单号的区域 由应用二一直监听（轮询）如果里面有值 代表有订单等待处理
	 */
	private String placeOrder;
	/**
	 * 由应用1一直监听，如果变量有值，代表订单已经完成，需要将结果返回给前端 返回结果的区域
	 */
	private String completeOrder;

	public void setPlaceOrder(String placeOrder) {

		new Thread(() -> {
			log.info("接收到了下单请求中的订单号应用2开始处理订单");

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			this.completeOrder = placeOrder;
			log.info("应用2订单处理完毕 订单号为" + placeOrder);
		}).start();

	}

	public String getPlaceOrder() {
		return placeOrder;
	}

	public String getCompleteOrder() {
		return completeOrder;
	}

	public void setCompleteOrder(String completeOrder) {
		this.completeOrder = completeOrder;
	}

}

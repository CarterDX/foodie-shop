package net.seehope.foodie.controller;

import java.util.concurrent.Callable;

import org.n3r.idworker.Sid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import net.seehope.foodie.controller.async.DeferredResultHolder;
import net.seehope.foodie.controller.async.MockQueue;

@RestController
@RequestMapping("/async")
public class AsyncController {

	@Autowired
	private Sid sid;

	@Autowired
	private MockQueue mockQueue;

	@Autowired
	private DeferredResultHolder deferredResultHolder;

	private static final Logger log = LoggerFactory.getLogger(AsyncController.class);

	@GetMapping("/{orderId}")
	public DeferredResult<String> getOrder(@PathVariable String orderId) {
		log.info("------主线程开始-------");

		String orderString = sid.nextShort();
		mockQueue.setPlaceOrder(orderString);

		DeferredResult<String> result = new DeferredResult<String>();
		deferredResultHolder.getMap().put(orderString, result);

		/*
		 * Callable<String> result = new Callable<String>() {
		 * 
		 * @Override public String call() throws Exception { log.info("副线程开启");
		 * 
		 * Thread.sleep(1000);
		 * 
		 * log.info("副线程结束");
		 * 
		 * return "success :" + sid.nextShort(); }
		 * 
		 * };
		 */

		log.info("------主线程结束-------");
		return result;
	}
}

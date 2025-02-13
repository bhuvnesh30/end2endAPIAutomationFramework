package com.api.listeners;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {
	private static final Logger logger = LogManager.getLogger(TestListener.class);

	@Override
	public void onStart(ITestContext context) {
		logger.info("Test Suite started: " + context.getName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		logger.info("Test passed: " + result.getName());
	}

	@Override
	public void onTestFailure(ITestResult result) {
		logger.fatal("Test failed: " + result.getMethod().getMethodName());
		logger.info("Description: " + result.getMethod().getDescription());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		logger.info("Test skipped: " + result.getMethod().getMethodName());
		logger.info("Description: " + result.getMethod().getDescription());
	}

	@Override
	public void onFinish(ITestContext context) {
		logger.info("Test Suite is ending: " + context.getName());
	}

	@Override
	public void onTestStart(ITestResult result) {
		logger.info("Test started: " + result.getMethod().getMethodName());
		logger.info("Description: " + result.getMethod().getDescription());
	}
}

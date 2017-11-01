package com.zzg.mybatis.generator.util;

import org.mybatis.generator.api.ProgressCallback;

public class TestProgressCallback implements ProgressCallback{

	@Override
	public void introspectionStarted(int totalTasks) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void generationStarted(int totalTasks) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveStarted(int totalTasks) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void startTask(String taskName) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void done() {
		System.out.println("generate success");
		
	}

	@Override
	public void checkCancel() throws InterruptedException {
		// TODO Auto-generated method stub
		
	}

}

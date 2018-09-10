package com.lyl.common.utils.util;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FileScanner implements Serializable {

	private static final long serialVersionUID = -278273088085485815L;
	
	private ExecutorService service;
	
	private String findName;
	
	private List<File> findFiles;
	
	public FileScanner(String findName) {
		this.findName = findName;
	}
	
	public void start() {
		service = Executors.newFixedThreadPool(200);
		findFiles = new ArrayList<>();
		for (final File dir : File.listRoots()) {
			service.execute(new Runnable() {
				@Override
				public void run() {
					eachFiles(dir);
				}
			});
		}
	}
	
	public void eachFiles(File dir) {
		if (dir == null || !dir.exists() || !dir.isDirectory()) {
			return;
		}
		File[] files = dir.listFiles();
		if (files == null) 
			return;
		try {
			for (final File file : files) {
				String name = file.getName();
				if (name.contains(findName)) {
					synchronized (name) {
						findFiles.add(file);
					}
					System.out.println(file);
				}
				if(file.isDirectory()) {
					service.execute(new Runnable() {
						@Override
						public void run() {
							eachFiles(file);
						}
					});
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<File> getFiles() {
		return findFiles;
	}
	
	public static void main(String[] args) {
		FileScanner fs = new FileScanner("AAW.bmp");
		fs.start();
		while(Thread.activeCount() > 1) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(fs.getFiles());
	}
	
}

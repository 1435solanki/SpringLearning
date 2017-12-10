package com.spring.demo.springDemo.service;

import java.util.List;

public class dataBuilder {

	private InfoData infoData;

	public static class InfoData {
		List<Entity> info;

		public List<Entity> getInfo() {
			return info;
		}

		public void setInfo(List<Entity> info) {
			this.info = info;
		}

	}

	public InfoData getInfoData() {
		return infoData;
	}

	public void setInfoData(InfoData infoData) {
		this.infoData = infoData;
	}

	@Override
	public String toString() {
		return "dataBuilder [infoData=" + infoData + "]";
	}
}

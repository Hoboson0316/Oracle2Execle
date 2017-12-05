package com.xetlab.jxlexcel;

public class sql2excleVo {

	private String dzzhuuid;
	private String lng;
	private String lat;
	private String address;
	private String nsrid;
	private String czsj;
	private String yxbz;
	private String status;
	private String precise;
	private String confidence;
	private String lev;
	private String city;
	private String insertdate;
	private String address_1;
	private String zgswj_dm;
	
	
	
	public sql2excleVo(String dzzhuuid, String lng, String lat, String address, String nsrid, String czsj, String yxbz,
			String status, String precise, String confidence, String lev, String city, String insertdate,
			String address_1, String zgswj_dm) {
		super();
		this.dzzhuuid = dzzhuuid;
		this.lng = lng;
		this.lat = lat;
		this.address = address;
		this.nsrid = nsrid;
		this.czsj = czsj;
		this.yxbz = yxbz;
		this.status = status;
		this.precise = precise;
		this.confidence = confidence;
		this.lev = lev;
		this.city = city;
		this.insertdate = insertdate;
		this.address_1 = address_1;
		this.zgswj_dm = zgswj_dm;
	}
	
	
	@Override
	public String toString() {
		return "sql2excleVo [dzzhuuid=" + dzzhuuid + ", lng=" + lng + ", lat=" + lat + ", address=" + address
				+ ", nsrid=" + nsrid + ", czsj=" + czsj + ", yxbz=" + yxbz + ", status=" + status + ", precise="
				+ precise + ", confidence=" + confidence + ", lev=" + lev + ", city=" + city + ", insertdate="
				+ insertdate + ", address_1=" + address_1 + ", zgswj_dm=" + zgswj_dm + "]";
	}


	public String getDzzhuuid() {
		return dzzhuuid;
	}
	public void setDzzhuuid(String dzzhuuid) {
		this.dzzhuuid = dzzhuuid;
	}
	public String getLng() {
		return lng;
	}
	public void setLng(String lng) {
		this.lng = lng;
	}
	public String getLat() {
		return lat;
	}
	public void setLat(String lat) {
		this.lat = lat;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getNsrid() {
		return nsrid;
	}
	public void setNsrid(String nsrid) {
		this.nsrid = nsrid;
	}
	public String getCzsj() {
		return czsj;
	}
	public void setCzsj(String czsj) {
		this.czsj = czsj;
	}
	public String getYxbz() {
		return yxbz;
	}
	public void setYxbz(String yxbz) {
		this.yxbz = yxbz;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getPrecise() {
		return precise;
	}
	public void setPrecise(String precise) {
		this.precise = precise;
	}
	public String getConfidence() {
		return confidence;
	}
	public void setConfidence(String confidence) {
		this.confidence = confidence;
	}
	public String getLev() {
		return lev;
	}
	public void setLev(String lev) {
		this.lev = lev;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getInsertdate() {
		return insertdate;
	}
	public void setInsertdate(String insertdate) {
		this.insertdate = insertdate;
	}
	public String getAddress_1() {
		return address_1;
	}
	public void setAddress_1(String address_1) {
		this.address_1 = address_1;
	}
	public String getZgswj_dm() {
		return zgswj_dm;
	}
	public void setZgswj_dm(String zgswj_dm) {
		this.zgswj_dm = zgswj_dm;
	}
	
	
	
}

package com.example.demo.data.vo.v1;

import java.io.Serializable;
import java.util.Objects;

public class LinkVO implements Serializable{
	private static final long serialVersionUID = 1L;
	private String id;
	private String originalUrl;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getOriginalUrl() {
		return originalUrl;
	}
	public void setOriginalUrl(String originalUrl) {
		this.originalUrl = originalUrl;
	}
	@Override
	public int hashCode() {
		return Objects.hash(id, originalUrl);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LinkVO other = (LinkVO) obj;
		return Objects.equals(id, other.id) && Objects.equals(originalUrl, other.originalUrl);
	}
	
}

package org.qritrim.qivrtrack.model;

import java.util.ArrayList;

import lombok.Data;

@Data
public class Brand {
	
	private Integer brandId;
	private String brandName;
	private String logoPath;
	private Integer categoryId;
	private String categoryName;
	private String pocFirstName;
	private String pocLastName;
	private String pocNum;
	private String pocEmail;
	private String webLink;
	private Integer agencyId;
	private Integer companyId;
	private String companyName;
	private Boolean isNewCompany;
	private String brandLogoUrl;
	private String networks;
	public Integer getBrandId() {
		return brandId;
	}
	public void setBrandId(Integer brandId) {
		this.brandId = brandId;
	}
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	public String getLogoPath() {
		return logoPath;
	}
	public void setLogoPath(String logoPath) {
		this.logoPath = logoPath;
	}
	public Integer getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getPocFirstName() {
		return pocFirstName;
	}
	public void setPocFirstName(String pocFirstName) {
		this.pocFirstName = pocFirstName;
	}
	public String getPocLastName() {
		return pocLastName;
	}
	public void setPocLastName(String pocLastName) {
		this.pocLastName = pocLastName;
	}
	public String getPocNum() {
		return pocNum;
	}
	public void setPocNum(String pocNum) {
		this.pocNum = pocNum;
	}
	public String getPocEmail() {
		return pocEmail;
	}
	public void setPocEmail(String pocEmail) {
		this.pocEmail = pocEmail;
	}
	public String getWebLink() {
		return webLink;
	}
	public void setWebLink(String webLink) {
		this.webLink = webLink;
	}
	public Integer getAgencyId() {
		return agencyId;
	}
	public void setAgencyId(Integer agencyId) {
		this.agencyId = agencyId;
	}
	public Integer getCompanyId() {
		return companyId;
	}
	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public Boolean getIsNewCompany() {
		return isNewCompany;
	}
	public void setIsNewCompany(Boolean isNewCompany) {
		this.isNewCompany = isNewCompany;
	}
	public String getBrandLogoUrl() {
		return brandLogoUrl;
	}
	public void setBrandLogoUrl(String brandLogoUrl) {
		this.brandLogoUrl = brandLogoUrl;
	}
	public String getNetworks() {
		return networks;
	}
	public void setNetworks(String networks) {
		this.networks = networks;
	}
	
	

}
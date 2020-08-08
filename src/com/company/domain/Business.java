package com.company.domain;

public class Business
{
    private Integer bussinessId;
    private String password;
    private String businessName;
    private String businessAddress;
    private String businessExplain;
    private Double starPrice;
    private Double deliveryPrice;

    public Business()
    {
    }

    public Business(Integer bussinessId, String password,String businessName, String businessAddress, String businessExplain, Double starPrice, Double deliveryPrice)
    {
        this.bussinessId = bussinessId;
        this.password = password;
        this.businessName = businessName;
        this.businessAddress = businessAddress;
        this.businessExplain = businessExplain;
        this.starPrice = starPrice;
        this.deliveryPrice = deliveryPrice;
    }

    public Integer getBussinessId()
    {
        return bussinessId;
    }

    public void setBussinessId(Integer bussinessId)
    {
        this.bussinessId = bussinessId;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getBusinessAddress()
    {
        return businessAddress;
    }

    public void setBusinessAddress(String businessAddress)
    {
        this.businessAddress = businessAddress;
    }

    public String getBusinessExplain()
    {
        return businessExplain;
    }

    public void setBusinessExplain(String businessExplain)
    {
        this.businessExplain = businessExplain;
    }

    public Double getStarPrice()
    {
        return starPrice;
    }

    public void setStarPrice(Double starPrice)
    {
        this.starPrice = starPrice;
    }

    public Double getDeliveryPrice()
    {
        return deliveryPrice;
    }

    public void setDeliveryPrice(Double deliveryPrice)
    {
        this.deliveryPrice = deliveryPrice;
    }

    public String getBusinessName()
    {
        return businessName;
    }

    public void setBusinessName(String businessName)
    {
        this.businessName = businessName;
    }

    @Override
    public String toString()
    {
        return "Business{" +
                "bussinessId=" + bussinessId +
                ", password='" + password + '\'' +
                ", businessName='" + businessName + '\'' +
                ", businessAddress='" + businessAddress + '\'' +
                ", businessExplain='" + businessExplain + '\'' +
                ", starPrice='" + starPrice + '\'' +
                ", deliveryPrice='" + deliveryPrice + '\'' +
                '}';
    }
}

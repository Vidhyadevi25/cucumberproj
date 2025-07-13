package org.utility;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdactinSearchHotel extends BaseClass{
	public AdactinSearchHotel() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="location")
	private WebElement location;
	@FindBy(id="hotels")
	private WebElement hotel;
	@FindBy(id="room_type")
	private WebElement roomtype;
	@FindBy(id="room_nos")
	private WebElement numofroom;	
	@FindBy(id="datepick_in")
	private WebElement checkin;
	@FindBy(id="datepick_out")
	private WebElement checkout;
	@FindBy(id="adult_room")
	private WebElement adult;
	@FindBy(id="child_room")
	private WebElement children;
	@FindBy(id="Submit")
	private WebElement search;
	@FindBy(id="Reset")
	private WebElement reset;
	@FindBy(id="radiobutton_0")
	private WebElement selecthotel;
	@FindBy(id="continue")
	private WebElement continu;
	@FindBy(id="first_name")
	private WebElement firstname;
	@FindBy(id="last_name")
	private WebElement lastname;
	@FindBy(id="address")
	private WebElement address;
	@FindBy(id="cc_num")
	private WebElement creditcardnum;
	@FindBy(id="cc_type")
	private WebElement cardtype;
	@FindBy(id="cc_exp_month")
	private WebElement expmonth;
	@FindBy(id="cc_exp_year")
	private WebElement expyear;
	
	@FindBy(id="cc_cvv")
	private WebElement cvvnum;
	@FindBy(id="book_now")
	private WebElement booknow;
	@FindBy(id="my_itinerary")
	private WebElement myitinerary;
	
	@FindBy(id="order_no")
	private WebElement orderno;
	
	
	@FindBy(id="logout")
	private WebElement logout;
	
	
	public WebElement getOrderno() {
		return orderno;
	}

	
	public WebElement getSelecthotel() {
		return selecthotel;
	}
	public WebElement getContinu() {
		return continu;
	}
	public WebElement getFirstname() {
		return firstname;
	}
	public WebElement getLastname() {
		return lastname;
	}
	public WebElement getLocation() {
		return location;
	}
	public WebElement getHotel() {
		return hotel;
	}
	public WebElement getRoomtype() {
		return roomtype;
	}
	public WebElement getNumofroom() {
		return numofroom;
	}
	public WebElement getCheckin() {
		return checkin;
	}
	public WebElement getCheckout() {
		return checkout;
	}
	public WebElement getAdult() {
		return adult;
	}
	public WebElement getChildren() {
		return children;
	}
	public WebElement getSearch() {
		return search;
	}
	public WebElement getReset() {
		return reset;
	}
	public WebElement getAddress() {
		return address;
	}
	public WebElement getCreditcardnum() {
		return creditcardnum;
	}
	public WebElement getCardtype() {
		return cardtype;
	}
	public WebElement getCvvnum() {
		return cvvnum;
	}
	public WebElement getBooknow() {
		return booknow;
	}
	public WebElement getMyitinerary() {
		return myitinerary;
	}
	public WebElement getLogout() {
		return logout;
	}
	public WebElement getExpmonth() {
		return expmonth;
	}
	public WebElement getExpyear() {
		return expyear;
	}
	
	
	

}

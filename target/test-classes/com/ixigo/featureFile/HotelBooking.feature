Feature: Complete Hotel Booking Journey

Scenario: To verify hotel search and booking flow

Given click the hotel module  
When click the search destination field and enter the destination "Goa"  
And select check-in date after 5 days and check-out date after 7 days 
And select "2 Adults" and "1 Room" 
And click the search button  

When click the first hotel from the search results  
And verify hotel details like name, amenities, photos and rooms  
And select "Deluxe Room" and click on reserve rooms

When enter with valid credentials "testuser@email.com" and "Password@123"  
Then verify booking details page  
And verify hotel name, room type, check-in and check-out dates  
And verify total price details  
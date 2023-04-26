@smoke
Feature: Login feature

Background: 
Given User launches login page

#whenever you want to use parameterized scenario you should use scenario outline 
Scenario Outline: Verify the Login functionality
  #When user enters username and password
  #to pass parameters for line num 8 we can give as below
  When user enters "<username>" and "<password>"
  And user clicks on button login
  But user do not clicks on remember me checkbox
  Then user should see the homepage

	Examples:
    | username              | password  |
    | mar23pravalika@ta.com | Mar231234 |
    | joshi@ta.com          | mar465476 |


Scenario: Verify the Login functionality
  When user enters invalid username and password
	And user clicks on button login
	Then user should see the error message on the login screen
	#datatable is always applicable in last step only in this case it is line no:24
	#datatable implementation  is as follows
		#	| error msg            |
		# | check your password. |
		# | check your Username. |
			
			#we might also have 2 types of datatables
			#and one more data table
			| student  |  age    |
			| sarah    |   2     |
			| narah    |   4     |	
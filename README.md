# Contact-Management-System

## How to clone the application and run it locally:
- Copy the url mentioned here - "https://github.com/raghu-45577/contact-management-system.git".
- Open the git bash in the local machine and type the command "git clone https://github.com/raghu-45577/contact-management-system.git" and hit enter.
- After running the command the application will start to get copied into the system.
- Now open the IDE (Eclipse, STS or IntelliJ) in the machine and click on file and click on import.
- You will get a window to choose the kind of project you want to import.
- Select the Maven and click on "Existing Maven Project", it will give the dialogue box to browse the location where the application is copied.
- select the application and click on finish.The project will start building after that.
- Make sure you have Java version above 8 and MySQL installed in your machine.
- Now right click on the project and click on Run, then click on Maven clean.
- After Maven clean, go to same point and click on Maven install, so all the required dependencies will get added to the project.
- Now right click on the project again, click on run and click on "Spring Boot App" or "Java Application".
- Then the Application will run in the machine in the port 8080.

## How to call the end points and test the API's:
- Install the Postman application in the local machine to test the api's.
- Open the Postman and in the tab, we can see input field to provide the url and also type of request we have to make.
- In the url field give the url "http://localhost:8080/api/contacts/contact", this is the post request so select the POST request in the dropdown provided.
- Now click on the body link and select raw radio button. Now select media type as JSON(application/json).
- In the given space create a payload with name, address, phone no and email keys and values in the form of json modal.
- Now hit on the send button to send the request to the server.
- If request is success, we can see the object we send in the request and also the status code "201 created" in the Test Results tab.
- Similarly open another tab to make a get request to get all the contacts in the database.
- URL for get request is "http://localhost:8080/api/contacts/all" and select GET from the dropdown.
- Hit on send to see 200 OK response in the Test Results and also the list of contacts which are present in the database.
- Now open another tab to send the delete request to delete the contact using it's id.
- URL to delete the contact is "http://localhost:8080/api/contacts/{id}". In the place of {id}, provide the id of the contact which you want to delete.
- Select the DELETE request from dropdowm and click on send. We will get 200 OK and which contact is deleted in Test Results tab.

### Thank you.

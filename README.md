<h1>TBRManagerAPI<h1>
<h2>Project Description</h2>
<p>This is a project I've worked on, with inspiration from the Goodreads application, to practice creating REST APIs using Spring and source control using Git and Github. This project is a very basic project that manages a To Be Read (hereafter referred to as TBR) list. A user would be allowed to store all the books they have collected/bought. They can then 'mark' the book as currently reading which will store the current date or the user can update the date to the date they choose. The user can then mark the book as Read and they can rate the book out of five, the date they finish reading the book is also stored with either the current date or the user's updated date.</p>

<h2>Project Details</h2>
<p>This project consists of 3 entities:</p>
<ul>
  <li><strong>TBR (which is named Book_List in the database)</strong>: Stores the list of books</li>
  <li><strong>CurrentlyReading</strong>: Stores information regarding books that are currently being read</li>
  <li><strong>BooksRead</strong>: Stores information regarding books that have already been read</li>
</ul>

<p>These entities and their data are stored in an H2 Database which is accessed in the browser while running the project. The user is, for now, able to view the data via the command line or by entering values using a browser link. A user can GET, POST and PUT (update) data in the three tables.</p>

<h3>Below are some examples of some of the endpoints created:</h3>

<h4>GET Mappings</h4>
<img src="https://github.com/TheMbalist/TBRManagerAPI/assets/121617487/7b880dd9-2bbb-4b82-b03a-5d3dca62ea40" alt="A snippet of the GET requests"/>

<h4>POST Mappings</h4>
<img src="https://github.com/TheMbalist/TBRManagerAPI/assets/121617487/49a6933a-55cf-4326-bc16-7c177707c9dc" alt="A snippet of the POST requests" />

<h4>PUT Mappings</h4>
<img src="https://github.com/TheMbalist/TBRManagerAPI/assets/121617487/2d2ae68f-0144-4e93-9e99-5d0984b1b304" alt="A snippet of a PUT requests"/>

<h4>DELETE Mappings</h4>
<img src="https://github.com/TheMbalist/TBRManagerAPI/assets/121617487/bcf850f4-b19b-4023-a2d1-dc2203944bc8" alt="A snippet of the DELETE requests">

<p>As I mentioned before I also used this project as an opportunity to practice using Git and Github for this project.</p>
<h4>Below are some examples of my usage of Git while completing this project:</h4>
<img src="https://github.com/TheMbalist/TBRManagerAPI/assets/121617487/1630e692-4973-4bba-ad4b-45150da621a8" alt="A snippet of Git commands"/>

<h2>Project Refelction</h2>
<p>This project presented challenges, especially with the H2 Database. Not having had prior knowledge of using H2 Databases before completing the Codecademy course I had completed that enabled me to complete this project and my <a href="https://github.com/TheMbalist/DiningReviewAPI">Dining Review</a> project, I found myself amending the configuration of my entity classes to deal with issues with the database. While this felt like a hindrance while completing the project, I now see the valuable problem-solving skills it allowed me to develop, especially because this project presented challenges unique to me and my initial idea. I have since had more experience writing RESTful APIs, using Visual Studio and Entity Framework using an SQL Server Database, in my university course and I've since learned more about problem-solving and had more exposure to using and working with APIS. </p>

<p>For future projects I think better planning and research would be beneficial to ensure that the challenges I face with setting up my environment do not persist during the coding phase or they should be minimal issues that can be solved in less than an hour.</p>

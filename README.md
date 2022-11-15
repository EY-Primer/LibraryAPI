# LibraryAPI :books: :bank:

- Your Local Library™ has decided to get with the times and hire some competent full stack developers to build a management application for their inventory. This application will allow employees to view and manage the books in the library. 
- The son of one of the librarians started on the back end, but didn't get very far as he is 7 years old. He fully implemented a JDBC Repository layer, as well as the Book and Author Classes before he lost interest. The service layer is empty, and the MVC Controller only has method stubs, except for the "get all books" method.
- You are tasked with **expanding and improving the codebase** found in this repo! Your tasks will be updated below as Deliverables.
- (Breaking character) We're going to add to this project every day for the rest of the week. It is meant to simulate an actual real world job with a stakeholder that's depending on you to build up an application according to their specs. E&Y wants to hire problem solvers that can think through tasks and provide a reasonable solution. There are many ways to fulfill these deliverables, and no specific right answer.


# Deliverable 1 (Tuesday)

- Clone the repo (This is a gradle project - you'll want to do a gradle refresh when you clone so the dependencies register)
- Create the database (just copy and paste the SQL script found in this repo unless you REALLY want to write it yourself)
- Implement the "insert book" functionality
- Implement the "get book by id" functionality
- Implement the "get books by author id" functionality
- Get postman requests working for each of the endpoints in the Controller

### Hints

- This API is not going to work right off the bat. You will need to fill in DB credentials in the ConnectionFactory, and the application.properties. 
- It's up to you if you want everyone coding, or one person coding and teammates providing conceptual support. It would be good practice to make a remote git repository and database so you can all code together, but it's not required.
- There is a rookie mistake in the Controller layer that will prevent the API from compiling. Figure out how to fix this "ambiguous" problem.
- Leave the DAO/Repository Classes alone for now, we'll change them on Wednesday.

# Deliverable 2 (Wednesday)

- Refactor the Repo (DAO) layer! Remove anything related to JDBC and replace it with Spring Data JPA. So your Repo (DAO) layer should just be an interface that extends JpaRepository. This will also require you to change the methods being called in the controller layer.
- Add a new method in the BookController that allows you to update the isStocked field from true to false or vice versa. 
- Add a new method in the BookController that allows you to delete a book by Id.

# Deliverable 2 (Thursday)

-TBD

# Deliverable 2 (Friday)

-TBD

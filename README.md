
1) Clone the application
	# git clone https://github.com/ravivarma4142/recipes-app.git

2) MongoDB setup	
	# Install mongoDb
	# Connect to your local mongoDb(Default port will be 27017)
	# Create a database with name recipes and create a collection's with name as recipes and user.

3) Build and running the application using maven
	# cd springbootsc
	# mvn package
	# java -jar target/Recipes-0.0.1-SNAPSHOT.jar 

4) Usage
	# Application is up and running at http:localhost:8082
	
This application has five api's

	# http://localhost:8082/authenticate --POST
	This api returns jwt token currently the credentials are hard coded in the code.
	Request Body:
	{
	"username":"recipeauthens",
	"password":"password"
	}

	# http://localhost:8082/addUser --POST
	This api creates a user.
	Request Body:
	{
	"userName":"rsavi",
	"password":"S@123"
	}

	# http://localhost:8082/validateUser --POST
	This api validates the existing user from the database.
	Request Body:
	{
	"userName":"rsavi",
	"password":"S@123"
	}

	# http://localhost:8082/addRecipe/ --POST
	This api creates a recipe as sent in the request body.
	Request Body:
	{
	"recipeName":"maggie",
	"vegetarian":true,
	"serves":2,
	"ingredients":"flour,corn,rice, Olive,cream",
	"cookingInstructions":"simmer with all ingredients"
	}

	# http://localhost:8082/allRecipes
	This api fetches the existing recipes from the DB.







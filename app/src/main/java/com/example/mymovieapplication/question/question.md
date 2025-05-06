Description

You are required to implement an Android application using Kotlin and Jetpack Compose described by the specifications below.
You are not allowed to use third-party libraries. The only libraries that you can
use are the standard Android API libraries found in the following URL (with the
exception of Views that you should NOT use):
https://developer.android.com/reference/
Your are not allowed to use View classes. You should use Jetpack Compose
instead.
You should NOT disable Activity recreation (e.g. when screen orientation
changes) for any parts of your work. You should also not disable re-orientation
of the device.
It is important to follow exactly the specifications and your implementation must
conform to these:
The application developed will be helping users with testing and acquiring new knowledge
regarding movies.
The application will be using the http://www.omdbapi.com/ Web service and the Room
Library to save information about movies.
1. When the application starts, it presents the user with 3 buttons labelled Add Movies to
   DB, Search for Movies and Search for Actors. (2 marks)
2. Clicking on the Add Movies to DB button saves all the details of a few movies in an SQLite
   database local to the mobile device using the Room library. The specific information of
   the movies which will be saved is shown in the following link and the information saved
   could simply be hardcoded in the application.
   https://ddracopo.github.io/DOCUM/courses/5cosc023w/movies.txt (find the contents of this file below)
   An appropriate database with appropriate tables should be created and populated by your
   application, based on the above data.
   (20 marks)
   3
   5COSC023C MOBILE APPLICATION
   • 5 marks for the creation of the database
   • 5 marks for the creation of tables with appropriate structure
   • 5 marks for the population of tables
   • 5 marks for saving all the fields from the given file to the DB
3. The application is using the following Web service:
   http://www.omdbapi.com/
   You will need to create a free account on that web service which provides you with a
   unique key which you can use to make queries.
   The documentation of how to use the Web service is in the above web page. For example,
   the following request (type this in your web browser by substituting your own personal
   API key):
   https://www.omdbapi.com/?t=Matrix&apikey=YOUR_OWN_API_KEY
   will give you back the results (in JSON format) of searching the title “Matrix”:
   {"Title":"Matrix","Year":"1993","Rated":"N/A","Released":"01 Mar
   1993","Runtime":"60 min","Genre":"Action, Drama,
   Fantasy","Director":"N/A","Writer":"Grenville Case","Actors":"Nick
   Mancuso, Phillip Jarrett, Carrie-Anne Moss","Plot":"Steven Matrix is
   one of the underworld’s foremost hitmen until his luck runs out, and
   someone puts a contract out on him. Shot in the forehead by a .22
   pistol, Matrix \"dies\" and finds himself in \"The City In Between\",
   where he is sho","Language":"English","Country":"Canada","Awards":"1
   win","Ratings":[{"Source":"Internet Movie Database","Value":"8.0/10"}],
   "Metascore":"N/A","imdbRating":"8.0","imdbVotes":"185","imdbID":"tt0106062",
   "Type":"series","totalSeasons":"N/A","Response":"True"}
   Clicking on the Search for Movies button will present the user with a screen displaying
   a single textbox and 2 buttons Retrieve Movie and Save movie to Database.
   The user will be using the textbox to type the name of a movie and click the Retrieve
   Movie button to retrieve the details of the movie from the Web service. The details of
   each movie will be displayed as part of the same screen of the application in the following
   format:
   Title":"The Shawshank Redemption"
   Year: 1994
   Rated: R
   Released: 14 Oct 1994
   Runtime: 142 min
   Genre: Drama
   Director: Frank Darabont
   Writer: Stephen King, Frank Darabont
   Actors: Tim Robbins, Morgan Freeman, Bob Gunton
   Plot: "Two imprisoned men bond over a number of years, finding solace
   and eventual redemption through acts of common decency."
   4
   (20 marks)
   • Creation of buttons: 3 marks
   • Retrieve all data: 5 marks
   • JSON parsing: 7 marks
   • Displaying all the data appropriately according to the course specification: 3 marks
4. Following this, if the user clicks on the second button Save movie to Database all the
   retrieved details of the movie will be saved to the SQLite database of the device (using the
   Room library), by using the same tables which were utilised in the previous subquestion.
   (10 marks)
   • Partial population of tables: 5 marks
   • All fields are populated properly: 5 marks
5. Clicking on the Search for Actors button will display the user with a screen which
   contains a single textbox and a Search button.
   The user can type in the textbox any string which is part of the name of an actor and
   subsequently press the Search button to display ALL the movies in the database which
   contain the typed string in the Actors fields of the movie in the corresponding table
   containing this information.
   The search should be case insensitive and a match does not have to be a complete match
   but partial. I.e. if the user types the string “rUISE” the displayed movie(s) could be, a
   movie which contains “Tom Cruise” or “Penelope Cruise” in the list of actors.
   (20 marks)
   • Search is case insensitive: 7 marks
   • Search is based on a substring match, not a full match: 7 marks
   • Search displays all the movies: 6 marks
6. For all the tasks, the application should behave in a user friendly manner when the device
   is rotated from portrait to landscape and back to portrait mode. I.e. the application
   should resume from exactly the same point (same screen and data) when the orientation
   changes. The rotation of the device should not change what was the user was seeing before
   the rotation.
   You should NOT disable Activity recreation (e.g. when screen orientation
   changes) for this or any parts of your work. You should also not disable reorientation of the device.
   (9 marks)
   • 1-5 marks: partial implementation
   • 6-9 marks: minor omissions
7. Extend the application so that the initial screen contains an additional button which the
   user can press and subsequently type a string. All movies containing the string as part of
   their title will be retrieved directly from the Web service (NOT THE DATABASE)
   and displayed to the user.
   5
   For example, if the user types “MAt” all of the movies in the OMDb Web service containing
   this substring in their title will be retrieved and displayed to the user. These could be
   “The Matrix Resurrections”, “Matilda”, “Aftermath”, etc.
   (11 marks)
   • Just one movie is displayed: 2 marks
   • Search is not case sensitive: 3 marks
   • At least 10 movies (or the first page from the Web Service) are displayed: 6 marks



https://ddracopo.github.io/DOCUM/courses/5cosc023w/movies.txt
Title":"The Shawshank Redemption",
"Year":"1994",
"Rated":"R",
"Released":"14 Oct 1994",
"Runtime":"142 min",
"Genre":"Drama",
"Director":"Frank Darabont",
"Writer":"Stephen King, Frank Darabont",
"Actors":"Tim Robbins, Morgan Freeman, Bob Gunton",
"Plot":"Two imprisoned men bond over a number of years, finding solace
and eventual redemption through acts of common decency."


Title":"Batman: The Dark Knight Returns, Part 1",
"Year":"2012",
"Rated":"PG-13",
"Released":"25 Sep 2012",
"Runtime":"76 min",
"Genre":"Animation, Action, Crime, Drama, Thriller",
"Director":"Jay Oliva",
"Writer":"Bob Kane (character created by: Batman), Frank Miller (comic book), Klaus Janson (comic book), Bob
Goodman",
"Actors":"Peter Weller, Ariel Winter, David Selby, Wade Williams",
"Plot":"Batman has not been seen for ten years. A new breed
of criminal ravages Gotham City, forcing 55-year-old Bruce Wayne back
into the cape and cowl. But, does he still have what it takes to fight
crime in a new era?"

"Title":"The Lord of the Rings: The Return of the King",
"Year":"2003",
"Rated":"PG-13",
"Released":"17 Dec 2003",
"Runtime":"201 min",
"Genre":"Action, Adventure, Drama",
"Director":"Peter Jackson",
"Writer":"J.R.R. Tolkien, Fran Walsh, Philippa Boyens",
"Actors":"Elijah Wood, Viggo Mortensen, Ian McKellen",
"Plot":"Gandalf and Aragorn lead the World of Men against Sauron's
army to draw his gaze from Frodo and Sam as they approach Mount Doom
with the One Ring."


"Title":"Inception",
"Year":"2010",
"Rated":"PG-13",
"Released":"16 Jul 2010",
"Runtime":"148 min",
"Genre":"Action, Adventure, Sci-Fi",
"Director":"Christopher Nolan",
"Writer":"Christopher Nolan",
"Actors":"Leonardo DiCaprio, Joseph Gordon-Levitt, Elliot Page",
"Plot":"A thief who steals corporate secrets through the use of
dream-sharing technology is given the inverse task of planting an idea
into the mind of a C.E.O., but his tragic past may doom the project
and his team to disaster.",

Title":"The Matrix",
"Year":"1999",
"Rated":"R",
"Released":"31 Mar 1999",
"Runtime":"136 min",
"Genre":"Action, Sci-Fi",
"Director":"Lana Wachowski, Lilly Wachowski",
"Writer":"Lilly Wachowski, Lana Wachowski",
"Actors":"Keanu Reeves, Laurence Fishburne, Carrie-Anne Moss",
"Plot":"When a beautiful stranger leads computer hacker Neo to a
forbidding underworld, he discovers the shocking truth--the life he
knows is the elaborate deception of an evil cyber-intelligence."
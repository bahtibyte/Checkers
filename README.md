# # Checkers
 
#### REQUIRED (10pts)
- [x] (5pts) User can tap a cell to see more details about a particular movie.
- [x] (5pts) User can tap a tab bar button to view a grid layout of Movie Posters using a CollectionView.

#### BONUS
- [x] (2pts) User can tap a poster in the collection view to see a detail screen of that movie.
- [x] (2pts) In the detail view, when the user taps the poster, a new screen is presented modally where they can view the trailer.
- [x] User can search for movies. It returns the top 20 matching movies to the search query.

### App Walkthough GIF
<img src="http://g.recordit.co/8s9PTqHZyz.gif" ><br>

### Notes
- Working on the search tab was challenging because I had trouble hiding the keyboard when a movie was selected. When adding a new gesture for the collection view, it overrided its past gestures and it didnt detect tapping. I overcame the problem by hiding the keyboard when a movie is chosen.


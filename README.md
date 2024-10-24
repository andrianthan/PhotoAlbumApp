# Photo Album Manager

This project is a desktop-based **Photo Album Manager** built using Java Swing. It demonstrates the use of key software design patterns: **Iterator**, **MVC (Model-View-Controller)**, and **Strategy**. The program allows users to manage a photo album by adding, viewing, deleting, and sorting photos.


## Objectives
The purpose of this project is to:
- Implement a **Photo Album Manager** using **Java Swing**.
- Utilize design patterns such as **Iterator**, **MVC**, and **Strategy** to achieve flexible and maintainable code.
- Provide dynamic sorting and navigation functionality for managing photos.

## Features

### Photo Management
- Add new photos to the album with attributes:
  - **Name**
  - **File path**
  - **Date added**
  - **File size**
- Delete photos by name.
- Display a list of photos including their names and thumbnail previews.
- Show the current photo in the album.

### Navigation
- Users can navigate through the album using **Next** and **Previous** buttons.
- The photo order is based on the current sorting strategy.

### Sorting
- Users can dynamically change the sorting strategy of the album:
  - **Sort by Name**
  - **Sort by Date Added**
  - **Sort by File Size**

## Design Patterns

### MVC Pattern
This project follows the **Model-View-Controller** (MVC) architecture:
- **Model**: Manages the data (photo album) and business logic. Implements the `Iterable` interface for photo traversal.
- **View**: A Swing-based UI that displays the album and current photo.
- **Controller**: Handles user input (e.g., button clicks) and updates the model.

### Iterator Pattern
An **Iterator** is used to navigate through the photos in the album:
- **AlbumIterator**: Implements the `Iterator` interface to allow traversal over the photo collection.

### Strategy Pattern
Three different sorting strategies are implemented using the **Strategy** pattern:
- **SortByName**: Sorts photos alphabetically by their names.
- **SortByDate**: Sorts photos based on the date they were added.
- **SortBySize**: Sorts photos by their file sizes.

## Usage
1. **Add a Photo**: Click the "Add Photo" button and provide the photo's details.
2. **Delete a Photo**: Select a photo by its name and click "Delete Photo."
3. **Navigate Photos**: Use the "Next" and "Previous" buttons to cycle through the album.
4. **Sort Photos**: Use the "Sort By" dropdown menu to change the sorting strategy (by Name, Date, or Size).



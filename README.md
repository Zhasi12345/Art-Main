#                    Artwork Inventory Manager

## -  Project Description -
Java Swing application that manages an artwork collection.  
It stores information about artworks including ID, title, artist, year, location, and type (Painting or Sculpture).

---

## - Author
Sydygaalieva Zhasmin

---

##  - Objectives
- Manage artwork records (CRUD operations)
- Provide a simple GUI using Java Swing
- Store data in files for persistence
- Allow import/export of data
- Demonstrate OOP principles (Encapsulation, Inheritance, Polymorphism)

---

## - Features

### CRUD Operations
- Add artwork
- View artwork list
- Update artwork
- Delete artwork

### GUI
- Built using Java Swing
- Simple user-friendly interface

###  Data Types
- Painting
- Sculpture

###  File Support
- Export data to file
- Import data from file

---

## - OOP Concepts
- Encapsulation (private fields + getters/setters)
- Inheritance (Artwork - Painting, Sculpture)
- Polymorphism (method overriding)

---
## - Documentation

### Project Structure
- Main.java - run
- GUI.java - user interface (Swing)
- Artwork.java - base class
- Painting.java - child class (inheritance)
- Sculpture.java - child class (inheritance)
- User.java - child class (inheritance)
- ArtworkService.java - logic (CRUD operations)
- AuthService.java - login system
- DBconnection.java - connects to the database
- InitDB.java - creates table SQlite
- FileStorage.java - saving data to cvs files (export/import)

---

### How the program works
1. Creating table in InitDB
2. Run the program in Main class 
3. User logs in (Admin/User)
4. User can add and view artwork (ID, title, artist, year, location, type)
5. Data is displayed in text area 
6. Admin can update or delete records 
7. Data is saved to file and loaded again

---

### Error handling
- Invalid input is caught using try-catch
- Empty fields are validated before saving
- Wrong ID handling prevents crashes
---

##  Screenshots

all screen, with time, day
<img width="1884" height="1042" alt="img" src="https://github.com/user-attachments/assets/7278db21-07ab-4c65-ae44-7f8c1ac52fe9" />


add
![img_4.png](img_4.png)


after we press view to see changes
![img_1.png](img_1.png)


after we are updating our information
![img_2.png](img_2.png)


and press view to see changes
![img_3.png](img_3.png)


checking delete 
![img_5.png](img_5.png)


view to see changes, and we see that its deleted
![img_6.png](img_6.png)

export
![img_7.png](img_7.png)
 
when I press export, all information saves in file csv
![img_8.png](img_8.png)


we're deleting all info, and reruning the program 
There is no information when I press view

![img_9.png](img_9.png)


we press import
![img_10.png](img_10.png)

after we press view to see changes, and we that information was imported
![img_11.png](img_11.png)
# individual-project-jaineil

### Setup

- Download IntelliJ IDE.
- Clone the repository:
  `git clone "https://github.com/gopinathsjsu/individual-project-jaineil.git"`
- Open the cloned directory as your project.
- Open the `Billing.java` on IntelliJ and hit the run icon to run the project.
- All the files required to run and test the system are in the same directory level at the top-most level.
- The terminal will prompt you to input the inventory stock data's path. 
  - Enter: `InventoryItems.csv`
- The terminal will prompt you to input the credit card's data path.
  - Enter: `Cards.csv`
- The terminal will prompt you to input the order's data path.
  - Enter: `Order.csv`

---

### About the Design Patterns used:

I have used two design patterns as follows:

- Singleton (Creational Design Pattern) 
  - All the major app methods are invoked in Main class as methods. We make Main class a Singleton.
- Factory (Creational Design Pattern) 
  - Used this pattern to hide the output generator logic from the client (in our case, the Billing class)

---

### Class diagram
![Class Diagram](https://user-images.githubusercontent.com/26373088/167290924-ee975ec8-2b56-4f5b-8d09-9d01d5f8e508.jpg)
